LinkedBlockingQueue  和ArrayBlockingQueue 功能上大体一样。 只不过ArrayBlockingQueue  是有界队列，而LinkedBlockingQueue  是无界的，当然LinkedBlockingQueue  也可以定义为有界的 ，。此队列的默认和最大长度为Integer.MAX_VALUE  ，按照先进先出的原则对元素进行排序

LinkedBlockingQueue 是底层基于单向链表实现的阻塞队列 ，可以当作无界队列也可以当作有界队列 （当初始化构造函数时不传入容量，则是无界队列，当传入容量，则为有界队列）

### LinkedBlockingQueue 类的属性


```
// 队列容量
private final int capacity;

// 队列中的元素数量
private final AtomicInteger count = new AtomicInteger(0);

// 队头
private transient Node<E> head;

// 队尾
private transient Node<E> last;

// take, poll, peek 等读操作的方法需要获取到这个锁
private final ReentrantLock takeLock = new ReentrantLock();

// 如果读操作的时候队列是空的，那么等待 notEmpty 条件
private final Condition notEmpty = takeLock.newCondition();

// put, offer 等写操作的方法需要获取到这个锁
private final ReentrantLock putLock = new ReentrantLock();

// 如果写操作的时候队列是满的，那么等待 notFull 条件
private final Condition notFull = putLock.newCondition();
```

如果需要获取一个元素，需要获取takelock 锁，但是获取锁还不够，如果队列此时为空，还需要队列不为空 nullEmptu 这个condition 。
如果插入一个元素，需要获取putlock ，但是获取若还不够，如果队列此时已满，还需要队列不是满 notFull 这个condition

LinkedBlockingQueue 的take 和put 方法 主要是使用 reetrantlock , condition  和    AtomicInteger 原子类来判断队列是否满了，如果满了则通知写入队列等待。 如果不满，则 AtomicInteger  加一 。