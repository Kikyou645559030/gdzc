package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-2.
 * 拿到当前线程
 */
public class TestThread3 {
    public static void main(String[] args){
        Runner3 r = new Runner3();
        r.start();
        for (int i = 0;i < 50;i++){
            System.out.println("MainThread:"+i);
        }
    }
}

class Runner3 extends Thread{
    public void run(){
        Thread t = Thread.currentThread();//拿到当前执行这个对象的线程
        System.out.println(t.isAlive()+"===="+t.getPriority()+"===="+t.getName());
        for (int i = 0;i < 50;i++){
            System.out.println("SubThread:"+i);
        }
    }
}