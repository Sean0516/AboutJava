# JDK1.8 ConcurrentHashMap 源码

JDK1.7 使用的分段锁机制，其内部类Segment 继承了ReentrantLock ，将容器内的数组划分为多段区域，每个区域对应一把锁 ，但是在数据量庞大的情况下，性能依然不容乐观， 只能通过不断的增加锁来维持并发性能。而JDK1.8 则使用了CAS 乐观锁和synchronized 局部锁处理并发问题， 锁粒度更细，即使数据量恒大也能保证良好的并发性

#### 节点类型

节点类型有五种：Node、TreeBin、TreeNode、ForwardingNode和ReservationNode

![image-20211014164127841](https://gitee.com/Sean0516/image/raw/master/img/image-20211014164127841.png)



在Node 桶中，Node 连接着一个链表，数据被封装成Node 节点以链表的方式存储，在TreeBin 桶中，TreeBin 连接着一个红黑树，真实数据被封装成TreeNode 节点以红黑树的结构存储。TreeBin 指向红黑树的根节点。

##### ForwardingNode

ForwardingNode是一种临时节点，hash值为固定值 -1，在扩容进行中才会出现，相当于一个占位节点。当table中节点数量到达指定的阈值时，ConcurrentHashMap就会进行扩容。扩容时ConcurrentHashMap会新建一个数组nextTable，将原来数组table中的数据迁移到新的数组nextTable中。当table数组的一个hash桶中全部的节点都迁移到了nextTable中，原table数组的桶中会被放置一个ForwardingNode节点

##### ReservationNode

ReservationNode是一个保留节点，hash值为固定值 -3，在ConcurrentHashMap中就相当于一个占位符，不存储实际的数据，正常情况不会出现。在ConcurrentHashMap中，computeIfAbsent和compute这两个函数在加锁时会使用ReservationNode起到占位符的作用

##### treeBin

treeBin是红黑树的顶级节点，hash值为固定值 -1。当桶中的数据以红黑树结构存储的时候，TreeBin作为桶的顶级节点，存储在table中 

使用treeBin主要是为了：

1.  降低treeNode 的复杂度
2. 指定根节点。 可以让在顶级节点加锁的方式实现线程安全



ConcurrentHashMap 和HashMap 的常量和成员变量类似。 主要新增了以下比较重要的参数

#### 字段属性

```java
static final int MOVED     = -1; // 表示正在转移
static final int TREEBIN   = -2; // 表示已经转换成树
static final int RESERVED  = -3; // hash for transient reservations
static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
transient volatile Node<K,V>[] table;//默认没初始化的数组，用来保存元素
private transient volatile Node<K,V>[] nextTable;//转移的时候用的数组
private transient volatile int sizeCtl; // 参数用途很多
```

##### sizeCtl

sizeCtl的用途比较多，其中负数代表正在进行初始化或者扩容操作。根据情境的不同，sizeCtl有不同的含义及作用，总结起来分为以下四种情况

1. sizeCtl =0 默认值，表示table 初始化时使用默认容量
2. sizeCtl>0   
   1. 如果table未初始化，sizeCtl表示table初始化的容量
   2. table 已经 已经初始化，sizeCtl表示table扩容的阈值。 
3. sizeCtl=-1 表示有线程正在初始化table数组操作。 使用CAS 更新sizeCtl 的值保证只有一个线程执行初始化操作
4.  sizeCtl = -(1 + nThreads) 表示有nThreads 个线程在进行扩容操作

 ConcurrentHashMap 的核心就在于其put元素时 利用synchronized局部锁 和 CAS乐观锁机制 大大提升了本集合的并发能力，比JDK7的分段锁性能更强

#### putVal 方法

1. 数组未初始化，初始化table ，然后重新执行插入操作
2. table[i] 数组为空，通过CAS 将数据插入table,插入失败，则重新自旋插入操作
3. table[i]不为空 ，如果正在扩容，则需要先扩容，扩容完毕后，重新开始插入操作
4. 当hash 冲突
   1. 首先对table[i]加锁 ，同时检测table[i] 是否被修改。如果已经被修改，则重新插入操作
   2. 若加锁成功。 判断table[i] 是链表还是红黑树 ，通过hash 值来判断类型 如果 hash >0 则表示链表 

![image-20211014173231657](https://gitee.com/Sean0516/image/raw/master/img/image-20211014173231657.png)

```java
 final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode()); // 计算hash
        int binCount = 0; // 桶中的bin 数量
        for (Node<K,V>[] tab = table;;) { // 自旋插入数据
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0) // 数组为空,初始化数组
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) { //table[i]无数据, 使用CAS操作 将 Node键值对 放入对应的数组下标。
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null))) //CAS 失败，自旋
                    break;                   // no lock when adding to empty bin CAS 成功跳出循环
            }
            else if ((fh = f.hash) == MOVED) // 如果检测到某个节点的hash值是MOVED，则表示正在进行数组扩张的数据复制阶段则当前线程也会参与去复制，通过允许多线程复制的功能，一次来减少数组的复制所带来的性能损失
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                synchronized (f) { // 对当前Node进行加锁
                    if (tabAt(tab, i) == f) {// 检测数据是否被其他线程修改
                        if (fh >= 0) { // 表示neode 节点是链表
                            binCount = 1;
                            for (Node<K,V> e = f;; ++binCount) { // 元素进行遍历，如果找到了key和key的hash值都一样的节点，则把它的值替换到， 如果没找到的话，则添加在链表的最后面
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) { // key 是否相等，相等则更新节点的值
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null); // 不相等则新建一个node 加入链表中
                                    break;
                                }
                            }
                        }
                        else if (f instanceof TreeBin) { // 如果是红黑树
                            Node<K,V> p;
                            binCount = 2; // 插入红黑树 binCount等于2
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) { // binCount >0 表示插入成功，同时判断链表是否转换为红黑树
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i); // 链表转换为红黑树
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount); // 插入结束更新元素总数,判断是否需要扩容
        return null;
    }
// 将链表转换为红黑树
 private final void treeifyBin(Node<K,V>[] tab, int index) {
        Node<K,V> b; int n, sc;
        if (tab != null) {
            if ((n = tab.length) < MIN_TREEIFY_CAPACITY) // 如果table 容量小于64 将table扩容2倍
                tryPresize(n << 1);
            else if ((b = tabAt(tab, index)) != null && b.hash >= 0) { // 如果大于64 则进行链表到红黑树的转换
                synchronized (b) {
                    if (tabAt(tab, index) == b) {// 检测是否被其他线程修改
                        TreeNode<K,V> hd = null, tl = null;
                        for (Node<K,V> e = b; e != null; e = e.next) { // 遍历双向链表，创建双向链表
                            TreeNode<K,V> p =
                                new TreeNode<K,V>(e.hash, e.key, e.val,
                                                  null, null); // 将node 节点转换为tree node
                            if ((p.prev = tl) == null)
                                hd = p;
                            else
                                tl.next = p;
                            tl = p;
                        }
                        setTabAt(tab, index, new TreeBin<K,V>(hd)); // 以TreeBin 类型包装双向链表为红黑树，报错TreBin 到table[index] 中
                    }
                }
            }
        }
    }
```

##### initTable

initTable方法使用CAS无锁策略，保证同时只能有一个线程执行初始化table的工作

```java
private final Node<K,V>[] initTable() { // 初始化数组
    Node<K,V>[] tab; int sc;
    while ((tab = table) == null || tab.length == 0) {
        if ((sc = sizeCtl) < 0) // 有其他线程进行初始化操作 线程自旋，让出CPU
            Thread.yield(); // lost initialization race; just spin
        else if (U.compareAndSwapInt(this, SIZECTL, sc, -1)) { // CAS 更新sizeCTL 为-1 成功，表示当前线程进行初始化工作
            try {
                if ((tab = table) == null || tab.length == 0) {
                    int n = (sc > 0) ? sc : DEFAULT_CAPACITY;
                    @SuppressWarnings("unchecked")
                    Node<K,V>[] nt = (Node<K,V>[])new Node<?,?>[n];
                    table = tab = nt;
                    sc = n - (n >>> 2);
                }
            } finally {
                sizeCtl = sc; // 设置sizeCtl 用作扩容的阈值
            }
            break;
        }
    }
    return tab;
}
```

#### replaceNode

![image-20211014173415568](https://gitee.com/Sean0516/image/raw/master/img/image-20211014173415568.png)



#### get 方法

```java
public V get(Object key) {
    Node<K,V>[] tab; Node<K,V> e, p; int n, eh; K ek;
    int h = spread(key.hashCode()); // 计算hash 值
    if ((tab = table) != null && (n = tab.length) > 0 && // table 已经初始化
        (e = tabAt(tab, (n - 1) & h)) != null) {  // 定位key 在table的位置
        if ((eh = e.hash) == h) {
            if ((ek = e.key) == key || (ek != null && key.equals(ek))) // 相等访问值
                return e.val;
        }
        else if (eh < 0)
            return (p = e.find(h, key)) != null ? p.val : null; // 在红黑树中查找 需要加锁查找
        while ((e = e.next) != null) { // 遍历链表查找
            if (e.hash == h &&
                ((ek = e.key) == key || (ek != null && key.equals(ek))))
                return e.val;
        }
    }
    return null;
}
```

##### size 方法

键值对计数时使用了分段锁的思路，计数相关的字段为：baseCount和counterCells数组

counterCells数组为计数数组，属于CounterCell类型的volatile数组，当有并发冲突时，更新计数时会累加到counterCells数组中。CounterCell类比较简单，只有一个value字段，用于保存计数信息

```java
final long sumCount() {// 计算map 中键值对的总数
    CounterCell[] as = counterCells; CounterCell a;
    long sum = baseCount;
    if (as != null) {
        for (int i = 0; i < as.length; ++i) { // 遍历累加 counterCells 中所有数据
            if ((a = as[i]) != null)
                sum += a.value;
        }
    }
    return sum;
}
```

#### 扩容和数据迁移 （太复杂，后面理解）

首先是数组扩容，新建一个2倍于原来容量的新数组newTable，这一步需保证只能由一个线程完成。

然后进行数据迁移，把旧数组table中的所有元素重新计算桶的位置后再转移到新数组中

