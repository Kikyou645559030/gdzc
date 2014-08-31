package com.gdzc.study.heima.interview;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 编写一个类，增加一个实例方法用于打印一条字符串。并使用反射手段创建该类的对象，并调用该对象中的方法
 */
public class Test5 {
    public static void main(String[] args){
        Class clazz = PrintString.class;
        try {
            PrintString ps = (PrintString)clazz.newInstance();
            ps.print("aaa");

            Method method = clazz.getMethod("print", new Class[]{String.class});
            method.invoke(ps,"bbb");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class PrintString{
    public void print(String s){
        System.out.println(s);
    }
}
