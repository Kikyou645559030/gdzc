package com.gdzc.study.heima.tset;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 通过java反射是如何来获取字节码的？有三种方式，分别是?
 */
public class Test4 {
    public static void main(String[] args){
        //三种获取字节码的方式
        try {
            Class clazz1 = Class.forName("com.gdzc.study.heima.tset.Test4");

            Class clazz2 = Test4.class;

            Test4 t = new Test4();
            Class clazz3 = t.getClass();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
