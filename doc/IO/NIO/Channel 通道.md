NIO 新引入了最重要的抽象是通道的概念，channel 对象模拟了通信连接， 管道既可以是单向 ，也可以是双向的，可以将通道想象成连接缓冲区和I/.O 服务的捷径 Channel 可以是异步地读写。
Channel 中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入 。通道是一种途径，借助该途径，可以用最小的总开销来访问操作系统本身的IO服务，缓冲区则是通道内部用来发送和接收数据的端点

通道分为FIlechannel 类和三个socket 通道类： socketchannel ，serversocketchannel  和datagramchannel

1. FileChannel 从文件中读写数据。 RandomAccessFile raf = new RandomAccessFile ("somefile", "r");
FileChannel fc = raf.getChannel( );
2. DatagramChannel 能通过UDP读写网络中的数据。 DatagramChannel dc = DatagramChannel.open( );
3. SocketChannel 能通过TCP读写网络中的数据。 SocketChannel sc = SocketChannel.open( );
4. ServerSocketChannel可以监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel ServerSocketChannel ssc = ServerSocketChannel.open( );

### Channel 之间的数据传输
 
 在Java NIO中，如果两个通道中有一个是FileChannel，那你可以直接将数据从一个channel传输到另外一个channel。
 
 FileChannel的transferFrom()方法可以将数据从源通道传输到FileChannel中
 
```
       FileInputStream fileInputStream = new FileInputStream(fromFile);
        FileChannel fromChannel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);
        FileChannel toChannel = fileOutputStream.getChannel();
        toChannel.transferFrom(fromChannel, 0, fromChannel.size());
```

transferTo()方法将数据从FileChannel传输到其他的channel中
```
        FileInputStream fileInputStream=new FileInputStream(fromFile);
        FileChannel channel = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream(toFile);
        FileChannel toChannel = fileOutputStream.getChannel();
        channel.transferTo(0,channel.size(),toChannel);
```

### Scatter  (分散) 和Gather （聚集）

分散（scatter）从Channel中读取是指在读操作时将读取的数据写入多个buffer中。因此，Channel将从Channel中读取的数据“分散（scatter）”到多个Buffer中。 

```
    ByteBuffer header = ByteBuffer.allocate(12);
    ByteBuffer body = ByteBuffer.allocate(512);
    ByteBuffer[] byteBuffers = {header, body};
    channel.read(byteBuffers);
        
```
聚集（gather）写入Channel是指在写操作时将多个buffer的数据写入同一个Channel，因此，Channel 将多个Buffer中的数据“聚集（gather）”后发送到Channel。 

```
    ByteBuffer header = ByteBuffer.allocate(12);
    ByteBuffer body = ByteBuffer.allocate(512);
    ByteBuffer[] byteBuffers = {header, body};
    channel.write(byteBuffers);
```


 
 
