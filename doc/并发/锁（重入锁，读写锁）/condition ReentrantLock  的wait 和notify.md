ReentrantLock 使用 Condition 来实现线程的wait 和notify 。condition 类是jdk 5 中出现的技术，它有更好的灵活性。 例如多路通知功能， 也就是在一个lock对象里面可以创建多个condition 实例，线程对象可以注册在指定的condition中，从而可以选择性的进行线程通知，在调度线程上更加灵活

synchronization 相当于整个lock对象中只有一个单一的condition对象，所有的线程都注册在它一个对象上。 线程notifyall时，需要通知所有waiting线程，没有选择权，会出现很大的效率问题

condition 定义了等待/ 通知两种类型的方法，当前线程调用这些方法时，需要提前获取到condition对象关联到的锁，condition对象是由lock 对象 创建出来的， condition 是依赖 ReentrantLock 对象的

当线程使用condition.await() 时，要求线程持有相关的重入锁，在condition.await 调用后，线程会释放这个锁，同理 ，当signal 方法调用后，系统会从当前从condition对象的等待队列中，唤醒一个线程，一旦这个线程被唤醒，他会重新尝试获得与之绑定的重入锁，一旦获取成功，就可以继续执行。因此，在signal方法调用之后，一般需要释放相关的锁，谦让给被唤醒的线程，让他可以继续执行

### condition 的实现分析
condition  是同步器AbstractQueuedSynchronizer的内部类，个condition对象都包含着有个队列（等待队列） 该队列是condition实现等待/通知功能的关键 

condition的实现主要包括 等待队列，等待和通知
1. 等待队列：	等待队列是一个FIFO的队列，在队列中的每个节点都包含一个线程引用，该线程就是在condition 对象上等待的线程，如果线程调用了await方法，那么该线程就会释放锁，构造成节点加入等待队列并进入等待状态。
2. 等待： 调用condition的await方法，会使线程进入等待队列并释放锁，同时线程状态变为等待状态，当从await 方法返回时，当前线程一定获取了condition 相关联的锁 ，从同步队列和等待队列来看，当调用await方法时，相当于同步队列的首结点移动到condition 的等待队列中
3. 通知  调用condition的signal方法，将会唤醒在等待队列中等待事件最长的结点，在唤醒节点之前，会将结点移到同步队列中，被唤醒后的线程，将从await方法中的while循环中退出， 进而调用同步器 的acquireQueued 方法加入到获取同步状态的同步队列中，去竞争锁 。 condition 的signalAll 方法相当于对等待队列中的每个节点均执行一次signal 方法，目的在于将等待队列中所有节点全部移动到同步队列中，并唤醒每个节点的线程



