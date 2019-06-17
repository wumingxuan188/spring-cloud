package com.casic.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        Future<String> submit = pool.submit(new MyCallback());
        if (!submit.isDone()) {
            System.err.println("please wait");
        }
        try {
            System.out.println("this value :"+submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}
