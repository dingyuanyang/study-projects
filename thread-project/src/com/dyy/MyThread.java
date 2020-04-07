package com.dyy;

/**
 * thread的结束是恶意中断，可能导致程序代码逻辑执行并不完整
 */
public class MyThread {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("线程进入休眠");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("异常处理");
                }
                //这里的代码不被执行
                System.out.println("这里的代码不会被");
            }
        };
        thread.start();
        System.out.println("线程开始");
        //因为外层休眠时间小于内部时间，意外停止，导致后续代码不能执行
        Thread.sleep(100);
        System.out.println("线程休眠100");
        thread.stop();
        System.out.println("线程停止");
    }
}
