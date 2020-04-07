package com.dyy.test;

import com.dyy.SafeStopThread;

public class SafeStopThreadTest {

    public static void main(String[] args) throws InterruptedException {
        SafeStopThread t = new SafeStopThread();
        Thread t1 = new Thread(t);
        t1.start();
        for (int i = 0; i < 5; i++) {
            /*
            //不共享变量， 不影响
            SafeStopThread thread2= new SafeStopThread();
            new Thread(thread2).start();
             */
            //共享stop变量
            new Thread(t).start();

        }
        Thread.sleep(100);
        t.terminate();
    }
}
