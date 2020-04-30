package com.duolicall.createthreadmethod;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sean
 * @date 2020/4/23  14:25
 */
public class ThreadByCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("thread run code and deal file");
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadByCallable threadByCallable = new ThreadByCallable();
        FutureTask<String> futureTask = new FutureTask(threadByCallable);
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println("thread result " + s);
    }
}
