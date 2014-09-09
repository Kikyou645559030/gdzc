package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-9.
 * 继承Thread类并实现Runnable接口
 */
public class XTest extends Thread implements Runnable{
    public void run(){
        System.out.println("this is run()");
    }

    public static void main(String[] args){
        Thread t = new Thread(new XTest());
        t.start();
    }
}
