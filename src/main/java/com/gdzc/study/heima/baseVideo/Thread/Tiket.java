package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程
 * -售票系统
 * -静态
 * Created by Liu_Zhichao on 14-10-3.
 */
public class Tiket {
    private static String str = "abc";
    public static void main(String[] args) {
        SellTiket sellTiket = new SellTiket();
        Thread t1 = new Thread(sellTiket);
        Thread t2 = new Thread(sellTiket);
        t1.start();//执行同步块代码的线程
        try {
            Thread.sleep(10);//需要先等一会儿，确定t1线程是在flag为true时执行的
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sellTiket.flag = false;//设置true为false，
        t2.start();//执行同步函数
    }
}

/**
 * -不建议这样使用，因为static修饰的话，生命周期太长了
 */
class  SellTiket implements Runnable {
    private int num = 300;//静态方法不能访问非静态成员变量，但普通方法可以访问静态成员变量
    boolean flag = true;

    public void run() {
        if (flag){
            while (true){
                synchronized (this){//只有使用this时才是两个线程使用同一个锁
                    if (num > 0){
                        System.out.println(Thread.currentThread().getName() + "====show====" + num--);
                    }
                }
            }
        }else {
            show();
        }
    }

    private synchronized void show(){
        if (num > 0){
            System.out.println(Thread.currentThread().getName() + "====show====" + num--);
        }
    }
}