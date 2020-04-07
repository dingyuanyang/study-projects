package com.dyy.test;

import com.dyy.UnsafeStopThread;

/**
 * 共享变量，导致原子性破坏
 */
public class UnsafeStopThreadTest {
    public static void main(String[] args) throws InterruptedException {
        UnsafeStopThread thread = new UnsafeStopThread();
        Thread t1 = new Thread(thread);
        t1.start();
        for (int i = 0; i < 5; i++) {
            /*
            //不共享变量， 不影响
            SafeStopThread thread2= new SafeStopThread();
            new Thread(thread2).start();
             */
            //共享stop变量
            new Thread(thread).start();

        }
        Thread.sleep(100);
        t1.stop();
    }
}
