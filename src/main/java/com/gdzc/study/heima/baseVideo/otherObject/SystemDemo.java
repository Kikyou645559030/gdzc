package com.gdzc.study.heima.baseVideo.otherObject;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * -System类
 * Created by Liu_Zhichao on 14-10-5.
 */
public class SystemDemo {
    public static void main(String[] args) {
        Properties properties = System.getProperties();//获取虚拟机运行时的所有参数信息
        for (Iterator i = properties.entrySet().iterator();i.hasNext();){
            Map.Entry entry = (Map.Entry) i.next();
            System.out.println(entry.getKey() + "::" + entry.getValue());
        }
    }
}
