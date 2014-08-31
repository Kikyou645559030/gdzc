package com.gdzc.study.heima.interview;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 遍历map集合的两种方式
 */
public class Test2 {
    public static void main(String[] args){
        Map map = new HashMap();

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            map.get(iterator.next());
        }

        Set<Map.Entry> entrySet = map.entrySet();
        Iterator i = entrySet.iterator();
        while (i.hasNext()){
            Map.Entry entry = (Map.Entry)i.next();
            entry.getValue();
        }
    }
}
