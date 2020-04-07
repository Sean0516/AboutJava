### 创建线程池

```
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(3,10,100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

        new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,milliseconds,runnableTaskQueue, handler);
```

线程池ThreadPoolExecutor创建有个参数可以配置。具体参数如下。 

####  corePoolSize （线程池的基本大小）
当提交一个任务到线程池时，线程池回创建一个线程来执行任务，即使其他空闲的基本线程能够执行新任务也会创建线程，等到需要执行的任务数大于线程池的基本大小时就不在创建。 如果调用prestartAllCoreThreads 方法，线程池会提前创建并启动所有基本线程

#### maximumPoolSize (线程池最大数量)
线程池允许创建的最大线程数，如果阻塞队列满了，并且创建的线程数小于最大线程数，则线程池会再创建新的线程执行 ，如果创建的线程数大于最大线程数，则会根据饱和策略作出一定的操作。需要注意的是，当使用无界阻塞队列 ，这个判断将会没有什么作用。因为队列永远不会满

#### keepAliveTime （线程获得保持时间）
==注意这个值并不会对所有线程起作用，如果线程池中的线程数少于等于核心线程数 corePoolSize，那么这些线程不会因为空闲太长时间而被关闭，当然，也可以通过调用allowCoreThreadTimeOut(true)使核心线程数内的线程也可以被回收==

 线程池的工作线程空闲后，保持存活的时间。所以，如果任务很多，并且每个任务执行的时间比较短，可以调大时间，提高线程的利用率

#### TimeUnit
 线程活动保持时间的单位 可选择不同的单位
 
 #### RunableTaskQueue (任务阻塞队列)
 用于保存等待执行的任务的阻塞队列 有以下阻塞队列可以选择
 1. ArrayBlockQueue
> 一个基于数组结构的有界阻塞队列，此队列按FIFO （先进先出）原则对元素进行排序 ，当使用ArrayBlockQueue 任务队列时，若有新的任务需要执行，如果线程池的实际线程小于corePoolSize ，则会有限创建新的线程，如果大于corePoolSize ，则会将新任务加入等待队列，如果等待队列满了，无法加入，则再总线程数不大于maximumPoolSize 的前提下，创建新的进程执行任务，若大于maximumPoolSize ，则执行拒绝策略，可见Arrayblockqueue 只有当任务队列装满时，才可能将线程数提升到corePoolSize 以上，换言之，除非系统非常繁忙，否则核心线程数量维持再corePoollSize 
 2. LinkedbLockingQueue
 > 一个基于链表结构的无界阻塞队列，FIFO排序，吞吐量高于ArrayBlockQueue。与ArrayBlockQueue相比，除非系统资源耗尽，否则无界任务队列不存在任务入队失败的情况这样的化，也不会调用拒绝策略。当有新任务到来，如果系统的线程数小于corePoolSize ,线程池会继续生成新的线程执行任务，但是当线程数到达corePoolSize后，就不会继续创建新的线程了， 如果后续新的任务加入，但是又没有空闲的线程资源使用，则任务会直接加入等待队列，若线程创建和处理的速度差异很大，无界队列会保持快速增加，直到系统内存耗尽。当然LinkedbLockingQueue也可以通过设置变为有界队列 静态工厂方法 Executors.newFixedThreadPool 线程池使用的该队列 。
 3. SynchronousQueue
 > 一个不存储元素的阻塞队列，每个插入操作必须等到另外一个线程调用移除操作，否则插入操作一直处于阻塞状态。吞吐量高于LinkedbLockingQueue SynchronousQueue 队列提交的任务不会被真是的保持，总是将新任务提交给线程执行，如果没有空闲的线程，则尝试创建新的进行，如果进行数量已经到达最大值，则执行拒绝策略。  newCachedThreadPool 使用这个队列 （需要说明的是，该线程池的最大线程数设置的是 Integer.MAX_VALUE）
 4. PriorityBlockingQueue
> 一个具有优先级的无限阻塞队列  可以根据任务自身的优先级顺序先后执行，再确保系统性能的同时，也能有很好的质量保证
####  ThreadFactory 
用于设置创建线程的工厂。可以通过线程工厂给每个线程设置名字一般可以通过开源框架 guava 提供的threadfactorybuilder 可以快速给线程池设置有意义的名字 

```
new ThreadFactorybuilder.setnameFormat("XXXX-%d").build()；
```
#### RejectedExecutionHandler （饱和策略，当任务太多来不及处理，如何拒绝任务）
当队列和线程池都满了， 需要采取一种策略处理提交的新任务
1. AbortPolicy：直接抛出异常。阻止系统正常工作
2. CallerRunsPolicy：只要线程池未关闭，该策略直接在调用者线程中允许当前被丢弃的任务，这样不会真正的丢弃任务，但是任务提交线程的性能极有可能会急剧下降
3. DiscardOldestPolicy：线程池放弃等待队列中最旧的未处理任务，并将被拒绝的任务添加到等待队列中
4. DiscardPolicy：不处理，直接丢弃掉

当然，也可以根据应用场景需要来实现RejectedExecutionHandler接口自定义策略。如记录日志或持久化存储不能处理的任务
