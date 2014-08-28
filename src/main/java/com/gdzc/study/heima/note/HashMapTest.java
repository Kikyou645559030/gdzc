package com.gdzc.study.heima.note;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Liu_Zhichao on 14-8-23.
 * Java遍历Map的两种实现方法,第二种方法key和value都可以遍历的
    第一种方法是根据map的keyset（）方法来获取key的set集合，然后遍历map取得value的值
 */

public class HashMapTest{
    public static void main(String[] args){
        HashMap hashMap = new HashMap();

        hashMap.put("a", "aaaa");
        hashMap.put("b", "bbbb");
        hashMap.put("c", "cccc");
        hashMap.put("d", "dddd");

        Set set = hashMap.keySet();

        for(Iterator iter = set.iterator(); iter.hasNext();){
            String key = (String)iter.next();
            String value = (String)hashMap.get(key);
            System.out.println(key+"===="+value);
        }
    }
}

/**
 * 第二种方式是使用Map.Entry来获取：
     import java.util.HashMap;
     import java.util.Iterator;
     import java.util.Map;
     import java.util.Set;
 */
/*public class HashMapTest{
    public static void main(String[] args)
    {
        HashMap map = new HashMap();

        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        map.put("d","dd");

        Set set = map.entrySet();

        for(Iterator iter = set.iterator(); iter.hasNext();)
        {
            Map.Entry entry = (Map.Entry)iter.next();

            String key = (String)entry.getKey();
            String value = (String)entry.getValue();
            System.out.println(key +" :" + value);
        }
    }
}*/
