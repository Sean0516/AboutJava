PriorityBlockingQueue 支持在并发情况下的优先级的无界阻塞队列，默认情况下采取自然顺序升序排序，也可以自定义compareTo  方法来来指定元素排序规则，或者在初始化PriorityBlockingQueue 指定构造参数comparator 来对元素进行排序 ，需要注意的是，不能保证同优先级元素的顺
PriorityBlockingQueue 只能指定队列的初始化大小，如果不指定，默认为11 ，但是，在插入元素时( put 方法不会被block ，take 方法在队列为空的时候会阻塞)，如果空间不够PriorityBlockingQueue 会自动进行扩容 。

### PriorityBlockingQueue 拥有的属性如下
```java
// 构造方法中，如果不指定大小的话，默认大小为 11
private static final int DEFAULT_INITIAL_CAPACITY = 11;
// 数组的最大容量
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

// 这个就是存放数据的数组
private transient Object[] queue;

// 队列当前大小
private transient int size;

// 大小比较器，如果按照自然序排序，那么此属性可设置为 null
private transient Comparator<? super E> comparator;

// 并发控制所用的锁，所有的 public 且涉及到线程安全的方法，都必须先获取到这个锁
private final ReentrantLock lock;

// 这个很好理解，其实例由上面的 lock 属性创建
private final Condition notEmpty;

// 这个也是用于锁，用于数组扩容的时候，需要先获取到这个锁，才能进行扩容操作
// 其使用 CAS 操作
private transient volatile int allocationSpinLock;
```


PriorityBlockingQueue 类实现了collection 和iterator 接口中的所有接口方法，但是在对其对象进行遍历时，不能保证有序性，如果想要实现有序遍历，建议采用Arrays.sort(queue.toArray) 进行处理。 但是还需要说明的是，PriorityBlockingQueue 中，如果两个对象的优先级相同，队列不保证他们之间的们优先级

PriorityBlockingQueue 使用基于数组的二叉堆 来存放元素，所有的public方法采用同一个lock 进行并发控制
二叉堆：一颗完全二叉树，它非常适合用数组进行存储，对于数组中的元素 a[i]，其左子节点为 a[2*i+1]，其右子节点为 a[2*i + 2]，其父节点为 a[(i-1)/2]，其堆序性质为，每个节点的值都小于其左右子节点的值。二叉堆中最小的值就是根节点，但是删除根节点是比较麻烦的，因为需要调整树。

### 扩容方法


```java
private void tryGrow(Object[] array, int oldCap) {
    // 这边做了释放锁的操作
    lock.unlock(); // must release and then re-acquire main lock
    Object[] newArray = null;
    // 用 CAS 操作将 allocationSpinLock 由 0 变为 1，也算是获取锁
    if (allocationSpinLock == 0 &&
        UNSAFE.compareAndSwapInt(this, allocationSpinLockOffset,
                                 0, 1)) {
        try {
            // 如果节点个数小于 64，那么增加的 oldCap + 2 的容量
            // 如果节点数大于等于 64，那么增加 oldCap 的一半
            // 所以节点数较小时，增长得快一些
            int newCap = oldCap + ((oldCap < 64) ?
                                   (oldCap + 2) :
                                   (oldCap >> 1));
            // 这里有可能溢出
            if (newCap - MAX_ARRAY_SIZE > 0) {    // possible overflow
                int minCap = oldCap + 1;
                if (minCap < 0 || minCap > MAX_ARRAY_SIZE)
                    throw new OutOfMemoryError();
                newCap = MAX_ARRAY_SIZE;
            }
            // 如果 queue != array，那么说明有其他线程给 queue 分配了其他的空间
            if (newCap > oldCap && queue == array)
                // 分配一个新的大数组
                newArray = new Object[newCap];
        } finally {
            // 重置，也就是释放锁
            allocationSpinLock = 0;
        }
    }
    // 如果有其他的线程也在做扩容的操作
    if (newArray == null) // back off if another thread is allocating
        Thread.yield();
    // 重新获取锁
    lock.lock();
    // 将原来数组中的元素复制到新分配的大数组中
    if (newArray != null && queue == array) {
        queue = newArray;
        System.arraycopy(array, 0, newArray, 0, oldCap);
    }
}

```

扩容方法对并发的控制也非常的巧妙，释放了原来的独占锁 lock，这样的话，扩容操作和读操作可以同时进行，提高吞吐量。