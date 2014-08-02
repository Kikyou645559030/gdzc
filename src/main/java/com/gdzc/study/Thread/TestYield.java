package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-2.
 * 暂停当前正在执行的线程对象，并执行其他线程
 */
public class TestYield {
    public static void main(String[] args){
        MyThread3 mt1 = new MyThread3("mt1");
        MyThread3 mt2 = new MyThread3("mt2");
        mt1.start();
        mt2.start();
    }
}

class MyThread3 extends Thread{
    MyThread3(String s){
        super(s);
    }
    public void run(){
        for (int i = 0;i < 100;i++){
            System.out.println(getName()+":"+i);
            if ((i%10) == 0){
                yield();//让其他线程执行
            }
        }
    }
}
