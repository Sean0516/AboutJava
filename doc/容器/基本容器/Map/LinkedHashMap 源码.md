# LinkedHashMap 源码

LinkedHashMap 的底层实现和HashMap 一样，都是使用的 数组 + (链表/红黑树)  。不过多个一个元素有序的功能。 并且可以按照两种顺序排列。

1. 按照插入的顺序
1. 按照访问的顺序

LinkedHashMap 内部使用一个双向链表来维护这个顺序，每次插入和删除后，都会调用一个函数来进行双向链表的维护。
### LinkedHashMap 特点

1. 继承HashMap ，所以和HashMap 的底层数据结构是一样的，都是数组+(链表/红黑树) ，扩容机制也一样
1. 通过双向链表来维护数据。
1. 存储顺序和添加顺序一样。 同时可以根据accessOrder 参数来决定是否在访问时移动元素



### 前继后继节点
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
	//是否根据访问 进行排序，true为是，可通过构造方法进行设置
    final boolean accessOrder;
```


```java
// 在添加元素后，将元素存放在链表尾部    
private void linkNodeLast(LinkedHashMap.Entry<K,V> p) {
        LinkedHashMap.Entry<K,V> last = tail;
        tail = p;
        if (last == null)
            head = p;
        else {
            p.before = last;
            last.after = p;
        }
    }
```
### 创建新的node
```java
 // 如果数组 table 中不包含键值对节点引用，则创建新的键值对引入,并存放到数组中,同时将创建的节点，存放在链表的尾部
Node<K,V> newNode(int hash, K key, V value, Node<K,V> e) {
        LinkedHashMap.Entry<K,V> p =
            new LinkedHashMap.Entry<K,V>(hash, key, value, e);
        linkNodeLast(p);
        return p;
    }
// 同上,创建红黑树节点
 TreeNode<K,V> newTreeNode(int hash, K key, V value, Node<K,V> next) {
        TreeNode<K,V> p = new TreeNode<K,V>(hash, key, value, next);
        linkNodeLast(p);
        return p;
   }

```
### 删除node 在链表中的记录
```java
// 在删除元素之后，将元素从双向链表中删除
void afterNodeRemoval(Node<K,V> e) { // unlink
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
### 根据访问顺序来维护链表，以实现LRU机制
```java
  // 在访问元素之后，将该元素放到双向链表的尾巴处 
void afterNodeAccess(Node<K,V> e) { // move node to last
        LinkedHashMap.Entry<K,V> last;
        if (accessOrder && (last = tail) != e) {
            LinkedHashMap.Entry<K,V> p =
                (LinkedHashMap.Entry<K,V>)e, b = p.before, a = p.after;
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
            tail = p;
            ++modCount;
        }
    }
```
