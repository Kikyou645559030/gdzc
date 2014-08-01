package com.gdzc.study;

/**
 * Created by Liu_Zhichao on 14-8-1.
 * 实现Runnable接口,new Thread类来启动线程
 */
public class TestThread1 {
    public static void main(String[] args){
        Runner r = new Runner();
//        r.run();//方法的调用,不是启动线程
        Thread t = new Thread(r);//new一个线程,参数是实现了Runnable接口的对象
        t.start();//启动线程
        for (int i = 0;i < 100;i++){
            System.out.println("Main Thread:"+i);
        }
    }
}

class Runner implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 100;i++){
            System.out.println("Runner Thread:"+i);
        }
    }
}