package com.gdzc.study.heima.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liu_Zhichao on 14-9-1.
 * 银行业务调度系统--模拟开始服务
 */
public class StartService {
    public static void main(String[] args){
        //创建4个普通客户服务窗口
        for (int i = 1; i < 5; i++){
            ServiceWindow sw = new ServiceWindow();
            sw.setWindowNum(i);
            sw.setType(CustomerType.COMMON);
            sw.start();
        }

        //创建一个快速服务窗口
        ServiceWindow sw5 = new ServiceWindow();
        sw5.setWindowNum(5);
        sw5.setType(CustomerType.QUICK);
        sw5.start();

        //创建一个VIP服务窗口
        ServiceWindow sw6 = new ServiceWindow();
        sw6.setWindowNum(6);
        sw6.setType(CustomerType.VIP);
        sw6.start();

        //参数表示意思，第一项参数是要进行的操作，第二项参数是从多长时间后开始，
        // 第三项是以后每隔多长时间进行一次操作，第四项是时间单位，天、时、分、秒等等。
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Integer num1 = NumberMachine.getNumberMachine().getCommonNum().creatNumber();
                        System.out.println(num1 + "号普通客户等待服务！");
                    }
                },0,1,TimeUnit.SECONDS);

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer num2 = NumberMachine.getNumberMachine().getQuickNum().creatNumber();
                System.out.println(num2 + "号快速客户等待服务！");
            }
        },0,2,TimeUnit.SECONDS);

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer num = NumberMachine.getNumberMachine().getVipNum().creatNumber();
                System.out.println(num + "号VIP客户等待服务！");
            }
        },0,6,TimeUnit.SECONDS);
    }
}
