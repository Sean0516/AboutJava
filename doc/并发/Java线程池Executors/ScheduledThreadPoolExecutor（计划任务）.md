ScheduledThreadPoolExecutor继承自ThreadPoolExecutor主要作用是将定时任务和线程池功能接合使用,用来在给定的延迟之后运行任务。

### ScheduledThreadPoolExecutor 的运行机制
ScheduledThreadPoolExecutor的执行主要分为两部分
1. 当调用ScheduledThreadPoolExecutor的scheduleAtFixedRate方法或者scheduleWithFixedDelay 方法时，会向ScheduledThreadPoolExecutor的delayQueue(无界延时阻塞队列)添加一个实现了RunnableScheduledFuture 接口的 ScheduledFutureTask 
2. 线程池从 DelayQueue  中获取 ScheduledFutureTask  ，然后执行任务

ScheduledThreadPoolExecutor 为了实现周期性执行任务，对ThreadPoolExecutor  做了一下修改
1. 使用 DelayQueue  作为任务队列
2. 获取任务的方式不同
3. 执行周期任务后，增加了额外的处理

### ScheduledThreadPoolExecutor的实现
ScheduledThreadPoolExecutor 会把待调度的任务ScheduledFutureTask放入到一个DelayQueue 中 。

ScheduledFutureTask  主要包含以下三个成员变量

1. long 型成员变量 time  ，表示这个任务被执行的具体时间
2. long型成员变量 表示这个任务被添加到ScheduledThreadPoolExecutor  中的需要
3. long 型 成员变量 period 表示任务执行的间隔周期

### 线程执行周期任务的步骤
1. 线程A从DelayQueue获取已到期的ScheduledFutureTask,到期任务指的是ScheduledFutureTask 的time 大于等于当前时间
2. 线程A执行这个ScheduledFutureTask 
3. 线程A修改ScheduledFutureTask 的time变量为下一次将要被执行的时间
4. 线程A把这个修改time之后的ScheduledFutureTask  放回 DelayQueue 中

#### ScheduledRxecutorService 工具类自带的定时任务
1. newSingleThreadScheduledExecutor() 
> 返回一个scheduledRxecutorService对象，线程池大小为1，执行定时线程任务的功能，如在某个固定的延时之后之前，或者周期性执行某个任务
2. newScheduledThreadExecutor() 
> 返回一个可以指定线程数量的scheduledRxecutorService 对象

ScheduledRxecutorService对象可以根据时间需要对线程进行调度，ScheduledRxecutorService 并不会立即安排执行任务，他其实是起到计划任务的作用，他会在指定的时间，对任务进行调度
### FixedRate与FixEdeLay 的区别
1. FixedRate是指任务调度的频率一定，以上一个任务开始执行时间作为起点，之后的period 时间，调度下一次时间 
2. FixEdeLay:指在上一次任务执行结束后，再经过delay 时间进行调度