ConcurrentLinkedQueue是一个基于链接节点的无界线程安全队列，它采用先进先出的规则对节点进行排序，当我们添加一个元素的时候，它会添加到队列的尾部；当我们获取一个元素时，它会返回队列头部的元素 ，采用了wait -free  算法 （即CAS 算法）来实现 

concurrentlinkedqueue 的阻塞队列是用加锁来实现，非阻塞队列可以通过CAS 操作来实现

ConcurrentLinkedQueue 使用链表作为数据结构， ConcurrentLinkedQueue 算是高并发环境中性能最好的队列，它之所以能有很好的性能，主要是因为内部的复杂实现

ConcurrentLinkedQueue 适合对性能要求较高，同时对队列的读写存在多个线程同时进行的场景。 

