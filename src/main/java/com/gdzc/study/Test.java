package com.gdzc.study;

import java.util.ArrayList;

/**
 * Created by Liu_Zhichao on 14-5-19.
 * get方法一般是public的，供外部调用获取属性值(成员变量,即属性值一般是private)
 */
public class Test {
    public static void  main(String[] a){
        Point p = new Point();
        Animal dog = new Dog();
        dog.getAge();
        dog.eat(3);

        Person p1 = new Person();
        Person p2 = new Person("Lee",18);
        Person p3 = new Person("Jeam",20,"men");
        System.out.println(p1+"----"+p2+"----"+p3);

        Data data = new Data();
        ArrayList<Data> datas = new ArrayList<Data>();

        for (int i = 100; i < 103; i++) {
            data.val = i;
            datas.add(data);
        }
        for (Data d : datas){
            System.out.println(d.val);
        }
    }
}

class Data {
    int val;
}
