package com.gdzc.study.heima.RedGreenLamp;

/**
 * Created by Liu_Zhichao on 14-9-4.
 * 交通灯管理系统--启动系统
 */
public class RunSystem {
    public static void main(String[] args){
        String[] routes = new String[]{"E2W","W2E","S2N","N2S","E2S","W2N","S2W","N2E","E2N","S2E","W2S","N2W"};
        for (int i  = 0; i < routes.length; i++){
            new Route(routes[i]);
        }

        new LampController();
    }
}
