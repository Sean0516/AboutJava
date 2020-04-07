### 向线程池提交任务 的两种方式 （execute和submit）
1. execute() 方法 用于提交不需要返回值的任务，所以不能判断任务是否被线程池执行成功
2. submit()方法用于提交需要返回值的任务  线程池会返回一个future对象。 通过 feature对象可以判断任务是否执行成功 并且可以通过  get() 获取返回值 通过feature 的get()方法来获取返回值，get()方法会阻塞当前线程直到任务完成，（一般可以使用 callable 实现的线程来获取返回值）

### 线程池关闭
通过调用线程池的shutdown或shutdownNow方法来关闭线程池。原理是遍历线程池中的工作线程， 然后逐个调用线程的interrupt方法来中断线程。所以无法响应中断的任务可能永远无法终止，但是他们存在一定的区别 。shutdownNow 首先将线程池的状态设置为stop ，然后尝试停止所有的正在执行或暂停任务的线程 。并且返回等待执行任务的列表。 而shutdown 只是将线程池状态设置为shutdown状态，然后中断所有没有正在执行任务的线程

可以使用 isShutDown()  该方法用来判断线程池是否已经关闭

### 自定义线程工厂的异常处理
通过重写 ThreadFactory  中的 newThread()方法，通过setUncaughtExceptionHandler 重写 UncaughtExceptionHandler 类的 uncaughtException（） 方法 来处理异常

### 自定义线程池的拒绝策略
通过实现RejectedExecutionHandler 类，重写 rejectedExecution(Runnable r, ThreadPoolExecutor executor) 方法