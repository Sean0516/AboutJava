所谓重入锁是指支持重进入的锁，表示该锁能够支持一个线程对资源的重复加锁。

所谓重进入指的是任意线程在获取到锁之后们能够再次获取到该锁而不会被锁阻塞  ，需要注意的是，如果同一个线程在多次获得锁，那么释放锁的时候，必须释放相同次数的锁 ，如果释放的锁次数多于加锁的次数，系统会抛出异常，反之，如果释放的次数少，相当于线程还持有这个锁，其他线程也无法进入临界区。

要实现锁的重入功能需要解决以下问题：

1. 线程再次获取锁： 线程需要去识别获取锁的线程是否为当前占据锁的线程。 如果是，则再次获取成功
2. 锁的最终释放： 线程重复n次获取锁计数器对获取锁自增，在n次释放该锁后，其他线程可以获取当该锁  当释放时，计数器自减  当计数器为0时表示锁释放成功

ReentrantLock 通过组合自定义同步器来实现锁的获取与释放，以非公平性锁的获取的实现为例： 通过判断当前线程是否为获取锁的线程来决定获取操作是否成功，如果是获取锁的线程再次请求，则将同步状态值进行增加并返回true ，表示获取同步状态成功

成功获取锁的线程再次获取锁，只是增加了同步状态值，这样也就要求了ReentrantLock 在释放同步状态时需要减少同步状态值，由方法 tryRelease 方法实现。 如果该锁被获取了N 此 那么前n- 1 次tryRelease 方法必须放回false ，只有当同步状态完全释放了，才能返回true ，该方法通过判断同步状态是否为0 作为释放发最终条件，当同步状态为0 ，则将 占有线程设置为null ，并且返回true ，表示释放成功

### 重入锁的高级功能：

#### 获取锁时的公平和非公平性选择
公平性与否 是针对获取锁而言，如果一个锁是公平的，那么锁的获取顺序就应该符合请求的绝对时间顺序，也就是FINFO 

关于锁的公平性： 如果在绝对时间上，先对锁进行获取的请求一定先被满足，那么这个锁时公平的。反之则是不公平的.公平的锁就是等待时间最长的线程最优先获取锁，可以说这个锁是顺序的 ，公平锁不会产饥饿现象，只要排队，最终都可以等到资源，ReentrantLock 提供了一个构造函数，能够控制锁是否公平

但实际上，公平锁往往没有非公平锁的效率高，虽然公平锁看起来很优美，但是实现公平锁必然要求系统维护一个有序队列，因此公平锁的实现成本较高，性能也非常低下。不过公平锁能够减少饥饿 的发生概率， 等待越久的请求越能够得到优先满足

公平锁保证了锁的获取按照FIFO 原则，代价则是进行大量的线程切换， 非公平锁虽然可能造成线程==饥饿== ，但是极少的线程切换，保证了其更大的吞吐量

#### 中断响应
重入锁提供一种线程可以被中断的功能，也就是在等待锁的时候，程序可以根据需要取消对锁的请求。如果一个线程正在等待锁，那么它依然可以接收到一个通知，被告知无需等待，可以停止工作了，这种情况对处理死锁有一定的帮助


#### 锁申请等待时限 （ReentrantLock.tryLock）
除了等待外部通知之外，还可以使用限时等待的方法来避免死锁。可以主动给线程一个等待事件，如果在等待时间后仍然没有获得锁，可以让线程放弃锁

重入锁（reentrantLock） 是排他锁， 这些锁统一个时刻只允许一个线程进行访问

### 重入锁的几个重要方法
1. lock() 获得锁，如果锁已经被占用，则等待
2. lockInterruptibly()  获得锁，但是有限响应中断
3. tryLock()  尝试获取锁，如果成功，返回true，失败返回false ，该方法不等待，立即返回
4. tryLock(long time ,TimeUnit unit) 给定时间内尝试获得锁
5. unLock（）  释放锁

### 重入锁实现的主要要素
1. 原子状态 原子状态使用CAS 操作来存储当前锁的状态，判断锁时否已经被其他线程持有
2. 等待队列。 所有没有请求到锁的线程，会进入等待队列进行等待，待有线程释放锁后，系统就能从等待队列中唤醒一个线程，继续工作
3. 阻塞原语 park  和unpark  ，用来挂起和恢复线程，没有得到锁的线程将会被挂起 。


