#### 字段属性

```java
    // 集合默认大小
    private static final int DEFAULT_CAPACITY = 10;
    // 空的数组实例
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    // 存储array list 集合的元素 数据存放在 Object 数组中
    transient Object[] elementData; // non-private to simplify nested class access
    // 集合的长度
    private int size;
	// 提供快速失败行为
	protected transient int modCount = 0;
```

#### 构造函数

```java
    // 无参构造函数将创建一个DEFAULTCAPACITY_EMPTY_ELEMENTDATA 声明的数组，初始化容量为0
    // 因此根据默认构造函数创建的集合，ArrayList list = new ArrayList()；此时集合长度是0
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }
```

#### add(E e)  方法

1. 添加元素是，确认集合大小
2. 计算数组的添加元素后的最小容量
3. 比较添加元素后的最小容量和当前数组的长度 ，判断是否需要扩容
4. 如果需要扩容则扩容 
5. 然后将数据放入数组中

```java
    public boolean add(E e) {
        // 在添加元素之前，首先要确定集合的大小
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        // 将数据放入数组中
        elementData[size++] = e;
        return true;
    }

// 计算数组的添加元素后的最小容量
private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            // 如果数组为空，则从size + 1 的值和默认值10 中取最大值
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
//         返回默认值
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        // modCount  +1 是给迭代器使用，在并发操作被修改时，提供快速失败行为
        modCount++;

        // 计算最小的容量是否大于当前数组长度，大于则调用grow 方法进行扩容
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```

#### grow 方法

1. 获取容器的原始容量
2. 获取新容量  新容量=old容量+ (old容量>>1 ) 将新容量更新为old容量的1.5 倍 需要注意的是 (在 jdk 1.6 时 ，扩容为 1.5+1)  .之所以使用位运算符。主要是因为位运算符比普通运算符的运算要块很多，因为程序仅仅移动了一下， 不需要计算，这样提高了效率，节省了资源
3. 检查扩容后的容量是否大于最小需要容量 ，若扩容后的容量仍然小于最小需要容量，则把最小需要容量当作数组的新容量
4. 比较新容量的值和 MAX_ARRAY_SIZE 的大小 进入 hugeCapacity 方法。 来决定容器的最大值。 主要是分两种情况 ，若最小需要容量大需要 MAX_ARRAY_SIZE  则 将Integer.MAX_VAKUE 作为新数组的大小。 若小，则将MAX_ARRAY_SIZE  作为新数组的容量

```java
    private void grow(int minCapacity) {
        // 获取当前数组的原始长度
        int oldCapacity = elementData.length;
        // 根据原始长度计算出新的长度 （原始长度+ 原始长度的0.5） 新数组长度为原始长度的1.5 倍
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            // 如果计算的新长度仍然小于最小长度，则使用最小容量长度作为新的长度
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // 使用copyOf 方法，将原始数组拷贝到新容量的数组中（拷贝引用）
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```

#### remove (int index )方法

```java
public E remove(int index) {
    // 判断给定索引的范围是否超过集合大小
    rangeCheck(index);

    modCount++;
    //  返回需要删除的值
    E oldValue = elementData(index);
    //  计算需要移动的数量
    int numMoved = size - index - 1;
    if (numMoved > 0)
        // 对数组进行自身拷贝
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    //设置为Null用于垃圾回收
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}
```

#### remove（Object o）方法

删除第一次出现的该元素。然后通过System.arraycopy进行数组自身拷贝

#### set(index , element)

```java
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        // 将指定index 的元素替换为element,并返回老元素
        elementData[index] = element;
        return oldValue;
    }	
```

#### 迭代器 通过内部类 Itr实现



```java
private class Itr implements Iterator<E> {
        int cursor;       // 游标 ，下一个需要返回的元素的索引
        int lastRet = -1; //  返回最后一个元素的索引，如果没有 返回-1
        int expectedModCount = modCount;    
Itr() {}
    // 通过游标判断是否还有下一个元素
    public boolean hasNext() {
        return cursor != size;
    }

    @SuppressWarnings("unchecked")
    public E next() {
        // 迭代器在进行元素迭代时，同时增加和删除操作会抛出异常
        checkForComodification();
        int i = cursor;
        if (i >= size)
            throw new NoSuchElementException();
        Object[] elementData = ArrayList.this.elementData;
        if (i >= elementData.length)
            throw new ConcurrentModificationException();
        cursor = i + 1;
        return (E) elementData[lastRet = i];
    }

    public void remove() {
        if (lastRet < 0)
            throw new IllegalStateException();
        checkForComodification();

        try {
            ArrayList.this.remove(lastRet);
            cursor = lastRet; // 游标指向删除元素的位置
            lastRet = -1; // lastRet 恢复默认值 -1
            // expectedModCount 和 modCount 同步，因为在进行add 和remove 时, modCount 会加1
            expectedModCount = modCount;
        } catch (IndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void forEachRemaining(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        final int size = ArrayList.this.size;
        int i = cursor;
        if (i >= size) {
            return;
        }
        final Object[] elementData = ArrayList.this.elementData;
        if (i >= elementData.length) {
            throw new ConcurrentModificationException();
        }
        while (i != size && modCount == expectedModCount) {
            consumer.accept((E) elementData[i++]);
        }
        // update once at end of iteration to reduce heap write traffic
        cursor = i;
        lastRet = i - 1;
        checkForComodification();
    }

    final void checkForComodification() {
        // 不能在迭代器进行元素迭代时进行增加和删除操作。否证会抛出异常
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
    }
}
```

#### 迭代器ListIterator

能实现一边遍历，一边进行新增或删除操作

```java
private class ListItr extends Itr implements ListIterator<E> {
        ListItr(int index) {
            super();
            cursor = index;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }

        @SuppressWarnings("unchecked")
        public E previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return (E) elementData[lastRet = i];
        }

        public void set(E e) {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                ArrayList.this.set(lastRet, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
		// 添加元素
        public void add(E e) {
            checkForComodification();

            try {
                int i = cursor;
                ArrayList.this.add(i, e);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
```

