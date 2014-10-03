package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程-线程同步-银行金库存钱
 * Created by Liu_Zhichao on 14-10-4.
 */
public class BankDemo {

    public static void main(String[] args) {
        Cus cus = new Cus();//一个账号
        Thread t = new Thread(cus);//多人存钱
        Thread t1 = new Thread(cus);//多人存钱
        t.start();
        t1.start();
    }
}

/**
 * -银行向金库加钱
 */
class Bank{
    private int sum;//金库的钱
    public synchronized void add(int money){//金库加钱的方法，需要上锁
        System.out.println(Thread.currentThread().getName() + "..." + (sum+=money));
    }
}

/**
 * -多人向同一个银行账户存钱
 */
class Cus implements Runnable{
    Bank bank = new Bank();
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {//每次存100，存3次共300
            bank.add(100);
        }
    }
}
