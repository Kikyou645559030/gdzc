package com.gdzc.study.heima.baseVideo.Thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * -多线程-升级版消费者生产者问题-使用到JDK5.0关于线程的新特性
 * -使用Lock替代synchronized
 * ----好处一：将上锁和解锁分离成两个方法，提高灵活性，可扩展性
 * ----好处二：Lock可以拥有多个Condition对象，可以将不同功能的线程的方法(等待和唤醒等)分离出来
 * -Condition对象替代了Object对象中的wait()、notify()等对线程操作的方法，好处就是上面的好处二。
 * Created by Liu_Zhichao on 14-10-5.
 */
public class UpgradedProducerAndConsumerTest {
    public static void main(String[] args) {
        NewProduct product = new NewProduct();
        NewProduceProduct npp = new NewProduceProduct(product);
        NewConsumeProduct ncp = new NewConsumeProduct(product);
        Thread t1 = new Thread(npp);
        Thread t2 = new Thread(npp);
        Thread t3 = new Thread(ncp);
        Thread t4 = new Thread(ncp);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

/**
 * -商品实体类
 */
class NewProduct{
    private int id = 1;//商品id
    private String name;//商品名称
    private boolean flag = false;//状态,表示没有存放数据
    private Lock lock = new ReentrantLock();//创建一个锁，替代synchronized
    private Condition proLock = lock.newCondition();//针对生产商品方法的线程的wait()和叫醒的类(替代Object中对应的方法)
    private Condition conLock = lock.newCondition();//针对消费商品方法的线程的wait()和叫醒的类

    /**
     * -生产商品方法
     * @param name
     */
    public void produce(String name){
        lock.lock();//上锁
        try {
            while (flag){//每一次被唤醒都需要判断一次，如果不是while就会出现错误
                proLock.await();//使当前生产商品的线程等待
            }
            this.name = name + "--ID：" + id++;
            System.out.println(Thread.currentThread().getName() + "--生产了：" + this.name);
            flag = true;//生产完成之后修改状态
            conLock.signalAll();//唤醒所有消费商品的线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }

    /**
     * -消费商品方法
     */
    public synchronized void consume(){
        lock.lock();//上锁
        //如果没有商品能消费就等待，等生产者生产，每一次醒来都需要判断，否则有可能出现消费已经被消费过的商品
        try {
            while (!flag){
                conLock.await();//使当前消费商品的线程等待
            }
            System.out.println(Thread.currentThread().getName() + "--消费了：" + name);
            flag = false;//修改商品状态，让生产者可以生产
            proLock.signalAll();//唤醒所有生产商品的线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();//解锁
        }
    }
}

/**
 * -生产商品
 */
class NewProduceProduct implements Runnable{
    private NewProduct product;

    NewProduceProduct(NewProduct product) {
        this.product = product;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {//每个线程生产十万个商品
            product.produce("商品");
        }
    }
}

/**
 * -消费商品
 */
class NewConsumeProduct implements Runnable{
    private NewProduct product;

    NewConsumeProduct(NewProduct product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true){//不停的消费
            product.consume();
        }
    }
}