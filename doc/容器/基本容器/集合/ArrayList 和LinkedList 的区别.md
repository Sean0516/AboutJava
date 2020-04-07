是否包装线程安全： arraylist 和linked list 都是不同步的，也就是不能保证线程安全

底层数据结构 array list 底层使用的是 object 数组； linked list 底层使用的是双向链表 数据结构

插入和删除是否受元素位置影响：arraylist  采用数组存储，所以插入和删除元素的时间复杂度受元素位置影响。时间复杂度为 O n linked list 采用链表存储，所以插入
，删除元素时间复杂度不受元素位置影响 ，时间复杂度为 O 1 


是否支持快速随机访问  linked list 不支持高效地随机元素访问，而 array list支持


内存空间占用  array list 空间浪费主要体现在list 列表的结尾会预留一定的容量空间 ，而 linked list则需要有额外的空间来存放直接后继和直接前驱以及数据