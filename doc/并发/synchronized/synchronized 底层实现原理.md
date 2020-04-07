### synchronized 同步语句块的情况
```
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}
```

 monitorenter  指令是在编译后插入到同步代码块开始位置，而monitorexit 则是插入到方法结束出和异常处，JVM 要保证每一个monitorenter   必须又对应的monitorexit 与之匹配。任何对象都有一个monitor 与之管理，当一个monitor被持有后，它将处于锁定状态，线程执行到 monitorenter  指令时，将会尝试获取对象所对应的monitor 的所有权，即尝试获得对象的锁

synchronized 同步语句块的实现使用的是monitorenter和monitorexit指令.onitorenter指令是在编译后插入到同步代码块开始位置，而monitorexit 则是插入到方法结束出和异常处,JVM 要保证每一个monitorenter必须又对应的monitorexit 与之匹配。任何对象都有一个monitor 与之管理，当一个monitor被持有后，它将处于锁定状态,线程执行到monitorenter  指令时，将会尝试获取对象所对应的monitor 的所有权,即尝试获得对象的锁 

当执行monitorenter 指令时，线程试图获取锁 也就是获取monitor（monitor对象存在于每个Java对象头中)。 synchronized 锁便是通过这种方式获取锁的，这也是为什么Java中任意对象可以作为锁的原因)的持有权。 当计数器为0 则可以成功获取，获取后将锁计数器设为1,也就是加1,相应的执行monitorexit指令后，将锁计数器设为0,表明锁被释放。 如果获取对象锁失败，那当前线程就要阻塞等待，直到锁被另外一个线程释放为止

### synchronized 修饰方法的情况

```
public class SynchronizedDemo2 {
    public synchronized void method() {
        System.out.println("synchronized 方法");
    }
}
```
synchronized 修饰方法没有使用monitorenter和monitorexit指,而是使用ACC_SYNCHRONIZED标识,该标识指明了该方法是一个同步方法,JVM 通过该标识来辨别一个方法是否声明为同步方法,从而执行相应的同步调用
