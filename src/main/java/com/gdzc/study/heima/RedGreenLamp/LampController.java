package com.gdzc.study.heima.RedGreenLamp;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Liu_Zhichao on 14-9-4.
 * 交通灯管理系统--交通灯控制器
 */
public class LampController {
    private Lamp currentLamp;

    public LampController(){
        currentLamp = Lamp.E2W;
        currentLamp.toGreen();

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (currentLamp.isLight()){
                    currentLamp = currentLamp.toRed();
                }
            }
        },10,10,TimeUnit.SECONDS);
    }
}
