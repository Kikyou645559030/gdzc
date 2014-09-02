package com.gdzc.study.heima.myselfBank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-2.
 * 银行叫号系统--号码管理器
 */
public class NumberManager {
    private int number = 0;
    private List<Integer> list = new ArrayList<Integer>();

    public Integer creatNum(){
        number++;
        list.add(number);
        return number;
    }

    public Integer nextNumber(){
        if (list.size() > 0){
            return list.remove(0);
        }
        return null;
    }
}
