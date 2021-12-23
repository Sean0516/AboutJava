### add(E)

当向linked list 添加元素时，需要做的是创建一个entry对象，并将此对象的next指向header ，previous 指向header.pervious ，在完成自己的next和previous设置后，同时将位于当前元素的后一个元素的previous指向自己，并将位于当前元素的前一元素的next指向自己。这样就保持了双向链表的闭环
linked list的add 方法不用像array list 考虑扩容以及复制数组的问题，但是他没增加一个元素，都要创建一个新的entry 对象，并要修改相邻的两个元素的属性

### remove（E）
删除元素时，首先需要遍历整个linked list中的元素，遍历和寻找匹配的元素和array list相同。当寻找到匹配元素后，删除的方法就很简单了，只需要直接删除链表上的当前元素，并将当前元素中的element previous和next属性设置为null ，即可完成对象的删除
该操作比array list 更加简单，因为array list需要将当前元素所在的位子的后面的元素通过复制往前移动一位

### get(int i)
由于linked list的元素没有存储在一个数组中，因此其get 操作比array list更复杂， 在执行get 操作时，首先要判断传入的 index 值是否小于0 或者大于 等于当前 linked list 的size 值。 
首先判断当前要获取元素的位置是否小于linked list的一般，如小于，则从头找到index 位置的next元素，如大于，则从队列的尾部往前查找到index位置对于的previous元素

### contains（E）
linked list 采用遍历所有的元素， 并通过equals来判断元素

### 注意
linked list 基于双向链表机制实现
插入元素时，需要创建新的entry对象，并且换相应元素的前后元素引用；在查找元素时，需要遍历链表。 在删除元素时，也需要遍历链表，但是删除比array list 的删除更简单