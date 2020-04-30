package com.duolicall.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author sean
 * @date 2020/4/23  14:41
 */
public class ReadFileThread implements Runnable {
    private CountDownLatch countDownLatch;
    private int sleepTime;

    public ReadFileThread(CountDownLatch countDownLatch, int sleepTime) {
        this.countDownLatch = countDownLatch;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " read file time " + sleepTime + " s");
        countDownLatch.countDown();
    }
    public static void main(String[] args)  {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        ReadFileThread readFileThreadOne = new ReadFileThread(countDownLatch, 10);
        ReadFileThread readFileThreadTwo = new ReadFileThread(countDownLatch, 3);
        new Thread(readFileThreadOne).start();
        new Thread(readFileThreadTwo).start();

        try {
            countDownLatch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread end");
    }

}
