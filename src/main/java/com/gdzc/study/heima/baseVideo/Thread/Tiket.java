package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程
 * -售票系统
 * Created by Liu_Zhichao on 14-10-3.
 */
public class Tiket {
    private static String str = "abc";
    public static void main(String[] args) {
        SellTiket sellTiket1 = new SellTiket();
        SellTiket sellTiket2 = new SellTiket();
        SellTiket sellTiket3 = new SellTiket();
        sellTiket1.start();
        sellTiket2.start();
        sellTiket3.start();
    }
}

/**
 * -不建议这样使用，因为static修饰的话，生命周期太长了
 */
class  SellTiket extends Thread{
    private static int num = 300;//静态方法不能访问非静态成员变量，但普通方法可以访问静态成员变量
    @Override
    public synchronized void run() {
        while (num > 0){
            System.out.println(currentThread().getName() + "------" + num--);
        }
    }
}