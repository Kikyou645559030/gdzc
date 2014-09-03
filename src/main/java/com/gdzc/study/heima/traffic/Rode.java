package com.gdzc.study.heima.traffic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liu_Zhichao on 14-9-3.
 * 交通灯管理系统--路线
 */
public class Rode {
    private String name;//路线，方向
    private List<String> list = new ArrayList<String>();//路上要等待通过的车辆数

    public Rode(String name){
        this.name = name;

        //模拟一条路线上来车，随机1到10秒来一辆
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++) {
                    try {
                        Thread.sleep(new Random().nextInt(9000) + 1001);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(Rode.this.name + "--" + i);
                }
            }
        });

        //模拟一条路线上绿灯，车辆通行,1秒通过1辆
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (list.size() > 0){
                    //判断当前路对应的灯是否为绿灯
                    boolean lamp = Lamp.valueOf(Rode.this.name).isLight();
                    if (lamp){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(list.remove(0) + "通过了红绿灯！");
                    }
                }
            }
        },0,1, TimeUnit.SECONDS);
    }
}
