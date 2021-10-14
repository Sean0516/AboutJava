# HashMap源码

JDK 1.8 HashMap 底层采用的是数组，数组中的元素存放在链表或红黑树中。

#### 字段属性

```java
// hashmap 初始容量为16
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
// map 最大容量

static final int MAXIMUM_CAPACITY = 1 << 30;
// 默认装载因子 主要用于阈值计算

static final float DEFAULT_LOAD_FACTOR = 0.75f;
// 当链表长度大于8 会转为红黑树

static final int TREEIFY_THRESHOLD = 8;
// 当链表长度小于6 又会转为链表
static final int UNTREEIFY_THRESHOLD = 6;
// 当map 中的容量大于这个值时，表中的链表才进行树形话

static final int MIN_TREEIFY_CAPACITY = 64;
// 初始化使用的数组
    transient Node<K,V>[] table;
    transient Set<Map.Entry<K,V>> entrySet;
    // 键值对的数量
    transient int size;
    // 快速失败
   
    transient int modCount;
    // 需要扩容的阈值 capacity * load factor 超过这个值，就进行扩容，扩容后的容量为之前的2倍
    int threshold;

```


##### HashMap 数据存放结构 （单向链表结构）
```java
static class Node<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
//红黑树
    static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next) {
            super(hash, key, val, next);
        }
    }
```

#### 确定Hash桶数组索引位置

1. 取hashCode 值
2. 高位参与运算 h>>>16  （h为hashCode 的值）
3. 取模运算  （n-1） & hash  （n 表示table 的长度）

```java
static final int hash(Object key) {
    int h;
    // 取hashCode 值, 高位参与运算 取模运算
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}

// (n - 1) & hash] 取模运算，定位当前hash 在table 中的index
    
```

#### HashMap put 方法  （putVal）

1. 判断数组table是否为空，为空则执行 resize 进行扩容
2. 根据key 计算hash 获得插入数组索引 i ，如果tab[i] 为空，则创建新节点添加。
3. 如果不为空，则判断tab[i] 的首个元素是否和key 一样，一样则直接覆盖value 。
4. 如果不一样，则判断tab[i]  是否为treeNode 如果是红黑树，则直接在树中插入键值对
5. 遍历table[i] ，判断链表长度是否大于8 ，大于8，则将链表转化为红黑树。如果遍历过程中，发现key 已经存在，则覆盖value
6. 插入成功了，进行容量判断，是否进行扩容

##### 数组上有5个元素，而某个链表上有3个元素，问此HashMap的size是多大

7 个元素  

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
    	// 初始化数组 table
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
    
    	//  如果数组 table 中不包含键值对节点引用，则创建新的键值对引入,并存放到数组中
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            // 如果键的值和节点的hash 等于链表的第一个键值对节点，则直接将e 指向该键值对
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                // 如果数组的节点为TreeNode ，则使用红黑树的插入方法
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                // 链表中遍历查找对应的key ，同时统计链表长度，当链表长度大于阈值，则进化为红黑树
                for (int binCount = 0; ; ++binCount) {
                    // 链表中不包含要插入的键值对节点时，则将该节点接在链表的最后
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            // 如果链表长度达到阈值，则进化成红黑树
                            treeifyBin(tab, hash);
                        break;
                    }
                    //当前链表包含要插入的键值对，终止遍历
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            //判断要插入的键值对是否存在 HashMap 中
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
    	//// 键值对数量超过阈值时，则进行扩容
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```
#### 扩容函数 resize

1. 计算新桶的新的容量和新的阈值
2. 将原来集合的元素重新映射到新的集合中 

```java
final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
    	// 如果 table 不为空，表明已经初始化过了
        if (oldCap > 0) {
            
            // 当 table 容量超过容量最大值，则不再扩容   
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            // 按旧容量和阈值的2倍计算新容量和阈值的大小
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                     oldCap >= DEFAULT_INITIAL_CAPACITY)
                newThr = oldThr << 1; // double threshold
        }
        else if (oldThr > 0) // initial capacity was placed in threshold
            newCap = oldThr;
        else {              
            // 调用无参构造方法时，桶数组容量为默认容量，
	        // 阈值为默认容量与默认负载因子乘积
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                      (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        @SuppressWarnings({"rawtypes","unchecked"})
    	// 创建新的桶数组
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        table = newTab;
    // 如果旧的桶数组不为空，则遍历桶数组，并将键值对映射到新的桶数组中
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }
```
#### 删除元素

1. 根据key 找到index ，元素在桶中的位置
2. 如果是链表，则遍历链表删除 。 
3. 如果是红黑树，则进行树遍历，删除元素，调整树结构 （当红黑树节点小于6时，会转化为链表）

```java
final Node<K,V> removeNode(int hash, Object key, Object value,
                           boolean matchValue, boolean movable) {
    Node<K,V>[] tab; Node<K,V> p; int n, index;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (p = tab[index = (n - 1) & hash]) != null) {
        // 定位key在桶中的位置
        Node<K,V> node = null, e; K k; V v;
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            // 获取当前的节点的元素
            node = p;
        // 如果当前节点还存在next 节点，则需要在链表和红黑树中查找需要删除的节点
        else if ((e = p.next) != null) {
            if (p instanceof TreeNode)
                // 红黑树中查找
                node = ((TreeNode<K,V>)p).getTreeNode(hash, key);
            else {
                // 链表中查找
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key ||
                         (key != null && key.equals(k)))) {
                        node = e;
                        break;
                    }
                    p = e;
                } while ((e = e.next) != null);
            }
        }

        if (node != null && (!matchValue || (v = node.value) == value ||
                             (value != null && value.equals(v)))) {
            if (node instanceof TreeNode)
                // 删除红黑树中的节点，并重新构建树结构
                ((TreeNode<K,V>)node).removeTreeNode(this, tab, movable);
            else if (node == p)
                // 直接删除数组中的元素
                tab[index] = node.next;
            else
                // 删除链表中的元素
                p.next = node.next;
            ++modCount;
            --size;
            afterNodeRemoval(node);
            return node;
        }
    }
    return null;
}
```

#### 获取Map 中对应节点的代码

```java
 final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
     //  定位键值对所在数组中的位置，如果该位置有元素，则获取第一个元素
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            // 如果hash和key都与 第一个元素相同，则第一个元素就是我们要获取的，直接返回
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                //如果 first 是 TreeNode 类型，则调用黑红树查找方法
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                //遍历链表进行查找
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
```

