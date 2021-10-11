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

