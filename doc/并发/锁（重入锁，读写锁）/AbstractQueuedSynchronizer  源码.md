# AbstractQueuedSynchronizer  源码

AbstractQueuedSynchronizer 是用来构建锁或其它同步组件的基础框架类，JUC 许多锁和并发工具的核心实现都依赖于AQS ，如：ReentrantLock、ReentrantReadWriteLock、Semaphore、CountDownLatch 等
AQS 主要做以下三件事情

1. 管理同步状态
1. 维护同步状态
1. 阻塞和唤醒线程
### 实现原理
AQS 内部维护了一个FIFO 队列来管理锁，线程首先会尝试获取锁，如果是百年，则将当前线程以及等待状态信息包装成一个Node 节点，放入同步队列阻塞起来，当持有锁的线程释放锁的时候，就唤醒队列中的后继线程 。
### AQS 核心内部类
```java
static final class Node {
  		// 用于标记一个节点在共享模式下等待
        static final Node SHARED = new Node();
    	// 用于标记一个节点在独占模式下等待
        static final Node EXCLUSIVE = null;
    	// 当前线程因为超时或中断被取消。 这是一个终结态
        static final int CANCELLED =  1;
    	// 当前线程的后继线程被阻塞或者即将被阻塞，当前线程释放锁或者取消后需要唤醒后继线程
        static final int SIGNAL    = -1;
        static final int CONDITION = -2;
    	// 用于将唤醒后继线程传递下去，这个状态的引入是为了完善和增强共享锁的唤醒机制
        static final int PROPAGATE = -3;
		// 等待状态
        volatile int waitStatus;
    	// 前驱节点
        volatile Node prev;
    	// 后继节点
        volatile Node next;
    	//	 节点对应的线程
        volatile Thread thread;
    	//	等待队列中的后节点
        Node nextWaiter;
        final boolean isShared() {
            return nextWaiter == SHARED;
        }
		// 获取前驱节点
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }

        Node() {   
        }
        Node(Thread thread, Node mode) {     // Used by addWaiter
            this.nextWaiter = mode;
            this.thread = thread;
        }

        Node(Thread thread, int waitStatus) { // Used by Condition
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }
```
### 独占锁的实现
#### 锁的获取
```java
    
public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
    }
```


- 当线程需要获取锁的时候，首先会先尝试获取一次锁 (tryAcquire ) ，如果成功，则返回
- 将当前线程包装成Node 内部类，然后插入到队列中。 而队列中会检测是否为head  的直接后继，并尝试获取锁
```java
// 将线程包装成的Node  添加到队列中
private Node addWaiter(Node mode) {
    Node node = new Node(Thread.currentThread(), mode);
    Node pred = tail;
    // 快速尝试
    if (pred != null) {
        node.prev = pred;
        // 通过CAS在队尾插入当前节点
        if (compareAndSetTail(pred, node)) {
            pred.next = node;
            return node;
        }
    }
    // 初始情况或者在快速尝试失败后插入节点
    enq(node);
    return node;
}

```

- 如果获取失败，则阻塞当前线程，知道被释放锁的线程唤醒或者被终端，随后再次尝试获取锁。
```java
// 在队列中的节点获取锁
final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            // 循环遍历，检测当前节点的前驱节点是否为head,如果是，则可以尝试获取锁，成功，则把head 置为当前节点
            for (;;) {
                final Node p = node.predecessor();
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return interrupted;
                }
                // 如果获取锁失败，则根据前驱节点判断是否需要阻塞
                if (shouldParkAfterFailedAcquire(p, node) &&
                    parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {
            if (failed)
                cancelAcquire(node);
        }

}

```
```java
// 根据前驱节点的waitStatus  来判断是否需要阻塞当前线程
private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;
    	// 
        if (ws == Node.SIGNAL)
            return true;
        if (ws > 0) {  
            
            do {
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            //等待状态为0或者PROPAGATE(-3)，设置前驱的等待状态为SIGNAL 并且之后会回到循环再次重试获取锁
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL);
        }
        return false;
    }
```
#### 锁的释放
在释放一个独占锁的时候， 首先会调用tryRelease 方法，在完全释放掉独占锁后，其后继线程是可以获取到独占锁的，因此释放线程需要做的事情是：唤醒队列中的后继线程，让他去尝试获取独占锁
```java
    public final boolean release(int arg) {
        // 如果调用tryRelease 返回true  则表示独占锁被完全释放，然后唤醒后继线程 
        if (tryRelease(arg)) {
            Node h = head;
            if (h != null && h.waitStatus != 0)
                unparkSuccessor(h);
            return true;
        }
        return false;
    }
```
unparkSuccessor 唤醒后继线程
```java
private void unparkSuccessor(Node node) {
        int ws = node.waitStatus;
        if (ws < 0)
            // 尝试将node 的等待状态设置为0，这样的话，后继线程可以再有一次机会获取锁
            compareAndSetWaitStatus(node, ws, 0);
        Node s = node.next;
    	// 如果node.ext  不为空，且状态为不取消，则可以直接唤醒线程
    	// 否则需要从tail 开始向前找出node 之后的最近的非取消节点
        if (s == null || s.waitStatus > 0) {
            s = null;
            for (Node t = tail; t != null && t != node; t = t.prev)
                if (t.waitStatus <= 0)
                    s = t;
        }
        if (s != null)
            LockSupport.unpark(s.thread);
    }
```
