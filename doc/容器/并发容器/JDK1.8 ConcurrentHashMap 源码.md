# JDK1.8 ConcurrentHashMap 源码

JDK1.7 使用的分段锁机制，其内部类Segment 继承了ReentrantLock ，将容器内的数组划分为多段区域，每个区域对应一把锁 ，但是在数据量庞大的情况下，性能依然不容乐观， 只能通过不断的增加锁来维持并发性能。而JDK1.8 则使用了CAS 乐观锁和synchronized 局部锁处理并发问题， 锁粒度更细，即使数据量恒大也能保证良好的并发性
ConcurrentHashMap 和HashMap 的常量和成员变量类似。 主要新增了以下比较重要的参数
```java
static final int MOVED     = -1; // 表示正在转移
static final int TREEBIN   = -2; // 表示已经转换成树
static final int RESERVED  = -3; // hash for transient reservations
static final int HASH_BITS = 0x7fffffff; // usable bits of normal node hash
transient volatile Node<K,V>[] table;//默认没初始化的数组，用来保存元素
private transient volatile Node<K,V>[] nextTable;//转移的时候用的数组
```
 ConcurrentHashMap 的核心就在于其put元素时 利用synchronized局部锁 和 CAS乐观锁机制 大大提升了本集合的并发能力，比JDK7的分段锁性能更强
```java
final V putVal(K key, V value, boolean onlyIfAbsent) {
        if (key == null || value == null) throw new NullPointerException();
        int hash = spread(key.hashCode());
        int binCount = 0;
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                // 当前指定数组位置无元素时，使用CAS操作 将 Node键值对 放入对应的数组下标。
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            // 如果检测到某个节点的hash值是MOVED，则表示正在进行数组扩张的数据复制阶段则当前线程也会参与去复制，通过允许多线程复制的功能，一次来减少数组的复制所带来的性能损失
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                //如果在这个位置有元素的话（hash 冲突），就采用synchronized的方式加锁
                V oldVal = null;
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            //元素进行遍历，如果找到了key和key的hash值都一样的节点，则把它的值替换到， 如果没找到的话，则添加在链表的最后面
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        // 如果从链表转为红黑树，则使用红黑树的方式putTreeVal 元素到树中
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        addCount(1L, binCount);
        return null;
    }
```


