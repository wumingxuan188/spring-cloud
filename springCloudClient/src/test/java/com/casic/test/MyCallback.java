package com.casic.test;

import java.util.concurrent.Callable;

public class MyCallback implements Callable<String> {
    String value;

    @Override
    public String call() throws Exception {
       Thread.sleep(5000);
        value="test";
        return value;
    }
}
