Set 是不保存重复的元素的容器，如果试图将相同对象的多个实例添加到Set 中，那么他会阻止这种重复现像。

Set 具有与Collection 完全一样的接口，因此没有额外的功能。HashSet 中值的输出顺序没有任何规律可循，这是因为处于速度的考虑，HashSet 使用了散列。

HashSet ,TreeSet 和LinkedHashSet 的元素顺序是不同的，他们有各自的元素存储方式，TreeSet  将元素存储红黑树数据结构中，而HashSet  使用的是散列，LinkedHashSet 因为查询速度也使用了散列，但是他使用了链表来维护元素的插入顺序

不同的Set的实现不仅具有不同的行为，而且他们对于可以在特定的Set 中放置的元素的类型也有不同的要求：

1. Set(interface) ： 存入Set 中的每个元素必须是唯一的，因为Set 不保存重复元素，加入Set 的元素必须定义equals 方法来确保对象的唯一性。 set 和Collection 有完全一样的接口，Set 接口不保证维护元素的顺序

2. HashSet (默认选择，对速度进行了优化)： 为快速查找而设计的Set 存入HashSet 的元素必须定义hashCode()

3.TreeSet ： 保持次序的Set ，底层为树结构。 使用他可以从Set 中提取有序的序列。 元素必须实现Comparable 接口

4.LinkedHashSet 具有HashSet的查询速度，并且内部使用链表维护元素的顺序（插入的顺序），于是 在使用迭代器遍历Set 时，结果会按照元素插入的次序显示。元素也必须定义hashCode()方法