package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-2.
 */
public class TestSync implements Runnable{
    Timer timer = new Timer();

    public static void main(String[] args){
        TestSync ts = new TestSync();
        Thread t1 = new Thread(ts);
        Thread t2 = new Thread(ts);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        timer.add(Thread.currentThread().getName());
    }
}

class Timer{
    private static int num = 0;
    public void add(String name){
        num++;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+",你是第"+num+"个使用timer的线程");
    }
}