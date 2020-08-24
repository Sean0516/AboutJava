# Lock 相关组件源码

### Lock接口


```java
public interface Lock {
	//获取锁
    void lock();
	//获取锁，除非当前线程中断
    void lockInterruptibly() throws InterruptedException;

	// 只有当调用时 锁是空闲的情况下，才获取锁
    boolean tryLock();
	// 如果锁在给定的等待时间内空闲且当前线程未被中断，则获取该锁
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;
	//  释放锁
    void unlock();
}
```
### ReentrantLock 
ReentrantLock  实现 Lock  接口。 使用Sync 静态内部类来实现同步。 同时 ，Sync  有 NonfairSync 和FairSync 两个锁
#### Sync内部类
```java
abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;
		
        abstract void lock();
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        final int getHoldCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        final boolean isLocked() {
            return getState() != 0;
        }

    }
```
#### ReentrantLock 初始化以及相关方法
```java
  public ReentrantLock() {
        sync = new NonfairSync();
    }
	//可通过参数fair 控制实例化的是 公平锁还是非公平锁
    public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }
	// 加锁
    public void lock() {
        sync.lock();
    }
    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    public boolean tryLock(long timeout, TimeUnit unit)
            throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    public void unlock() {
        sync.release(1);
    }

    public boolean isLocked() {
        return sync.isLocked();
    }

    public final boolean isFair() {
        return sync instanceof FairSync;
    }
```
