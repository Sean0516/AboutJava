# AbstractQueuedSynchronizer  源码

AbstractQueuedSynchronizer 是用来构建锁或其它同步组件的基础框架类，JUC 许多锁和并发工具的核心实现都依赖于AQS ，如：ReentrantLock、ReentrantReadWriteLock、Semaphore、CountDownLatch 等
AQS 主要做以下三件事情

1. 管理同步状态
1. 维护同步状态
1. 阻塞和唤醒线程
### 实现原理
AQS 内部维护了一个FIFO 队列来管理锁，线程首先会尝试获取锁，如果失败，则将当前线程以及等待状态信息包装成一个Node 节点，放入同步队列阻塞起来，当持有锁的线程释放锁的时候，就唤醒队列中的后继线程 。

#### 字段属性

```java
private transient volatile Node head;  // 头节点

/**
 * Tail of the wait queue, lazily initialized.  Modified only via
 * method enq to add new wait node.
 */
private transient volatile Node tail; // 尾节点

/**
 * The synchronization state.
 */
private volatile int state; // 同步状态
```

##### AQS 核心内部类 Node 用来存放请求资源的线程
```java
static final class Node {
        static final Node SHARED = new Node(); // 用于标记一个节点在共享模式下等待
        static final Node EXCLUSIVE = null; // 在独占模式下等待
        static final int CANCELLED =  1; // 当前线程是否因为超时或中断被取消, 这是一个终结态
        static final int SIGNAL    = -1; // 当前线程的后继线程被阻塞或者即将被阻塞，当前线程释放锁或者取消后需要唤醒后继线程
        static final int CONDITION = -2; //当前线程在condition队列中
        static final int PROPAGATE = -3; //用于将唤醒后继线程传递下去，这个状态的引入是为了完善和增强共享锁的唤醒机制。
        volatile int waitStatus; // 等待状态
        volatile Node prev; // 前驱节点
        volatile Node next; // 后继节点
        volatile Thread thread; // 节点中等待的线程
        Node nextWaiter; // 等待队列中的下一个后继节点
        final boolean isShared() {
            return nextWaiter == SHARED;
        } // 当前节点是否处于共享模式等待
        final Node predecessor() throws NullPointerException { // 获取前驱节点
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;
        }
        Node() {    // Used to establish initial head or SHARED marker
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

1. 首先会执行tryAcquire（1）尝试抢占锁，成功返回true，失败返回false
2. 抢占锁失败后，执行addWaiter（Node. EXCLUSIVE）将线程封装成Node节点追加到AQS队列
3. 然后调用acquireQueued将线程阻塞
4. 线程阻塞后，接下来就只需等待其他线程（其他线程释放锁时）唤醒它，线程被唤醒后会重新竞争锁的使用

```java
    // // 尝试获取一次锁，成功则返回，失败则将当前线程包装为Node 插入到队列中。而队列中会检测是否为head  的直接后继，并尝试获取锁
    public final void acquire(int arg) {
        if (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
    }

```

```java
    private Node addWaiter(Node mode) {
        Node node = new Node(Thread.currentThread(), mode);
        // Try the fast path of enq; backup to full enq on failure
        Node pred = tail;
        if (pred != null) { // 快速尝试
            node.prev = pred;
            if (compareAndSetTail(pred, node)) {   // 通过CAS在队尾插入当前节点 compareAndSwapObject为本地方法
                pred.next = node;
                return node;
            }
        }
        enq(node); // 链表为空，将节点最佳到同步队列队尾
        return node;
    }
//通过自旋插入节点到同步队列AQS 中，如果队列为空，需要先初始化队列
private Node enq(final Node node) {
        for (;;) { 
            Node t = tail;
            if (t == null) { // 如果尾节点为空 初始化队列
                if (compareAndSetHead(new Node()))
                    tail = head;
            } else {
                /*
             * AQS的精妙在于很多细节代码，比如需要用CAS往队尾里增加一个元素
             * 此处的else分支是先在CAS的if前设置node.prev = t，而不是在CAS成功之后再设置。
             * 一方面是基于CAS的双向链表插入目前没有完美的解决方案，另一方面这样子做的好处是：
             * 保证每时每刻tail.prev都不会是一个null值，否则如果node.prev = t
             * 放在下面if的里面，会导致一个瞬间tail.prev = null，这样会使得队列不完整
             */
                node.prev = t; // 将当前节点的前驱设置为头节点
                if (compareAndSetTail(t, node)) { //CAS设置tail为node，成功后把老的tail也就是t连接到node
                    t.next = node;
                    return t;
                }
            }
        }
    }

```

1. 若同步队列中，若当前节点为队列第一个线程，则有资格竞争锁，再次尝试获得锁。
2. 尝试获得锁成功，移除链表head节点，并将当前线程节点设置为head节点。
3. 尝试获得锁失败，判断是否需要阻塞当前线程。
4. 若发生异常，取消当前线程获得锁的资格

```java
// 将线程阻塞 
 final boolean acquireQueued(final Node node, int arg) {
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                final Node p = node.predecessor(); // 如果当前节点的前驱节点为头节点，则尝试获取锁，获取锁成功，则将head 设置为当前节点
                if (p == head && tryAcquire(arg)) {
                    setHead(node);
                    p.next = null; // help GC
                    failed = false;
                    return interrupted;
                }// 如果为获取到锁，则根据前驱节点判断是否要阻塞
                if (shouldParkAfterFailedAcquire(p, node) && //houldParkAfterFailedAcquire方法在前驱状态不为SIGNAL的情况下都会循环重试获取锁
                    parkAndCheckInterrupt())
                    interrupted = true;
            }
        } finally {// 发生异常取消当前线程获取锁的资格
            if (failed)
                cancelAcquire(node);
        }
    }
}

// 线程获取锁失败后，根据前驱节点的waitStatus  来判断是否需要阻塞当前线程
 private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
        int ws = pred.waitStatus;
        if (ws == Node.SIGNAL)
            return true; //前驱节点设置为SIGNAL状态，在释放锁的时候会唤醒后继节点 所以后继节点（也就是当前节点）现在可以阻塞自己
        if (ws > 0) {
            do {//前驱节点状态为取消，向前遍历，更新当前节点的前驱为往前第一个非取消节点 当前线程会之后会再次回到循环并尝试获取锁
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            compareAndSetWaitStatus(pred, ws, Node.SIGNAL); //等待状态为0或者PROPAGATE(-3)，设置前驱的等待状态为SIGNAL 并且之后会回到循环再次重试获取锁
        }
        return false;
    }



```
1. 当其他线程调用了LockSupport. unpark（ThreadB），当前线程才能接着往下执行。
2. 若在等待过程中，若其他线程调用了ThreadB. interrupt()，则此时ThreadB的中断标识为true。当前线程需要响应中断请求，将中断标识复位为false（初始状态），并且将中断标识返回。
3. acquireQueued线程获取锁成功后，会同时将中断标识返回。
4. 若中断标识为false，回到acquire方法，会直接返回。
5. 若中断标识为true，回到acquire方法，会执行AQS. selfInterrupt()，将线程中断状态复位。后面当前线程获得锁成功，在处理业务代码时可以检查中断标志的状态来判断是否需要终止当前线程。
   

```java
    private final boolean parkAndCheckInterrupt() { // 将当前阻塞挂起
        LockSupport.park(this); // 阻塞当前线程，会使当前线程处于等待状态，不再往下执行
        return Thread.interrupted();// 检测当前线程是否已经被中断，并清除中断标记，并返回
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
##### unparkSuccessor 唤醒后继线程

```java

  private void unparkSuccessor(Node node) {
        int ws = node.waitStatus; //获取头节点的waitStatus 状态
        if (ws < 0)
            compareAndSetWaitStatus(node, ws, 0); // 尝试将node 的等待状态设置为0，这样的话，后继线程可以再有一次机会获取锁
 /*
     * 这里的逻辑就是如果node.next存在并且状态不为取消，则直接唤醒s即可
     * 否则需要从tail开始向前找到node之后最近的非取消节点。
     *
     * 这里为什么要从tail开始向前查找也是值得琢磨的:
     * 如果读到s == null，不代表node就为tail，参考addWaiter以及enq函数中的我的注释。
     * 不妨考虑到如下场景：
     * 1. node某时刻为tail
     * 2. 有新线程通过addWaiter中的if分支或者enq方法添加自己
     * 3. compareAndSetTail成功
     * 4. 此时这里的Node s = node.next读出来s == null，但事实上node已经不是tail，它有后继了!
     */
        Node s = node.next; // 从AQS 同步队列中，查找需要唤醒的线程节点
        if (s == null || s.waitStatus > 0) {
            s = null;
            for (Node t = tail; t != null && t != node; t = t.prev)
                if (t.waitStatus <= 0)
                    s = t;
        }
        if (s != null)
            LockSupport.unpark(s.thread); // 将节点中的线程唤醒
    }
```

##### 获取共享锁

```java
public final void acquireShared(int arg) {
    if (tryAcquireShared(arg) < 0)
        doAcquireShared(arg);
}

    private void doAcquireShared(int arg) {
        final Node node = addWaiter(Node.SHARED); // 构建共享节点
        boolean failed = true;
        try {
            boolean interrupted = false;
            for (;;) {
                final Node p = node.predecessor();
                if (p == head) {
                    int r = tryAcquireShared(arg); // 一旦共享获取成功，设置新的头节点，并唤醒后继线程
                    if (r >= 0) {
                        /**
                     * 这个函数做的事情有两件:
                     * 1. 在获取共享锁成功后，设置head节点
                     * 2. 根据调用tryAcquireShared返回的状态以及节点本身的等待状态来判断是否需要唤醒后继线程
                     */
                        setHeadAndPropagate(node, r);
                        p.next = null; // help GC
                        if (interrupted)
                            selfInterrupt();
                        failed = false;
                        return;
                    }
                }
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

