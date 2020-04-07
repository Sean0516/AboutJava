Java 的BIO 操作类在包 java.io 下 ，这些类大概可以分为以下两种
1. 基于字节操作的IO 接口 InputStream 和 OutputStream 
2. 基于字符操作的IO 接口  Writer 和Reader
InputStream 和OutputStream 都有read() 和write()方法。这两个方法在执行的时候都将阻塞。同时，在对流进行操作后，都需要调用close方法来关闭 


### 字符流
字符输入流 Reader ： BufferReader （缓冲操作） FileReader(文件操作)  InputStreamReader （字节字符流转换控制） CharArrayReader （数组操作）  PipReader （管道操作）
字符输出流 Writer : FileWriter PipeWriter CharArrayWriter BufferedWriter  OuputStreadWriter PrintWriter

### 字节流 

字节输入流 InputStream:  FileInputStream  PipInputStream ByteArrayInputStram BufferedInputStream DataInputStream （基本数据类型操作） ObjectInputStream （对象序列化操作） SequenceInputStream 
字节输出流 OutputStream: FileOutputStream PipedOutputStream ByteAarryOutputStream BufferedOutputStream DataOutoutStream ObjectOutputStream PrintStream 


FileInputStream  FileOutputStream  提供一个附着在一个磁盘文件上的输入流和输出流，只需要文件名或者完成的路径名
BufferedInputStream(InputStream in) 创建一个带缓冲去的流， 带缓冲区的流中读入字符的时候，不会每次都对设备访问，当缓冲区为空时，会向缓冲区读入一个新的数据块
BufferedOutputStream(OutputStream out) 创建一个带缓冲去的流,输出流在收集要写出的字符时，不会每次都对设备访问，当缓冲区填满或当流被flush()时，数据写出


由于文件编码不同，因此有了对字符进行高效操作的字符流对象。 字符流到字节需要经过编码的转换，而这个编码又非常耗时，并且会存在乱码的问题。而数据持久化或网络传输都是以字节进行的，因此必须要进行字节和字符的转换 。 而两种通过InputStreamReader 类来进行字节到字符之间转换的桥梁。 并且在进行inputstream 到reader的过程需要指定编码字符集，否则采用操作系统默认字符集，很可能会出现乱码问题。

### 字节流和字符流的区别

1. 字节流读取时，读到一个字节就返回一个字节。 字符流督导一个或多个字节时，先去查指定的编码表，再将查到的字符返回
2. 字节流可以处理所有类型的数据，而字符流则只能处理字符数据

因此，对于纯文本文件，考虑使用字符流，其他则使用字节流




