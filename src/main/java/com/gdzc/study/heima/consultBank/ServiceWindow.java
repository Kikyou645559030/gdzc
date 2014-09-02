package com.gdzc.study.heima.consultBank;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 * Created by Liu_Zhichao on 14-9-1.
 * 银行业务调度系统--服务窗口
 */
public class ServiceWindow {
    private int windowNum;//服务窗口号码
    private CustomerType type = CustomerType.COMMON;//服务窗口类型

    public void start(){
        //Executors创建线程池的，下面创建单个线程的线程池，取号
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                while (true){
                    switch (type){
                        case COMMON:
                            commonService();
                            break;
                        case QUICK:
                            quickService();
                            break;
                        case VIP:
                            vipService();
                            break;
                    }

                }
            }
        });
    }

    public void commonService(){
        System.out.println(windowNum + "号" + type + "窗口正在获取普通任务！");
        Integer num = NumberMachine.getNumberMachine().getCommonNum().getNextNumber();
        if (num != null){
            //使用此随机数的好处，无参方法返回任意int范围的值，有参方法返回0到指定整数(包括0不包括指定值)间的随机数
            int randomTime = (new Random().nextInt(7000)) + 3001;
            System.out.println(windowNum + "号" + type + "窗口准备为" + num + "号普通客户服务！");
            try {
                Thread.sleep(randomTime);
                System.out.println(windowNum + "号" + type + "口正在为" + num + "号普通客户服务，耗时" + randomTime / 1000 +"秒！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(windowNum + "号" + type + "窗口没有取到普通任务，休息1秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void quickService(){
        System.out.println(windowNum + "号快速窗口正在获取快速任务！");
        Integer num = NumberMachine.getNumberMachine().getQuickNum().getNextNumber();
        if (num != null){
            //使用此随机数的好处，无参方法返回任意int范围的值，有参方法返回0到指定整数(包括0不包括指定值)间的随机数
            int randomTime = (new Random().nextInt(1000)) + 1001;
            System.out.println(windowNum + "号快速窗口准备为" + num + "号快速客户服务！");
            try {
                Thread.sleep(randomTime);
                System.out.println(windowNum + "号快速窗口正在为" + num + "号快速客户服务，耗时" + randomTime / 1000 +"秒！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(windowNum + "号快速窗口没有取到快速任务！");
            commonService();
        }
    }

    public void vipService(){
        System.out.println(windowNum + "号" + type + "窗口正在获取VIP任务！");
        Integer num = NumberMachine.getNumberMachine().getVipNum().getNextNumber();
        if (num != null){
            //使用此随机数的好处，无参方法返回任意int范围的值，有参方法返回0到指定整数(包括0不包括指定值)间的随机数
            int randomTime = (new Random().nextInt(9000)) + 1001;
            System.out.println(windowNum + "号VIP窗口准备为" + num + "号VIP客户服务！");
            try {
                Thread.sleep(randomTime);
                System.out.println(windowNum + "号VIP窗口正在为" + num + "号VIP客户服务，耗时" + randomTime / 1000 +"秒！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(windowNum + "号VIP窗口没有取到VIP任务!");
            commonService();
        }
    }

    //提供get()、set()方法
    public int getWindowNum() {
        return windowNum;
    }

    public void setWindowNum(int windowNum) {
        this.windowNum = windowNum;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }
}
