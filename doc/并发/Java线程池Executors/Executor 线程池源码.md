# Executor 线程池源码

### Executor 
Executor 接口定义了线程池最核心的方法。 execute 方法
```java
public interface Executor {
	// 执行runnable 线程
    void execute(Runnable command);
}
```
### ExecutorService
ExecutorService  定义了任务submit 线程关闭 shutdown 方法
```java
public interface ExecutorService extends Executor {

	//优雅关闭，该关闭会继续执行完以前提交的任务，但不再接受新任务。
    void shutdown();
    // 提交一个有返回值的任务，并返回该任务的 未来执行完成后的结果。 同时使用Future的 get()方法 将在成功完成后返回任务的结果。    
    <T> Future<T> submit(Callable<T> task);

    <T> Future<T> submit(Runnable task, T result);

    Future<?> submit(Runnable task);
}
```
### AbstractExecutorService 
AbstractExecutorService  主要对公共方法submit  系列方法进行了实现。
```java
// 该抽象类最主要的内容就是，实现了 ExecutorService 中的 submit()系列方法
public abstract class AbstractExecutorService implements ExecutorService {
    // 创建一个新的 RunnableFuture ,并使用execute 执行
    public Future<?> submit(Runnable task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<Void> ftask = newTaskFor(task, null);
        execute(ftask);
        return ftask;
    }

    public <T> Future<T> submit(Runnable task, T result) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task, result);
        execute(ftask);
        return ftask;
    }

    public <T> Future<T> submit(Callable<T> task) {
        if (task == null) throw new NullPointerException();
        RunnableFuture<T> ftask = newTaskFor(task);
        execute(ftask);
        return ftask;
    }
}
```
### ThreadPoolExecutor
ThreadPoolExecutor 线程池的具体实现 ，主要实现在于 execute 的实现
```java
public class ThreadPoolExecutor extends AbstractExecutorService {

	// 阻塞队列 
    private final BlockingQueue<Runnable> workQueue;

     // 用于创建线程的线程工厂
    private volatile ThreadFactory threadFactory;
    
    //核心线程数
    private volatile int corePoolSize;

    //最大线程数
    private volatile int maximumPoolSize;
}
```
```java
public void execute(Runnable command) {
        if (command == null)
            throw new NullPointerException();
        int c = ctl.get();
    	// 如果运行中的线程少于corePoolSize核心线程数，则开启一个新的线程
        if (workerCountOf(c) < corePoolSize) {
            if (addWorker(command, true))
                return;
            c = ctl.get();
        }
    	// 如果工作队列没满，则进入工作队列，否则，判断是否超出最大线程数
        if (isRunning(c) && workQueue.offer(command)) {
            int recheck = ctl.get();
            if (! isRunning(recheck) && remove(command))
                reject(command);
            else if (workerCountOf(recheck) == 0)
                addWorker(null, false);
        }
    	// 如果未超过最大线程数，则开启一个新的线程， 不然则根据饱和策略处理未执行的任务
        else if (!addWorker(command, false))
            reject(command);
    }
```
```java
// 关闭线程   ，其中执行以前提交的任务，但不接受新的任务
public void shutdown() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(SHUTDOWN);
            interruptIdleWorkers();
            onShutdown(); // hook for ScheduledThreadPoolExecutor
        } finally {
            mainLock.unlock();
        }
        tryTerminate();
    }
```


