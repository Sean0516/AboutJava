semaphore 信号量是用来控制同时访问特定资源的线程数量。他通过协调各个线程，以保证合理的使用公共资源 。信号量为多线程协作提供了更为强大的控制方式，广义上说，信号量是对锁的扩展，无论是内部锁synchronized  还是重入锁 reentrantlock ，一次都只允许一个线程访问一个资源，而信号量可以指定多个线程，同时访问某一个资源， 信号量主要提供了以下构造函数


```
public Semaphore(int permits ) permits

 Semaphore semaphore=new Semaphore(10);
```

1. public Semaphore(int permits ) permits 指的是许可的意思，代表统一时间内，最多允许多少线程同时执行 acquire 和release 之间的代码

```
public Semaphore(int permits ,boolean fair)
```

2. public Semaphore(int permits ,boolean fair) 第二个参数可以 指定是否公平 非公平信号量运行的效果是线程启动的顺序和调用semaphore.acquire（）的顺序无关，也就是线程先启动了并不代表先获得许可，公平信号量运行的效果是线程启动的顺序和调用semaphore.acquire（）的顺序有关，也就是先启动的线程优先获得许可

构造信号量对象时，必须指定信号量的准入数量，即同时能申请多少个许可，意味着同时有多少个线程可以同时访问某一个资源
 
 ### semaphore  的主要方法
 acquire（）  参数获取一个准入的许可，若无法获得，线程会等待，直到有线程释放一个许可或者当前线程被中断（线程若中断，则会释放许可）

acquire（int permits） permits 为当前线程获取多少个许可
 
release（）用于在线程访问资源结束后，释放一个许可，以使的其他等待许可的线程可以进行资源的访问

release（int permits ）permits线程结束时，释放的许可数量，需要说明的是，在Semaphore构造函数设置的permits数量，并不是最终的许可数量，仅仅是初始的状态值。可以通过release （num ）来增加许可数量



