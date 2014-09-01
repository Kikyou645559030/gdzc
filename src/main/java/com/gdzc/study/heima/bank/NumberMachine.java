package com.gdzc.study.heima.bank;

/**
 * Created by Liu_Zhichao on 14-9-1.
 * 银行业务调度系统--取号器
 * 只有一个机器，所以做成单例更好
 */
public class NumberMachine {
    private static NumberMachine numberMachine = new NumberMachine();//创建自身的一个对象
    private NumberBuilder commonNum = new NumberBuilder();
    private NumberBuilder quickNum = new NumberBuilder();
    private NumberBuilder vipNum = new NumberBuilder();

    //私有构造方法
    private NumberMachine() {}

    //对外提供获取对象的方法
    public static NumberMachine getNumberMachine(){
        if (numberMachine == null){
            numberMachine = new NumberMachine();
        }
        return numberMachine;
    }

    public NumberBuilder getCommonNum() {
        return commonNum;
    }

    public NumberBuilder getQuickNum() {
        return quickNum;
    }

    public NumberBuilder getVipNum() {
        return vipNum;
    }
}
