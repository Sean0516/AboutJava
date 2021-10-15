ArrayBlockingQueue  是一个用数组实现的有界阻塞队列，此队列a按照FIFO 的原则进行排序。默认情况下，ArrayBlockingQueue  不保证线程公平访问队列，所谓公平访问队列是指阻塞的线程，可以按照阻塞的先后顺序访问队列，即先阻塞的线程先访问队列，非公平性是对先等待的线程是非公平的，当队列可用时，阻塞的线程都可用争夺访问队列资格，可能先阻塞的线程最后才访问队列。为了保证公平性，通常会降低吞吐量。 当然，也可以使用代码创建一个公平的阻塞队列 （该公平性使用可重入锁实现）

```
ArrayBlockingQueue  arrayBlockingQueue =new ArrayBlockingQueue (100,true);
```

#### 字段属性


```java
    final Object[] items; // 数组中存储队列的元素
    int takeIndex; // take 索引, 下一个待移除元素的数组索引
    int putIndex; //put 索引,下一个待插入位置的数组索引
    int count; // 队列中元素个数
    final ReentrantLock lock; // 全局锁 用来管理所有的访问
    private final Condition notEmpty; // 非空条件队列
    private final Condition notFull; // 非满条件队列
```

#### put 阻塞式插入

```java
public void put(E e) throws InterruptedException { // 阻塞式插入元素
    checkNotNull(e); // 判断元素是否为空
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly(); // 尝试加锁,保证只有一个线程执行入队操作
    try {
        while (count == items.length) // 如果队列满了,当前线程会被阻塞,让出lock 并在notFull 条件队列中等待被其他线程唤醒
            notFull.await();
        enqueue(e); // 有空闲位置,插入元素
    } finally {
        lock.unlock();
    }
}
    private void enqueue(E x) {
        // assert lock.getHoldCount() == 1;
        // assert items[putIndex] == null;
        final Object[] items = this.items;
        items[putIndex] = x;
        if (++putIndex == items.length)
            putIndex = 0;
        count++;
        notEmpty.signal(); // 唤醒notEmpty 中等待的线程
    }

```

##### take 阻塞式移除元素

```java
public E take() throws InterruptedException {
    final ReentrantLock lock = this.lock;
    lock.lockInterruptibly();
    try {
        while (count == 0) // 如果队列为空,线程被阻塞在notEmpty 条件队列上
            notEmpty.await();
        return dequeue();
    } finally {
        lock.unlock();
    }
}

    private E dequeue() {
        // assert lock.getHoldCount() == 1;
        // assert items[takeIndex] != null;
        final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        E x = (E) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        count--;
        if (itrs != null)
            itrs.elementDequeued();
        notFull.signal(); // 因为移除了一个元素,可以唤醒notFull 上的队列,继续put数据
        return x;
    }

```



ArrayBlockingQueue实现的原理是，读写操作都需要获取到AQS 独占锁才能进行操作，如果队列为空，这个时候读操作的线程进入到读线程队列，等待写传线程写入新元素，然后唤醒读线程队列的第一个等待线程。 如果队列满了，这个时候写操作的线程进入写线程队列排队 ，等待读线程进行消费，然后唤醒写线程队列的第一个等待线程

ArrayBlockingQueue 可以在构造的时候指定三个参数

1. 队列容量 ，其限制了队列中最多允许的元素个数
2. 指定独占锁是公平锁还是非公平锁。 非公平锁吞吐量搞，公平锁可以保证每次都是等待最久的线程获得锁
3. 指定一个集合来初始化，将此集合中的元素在构造方法期间就添加到队列中

