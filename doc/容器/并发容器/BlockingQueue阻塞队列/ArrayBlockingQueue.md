ArrayBlockingQueue  是一个用数组实现的有界阻塞队列，此队列a按照FIFO 的原则进行排序。默认情况下，ArrayBlockingQueue  不保证线程公平访问队列，所谓公平访问队列是指阻塞的线程，可以按照阻塞的先后顺序访问队列，即先阻塞的线程先访问队列，非公平性是对先等待的线程是非公平的，当队列可用时，阻塞的线程都可用争夺访问队列资格，可能先阻塞的线程最后才访问队列。为了保证公平性，通常会降低吞吐量。 当然，也可以使用代码创建一个公平的阻塞队列 （该公平性使用可重入锁实现）

```
ArrayBlockingQueue  arrayBlockingQueue =new ArrayBlockingQueue (100,true);
```

### ArrayBlockingQueue 有以下几个属性


```
// 用于存放元素的数组
final Object[] items;
// 下一次读取操作的位置
int takeIndex;
// 下一次写入操作的位置
int putIndex;
// 队列中的元素数量
int count;

// 以下几个就是控制并发用的同步器
final ReentrantLock lock;
private final Condition notEmpty;
private final Condition notFull;

```


ArrayBlockingQueue实现的原理是，读写操作都需要获取到AQS 独占锁才能进行操作，如果队列为空，这个时候读操作的线程进入到读线程队列，等待写传线程写入新元素，然后唤醒读线程队列的第一个等待线程。 如果队列满了，这个时候写操作的线程进入写线程队列排队 ，等待读线程进行消费，然后唤醒写线程队列的第一个等待线程

ArrayBlockingQueue 可以在构造的时候指定三个参数

1. 队列容量 ，其限制了队列中最多允许的元素个数
2. 指定独占锁是公平锁还是非公平锁。 非公平锁吞吐量搞，公平锁可以保证每次都是等待醉酒的线程获得锁
3. 指定一个集合来初始化，将此集合中的元素在构造方法期间就添加到队列中


