集合包是Java最常用的包，他最常用的有collection  和 map 两个接口的实现类，collection 用于存放单个对象，map 用于存放 key-value 形式的键值对

collection 中常用的又分为两种类型的接口 ： List 和 Set  ，两者明显的差别在于 List 支持放入重复的对象， 而 Set 不支持。 list  接口常用的实现类有 ： ArrayList  LinkedList  Vector   Stack

### ArrayList
ArrayLsit  是一个数组队列，相当于动态数组。它由数组实现，随机访问效率高，随机插入、随机删除效率低 。 采用Object数组的方式来存放对象的 ,无容量限制。

ArrayList 在执行插入元素时可能要扩容，在删除元素时并不会减少数组的容量（如果希望相应的缩小数组容量，可以调用 trimToSize ），在查找元素时要遍历数组，对于非null 的元素 采用equals的方式寻找 ArrayList 是非线程安全的

### LinkedList 
LinkedList是List接口的双向链表实现。由于是链表结构，所以长度没有限制；而且添加/删除元素的时候，只需要改变指针的指向（把链表断开，插入/删除元素，再把链表连起来）即可，非常方便 所以LinkedList适合用于添加/删除操作频繁的情况 。

LinkedList中，以一个内部的entry 类来代表集合中的元素，元素的值赋值element属性，entry中的next属性指向元素的后一个元素 ，previous 属性指向元素的前一个元素，基于这样的机制可以快速实现集合中元素的移动

### Stack
栈 通常是指 （后进先出 LIFO）的容器，有时栈也称为叠加栈，因为最后压入栈的元素，第一个弹出栈。LinkedLsit 具有能够直接实现栈的所有功能的方法，因此可以直接将LinkedList 作为栈使用