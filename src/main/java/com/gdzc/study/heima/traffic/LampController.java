package com.gdzc.study.heima.traffic;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liu_Zhichao on 14-9-3.
 * 交通灯管理系统--红绿灯控制器
 */
public class LampController {
    private Lamp currentLamp;

    //启动红绿灯控制器，默认一个方向为绿灯
    public LampController(){
        currentLamp = Lamp.E2W;
        currentLamp.light();

        //定时器，每隔10秒变换一次灯
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                currentLamp = currentLamp.blackOut();
            }
        },10,10, TimeUnit.SECONDS);
    }
}
