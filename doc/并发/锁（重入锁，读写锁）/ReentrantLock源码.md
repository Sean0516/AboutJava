ReentrantLock  实现 Lock  接口。 使用Sync 静态内部类来实现同步。 同时 ，Sync  有 NonfairSync 和FairSync 两个锁

#### Lock 接口

```java
public interface Lock {
    void lock();// 获取锁

    void lockInterruptibly() throws InterruptedException; // 获取锁，当线程中断抛出异常

    boolean tryLock(); // 只有当调用时，锁是空闲的，才获取锁

    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    void unlock(); // 释放锁

    Condition newCondition();
}
```

#### 字段属性

```java
private final Sync sync; //继承AQS 抽象类的内部抽象类  sync分为非公平锁NonfairSync和公平锁FairSync 都继承自抽象类SYnc
```

```java
final boolean nonfairTryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState(); // 获取锁当前状态
    if (c == 0) { // 如果state 为0 ，则表示锁未锁定，大于0 则表示被其他线程占用
        if (compareAndSetState(0, acquires)) { //通过CAS 修改state为1
            setExclusiveOwnerThread(current); // 设置当前线程为独占资源的持有者
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) { // 如果当前线程已经为锁的持有者，则设置重入次数。
        int nextc = c + acquires;
        if (nextc < 0) // overflow
            throw new Error("Maximum lock count exceeded");
        setState(nextc); // 设置重入次数
        return true;
    }
    return false;
}

protected final boolean tryRelease(int releases) {
    int c = getState() - releases;
    if (Thread.currentThread() != getExclusiveOwnerThread()) // 判断当前线程是不是锁的持有者
        throw new IllegalMonitorStateException();
    boolean free = false;
    if (c == 0) { // 线程将锁完全释放，则将锁初始化为无锁状态
        free = true;
        setExclusiveOwnerThread(null);
    }
    setState(c);
    return free;
}
```

#### 公平锁和非公平锁

可以看到，在上面的公平锁实现中，线程获得锁的顺序是按照请求锁的顺序，按照“先来后到”的规则获取锁。如果线程竞争公平锁失败后，则都会到AQS同步队列队尾排队，将自己阻塞等待锁的使用资格，锁被释放后，会从队首开始查找可以获得锁的线程并唤醒。

而在非公平锁中，允许新线程请求锁时“插队”，不管AQS同步队列是否有线程在等待，新线程都会先尝试获取锁，如果获取锁失败后，才会进入AQS同步队列队尾排队。

##### NonfairSync非公平锁

```java
static final class NonfairSync extends Sync { // 非公平锁
    private static final long serialVersionUID = 7316153563782823691L;

    /**
     * Performs lock.  Try immediate barge, backing up to normal
     * acquire on failure.
     */
    final void lock() {
        if (compareAndSetState(0, 1)) // 新线程，第一次插队
            setExclusiveOwnerThread(Thread.currentThread());
        else
            acquire(1);
    }

    protected final boolean tryAcquire(int acquires) {
        return nonfairTryAcquire(acquires); // 非公平锁，第二次插队
    }
}
```

FairSync 公平锁

```java
static final class FairSync extends Sync {
    private static final long serialVersionUID = -3000897897090466540L;

    final void lock() {
        acquire(1);
    }

    /**
     * Fair version of tryAcquire.  Don't grant access unless
     * recursive call or no waiters or is first.
     */
    protected final boolean tryAcquire(int acquires) {
        final Thread current = Thread.currentThread();
        int c = getState();
        if (c == 0) {
            if (!hasQueuedPredecessors() && // 公平锁会先判断同步队列中是否有线程在等待（除了头尾节点，还有其他的节点）
                compareAndSetState(0, acquires)) {
                setExclusiveOwnerThread(current);
                return true;
            }
        }
        else if (current == getExclusiveOwnerThread()) { // 判断当前锁是否为当前线程占用，占用则重入锁
            int nextc = c + acquires;
            if (nextc < 0)
                throw new Error("Maximum lock count exceeded");
            setState(nextc);
            return true;
        }
        return false;
    }
}
```