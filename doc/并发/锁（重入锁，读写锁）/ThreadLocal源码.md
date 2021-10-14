

ThreadLocal 类 提供了 get/set 线程局部变量的实现，ThreadLocal 成员变量与正常的成员变量不同，每个线程都可以通过 ThreadLocal 成员变量 get/set 自己的专属值。

ThreadLocal能为每个 Thread线程 绑定一个专属值的奥秘就是：

每个Thread对象都持有一个 ThreadLocalMap类型的成员变量，其key为ThreadLocal对象，value为绑定的值，所以每个线程调用 ThreadLocal对象 的set(T value)方法时，都会将该ThreadLocal对象和绑定的值 以键值对的形式存入当前线程，这样，同一个ThreadLocal对象就可以为每个线程绑定一个专属值咯。

每个线程调用 ThreadLocal对象的get()方法时，就可以根据 当前ThreadLocal对象 get到 绑定的值。

#### set方法

```java
public void set(T value) {
    Thread t = Thread.currentThread(); // 获取当前线程
    ThreadLocalMap map = getMap(t); // 获取当前线程的 ThreadLocalMap
    if (map != null) // map不为空,设置参数
        map.set(this, value);
    else
        createMap(t, value); // map 为kong ,创建map ,设置参数
}
```

get 方法

```java
public T get() {
    Thread t = Thread.currentThread();
    ThreadLocalMap map = getMap(t); // 获取当前线程的threadLocal Map
    if (map != null) {
        ThreadLocalMap.Entry e = map.getEntry(this); // 以当前thread local 为key 获取map中的value
        if (e != null) {
            @SuppressWarnings("unchecked")
            T result = (T)e.value;
            return result;
        }
    }
    return setInitialValue();// map 未找到,则初始化map ，且返回null 值
}
```



#### 静态内部类ThreadLocalMap 

##### 字段属性

```java
private static final int INITIAL_CAPACITY = 16; // 初始长度和HashMap 一样，且必须为 2 的倍数

private Entry[] table; // 用来存放键值对的数组

private int size = 0; // 数组长度

private int threshold; // 数组长度阈值 len * 2 / 3

private void setThreshold(int len) {
    threshold = len * 2 / 3;
}
        
static class Entry extends WeakReference<ThreadLocal<?>> { // Entry 对象 弱引用的ThreadLocal key
            Object value;
            Entry(ThreadLocal<?> k, Object v) {
                super(k);
                value = v;
            }
        }
```

```java
private Entry getEntry(ThreadLocal<?> key) { // 根据key 获取Entry 数组中对应的Entry 实例
    int i = key.threadLocalHashCode & (table.length - 1); // 类似hash map 的取模运算 ，定位当前key 在entry 数组中的index 下标
    Entry e = table[i]; // 获取到对应的节点获取key
    if (e != null && e.get() == key)
        return e;
    else
        return getEntryAfterMiss(key, i, e);
}
```



#### set  方法

```java
private void set(ThreadLocal<?> key, Object value) {
    Entry[] tab = table;
    int len = tab.length;
    int i = key.threadLocalHashCode & (len-1); // 根据hash和数组长度获取元素存放的位置，如果该位置有其他元素，就依次向后放

    for (Entry e = tab[i];
         e != null;
         e = tab[i = nextIndex(i, len)]) {
        ThreadLocal<?> k = e.get();

        if (k == key) { // key 相等，则覆盖value
            e.value = value;
            return;
        }

        if (k == null) {
            replaceStaleEntry(key, value, i); //key 未空，则用新key 和value 覆盖
            return;
        }
    }

    tab[i] = new Entry(key, value);
    int sz = ++size;
    if (!cleanSomeSlots(i, sz) && sz >= threshold) // 超过阈值，则rehash
        rehash();
}

  private void rehash() { // 调整当前table 容量，首先扫描整个容器,以删除过时的条目，如果不能分充分缩小表的大小，则进行扩容操作
            expungeStaleEntries();

            // Use lower threshold for doubling to avoid hysteresis
            if (size >= threshold - threshold / 4)
                resize();
        }
        private void resize() { // 扩容为原来的两倍
            Entry[] oldTab = table;
            int oldLen = oldTab.length;
            int newLen = oldLen * 2;
            Entry[] newTab = new Entry[newLen];
            int count = 0;

            for (int j = 0; j < oldLen; ++j) {// 遍历元素数组
                Entry e = oldTab[j];
                if (e != null) {
                    ThreadLocal<?> k = e.get();
                    if (k == null) { // 如果key 为空,则将value也设置为null ，方便垃圾回收
                        e.value = null; // Help the GC
                    } else {
                        int h = k.threadLocalHashCode & (newLen - 1);
                        while (newTab[h] != null)
                            h = nextIndex(h, newLen);
                        newTab[h] = e;
                        count++;
                    }
                }
            }

            setThreshold(newLen);//设置新的阈值
            size = count;
            table = newTab;
        }

```

#### 总结：

1. threadlocal 不是用来解决线程安全的问题。 目的是为了使线程能够使用本地变量
2. 如果使用了线程池，线程回收后threalLocal 变量要remove 。 否证线程池回收线程后，变量还在内存中，容易造成内存泄漏 