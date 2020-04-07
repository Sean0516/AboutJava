synchronized 关键字解决的是多个线程之间访问资源的同步性，synchronized关键字可以保证被他修饰的方法或者代码块在任意时刻只能有一个线程执行在早期Java版本，synchronized 属于重量级锁，效率低下，因为监视器（monitor） 是依赖于底层的操作系统的mutex lock 来实现的,Java的线程是隐射到操作系统的原生线程之上的。如果需要挂起或唤醒一个线程，都需要操作系统帮忙完成，而操作系统实现线程之间的切换需要从用户态转换到内核态,这个状态之间的转换需要相对较长的时间，时间成本相对较高。 这也是为什么早期synchronized 效率低的原因。 而jdk 6 以后， java 在jvm层面对synchronized 做了忧患， jdk 对锁的实现引入了大量的优化,如 自旋锁，适应性自旋锁，锁消除，锁粗化，偏向锁,轻量级锁等技术来减少锁操作的开销


### synchronized 关键字的使用方式
1. 修饰实例方法 作用于当前实例对象加锁，进入同步代码前要获得当前对象实例的锁,对于普通同步方法，锁是当前类的实例对象,进入同步代码前要获得给定对象的锁
2. 修饰静态方法 也就是给当前类加锁,会作用于类的所有实例对象,因为静态成员不属于任何一个实例对象，而是类成员—(static 表明这是该类的一个静态资源)因为访问静态synchronized方法占用是锁是当前类的锁，而访问非静态synchronized方法占用的锁是当前实例对象锁。对于静态同步方法锁是当前类的class对象进入同步代码块要获得当前类的锁
3. 修饰代码块 指定加锁对象，对给定对象加锁,进入同步代码块需要获得给定对象的锁。 对于同步方法块  锁是synchronized 括号里配置的对象  

 synchronized 关键字加到static静态方法和synchronized代码块上都是给class类上锁，synchronized关键字加锁到实例方法上是给对象实例上锁
 
 
 用关键字synchronized 声明方法在某些情况下是有弊端的,比如线程A调用同步方法执行了一个长时间的任务，那么线程B 则需要等待很长的时间，那么这样的情况下可以使用同步语句块

当一个线程访问object的一个同步代码块时,另一个线程任然可以访问该object对象的非同步代码块

在同步代码块中，可以使用任意对象来作为同步方法的对象监视器来实现同步功能，这个任意对象大多数是实例变量及方法的参数，使用格式为synchronized（非this对象）
锁非this 对象具有一定的优点:

如果在一个类中有许多个synchronized方法，这是虽然能够实现同步，但是会收到阻塞，影响运行效率，但是如果使用同步代码块 非this对象，则synchronized（非this）代码块中的程序与同步方法是异步的，不与其他锁this同步方法争抢this 锁，可以大大提运行效率

 
使用双重校验锁实现对象单例 （线程安全）

```
public class Singleton {

    private volatile static Singleton uniqueInstance; //使用volatile 主要是为了防止重排序

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
       //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (uniqueInstance == null) {
            //类对象加锁
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

```

上面例子需要注意的是 uniqueInstance 采用了volatile关键字修饰很有必要因为 uniqueInstance =new Singleteon 这段代码实际上是分为三部分执行的：
1. 为uniqueInstance 分配内存进空间
2. 初始化uniqueInstance
3. 将uniqueInstance指向分配的内存空间
而由于jvm 指令具有重排序的特性，指向顺序可能会改变，而指令重排在多线程环境下会导致一个线程获得还没有初始化的实例，例如一个线程执行了1,3,而线程2在获取uniqueInstance是发现uniqueInstance不为空，则返回uniqueInstance，但是此时的uniqueInstance 是为被初始化的所以,使用volatile 关键字可以禁止JVM 的指令重排序，保证多线程环境下也能正常运行




