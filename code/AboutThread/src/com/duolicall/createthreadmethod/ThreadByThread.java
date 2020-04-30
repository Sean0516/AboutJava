package com.duolicall.createthreadmethod;

/**
 * @author sean
 * @date 2020/4/23  14:17
 */
public class ThreadByThread extends Thread{
    @Override
    public void run() {
        System.out.println("thread run code");
    }
}
