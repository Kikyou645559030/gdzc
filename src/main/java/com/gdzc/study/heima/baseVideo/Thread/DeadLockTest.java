package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程-死锁
 * Created by Liu_Zhichao on 14-10-4.
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLock(true));
        Thread t2 = new Thread(new DeadLock(false));
        t1.start();
        t2.start();
    }
}

/**
 * -两个线程两把锁，每一个线程的第一个锁都依赖另一把锁。
 * -当一个线程一次获得两把锁的时候就不会出现死锁，否则就出现死锁。
 */
class DeadLock implements Runnable{
    private boolean flag;

    DeadLock(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag){
            synchronized (LockObj.o1){
                System.out.println(flag + "o1");
                synchronized (LockObj.o2){
                    System.out.println(flag + "o2");
                }
            }
        }else {
            synchronized (LockObj.o2){
                System.out.println(flag + "o2");
                synchronized (LockObj.o1){
                    System.out.println(flag + "o1");

                }
            }
        }
    }
}

class LockObj{
    static Object o1 = new Object();
    static Object o2 = new Object();
}