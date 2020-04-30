package com.duolicall.createthreadmethod;

/**
 * @author sean
 * @date 2020/4/23  14:25
 */
public class ThreadByRunable implements Runnable{
    @Override
    public void run() {
        System.out.println("thread run code");
    }
}
