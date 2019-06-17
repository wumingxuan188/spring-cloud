package com.casic.test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyFuturTask  {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallback());
        Thread t1 = new Thread(task);
        t1.start();

        if(!task.isDone()){
            System.err.println("please wait");
        }
        System.out.println("this value is :"+task.get());
    }
}
