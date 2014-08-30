package com.gdzc.study.heima.note;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Liu_Zhichao on 14-8-30.
 * AOP框架测试类
 */
public class AopFrameworkTest {
    public static void main(String[] args){
        InputStream is = null;
        try {
            //创建读取文件流，输入流
            is = new FileInputStream("src/main/java/com/gdzc/study/heima/note/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //调用getBean()方法获得对象
        Object obj = new BeanFactory(is).getBean("name");
        System.out.println(obj.getClass().getName());
    }
}
