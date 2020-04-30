package com.duolicall.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author sean
 * @date 2020/4/23  15:31
 */
public class CyclicBarrierThread implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private int sleepTime;

    public CyclicBarrierThread(CyclicBarrier cyclicBarrier, int sleepTime) {
        this.cyclicBarrier = cyclicBarrier;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime * 1000);
            System.out.println("thread" + Thread.currentThread().getName() + " sleep seconds " + sleepTime +"and cyclic barrier wait num is "+cyclicBarrier.getNumberWaiting());

            cyclicBarrier.await();
            System.out.println("thread" + Thread.currentThread().getName() + "end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
//        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
//        new Thread(new CyclicBarrierThread(cyclicBarrier,2)).start();
//        new Thread(new CyclicBarrierThread(cyclicBarrier,10)).start();
//        cyclicBarrier.await();
//        System.out.println("main thread end ");
//
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2,()-> System.out.println("cyclic barrier thread end ,custom thread run"));
        new Thread(new CyclicBarrierThread(cyclicBarrier,2)).start();
        new Thread(new CyclicBarrierThread(cyclicBarrier,10)).start();



    }
}
