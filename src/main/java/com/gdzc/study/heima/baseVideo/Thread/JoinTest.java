package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程-join方法示例
 * Created by Liu_Zhichao on 14-10-5.
 */
public class JoinTest {
    public static void main(String[] args) {
        Join join = new Join();
        Thread t1 = new Thread(join);
        Thread t2 = new Thread(join);
        t1.start();
        t2.start();
        try {
            t1.join();//当主线程执行到这句话的时候就等待，直到t1线程全部执行完才继续执行。t2线程不会被影响。
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程正在执行......" + i);
        }
    }
}

class Join implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + "线程正在执行......" + i);
//            Thread.yield();//停止当前线程，让其他线程执行，可以减缓线程执行速度，还可以均匀线程执行的机会。
        }
    }
}
