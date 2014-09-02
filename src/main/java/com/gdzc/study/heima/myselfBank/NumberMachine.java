package com.gdzc.study.heima.myselfBank;

/**
 * Created by Liu_Zhichao on 14-9-2.
 * 银行叫号系统--叫号器
 */
public class NumberMachine {
    private static NumberMachine numberMachine = new NumberMachine();
    private NumberManager commonNumber = new NumberManager();
    private NumberManager quickNumber = new NumberManager();
    private NumberManager vipNumber = new NumberManager();
    private NumberMachine(){}

    public synchronized static NumberMachine getNumberMachine(){
        return numberMachine;
    }

    public NumberManager getCommonNumber() {
        return commonNumber;
    }

    public NumberManager getQuickNumber() {
        return quickNumber;
    }

    public NumberManager getVipNumber() {
        return vipNumber;
    }
}
