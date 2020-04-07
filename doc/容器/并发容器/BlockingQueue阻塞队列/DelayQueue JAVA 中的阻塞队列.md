DelayQueue 是一个支持延时获取元素的无界阻塞队列，队列使用PrirityQueue 来实现，队列中的元素必须实现Delayed 接口，在创建元素时可以指定多久才能从队列中获取当前元素，只有在延迟期满时才能从队列中提取元素
DelayQueue 非常有用，可以将DelayQueue 运用到一下场景
1.缓存系统的设计 ： 可以用DelayQueue 保存缓存元素的有效期，使用一个线程循环查询DelayQueue  ，一旦能从delayQueue 中获取元素时，表示缓存有效期到了
2.定时任务调用 ： 使用DelayQueue  保存当天要执行的认为和执行时间，一旦从DelayQueue  中获取任务就开始执行
DelayQueue  里面的元素必须要继承 Delayed 接口 主要需要重写 getDelay () 和 compareTo() 方法