#### 字段属性

```Java
private volatile String name; // 线程名称
private int            priority; // 优先级
private boolean     daemon = false; // 是否为守护线程
private Runnable target; // 线程要执行的目标任务
private ThreadGroup group; // 线程组
private ClassLoader contextClassLoader; // 类加载器
ThreadLocal.ThreadLocalMap threadLocals = null; //threadLocal map
ThreadLocal.ThreadLocalMap inheritableThreadLocals = null; //主要针对父子线程参数传递的thread local map
private long stackSize; // 线程栈的大小
private volatile int threadStatus = 0; // 线程状态
```

#### 线程初始化

```java
private void init(ThreadGroup g, Runnable target, String name, // 初始化线程
                  long stackSize, AccessControlContext acc,
                  boolean inheritThreadLocals) {
    if (name == null) { // 线程名不能为空
        throw new NullPointerException("name cannot be null");
    }
    this.name = name;
    Thread parent = currentThread(); // 当前线程就是该线程的父线程
    SecurityManager security = System.getSecurityManager();
    if (g == null) {
        if (security != null) {
            g = security.getThreadGroup();
        }
        if (g == null) {
            g = parent.getThreadGroup();
        }
    }

    /* checkAccess regardless of whether or not threadgroup is
       explicitly passed in. */
    g.checkAccess();

    /*
     * Do we have the required permissions?
     */
    if (security != null) {
        if (isCCLOverridden(getClass())) {
            security.checkPermission(SUBCLASS_IMPLEMENTATION_PERMISSION);
        }
    }

    g.addUnstarted();

    this.group = g; // 设置父线程对象的属性
    this.daemon = parent.isDaemon();
    this.priority = parent.getPriority();
    if (security == null || isCCLOverridden(parent.getClass()))
        this.contextClassLoader = parent.getContextClassLoader();
    else
        this.contextClassLoader = parent.contextClassLoader;
    this.inheritedAccessControlContext =
            acc != null ? acc : AccessController.getContext();
    this.target = target;
    setPriority(priority);
    if (inheritThreadLocals && parent.inheritableThreadLocals != null)
        this.inheritableThreadLocals =
            ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);// 创建线程共享变量副本
    /* Stash the specified stack size in case the VM cares */
    this.stackSize = stackSize;

    /* Set thread ID */
    tid = nextThreadID();//分配线程ID
}
```

#### 线程启动

```java
public synchronized void start() {
 
    if (threadStatus != 0) // 如果线程初始化未做好，抛出异常
        throw new IllegalThreadStateException();
    group.add(this); // 通知group 该线程即将启动。group 未启动的线程数量减1

    boolean started = false;
    try {
        start0(); // 调用本地方法 start0 启动线程 然后执行run方法
        started = true;
    } finally {
        try {
            if (!started) {
                group.threadStartFailed(this); //启动不成功，group设置当前线程启动失败
            }
        } catch (Throwable ignore) {
         
        }
    }
}
```

#### 线程中断

```java
public void interrupt() { // 线程中断
    if (this != Thread.currentThread())
        checkAccess();

    synchronized (blockerLock) {
        Interruptible b = blocker;
        if (b != null) {
            interrupt0();           //只是将该线程发出一个中断信号,告诉他线程将要结束了，但是具体的中断还是继续运行，由程序内部决定
            b.interrupt(this);
            return;
        }
    }
    interrupt0();
}
```