package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程-线程通信-生产者消费者问题
 * Created by Liu_Zhichao on 14-10-5.
 */
public class ProducerAndConsumerTest {
    public static void main(String[] args) {
        Product product = new Product();//一个商品对象
        ProduceProduct pp = new ProduceProduct(product);//生产商品
        ConsumeProduct cp = new ConsumeProduct(product);//消费商品
        Thread t1 = new Thread(pp);//两个生产者
        Thread t11 = new Thread(pp);
        Thread t2 = new Thread(cp);//两个消费者
        Thread t22 = new Thread(cp);
        t1.start();
        t2.start();
        t11.start();
        t22.start();
    }
}

/**
 * -商品实体类
 */
class Product{
    private int id = 1;//商品id
    private String name;//商品名称
    private boolean flag = false;//状态,表示没有存放数据

    /**
     * -生产商品方法
     * @param name
     */
    public synchronized void produce(String name){
        while (flag){//如果已经有生产出来的商品，就等待消费，每一次被唤醒都需要判断一次，如果不是while就会出现错误
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name + "--ID：" + id++;
        System.out.println(Thread.currentThread().getName() + "--生产了：" + this.name);
        flag = true;//生产完成之后修改状态
        notifyAll();//唤醒所有在等待的线程，包括其他生产线程
    }

    /**
     * -消费商品方法
     */
    public synchronized void consume(){
        //如果没有商品能消费就等待，等生产者生产，每一次醒来都需要判断，否则有可能出现消费已经被消费过的商品
        while (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "--消费了：" + name);
        flag = false;//修改商品状态，让生产者可以生产
        notifyAll();//唤醒所有线程，让等待的生产者线程开始生产商品
    }
}

/**
 * -生产商品
 */
class ProduceProduct implements Runnable{
    private Product product;

    ProduceProduct(Product product) {
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
class ConsumeProduct implements Runnable{
    private Product product;

    ConsumeProduct(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true){//不停的消费
            product.consume();
        }
    }
}