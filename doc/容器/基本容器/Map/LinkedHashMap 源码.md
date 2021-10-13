# LinkedHashMap 源码

LinkedHashMap 的底层实现和HashMap 一样，都是使用的 数组 + (链表/红黑树)  。不过多个一个元素有序的功能。 并且可以按照两种顺序排列。

1. 按照插入的顺序
1. 按照访问的顺序

LinkedHashMap 内部使用一个双向链表来维护这个顺序，每次插入和删除后，都会调用一个函数来进行双向链表的维护。
### LinkedHashMap 特点

1. 继承HashMap ，所以和HashMap 的底层数据结构是一样的，都是数组+(链表/红黑树) ，扩容机制也一样
1. 通过双向链表来维护数据。
1. 存储顺序和添加顺序一样。 同时可以根据accessOrder 参数来决定是否在访问时移动元素

#### 字段属性

在 HashMap.Node节点 的基础上增加了 “前继节点” 和 “后继节点” 这种双向链表的功能特性
```java
    static class Entry<K,V> extends HashMap.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, Node<K,V> next) {
            super(hash, key, value, next);
        }
    }
```
```java
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {
    //记录这个 LinkedHashMap容器的 头节点
    transient LinkedHashMap.Entry<K,V> head;
    //记录这个 LinkedHashMap容器的 尾节点
    transient LinkedHashMap.Entry<K,V> tail;
	//是否根据访问 进行排序，true表示按照访问顺序，会把访问过的元素放在链表后面。可通过构造方法进行设置
    final boolean accessOrder;
```

#### 添加元素  为了保证LinkedHashMap的迭代顺序，在添加元素时重写的4种方法

1. newNode（hash，key，value，null）
2. newTreeNode方法
3. afterNodeAccess（e）方法 该方法是在accessOrder = true并且插入的当前节点不等于尾节点时，该方法才会生效
4. afterNodeInsertion（evict）方法 移除最老的首节点

```java
 // 如果数组 table 中不包含键值对节点引用，则创建新的键值对引入,并存放到数组中,同时将创建的节点，存放在链表的尾部
Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
    LinkedHashMap.Entry<K,V> p =
        new LinkedHashMap.Entry<K,V>(hash, key, value, e); // 初始化一个新的节点
    linkNodeLast(p);  // 将添加的元素设置为链表的尾节点
    return p;
}
// 在添加元素后，将元素存放在链表尾部    
    private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
        LinkedHashMap.Entry<K,V> last = tail; // 使用临时变量记录尾节点
        tail = p; // 将尾节点设置为当前插入的节点
        if (last == null)
            head = p; // 如果尾节点为空，则设置插入的节点为头节点
        else {
            p.before = last; // 如果链表不为空，则将插入节点的前驱节点设置为原始尾节点
            last.after = p; // 原始尾节点的后驱设置尾当前插入的节点
        }
    }
```

##### newTreeNode

```java
TreeNode<K,V> newTreeNode(int hash, K key, V value, Node<K,V> next) {
    TreeNode<K,V> p = new TreeNode<K,V>(hash, key, value, next);
    linkNodeLast(p);
    return p;
}
```

##### afterNodeAccess（e） 实现LRU机制

```java

    public V get(Object key) {
        Node<K,V> e;
        if ((e = getNode(hash(key), key)) == null)
            return null;
        if (accessOrder) // 如果为true 则将访问的元素放到链表尾部
            afterNodeAccess(e);
        return e.value;
    }

void afterNodeAccess(Node<K,V> e) { // 将当前节点放到双向链表的尾部 以实现LRU机制
    LinkedHashMap.Entry<K,V> last;
    if (accessOrder && (last = tail) != e) { // 当accessOrder为true 且当前节点不等于尾节点的时候，将last 节点赋值为tail 节点
        LinkedHashMap.Entry<K,V> p =
            (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;// 记录当前节点的上一个节点和下一个节点
        p.after = null;
        if (b == null)
            head = a;
        else
            b.after = a;
        if (a != null)
            a.before = b;
        else
            last = b;
        if (last == null)
            head = p;
        else {
            p.before = last;
            last.after = p;
        }
        tail = p; // 设置尾节点尾p
        ++modCount;
    }
```





##### afterNodeInsertion 删除最老的首节点
```java
    void afterNodeInsertion(boolean evict) { // possibly remove eldest
        LinkedHashMap.Entry<K,V> first;
        if (evict && (first = head) != null && removeEldestEntry(first)) { // 当重写removeEldestEntry的话，那么将会删除最老的一个元素
            K key = first.key;
            removeNode(hash(key), key, null, false, true);
        }
    }
```
```java
void afterNodeRemoval(Node<K,V> e) { // 删除某个节点时，为了保证链表还是有序的,那么必须维护其前后节点的关系
    LinkedHashMap.Entry<K,V> p =
        (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;
    p.before = p.after = null;
    if (b == null)
        head = a;
    else
        b.after = a;
    if (a == null)
        tail = b;
    else
        a.before = b;
}
```