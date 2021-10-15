LinkedBlockingQueue  和ArrayBlockingQueue 功能上大体一样。 只不过ArrayBlockingQueue  是有界队列，而LinkedBlockingQueue  是无界的，当然LinkedBlockingQueue  也可以定义为有界的 ，。此队列的默认和最大长度为Integer.MAX_VALUE  ，按照先进先出的原则对元素进行排序

LinkedBlockingQueue 是底层基于单向链表实现的阻塞队列 ，可以当作无界队列也可以当作有界队列 （当初始化构造函数时不传入容量，则是无界队列，当传入容量，则为有界队列）

### LinkedBlockingQueue 类的属性


```java
    private final int capacity; // 队列容量，默认为Intger.MAX
    private final AtomicInteger count = new AtomicInteger(); // 队列中元素的个数
    transient Node<E> head; // 队头
    private transient Node<E> last; // 队尾
    private final ReentrantLock takeLock = new ReentrantLock(); // take, poll, peek 等读操作的方法需要获取到这个锁
    private final Condition notEmpty = takeLock.newCondition(); //如果读操作的时候队列是空的，那么等待 notEmpty 条件
    private final ReentrantLock putLock = new ReentrantLock(); // put, offer 等写操作的方法需要获取到这个锁
    private final Condition notFull = putLock.newCondition();// 如果写操作的时候队列是满的，那么等待 notFull 条件

```

```java
public void put(E e) throws InterruptedException {
    if (e == null) throw new NullPointerException();
    int c = -1;
    Node<E> node = new Node<E>(e); // 构建新的node 节点
    final ReentrantLock putLock = this.putLock; // 获取put 锁
    final AtomicInteger count = this.count; // 获取当前链表的长度
    putLock.lockInterruptibly();
    try {
        while (count.get() == capacity) { // 当链表长度和链表容量相等 。 在notFull 队列中等待
            notFull.await();
        }
        enqueue(node); // 添加node 到链表
        c = count.getAndIncrement(); // 链表长度+1
        if (c + 1 < capacity)
            notFull.signal();// 元素插入后，队列未满，唤醒一个在notFull 上等待的线程插入元素
    } finally {
        putLock.unlock();
    }
    if (c == 0) // C表示链表为空，线程插入了一个元素后，则可以唤醒notEmpty 上等待的线程，通知它可以获取元素了
        signalNotEmpty();
}
```

```java
public E take() throws InterruptedException {
    E x;
    int c = -1;
    final AtomicInteger count = this.count;
    final ReentrantLock takeLock = this.takeLock;
    takeLock.lockInterruptibly(); // tack 锁加锁
    try {
        while (count.get() == 0) { // 如果队列为空，则将线程放入 notEmpty 队列
            notEmpty.await();
        }
        x = dequeue(); // 从队尾移除一个元素
        c = count.getAndDecrement(); // 链表长度 -1
        if (c > 1) // 队列出队后,容量不为空，唤醒 notEmpty 队列上的线程来take元素
            notEmpty.signal();
    } finally {
        takeLock.unlock();
    }
    if (c == capacity)
        signalNotFull(); // 这里的C表示之前队列是满的，现在移除元素后，则可以唤醒notFull 上等待线程，通知可以插入元素了
    return x;
}
```

如果需要获取一个元素，需要获取takelock 锁，但是获取锁还不够，如果队列此时为空，还需要队列不为空 nullEmptu 这个condition 。
如果插入一个元素，需要获取putlock ，但是获取若还不够，如果队列此时已满，还需要队列不是满 notFull 这个condition

LinkedBlockingQueue 的take 和put 方法 主要是使用 reetrantlock , condition  和    AtomicInteger 原子类来判断队列是否满了，如果满了则通知写入队列等待。 如果不满，则 AtomicInteger  加一 。