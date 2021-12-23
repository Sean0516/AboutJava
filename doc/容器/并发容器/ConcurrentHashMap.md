
### JDK1.7
ConcurrentHashMap 是由 Segment 和 HashEntry 数组结构构成的。其中Segment  继承了 ReentrantLock  所以 Segment 是一种可重入锁，扮演锁的角色，而 HashEntry用于存储键值对数据,当对 hash entry 数据的数据进行修改时，必须先获得他对于的segment锁

ConcurrentHashMap 在容器中设置多把锁，每一把锁用于锁容器其中一部分数据，当多线程访问容器里不同数据段的数据时，线程间就不会存在锁竞争。从而有效的提高并发访问效率。 具体实现是 ，将数据分成一段一段地存储，然后给每一段数据配一把锁， 当一个线程占用锁访问其中一个数据时，其他段的数据也能被其他线程访问

### JDK 1.8

ConcurrentHashMap 1.8 取消了 Segment 分段锁，采用CAS 和synchronized  来保证并发安全。 数据结构和HashMap1.8 的结构类似 ，由数组 + 链表/红黑树 构成 。 JAVA 8 在链表长度大于一定阈值（默认为8） 时，将会把链表 （寻址时间复杂度为 O（n））转换为红黑树 (寻址时间复杂度为 O (log n))

使用上面的方式可以保证 synchronized  只锁定当前链表或红黑二叉树的首节点，这样只要hash 不冲突，就不会产生并发

### 在JDK1.8主要设计上的改进有以下几点:

1. 不采用segment而采用node，锁住node来实现减小锁粒度。
2. 设计了MOVED状态 当resize的中过程中 线程2还在put数据，线程2会帮助resize。
3. 使用3个CAS操作来确保node的一些操作的原子性，这种方式代替了锁。
4. sizeCtl的不同值来代表不同含义，起到了控制的作用。
5. 采用synchronized而不是ReentrantLock

