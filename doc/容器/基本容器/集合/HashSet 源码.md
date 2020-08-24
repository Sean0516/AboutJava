# HashSet 源码

HashSet 本身并没有什么特别的东西，它提供的所有集合核心功能，都是基于HashMap来实现的
HashSet 有如下特点

1. 内部使用HashMap的key存储元素，以此来保证元素不重复
1. HashSet是无序的，因为HashMap的key是无序的
1. HashSet中允许有一个null元素，因为HashMap允许key为null
1. HashSet是非线程安全的



```java
public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, java.io.Serializable{
    static final long serialVersionUID = -5024744406713321676L;
	// 基于HahMap 实现,由HashMap 的key 的唯一性来保证元素不重复
    private transient HashMap<E,Object> map;
	// 只需要用到HashMap中key唯一的特性，所以value全部使用同一个 Object实例填充，节省内存空间
    private static final Object PRESENT = new Object();
	// 实例化 HashSet 的时候，实际上初始化的是内部的HashMap
    public HashSet() {
        map = new HashMap<>();
    }
    public HashSet(int initialCapacity, float loadFactor) {
        map = new HashMap<>(initialCapacity, loadFactor);
    }
    // 迭代器
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
    // 添加功能，使用HashMap 的put 功能, 传入对应的key 和固定的Object 实例 PRESENT
    public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
    public boolean remove(Object o) {
        return map.remove(o)==PRESENT;
    }
    public void clear() {
        map.clear();
    }
}
```
