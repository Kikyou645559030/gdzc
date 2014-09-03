package com.gdzc.study.heima.traffic;

/**
 * Created by Liu_Zhichao on 14-9-3.
 * 交通灯管理系统--红绿灯
 * N-北 S-南 E-东 W-西
 */
public enum Lamp {
    E2W("W2E","E2S",false),E2S("W2N","S2N",false),S2N("N2S","S2W",false),S2W("N2E","E2W",false),
    W2E(null,null,false),W2N(null,null,false),N2S(null,null,false),N2E(null,null,false),
    E2N(null,null,true),S2E(null,null,true),W2S(null,null,true),N2W(null,null,true);

    private boolean light;//是否为绿灯
    private String oppsite;//关联的灯
    private String nextLamp;//下一个灯

    private Lamp(String oppsite, String nextLamp, boolean light){
        this.light = light;
        this.oppsite = oppsite;
        this.nextLamp = nextLamp;
    }

    public boolean isLight(){
        return light;
    }

    //变成绿灯，关联灯也变成绿灯
    public void light(){
        light = true;
        if (oppsite != null){
            Lamp.valueOf(oppsite).light();
        }
        System.out.println(name() + "是绿灯，下面总共应该有6个方向能看到汽车穿过！");
    }

    //变成红灯，关联灯也变成红灯，下一个灯变成绿灯
    public Lamp blackOut(){
        light = false;
        if (oppsite != null){
            Lamp.valueOf(oppsite).blackOut();
        }
        Lamp tempLamp = null;
        if (nextLamp != null){
            tempLamp = Lamp.valueOf(nextLamp);
            System.out.println("绿灯从" + name() + "-------->切换为" + nextLamp);
            tempLamp.light();
        }
        return tempLamp;
    }
}
