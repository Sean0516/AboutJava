#### Worker 

Worker类继承了AQS，实现了简单的不可重入独占锁

```java
final Thread thread; // 正在执行任务的线程
Runnable firstTask; // 线程执行的第一个任务
volatile long completedTasks; // 已完成的任务数
// 构造函数
Worker(Runnable firstTask) {
    setState(-1); // inhibit interrupts until runWorker
    this.firstTask = firstTask; // 构造函数,初始化第一个任务和锁状态 ，并创建线程
    this.thread = getThreadFactory().newThread(this);
}
```

#### 字段属性

```java
private final BlockingQueue<Runnable> workQueue; // 阻塞队列
private final ReentrantLock mainLock = new ReentrantLock(); // 独占锁
private final HashSet<Worker> workers = new HashSet<Worker>(); // 工作线程Set
private final Condition termination = mainLock.newCondition(); // condition
private int largestPoolSize; // 最大线程池数量
private long completedTaskCount; // 完成任务数量
private volatile ThreadFactory threadFactory; // 线程工厂
private volatile RejectedExecutionHandler handler; // 拒绝策略
private volatile long keepAliveTime; // 线程存活时间
private volatile boolean allowCoreThreadTimeOut;
private volatile int corePoolSize; // 核心线程数
private volatile int maximumPoolSize; // 最大线程池数量
private static final RejectedExecutionHandler defaultHandler = // 默认拒绝策略
    new AbortPolicy();
```



#### execute 提交任务

```java
public void execute(Runnable command) {
    if (command == null)
        throw new NullPointerException();
    int c = ctl.get(); // 获取线程池状态
    if (workerCountOf(c) < corePoolSize) { // 当前工作线程池少于核心线程池，新建一个线程执行任务
        if (addWorker(command, true))
            return;
        c = ctl.get();
    }// 核心线程已经满了
    if (isRunning(c) && workQueue.offer(command)) { //任务队列未满，将任务添加到任务队列中
        int recheck = ctl.get();
        if (! isRunning(recheck) && remove(command))// 将任务添加到队列后，再次检查是否需要添加新的线程,因为已经存在的线程可能被销毁了
            reject(command);
        else if (workerCountOf(recheck) == 0)
            addWorker(null, false); // 如果之前的线程已经被销毁完了，创建一个新的线程
    }
    else if (!addWorker(command, false)) // 核心线程和任务队列都满了，试着创建一个新的线程
        reject(command); // 如果线程创建失败，说明线程池被关闭或者线程池完全满了，执行拒绝策略
}
```

#### addWorker创建并执行工作线程

