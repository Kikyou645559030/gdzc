package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-6.
 * 测试死锁,一个线程需要锁定多个对象才能继续执行,另一个对象也需要其中的多个对象,就会出现死锁的情况
 * 应该避免这种情况,如果有可能出现这种情况应该锁定方法(锁定更大一级的,降低效率,保证安全性)
 */
public class TestDeadLock implements Runnable{
    public int flag = 1;
    static Object o1 = new Object(),o2 = new Object();

    @Override
    public void run() {
        System.out.println("flag:"+flag);
        if (flag == 1){
            synchronized (o1){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    System.out.println("1");
                }
            }
        }
        if (flag == 0){
            synchronized (o2){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args){
        TestDeadLock tdl1 = new TestDeadLock();
        TestDeadLock tdl2 = new TestDeadLock();
        tdl1.flag = 1;
        tdl2.flag = 0;
        Thread t1 = new Thread(tdl1);
        Thread t2 = new Thread(tdl2);
        t1.start();
        t2.start();
    }
}
