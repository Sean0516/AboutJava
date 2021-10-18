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

addWorker方法只是构造了一个Worker，并且把firstTask封装到Worker中

```java
 private boolean addWorker(Runnable firstTask, boolean core) {
        retry:
        for (;;) {
            int c = ctl.get();
            int rs = runStateOf(c);
// 如果线程处于非运行状态,并且rs 不等于SHUTDOWN 且first 不等于空,且workQueue 为空，直接返回false (表示不可添加worker 状态)
            // Check if queue empty only if necessary.
            if (rs >= SHUTDOWN &&
                ! (rs == SHUTDOWN &&
                   firstTask == null &&
                   ! workQueue.isEmpty()))
                return false;

            for (;;) {
                int wc = workerCountOf(c); // 获取worker 工作线程数
                if (wc >= CAPACITY || // 如果工作线程数超过上限,则直接返回false 不能添加worker
                    wc >= (core ? corePoolSize : maximumPoolSize))
                    return false;
                if (compareAndIncrementWorkerCount(c)) //CAS 增加工作线程数,保证同时只有一个线程成功，CAS失败，则重试
                    break retry;
                c = ctl.get();  // Re-read ctl
                if (runStateOf(c) != rs) // 如果不相等,线程状态发生了变化，需要重新判断线程池状态
                    continue retry;
                // else CAS failed due to workerCount change; retry inner loop
            }
        }

        boolean workerStarted = false;
        boolean workerAdded = false;
        Worker w = null;
        try {
            w = new Worker(firstTask);// 构建一个新的线程
            final Thread t = w.thread;// 获取到当前运行的线程
            if (t != null) {
                final ReentrantLock mainLock = this.mainLock;
                mainLock.lock(); // 加锁，避免并发问题
                try {
                    // Recheck while holding lock.
                    // Back out on ThreadFactory failure or if
                    // shut down before lock acquired.
                    int rs = runStateOf(ctl.get());

                    if (rs < SHUTDOWN ||
                        (rs == SHUTDOWN && firstTask == null)) {
                        if (t.isAlive()) // 线程池是正在运行状态, 且为SHUTDOWN ,且fisrtTask 为空
                            throw new IllegalThreadStateException();
                        workers.add(w);// 将新创建的对象添加到workers 集合
                        int s = workers.size();//获取工作线程数量
                        if (s > largestPoolSize)//如果当前工作线程数量大于最大线程数量
                            largestPoolSize = s;
                        workerAdded = true;
                    }
                } finally {
                    mainLock.unlock();
                }
                if (workerAdded) { // 添加成功,启动线程
                    t.start();
                    workerStarted = true;
                }
            }
        } finally {
            if (! workerStarted) // 添加失败,递减实际工作线程数
                addWorkerFailed(w);
        }
        return workerStarted;
    }
```

### runWorker 方法

hreadPoolExecutor的核心方法addWorker，主要作用是创建工作线程。Worker可以理解为就是一个线程，里面重新定义了run方法，执行线程池中的任务,该方法主要做以下几件事

1. 如果task不为空，则开始执行task
2. 如果task为空，则通过getTask()再去取任务，并赋值给task，如果取到的Runnable不为空，则执行该任务
3. 051
4. 执行完毕后，通过while循环继续getTask()取任务
5. 如果getTask()取到的任务依然是空，那么整个runWorker()方法执行完毕

