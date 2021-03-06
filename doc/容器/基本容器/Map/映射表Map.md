映射表的基本思想是他维护的是键值对关联，因此你可以使用键来查找值。标准的Java类库中包含了Map 的几种基本实现： HashMap  TreeMap LinkedHashMap ,WeakHashMap  ConcurrentHashMap 等，他们都有相同的基本接口Map  但是行为特征各不相同，这表现在效率，键值对的保存和呈现次序，对象的保存周期。

性能是映射表中的一个重要问题，当在get 中使用线性搜索时，执行速度会相当地慢，而HashMap 却可以提高速度，因为Map 使用了特殊的值，使用散列码来取代对键的缓慢搜索。 散列码 是相对 唯一的 ，用以表示对象的int 值，他是通过将该对象的某些信息进行转换而生成的。hashCode 是根类Object 中的方法，因此所有Java对象都能产生散列码，而Map 就是使用对象的hashCode  进行快速查询的。此方法能够显著提高性能

1. 容量： 表所容纳的所有个数
2. 初始容量： 表在创建时所拥有的个数 ，Map ,set List 都允许你指定你的初始容量
3. 尺寸： 表中当前存储的元素个数
4. 负载因子： 尺寸/ 容量 空白的负载因子是0 。 负载轻的表产生冲突的可能性小，因此对于插入和查找都是最理想的。 HashMap 和HashSet  都是允许指定负载因子的构造器，v表示当负载情况达到了该负载因子的水平，容器将自动增加其容量 。实现的方式是使容器大致加倍，并重新将现有对象分布到新的桶位集中，这个操作被称为再散列

HashMap 使用的默认负载因子是0.75 ，这个因子在时间和空间代价之间达到了平衡，更高的负载因子可以降低表所需的空间，但是会增加查找代价。

