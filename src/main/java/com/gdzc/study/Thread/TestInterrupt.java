package com.gdzc.study.Thread;

import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-8-2.
 * 测试线程的中断方法
 */
public class TestInterrupt {
    public static void main(String[] args){
        MyThread mt = new MyThread();
        mt.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mt.interrupt();//中断线程,不推荐使用
    }
}

class MyThread extends Thread{
    private boolean flag = true;//通过第三方参数来控制线程,推荐使用

    @Override
    public void run() {
        while (flag){
            System.out.println("===="+new Date()+"====");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
