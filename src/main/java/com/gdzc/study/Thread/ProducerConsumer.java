package com.gdzc.study.Thread;

/**
 * Created by Liu_Zhichao on 14-8-17.
 * 生产者消费者问题
 */
public class ProducerConsumer {
    public static void main(String[] args){
        SyncStack ss = new SyncStack();
        Producer p = new Producer(ss);
        Consumer c = new Consumer(ss);
        new Thread(p).start();//一个人的时候就用notify(),超过一个人的时候就用notifyAll()
        new Thread(c).start();
    }
}

/**
 *被生产的东西
 */
class WoTou{
    private String id;

    WoTou(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "WoTou : " + id;
    }
}

/**
 *装生产出来东西的容器
 */
class SyncStack{
    int index = 0;
    private WoTou[] arrWt = new WoTou[6];

    public synchronized void push(WoTou wt){
        while (index == arrWt.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        arrWt[index] = wt;
        index++;
    }

    public synchronized WoTou pop(){
        while (index == 0){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return  arrWt[index];
    }
}

/**
 *生产者
 */
class Producer implements Runnable{
    SyncStack ss = null;

    Producer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0;i < 20;i++){
            WoTou wt = new WoTou(i+"");
            ss.push(wt);
            System.out.println("生产了：" + wt);
            try {
                Thread.sleep((int)(Math.random() * 200));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

/**
 *消费者
 */
class Consumer implements Runnable{
    SyncStack ss = null;

    Consumer(SyncStack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0;i < 20;i++){
            WoTou wt = ss.pop();
            System.out.println("消费了：" + wt);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}