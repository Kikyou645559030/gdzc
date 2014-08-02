package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-2.
 * 线程优先级,最大是10,最小是1,默认是5,优先级越高,CPU分配给该线程的时间片也就越多
 */
public class TestPriority {
    public static void main(String[] args){
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.setPriority(thread1.getPriority() + 2);
        thread1.start();
        thread2.start();
    }
}

class T1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 1000;i++){
            System.out.println("T1:"+i);
        }
    }
}

class T2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0;i < 1000;i++){
            System.out.println("----------T2:"+i);
        }
    }
}
