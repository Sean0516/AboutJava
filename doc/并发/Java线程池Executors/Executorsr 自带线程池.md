这里主要介绍由Executors工具类，Executors类扮演着线程池工厂的角色，通过Executors 可以获得一个拥有特定功能的线程池

但是 ，需要注意的是，一般不推荐直接使用Executors 来创建ThreadPoolExecutor ，因为不同的生产环境，对线程的配置也不一样，自己配置线程池大小，等待队列，以及饱和策略会让线程更好 ，当然如果只是简单的线程任务，还是可以使用Executors 工具类来创建的，下面是executor 框架提供了各种类型的线程池

### newFixedThreadPool()方法
newFixedThreadPool(int threadNum) 
返回一个 corepoolsize和maximumpoolsize 一样大小，并且使用LinkedBlockingQueue 任务队列的线程，由于使用无界队列存放无法立即执行的任务，当任务提交非常频繁的时候，该队列可能迅速膨胀，从而耗尽系统资源。该线程池的数量始终不变，由创建时输入的threadNum 决定，它的corePoolSize和maxiNumPoolSize都被设置为创建时指定的参数的线程数。 当线程池中的线程数大于corepoolsize时，keepalivetime为多余的空闲线程等待新任务的最长时间，超过这个时间后多余的线程被终止，而它的时间设置为0，意味着空闲线程立刻被终止

运行流程如下:
1. 如果当前运行的线程数小于corePoolSize， 创建线程来执行任务
2. 在线程池运行的线程数等于corePoolSize ，将任务放入LikedBlockingQueue 队列中
3. 线程执行完任务后，会循环从LikedBlockingQueue获取任务来执行

由于fixedthreadpool使用的是无界队列，所以，线程池不会拒绝任务，因此不会调用饱和策略

### newSingleThreadPool()(newFixedThreadPool()的退化只是简单的把线程池线程数设置为1)
该方法返回一个只有一个线程的线程池,core和max数量都是1.其他的和fixedthreadpool一样 若多余一个任务被提交到线程池，任务会被保存在一个任务队列中，等待线程空闲，按照先入先出的顺序执行队列中的任务

运行流程
1. 如果当前线程少于core poolsize  ，则创建一个线程
2. 当线程池里有一个线程正常运行时，则将新提交的任务加入linkedblockingqueue
3. 当线程执行完之后，反复循环从阻塞队列里面获取任务来执行

### newCachedThreadPool()	
返回一个corePoolSize和maximumPoolSize无穷大的线程池,线程池的线程数量不确定，但是若由空闲线程可以复用，会优先使用可复用的线程，若线程所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务，所有线程在当前任务执行完毕后，将返回线程池进行复用。

newCachedThreadPoolcore 的 size 设置为0 max size 设置为max_value  ，keepalivetime为60L。使用synchronousqueue作为线程池的工作队列，由于synchronousqueue 队列是一种直接提交的队列，他总会迫使线程池增加新的线程执行任务。 如果主线程提交任务的速度高于max pool 中线程处理的速度，cached 线程池会不断的创建新的线程，极端情况下，可能会因为创建过多线程而耗尽CPPU 和内存资源






