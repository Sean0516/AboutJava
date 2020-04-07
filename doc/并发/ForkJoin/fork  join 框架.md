fork /join  框架是Java7提供的一个用于并发执行任务的框架，是一个把大任务分割成若干个小任务。最终汇总每个小任务结构后，得到大任务结果的框架
### fork/ join  框架的设计思路
1. 分割任务
> 首先需要一个fork类来把大任务分割成子任务，有可能自认为还是很大，所以需要不停的分割。直到分割出的子任务足够小
2. 执行任务并合并结果
> 分割的子任分布放在双端队列里，然后几个启动线程分别从双端队列里获取任务执行，子任务执行完的结果都统一放在一个队列里，启动一个线程从队列里拿数据，然后合并这些数据

### fork/join 使用两个类来完成以上两件事
1.  ForkJoinTask 
> 要使用Fork/Join框架，首先必须创建一个Fork/Join任务，他提供了任务执行fork()join() 操作的机制， 通常我们不需要直接继承ForkJoinTask类，只需要继承他的子类,Fork/Join 提供了两个子类

>RecursiveAction  用于没有返回结果的任务 ,  RecursiveTask用于有返回结果的任务
2.  ForkJoinPool
> ForkJoinTask 需要通过ForkJoinPool来执行，任务分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部，当一个工作线程的队列里暂时没有任务时，他会随机从其他工作线程的队列尾部获取一个任务 

```
//获取有返回值的任务
public class CountTask extends RecursiveTask<Integer> {
    @Override
    protected Integer compute() {
    }
```



```
     ForkJoinPool forkJoinPool=new ForkJoinPool();
     forkJoinPool.execute(showMessageTask); //执行任务
     forkJoinPool.shutdown(); //停止任务 
     forkJoinPool.awaitTermination(30, TimeUnit.SECONDS); //等待任务终止
     
```
### ForkJoinTask 与其他任务的区别
ForkJoinTask 与一般任务的主要区别在于他需要实现compute方法，在这个方法里，首先需要判断任务是否足够小，如果足够小就直接执行，如果任务很大，就必须分割成两个子任务，每个字任务在调用fork方法时，又会进入compute方法，看看当前子任务是否需要继续分割成子任务，如果不需要继续分割，则执行当前子任务返回结果，使用join方法会等待子任务执行完并得到其结果。

### fork/ join 框架的异常处理
forkjointask 提供了isCompletedNormally方法来检查任务是否已经抛出异常或已经被取消了，并且可以通过继承了ForkJoinTask的任务通过调用getException获取异常，如果任务被取消了，则返回CancellationException 。如果任务没有完成或者没有抛出异常则返回null
 