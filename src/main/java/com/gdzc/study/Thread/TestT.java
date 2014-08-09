package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-8.
 * 锁定一个对象的某个方法,但是可以访问这个对象的其他方法
 * 互斥,保证某一个时间段只有一个线程进入该方法(被上锁的方法),不保证其他线程是否进入其他方法
 * 一把锁,两个方法,锁住一个就锁不住另一个了
 */
public class TestT implements Runnable{

    private int b = 100;

    public synchronized void m1(){
        b = 1000;
        try {
            Thread.sleep(3000);
            System.out.println("b = "+b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m2(){//不加锁时,其他线程可以在m1()上锁后继续访问,加锁了在m1被锁定时,不能访问该方法
//        System.out.println(b);未上锁之前m2()的方法体
        try {
            Thread.sleep(5000);
            b = 2000;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        m1();
    }

    public static void main(String[] args){
        TestT tt = new TestT();
        Thread t = new Thread(tt);
        t.start();

        try {
            Thread.sleep(1000);
            tt.m2();
            System.out.println(tt.b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
