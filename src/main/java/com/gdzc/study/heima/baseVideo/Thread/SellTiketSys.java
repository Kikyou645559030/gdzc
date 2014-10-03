package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程
 * -同步()的前提
 * -1.必须要有两个或以上的线程
 * -2.必须是多个线程使用
 *
 * -必须保证同步中只有一个线程在运行
 *
 * Created by Liu_Zhichao on 14-10-3.
 */
public class SellTiketSys {

    public static void main(String[] args) {
        SellTik sellTik = new SellTik();
        Thread t1 = new Thread(sellTik);
        Thread t2 = new Thread(sellTik);
        Thread t3 = new Thread(sellTik);
        t1.start();
        t2.start();
        t3.start();
    }
}

class SellTik implements Runnable{
    private int num =  1000;
    Object object = new Object();
    @Override
    public void run() {
        /*
        -为什么不直接在while里面判断，然后锁住while呢？
         */
        //while是循环，如果锁住的是while，只要判断不等于false就一直执行，
        // 直到为false的时候才会结束，然后线程才会放开锁让其他线程来执行
        while (true){
            synchronized (object){//当锁住的是if的时候只做一次判断，代码执行完就立即放开锁，让其他线程来执行
                if (num > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "====" + num--);
                }
            }
        }
    }
}