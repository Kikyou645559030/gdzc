package com.gdzc.study.heima.RedGreenLamp;

/**
 * Created by Liu_Zhichao on 14-9-4.
 * 交通灯管理系统--红绿灯
 * N-北 S-南 E-东 W-西
 */
public enum Lamp {
    E2W("E2S","W2E",false),W2E("W2N","S2N",false),S2N("S2W","N2S",false),N2S("N2E","E2W",false),
    E2S(null,null,false),W2N(null,null,false),S2W(null,null,false),N2E(null,null,false),
    E2N(null,null,true),W2S(null,null,true),S2E(null,null,true),N2W(null,null,true);

    private boolean light;
    private String corresponding;
    private String nextLamp;

    private Lamp(String corresponding,String nextLamp, boolean light){
        this.light = light;
        this.corresponding = corresponding;
        this.nextLamp = nextLamp;
    }

    public boolean isLight(){
        return light;
    }

    public void toGreen(){
        light = true;
        if (corresponding != null){
            Lamp.valueOf(corresponding).toGreen();
        }
        System.out.println(name() + "灯变成绿灯，下面应该有6个方向有车通过！");
    }

    public Lamp toRed(){
        light = false;
        if (corresponding != null){
            Lamp.valueOf(corresponding).toRed();
        }

        Lamp tempLamp = null;
        if (nextLamp != null){
            tempLamp = Lamp.valueOf(nextLamp);
            System.out.println(nextLamp + "--------------------------------->变换成绿灯了！");
            tempLamp.toGreen();
        }
        return tempLamp;
    }
}
