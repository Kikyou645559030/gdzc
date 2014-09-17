package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 默认构造函数的权限是随着类的变化而变化的
 */
public class Person {
    private String name;
    private int age;

    /**
     * 构造代码块：给对象进行初始化，定义的是不同对象共性的初始化内容
     * 对象一建立就运行，且优先于构造函数
     * 和构造函数的区别：
     * 构造代码块是给所有对象进行统一初始化
     * 而构造函数是给对应的对象初始化
     */
    {
        System.out.println("最先执行");
    }

    /**
     * 当自定义了构造方法，系统不再提供默认无参的构造方法
     * @param name
     */
    Person(String name){
        this.name = name;
    }

    /**
     * 调用自身构造方法，构造函数间调用只能用this来调用
     * @param name
     * @param age
     */
    Person(String name,int age){
        this(name);//调用自身构造方法
        this.age = age;
    }
}
