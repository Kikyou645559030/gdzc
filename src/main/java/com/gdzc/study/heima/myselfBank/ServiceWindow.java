package com.gdzc.study.heima.myselfBank;

import java.util.Random;
import java.util.concurrent.Executors;

/**
 * Created by Liu_Zhichao on 14-9-2.
 * 银行叫号系统--服务窗口
 */
public class ServiceWindow {
    private int windowNum = 1;
    private CustomerType type = CustomerType.COMMON;

    public void start(){
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

    private void commonService(){
        System.out.println(windowNum + "号" + type + "窗口正在获取普通任务!");
        Integer num = NumberMachine.getNumberMachine().getCommonNumber().nextNumber();
        if (num != null){
            System.out.println(windowNum + "号" + type + "窗口准备为" + num + "号普通客户服务！");
            int time = new Random().nextInt(6000) + 1001;
            try {
                Thread.sleep(time);
                System.out.println(windowNum + "号" + type + "窗口已经" + num + "号普通客户服务服务完成，耗时" + time / 1000 + "秒！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(windowNum + "号" + type + "窗口没有获取到普通任务，休息1秒！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void quickService(){
        System.out.println(windowNum + "号" + type + "窗口正在获取快速任务!");
        Integer num = NumberMachine.getNumberMachine().getQuickNumber().nextNumber();
        if (num != null){
            System.out.println(windowNum + "号" + type + "窗口准备为" + num + "号快速客户服务！");
            int time = new Random().nextInt(6000) + 1001;
            try {
                Thread.sleep(time);
                System.out.println(windowNum + "号" + type + "窗口已经" + num + "号快速客户服务服务完成，耗时" + time / 1000 + "秒！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(windowNum + "号" + type + "窗口没有获取到快速任务！");
            commonService();
        }
    }

    private void vipService(){
        System.out.println(windowNum + "号" + type + "窗口正在获取VIP任务!");
        Integer num = NumberMachine.getNumberMachine().getVipNumber().nextNumber();
        if (num != null){
            System.out.println(windowNum + "号" + type + "窗口准备为" + num + "号VIP客户服务！");
            int time = new Random().nextInt(6000) + 1001;
            try {
                Thread.sleep(time);
                System.out.println(windowNum + "号" + type + "窗口已经" + num + "号VIP客户服务服务完成，耗时" + time / 1000 + "秒！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(windowNum + "号" + type + "窗口没有获取到VIP任务！");
            commonService();
        }
    }

    public void setWindowNum(int windowNum) {
        this.windowNum = windowNum;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }
}
