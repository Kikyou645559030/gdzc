package com.gdzc.study.heima.baseVideo.Thread;

/**
 * -多线程-线程同步-等待唤醒机制
 * Created by Liu_Zhichao on 14-10-4.
 */
public class ThreadWaitAndNotifly {
    public static void main(String[] args) {
        Res res = new Res();
        Thread t1 = new Thread(new SaveRes(res));//一个线程存放数据
        Thread t2 = new Thread(new RemoveRes(res));//一个线程取出数据
        t1.start();
        t2.start();
    }
}

/**
 * -表示信息的实体类
 */
class Res{
    private String name;
    private String sex;
    private boolean flag = false;//记录是否存放了数据的状态

    public boolean isFlag() {
        return flag;
    }

    public synchronized void set(String name,String sex){
        if (flag){//如果已经有存在的就让当前线程等待，不再放入值
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;//等叫醒了，就设置值
        this.sex = sex;
        flag = true;//当设置完值之和，就修改状态
        notify();//所有设置完成之后，叫醒持有当前锁的线程
    }

    public synchronized void get(){
        if (!flag){//如果没有值的话，就等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + "======" + sex);//当有值了，就取出来
        flag = false;//修改状态
        notify();//唤醒持有当前对象的锁的线程
    }
}

/**
 * -向Res中存放信息的类
 */
class SaveRes implements Runnable{
    private Res res;
    private boolean flag = true;

    SaveRes(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            if (flag){
                res.set("张山","男");
                flag = false;
            }else {
                res.set("李丽","女");
                flag = true;
            }
        }
    }
}

/**
 * -从Res对象中取出数据
 */
class RemoveRes implements Runnable{
    private Res res;

    RemoveRes(Res res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true){
            res.get();
        }
    }
}
