package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-2.
 * 没上锁的时候,打印的是同一个数字使用timer的线程,上锁之后就有先后顺序了
 * 锁定一段代码,当执行改代码时锁定当前对象
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
    public synchronized void add(String name){//上锁的第一种方式,锁定当前对象,只能被一个线程占用
//        synchronized (this){//上锁的第二种方式
            num++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+",你是第"+num+"个使用timer的线程");
//        }
    }
}