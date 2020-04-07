CyclicBarrier 意思是可循环使用的屏障。他要作的事情是让一组程序到达一个屏障（同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被阻塞的线程才会继续运行

CyclicBarrier 默认的构造方法是CyclicBarrier(int)其参数表示屏障拦截的线程数量，每一个线程调用await方法告诉CyclicBarrier已经到达屏障了，然后线程被阻塞。

CyclicBarrier 默认的int参数必须和线程中调用的await方法的数量一致，不然主线程和子线程会永远等待。因为有线程没有到达屏障。到达屏障的线程都不会继续执行

CyclicBarrier  还提供一个更高级的构造函数 CyclicBarrier （int ,runnable  action）  用于在线程到达屏障时，优先执行action线程任务。方便处理复杂的业务场景

### CyclicBarrier 和 CountDownLatch的区别
1. CountDownLatch的计数器只能使用一次，而CyclicBarrier 的计数器可以使用reset方法重置
2. CountDownLatch作用的作用是：一个线程或者多个线程，等待另外一个线程或多个线程完成某个事情之后才能继续执行|CyclicBarrier的作用：多个线程之间相互等待，任何一个线程完成之前，所有的线程都必须等待 ，所以对于CyclicBarrier  来说， 重点是 多个线程之间 任何一个线程没有完成任务，则所有的线程都必须等待