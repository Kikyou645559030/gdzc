package com.gdzc.study.heima.note;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 基本数据类型的自动装箱和拆箱(享元设计模式 flyweight)
 * 很多很小的对象，很多属性相同(内部状态)的地方就可以把它们变成一个对象
 * 当有部分不同的地方(外部状态)时可以当做方法的参数传递
 */
public class FlyWeight {
    public static void main(String[] args){
        Integer a = 7;//自动装箱
        System.out.println(a + 3);//自动拆箱
        Integer m = 45;
        Integer n = 45;
        System.out.println(m == n);
        Integer e = 137;
        Integer f = 137;
        System.out.println(e == f);
        Integer o = Integer.valueOf(33);
        Integer p = Integer.valueOf(33);
        System.out.println(o == p);
    }
}
