### HashMap 和HashTable 的区别
1. 线程是否安全  hashmap 是非线程安全的，hashTable  是线程安全的； HashTable 的内部方法基本都经过synchronized 修饰 （需要注意的是，如果要保证线程安全 ，尽可能使用ConcurrentHashMap （ConcurrentHashMap 该map 1.7 和 1.8的实现方式不一样。后面会细说））
2. 效率问题  由于 hashTable 使用了 synchronized 锁。 所以效率较 hashMap 会低一些。 且 hashtable 基本上已经淘汰使用 ，而且有ConcurrentHashMap  更好的类使用
3. 对null key和 null value 的支持 map 中 ，可以允许有一个null 可以 ，多个 null value 。 但是 table 中不允许有Null  key  ，如果put null key ,则会报空指针异常
4. 初始容量大小和每次扩充容量的大小  创建时如果不指定容量初始值，hashtable 的默认大小为 11  ，每次扩充，容量变为之前的 2n +1   map 的初始化容量大小是16 .之后每次扩充， 容量会变为原来的2 倍  创建时指定初始值 table 会直接使用给定的初始值， 而map 则会将给定的值扩充为 2 的幂次方大小 （由方法 tableSizeFor 方法保证） 也就是说，map 总是使用2 的幂次方作为哈希表的大小。
5. 底层数据结构    jdk 1.8 之后的hashmap 在解决哈希冲突时由了较大的变化， 当链表长度大于阈值（默认为8）时 ，将链表转为红黑树 ，以减少搜索时间。 hashtable 没这样的机制
