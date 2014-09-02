package com.gdzc.study.heima.myselfBank;

/**
 * Created by Liu_Zhichao on 14-9-2.
 * 银行叫号系统--
 */
public enum CustomerType {
    COMMON,QUICK,VIP;

    public String toString(){
        switch (this){
            case COMMON:
                return "普通";
            case QUICK:
                return "快速";
            case VIP:
                return name();
        }
        return null;
    }
}
