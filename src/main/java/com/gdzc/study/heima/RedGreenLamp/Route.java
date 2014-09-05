package com.gdzc.study.heima.RedGreenLamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liu_Zhichao on 14-9-4.
 * 交通灯管理系统--路线
 */
public class Route {
    private String name;
    private List<String> list = new ArrayList<String>();

    public Route(String name){
        this.name = name;

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 1000; i++){
                    try {
                        Thread.sleep(new Random().nextInt(9000) + 1001);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(Route.this.name + ":" + i);
                }
            }
        });

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (list.size() > 0){
                    boolean light = Lamp.valueOf(Route.this.name).isLight();
                    if (light){
                        String temp = list.remove(0);
                        System.out.println(temp + "通过了");
                    }
                }
            }
        },1,1, TimeUnit.SECONDS);
    }
}
