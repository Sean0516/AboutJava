缓冲区本质上是一块可以写入数据，然后可以从中读取数据的内存。这块内存被包装成NIO Buffer对象，并提供了一组方法，用来方便的访问该块内存。原始数据元素组成的固定长度数组，封装在包含状态信息的对象中，存入缓冲区。缓冲区提供了一个会合点。通道既可提取放在缓冲区中的数据（写），也可向缓冲区存入数据供读取（读）。此外，还有一种特殊类型的缓冲区，用于内存映射文件

一个buffer对象是固定数量的数据的容器，其作用是一个存储器，在这里数据被存储并在之后用于检索 ，缓冲区的工作和通道紧密联系，通道是I/O 传输发生时通过的入口，而缓冲区是这样数据传输的来源

概念上，缓冲区是包在一个对象内的基本数据元素数组。Buffer 类相比一个简单数组的优点是它将关于数据的数据内容和信息包含在一个单一的对象中。Buffer 类以及它专有的子类定义了一个用于处理数据缓冲区的 API

### 所有的缓冲区都具有四个属性来提供关于其包含的数据元素的信息

capacity （容量）： 缓冲区能够容纳的数据元素的最大数量，容量在缓冲区创建时被设定，并且永远不能被改变 。一旦buffer 满了，需要将其清空（通过读取数据或清除数据）才能继续写数据

limit （上界）： 缓冲区第一个不能被读或写的元素，或者说，缓冲区现存元素的计数  在写模式下， limit表示最多能往buffer种写多少数据 limit 等于buffer的capacity ， 读模式下， limit 表示你最多能读到多少数据

position (位置)： 当你写数据到Buffer中时，position表示当前的位置。初始的position值为0.当一个byte、long等数据写到Buffer后， position会向前移动到下一个可插入数据的Buffer单元。position最大可为capacity – 1。    当读取数据时，也是从某个特定位置读。当将Buffer从写模式切换到读模式，position会被重置为0。当从Buffer的position处读取数据时，position向前移动到下一个可读的位置

标记： 一个备忘位置 用于记录当前position 的前一个位置或者默认是0

### buffer 的类型
1. ByteBuffer
2. MappedByteBuffer  比较特别 ，单独描述
3. CharBuffer
4. DoubleBuffer
5. FloatBuffer
6. IntBuffer
7. LongBuffer
8. ShortBuffer

### buffer 读数据的步骤
1. 写数据到buffer
2. 调用flip() 方法 将buffer从写模式切换到读模式 ，在读模式下，可以读取之前写入buffer的所有数据
3. 从buffer 读取数据 
4. 调用clear() (清空整个缓冲区)  方法或 compact() (只清除已经读过的数据，任何未读的数据会被移动到缓冲区的起始位置，新写入的数据将会放到未读的后面)方法 清空buffer


```
  FileInputStream fileInputStream = new FileInputStream(fileName);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        int read = channel.read(byteBuffer);
        while (read != -1) {
            byteBuffer.flip();
                System.out.println("____"+decoder.decode(byteBuffer));
            byteBuffer.clear();
            read = channel.read(byteBuffer);
        }
        fileInputStream.close();
        channel.close();
```
### ### buffer写数据的步骤
1. 写数据到Buffer
2. 通过buffer 的put() 方法将数据写入到buffer
3. buffer.flip();
4. channel.write(buffer);

```
     FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = outputStream.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        String string = "hello timer ";
        buffer.put(string.getBytes());
        //此处必须要调用buffer的flip方法
        buffer.flip();
        channel.write(buffer);
        channel.close();
        outputStream.close();
```





