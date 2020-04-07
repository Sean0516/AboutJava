ReentrantLock 和synchronized  的比较主要如下：
1. 两者都是可重入锁 
> 可重入锁的概念是： 自己可以再次获取自己的内部锁。 比如一个线程获得某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁是时候还是可以获得的。 同一个线程每次获取锁，锁的计数器都自增 1 .所以要等到锁的计数器下降到 0 时才能释放锁。 而 不可锁重入的化，就会造成死锁
2. synchronized 依赖于JVM 而 reentrantlock 则依赖于 API
> synchronized 依赖于虚拟机层面的实现 。而 reentrantlock 是JDK 层面实现的。 （需要 lock 和unlock 方法配合 try  finally 语句块来完成）
3. reentrant lock  比 synchronized 增加了一些高级功能
> 1. 等待可中断   reentrant lock 提供了一种能够中断等待锁的机制  。通过lock.lockInterruptibly() 来实现这个机制，也就是说在等待的线程可以选择放弃等待，改为处理其他事情
> 2. eentrantlock 可以指定 是公平锁还是非公平锁 。 而 synchronized 只能是非公平锁。 所谓的公平锁就是先等待的线程先获得锁 。 reentrantlock 默认情况下是非公平的。 可以通过 构造函数来指定锁是否公平
> 3. synchronized 关键字 和 wait  和 notifyAll 方法集合可以实现等待 / 通知机制 。reentrantlock 则需要借助 condition 接口方法。 condition 具有很好的灵活性，比如可以实现多路通知等待。也就是一个lock对象可以创建多个condition 实例，线程对象可以注册在指定的condition中 。从而可以有选择的进行线程通知，在调度上更加灵活。

4. 性能比较
> 从JDK1.6 之后。 synchronized 和reentrantlock 的性能基本持平。  而且，由于虚拟机再性能改进中会更偏向于元素的synchronized ，所以在synchronized 能够满足需求的情况下，优先考虑synchronized 关键字
