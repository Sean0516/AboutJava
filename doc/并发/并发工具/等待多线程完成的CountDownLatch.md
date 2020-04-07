CountDownLatch 允许一个或多个线程等待其他线程完成操作，是一个非常使用的多线程控制工具类，这个工具通常用来控制线程等待，可以让某个线程等待直到其他线程都执行完毕后，再开始执行

实现等待和继续运行的效果分别需要使用await()和countDown()方法来进行。调用await()方法时安定计算是否为0 ，如果不为0,则呈等待状态，其他线程可以调用countDow()方法将计算减 1 ，当计数 减到为0 时，等待的线程继续运行。

CountDownLatch  的构造函数接受一个int类型的参数作为计数器，一般来说 ，参数为你的线程数的总数当调用CountDownLatch的countdown 方法时， 参数 n 会减1 ，CountDownLatch的await 方法会阻塞当前线程， 直到n变成零，由于count down 方法可以用在任何地方，这里的n 可以是n 个线程，也可以是一个线程里面的N个执行步骤， 用在多线程时，只需要将这个CountDownLatch引用传递道线程里即可


如果有的线程处理比较慢，不能让主线程一直等待，可以使用带有指定事件的await 方法， await（long, timeunit）使用这个方法等待特定时间后，就会不在阻塞当前线程。需要注意的是， n 必须在线程中被完全消费掉， 最后n 为0 主线程才会释放

计数器必须大于等于0 ，只是等于0的时候，计数器就是零，调用await方法时不会阻塞当前线程。 

CountDownLatch不能重新初始化或者修改CountDownLatch对象内部计数器的值 ( CyclicBarrier可以)

```
  CountDownLatch countDownLatch=new CountDownLatch(2);
  countDownLatch.countDown();
  countDownLatch.await();
```
