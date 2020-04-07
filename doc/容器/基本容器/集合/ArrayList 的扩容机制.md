### ArrayList 的构造函数

1. 默认构造函数  使用初始化容量10 构造一个空列表 ，这里需要注意的是， 以无参构造方法创建ArrayList  时， ==实际上初始化赋值的是一个空数组，当真正对数组进行添加操作时，才正真分配容量,== 即向数组添加第一个元素时，数组容量扩充为10 
2. 带初始容量的构造函数。 若用户指定的初始容量为0 则创建一个空数组 （这个空数组和默认构造函数一样） 若初始化容量大于0 ，则创建对应初始容量的Object[] 
3. 带有extends  Collection 的数据

需要注意的是， 当ArrayList 使用无参构造时，默认大小为10 ，也就是说第一个add 的时候，分配 为10 的容量，==后续的每次扩容都会调用 Array.copyOf  方法，创建新的数组再复制。== 可以想象的是，加入需要将1000 个元素放入 ArrayList 中，采用默认构造方法，需要被动扩容13 此才可以完成存储。 但是，如果再初始化ArrayList 时就指定容器的容量，那么就可以避免被动扩容和数组复制的额外开销。

ArrayList 的扩容机制

1. add 方法

> 1. 在添加元素之前 ，需要先调用ensureCapacityInternal 方法 （传入参数为当前List 的size +1）

```
 ensureCapacityInternal(size + 1);
```

> 2. ensureCapacityInternal 方法会获取默认的容量以及传入参数的最小值(size +1) 然后调用ensureExplicitCapacity 方法判断是否需要进行扩容(比较List 当前最小值和数组的长度) 

```
  private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
```


> 3. 如果当最小需要容量- 容器原始容量  大于 0 则表示需要进行扩容， 下面就需要调用grow 方法进行扩容

2. grow 方法

```
 private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;  //获取容器的old  容量
        int newCapacity = oldCapacity + (oldCapacity >> 1); 
        if (newCapacity - minCapacity < 0) //检查扩容后的容量是否大于最小需要容量 ，若扩容后的容量仍然小于最小需要容量，则把最小需要容量当作数组的新容
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
```
> 1. 获取容器的old  容量
> 2. 获取新容量  新容量=old容量+ (old容量>>1 ) 将新容量更新为old容量的1.5 倍 需要注意的是 (在 jdk 1.6 时 ，扩容为 1.5+1)  .之所以使用位运算符。主要是因为位运算符比普通运算符的运算要块很多，因为程序仅仅移动了一下， 不需要计算，这样提高了效率，节省了资源
> 3. 检查扩容后的容量是否大于最小需要容量 ，若扩容后的容量仍然小于最小需要容量，则把最小需要容量当作数组的新容量
> 4. 比较新容量的值和 MAX_ARRAY_SIZE 的大小 进入 hugeCapacity 方法。 来决定容器的最大值。 主要是分两种情况 ，若最小需要容量大需要 MAX_ARRAY_SIZE  则 将Integer.MAX_VAKUE 作为新数组的大小。 若小，则将MAX_ARRAY_SIZE  作为新数组的容量




