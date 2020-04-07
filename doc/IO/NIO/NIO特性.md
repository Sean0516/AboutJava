java.nio全称java non-blocking IO（实际上是 new io），是指JDK 1.4 及以上版本里提供的新api（New IO） ，为所有的原始类型（boolean类型除外）提供缓存支持的数据容器，使用它可以提供非阻塞式的高伸缩性网络。

### NIO 有如下特性

1. 非阻塞IO 

NIO 是非阻塞的，线程从通道读取数据到buffer ，可以同时做其他事情，当数据读取到buffer 中，线程再继续处理数据，写数据也是一样 。这与BIO 不同， BIO 的各种流都是阻塞的，当线程调用read() write() 时，线程被阻塞，知道数据被读取或写入，线程才能继续下去
    
2. Buffer 缓冲区

NIO 面向缓冲区 ，在NIO 中，所有的数据都通过缓冲区处理，任何时候访问NIO 中的数据都是通过缓冲区操作 。

3. Channel 通道

NIO 通过通道进行数据读写，通道是双向的，可读也可写，通道只能通过和Buffer  交互，因为有了buffer ，通道才能异步读写 。Channel 包括Socket、File、Pipe 三种通道。
4. Selector 选择器

选择器用于使用单个线程处理多个通道，将多元异步I/O操作集中到一个或多个线程中。因此，他需要较少的线程来处理这些通道。 因为线程之间的切换对于操作系统来说是昂贵的。所以，使用选择器提高系统效率是有用的


NIO是基于通道（Channel）和缓冲区（Buffer）进行操作的，数据总是从通道读取到缓冲区中，或者从缓冲区写入到通道中，需要时可以在缓冲区中前后移动所保存的数据。

### Buffer 的工作方式
Bbuffer  可以简单地理解为一组基本数据类型的元素列表，他通过几个变量来保存这个数据的当前位置状态。 也就是四个索引
1. capacity 缓冲区数组的总长度
2. position 下一个要操作的数据元素的位置
3. limit 缓冲区数组不可操作的下一个元素的位置 ，limit <= capacity
4. mark  用于记录当前position 的前一个位置或者默认是0

### NIO 的数据访问方式
NIO 提供了比传统的文件访问方式更好的方法，NIO 有两个优化方法，一个是FileChannel.transferTo   FileChannel.transferFrom ; 
FileChannel。Transferxx 与传统的文件访问方式相比减少数据从内核到用户空间的复制，数据直接在内核空间调用
