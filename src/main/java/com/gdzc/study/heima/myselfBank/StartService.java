package com.gdzc.study.heima.myselfBank;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liu_Zhichao on 14-9-2.
 * 银行叫号系统--开始服务
 */
public class StartService {
    public static void main(String[] args){
        List<ServiceWindow> list = new ArrayList<ServiceWindow>();

        //创建1个VIP窗口
        ServiceWindow swForVip = new ServiceWindow();
        swForVip.setType(CustomerType.VIP);
        list.add(swForVip);

        //创建1个快速窗口
        ServiceWindow swForQuick = new ServiceWindow();
        swForQuick.setWindowNum(2);
        swForQuick.setType(CustomerType.QUICK);
        list.add(swForQuick);

        //创建4个普通窗口
        for (int i = 3; i < 7; i++){
            ServiceWindow swForCommon = new ServiceWindow();
            swForCommon.setWindowNum(i);
            list.add(swForCommon);
        }

        //模拟来普通客户，定时，1秒来一个
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer num = NumberMachine.getNumberMachine().getCommonNumber().creatNum();
                System.out.println(num + "号普通客户正在等待服务！");
            }
        },0,1, TimeUnit.SECONDS);

        //模拟来快速客户，定时，2秒来一个
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer num = NumberMachine.getNumberMachine().getQuickNumber().creatNum();
                System.out.println(num + "号快速客户正在等待服务！");
            }
        },0,2, TimeUnit.SECONDS);

        //模拟来VIP客户，定时，6秒来一个
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Integer num = NumberMachine.getNumberMachine().getVipNumber().creatNum();
                System.out.println(num + "号VIP客户正在等待服务！");
            }
        },0,6, TimeUnit.SECONDS);

        for (ServiceWindow sw : list){
            sw.start();
        }
    }
}
