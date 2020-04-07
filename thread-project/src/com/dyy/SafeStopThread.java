package com.dyy;

public class SafeStopThread implements Runnable {
    private volatile boolean stop = false;
    int a = 0;
    @Override
    public void run() {
        while (!stop){
            synchronized (""){
                String name = Thread.currentThread().getName();
                System.out.println(name + ":开始时\ta=" + a);
                a++;
                try {
                    System.out.println(name+"线程内休眠1000\ta="+a);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("异常处理");
                }
                a--;
                System.out.println(name + ":结束线程后\ta=" + a);
            }
        }

    }
    public void terminate(){
        stop = true;
    }
}
