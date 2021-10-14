package thread;

import org.junit.Test;

/**
 * @Description TestThread
 * @Author Sean
 * @Date 2021/10/14 14:08
 * @Version 1.0
 */
public class TestThreadLocal {
    @Test
    public void testThreadLocal() throws InterruptedException {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                threadLocal.set("id" + finalI);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadLocal.get() = " + threadLocal.get());
            });
            thread.start();
            thread.join();
        }
        Thread.sleep(2000);
    }
    @Test
    public void testParentThreadLocal() throws InterruptedException {
        InheritableThreadLocal<String> threadLocal=new InheritableThreadLocal<>();
        Thread thread = new Thread(() -> {
            threadLocal.set(" 父线程的thread local 中的参数");
            for (int i = 0; i < 10; i++) {
                Thread thread1 = new Thread(() -> {
                    String s = threadLocal.get();
                    System.out.println("子进程" + Thread.currentThread().getName() + s);
                });
                thread1.start();
            }

        });
        thread.start();
        thread.join();

    }
}
