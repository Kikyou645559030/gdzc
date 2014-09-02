package com.gdzc.study.heima.consultBank;

/**
 * Created by Liu_Zhichao on 14-9-1.
 * 银行业务调度系统--服务客户类型
 */
public enum CustomerType {
    COMMON,QUICK,VIP;

    public String toString(){
        switch (this){
            case COMMON: return "普通";
            case QUICK: return "快速";
            case VIP: return name();
        }
        return null;
    }
}
