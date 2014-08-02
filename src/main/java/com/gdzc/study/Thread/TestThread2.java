package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-1.
 * 继承Thread类,可以直接启动线程,不推荐
 */
public class TestThread2 {
    public static void main(String[] args){
        Runner1 r = new Runner1();
        r.start();
        for (int i = 0;i < 100;i++){
            System.out.println("Main Thread"+i);
        }
    }
}

class Runner1 extends Thread{
    public void run(){
        for (int i = 0;i < 100;i++){
            System.out.println("Runner Thread"+i);
        }
    }
}