Unsafe的位于是sun. misc包下，Unsafe类中的方法几乎全部都是native方法，它们使用JNI的方式调用本地的C++类库。

CAS是Compare And Swap的简称，即比较再替换。它是计算机处理器提供的一个原子指令，保证了比较和替换两个操作的原子性。CAS操作涉及三个操作数：CAS（V，E，N）。

1）V：要读写的内存地址；

2）E：进行比较的值E（预期值）；

3）N：拟写入的新值。

CAS操作含义：当且仅当内存地址V中的值等于预期值E时，将内存V中的值改为A，否则不操作。注意：CAS（V，E，N）是一个伪函数，这么写是为了让读者理解CAS的含义

