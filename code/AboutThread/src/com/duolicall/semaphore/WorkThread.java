package com.duolicall.semaphore;

import java.util.concurrent.Semaphore;

/**
 * @author sean
 * @date 2020/4/23  15:17
 */
public class WorkThread implements Runnable {
    private Semaphore semaphore;

    public WorkThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+" thread get semaphore");
            Thread.sleep(2*1000);
            System.out.println("have " + semaphore.getQueueLength() +" is wait for semaphore");
            System.out.println(Thread.currentThread().getName()+" thread release semaphore");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(4);
        for (int i = 0; i <10 ; i++) {
            new Thread(new WorkThread(semaphore)).start();
        }
    }
}
