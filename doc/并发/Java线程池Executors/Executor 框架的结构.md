### Executor框架主要组成部分
1. 任务  
>包括被执行任务需要实现的接口 ，runnable callable
2. 任务的执行
> 任务执行机制的核心接口 Executor 以及继承了Executor的ExecutorService接口
3. 异步计算的结果
> future 和实现 future接口 的futuretask

### Executor 框架的类和接口的一些介绍
1. Executor 接口
> 是executor框架的基础 ，他将任务的提交和任务的执行分离开来
2. threadpoolexecutor 
> 线程池的核心实现类 ，用来执行被提交的任务
3. scheduledthreadpoolexecutor  
> 异步任务或计划任务，在给定的延迟后运行命令，或定期执行命令。比timer更灵活，更强大
4. future 
> 用来接收异步计算的结果
5. runnable 和callable 
> 具体线程的实现接口，这两个接口的实现类,可以被threadpoolexecutor，scheduledthreadpoolexecutor   执行

### Executor 框架的使用流程
1. 通过Rnnable 或Callable 接口实现具体的任务对象
2. 将 实现Runnable 或Callable接口的任务对象交给 ExecutorService 执行，如果执行 是使用submit 则可以返回一个Future 对象，用来接收具体的返回参数
3. 使用get 方法来等待任务执行完成 ，同时主线程可以执行futuretask.cancel()  来取消此任务的执行