LinkedList类，这是一个由链表构成的类 

链表（Linked list）是一种常见的基础数据结构，是一种线性表，但是它并不会按线性的顺序存储数据，而是在每一个节点里存储到下一个节点的指针（Pointer）

#### 字段属性

```java
// 元素个数
transient int size = 0;
// 指向第一个节点的指针
transient Node<E> first;
// 指向最后一个节点的指针
transient Node<E> last;

private static class Node<E> {
        E item; // 数组元素
        Node<E> next; // 指向下一个节点
        Node<E> prev;  // 指向上一个节点
        // 构造函数
        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
}
```

#### 添加元素

##### addFirst(E e) 将指定元素添加到链表头

```java
private void linkFirst(E e) {
    // 将头节点赋值给f
    final Node<E> f = first;
    // 构造一个新的节点
    final Node<E> newNode = new Node<>(null, e, f);
    // 将新节点设置为头节点，将原来的头节点f 变为第二个节点
    first = newNode;
    if (f == null) // 如果原理的头节点为空,将这个新的节点设置为尾节点
        last = newNode;
    else
        //将原来的头节点的上一个节点指向新节点
        f.prev = newNode;
    size++; // 节点数+1
    modCount++;
}
```

##### addLast 和 add

```java
    void linkLast(E e) {
        // 将l 设置为为节点
        final Node<E> l = last;
        // 构造新的节点
        final Node<E> newNode = new Node<>(l, e, null);
        // 将尾节点设置为新的节点
        last = newNode;
        if (l == null)
            first = newNode;
        else
            // 将原来为节点的下一个节点，指向新节点
            l.next = newNode;
        size++; // 节点数加 1 
        modCount++;
    }

```

##### add(index,element)

```java
public void add(int index, E element) {
    // 判断索引是否越界
    checkPositionIndex(index);
    // 如果索引等于链表长度，则添加到尾节点
    if (index == size)
        linkLast(element);
    else
        // 获取当前index 的node 节点
        linkBefore(element, node(index));
}
	//查找index 对应的节点，并返回
    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<E> x = first;
            // 从开始节点到插入节点索引之间的所有节点向后移动一位
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            // 如果插入节点位置在后半部分
            Node<E> x = last;
            // 从最后节点到插入节点索引之间的所有节点向前移动一位
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

	// 生成新的节点，添加到链表中
  void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        // 获取当前Index node 的前驱节点
        final Node<E> pred = succ.prev;
        // 构建当前数据新的节点，设置前驱和后继节点
        final Node<E> newNode = new Node<>(pred, e, succ);
        // 设置原始节点的前驱为新的节点
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            // 设置当新节点前驱的后继节点为新节点
            pred.next = newNode;
        size++;
        modCount++;
    }
```

#### 删除元素

##### removeFirst remove 均使用的是unlinkFirst 方法

```java
// 删除第一个节点
private E unlinkFirst(Node<E> f) {
    // assert f == first && f != null;
    // 获取第一个节点的值
    final E element = f.item;
    // 获取第一个节点的后继节点
    final Node<E> next = f.next;
    // 设置第一个节点的元素，后继为null,便于垃圾回收
    f.item = null;
    f.next = null; // help GC
    // 将后继节点设置为第一个节点
    first = next;
    if (next == null)
        last = null;
    else
        // 将后继节点的前驱节点设置为null
        next.prev = null;
    // 减少元素个数
    size--;
    modCount++;
    return element;
}	
	// 删除尾节点
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        // 获取最后一个节点的元素
        final E element = l.item;
        // 获取最后一个节点的前驱
        final Node<E> prev = l.prev;
        // 将最后一个节点的元素和前驱设置为null ，方便垃圾回收
        l.item = null;
        l.prev = null; // help GC
        // 将最后一个节点的前驱设置为尾节点，同时将next 设置为空
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
        return element;
    }
```

##### remove(index) 删除指定位置的元素

```java
E unlink(Node<E> x) {
    // assert x != null;
    // 根据index 获取当前节点，以及当前节点的前驱和后继节点
    final E element = x.item;
    final Node<E> next = x.next;
    final Node<E> prev = x.prev;
    // 如果前驱为空，则表示删除第一个元素，将后继节点设置为首节点
    if (prev == null) {
        first = next;
    } else {
        // 将前驱节点的后继节点设置为需要删除的后继节点
        prev.next = next;
        x.prev = null;
    }
    // 如果后继节点为空，则涉资前驱节点为尾节点
    if (next == null) {
        last = prev;
    } else {
        // 不为空，则把后继节点的前驱节点设置为需要删除的节点的前驱节点
        next.prev = prev;
        x.next = null;
    }
    // 将需要删除的节点的前驱，后继和元素设置为Null 方便垃圾回收
    x.item = null;
    size--;
    modCount++;
    return element;
}
```

##### remove(Object o) 通过循环判断，删除第一次出现的元素

```java
public boolean remove(Object o) {
    if (o == null) {
        // 从首节点开始遍历,找到节点元素为null 的节点，删除
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null) {
                unlink(x);
                return true;
            }
        }
    } else {
        // 从首节点开始遍历,找到节点元素等于o 的节点，删除 
        for (Node<E> x = first; x != null; x = x.next) {
            if (o.equals(x.item)) {
                unlink(x);
                return true;
            }
        }
    }
    return false;
}
```

#### 迭代器

##### DescendingIterator 倒序打印链表



