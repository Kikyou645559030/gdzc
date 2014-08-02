package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-2.
 * 合并线程
 */
public class TestJoin {
    public static void main(String[] args){
        MyThread2 mt = new MyThread2("哟哟哟 切克闹");
        mt.start();
        try {
            mt.join();//合并当前线程到主线程中
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0;i <= 10;i++){
            System.out.println("I'm main thread");
        }
    }
}

class MyThread2 extends Thread{
    MyThread2(String s){
        super(s);
    }

    public void run(){
        for (int i = 0;i <= 10;i++){
            System.out.println("My name is "+getName());
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
