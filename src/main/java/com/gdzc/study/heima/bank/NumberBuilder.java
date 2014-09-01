package com.gdzc.study.heima.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-1.
 * 银行业务调度系统--号码管理器
 */
public class NumberBuilder {
    private int number = 0;//号码
    private List<Integer> list = new ArrayList<Integer>();//排队的号码的集合

    //生成号码，模拟来人取号
    public synchronized Integer creatNumber(){
        number ++;
        list.add(number);
        return number;
    }

    //服务窗口叫号
    public synchronized Integer getNextNumber(){
        Integer num = null;
        if (list.size() > 0){
            num = list.remove(0);
        }
        return num;
    }

    public List<Integer> getList() {
        return list;
    }
}
