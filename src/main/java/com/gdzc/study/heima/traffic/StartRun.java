package com.gdzc.study.heima.traffic;

/**
 * Created by Liu_Zhichao on 14-9-3.
 * 交通灯管理系统--模拟系统运行
 */
public class StartRun {
    public static void main(String[] args){

        //模拟12个方向的路线
        String[] roads = new String[]{"E2W","E2S","S2N","S2W","W2E","W2N","N2S","N2E","E2N","S2E","W2S","N2W"};
        for (String roadName : roads){
            new Rode(roadName);
        }

        //模拟启动控制器
        new LampController();
    }
}
