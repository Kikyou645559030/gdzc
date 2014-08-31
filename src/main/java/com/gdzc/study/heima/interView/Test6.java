package com.gdzc.study.heima.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 编写一个类，在main方法中定义一个Map对象（采用用泛型），加入若干个对象，然后遍历打印出个元素的key和value
 */
public class Test6 {
    public static void main(String[] args){
        Map<String,String> map = new HashMap<String, String>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");

        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry = (Map.Entry<String, String>) iterator.next();
            System.out.println(entry.getKey() + ":" +entry.getValue());
        }
    }
}
