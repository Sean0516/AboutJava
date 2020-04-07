1. HashMap  基于散列表的实现，插入和查询键值对的开销是固定的，可以通过构造器设置容量和负载因子，以调整容器的性能。HashMap根据键的hashCode值存储数据，大多数情况下可以直接定位到它的值，因而具有很快的访问速度，但遍历顺序却是不确定的。 HashMap最多只允许一条记录的键为null，允许多条记录的值为null。HashMap非线程安全，即任一时刻可以有多个线程同时写HashMap，可能会导致数据的不一致。如果需要满足线程安全，可以用 Collections的synchronizedMap方法使HashMap具有线程安全的能力，或者使用ConcurrentHashMap。

2. LinkedHashMap  类似于HashMap 但是迭代遍历他的时候，取得键值对的顺序是其插入次序，或者是最近最少使用（LRU）的次序 ，只比HashMap 慢一点， 而在迭代访问时反而更快，因为他使用链表维护内部次序

3. TreeMap 基于红黑树实现 ，查看 键或键值对时， 他们会被排序（次序由 Comparable 或 Comparator 决定） ，TreeMap 的特定在于， 所得到的结果是经过排序的，TreeMap 是唯一的带有subMap 的Map  他可以返回一个子树

4. WeakHashMap  弱键映射， 允许释放映射所指向的对象，这是为了解决某些特性问题而设计的，如果映射之外没有引用指向某个键，则此键 可以被垃圾收集器回收

5.  Hashtable Hashtable是遗留类，很多映射的常用功能与HashMap类似，不同的是它承自Dictionary类，并且是线程安全的，任一时间只有一个线程能写Hashtable，并发性不如ConcurrentHashMap，因为ConcurrentHashMap引入了分段锁。Hashtable不建议在新代码中使用，不需要线程安全的场合可以用HashMap替换，需要线程安全的场合可以用ConcurrentHashMap替换。

6. ConcurrentHahMap  一种线程安全的map 他不涉及同步加锁




需要注意的是，如果使用自己的类作为HashMap 的键，需要同时重载HashCode 和 equals 方法