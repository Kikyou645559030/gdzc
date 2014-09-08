package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-8.
 * 执行顺序，先创建父类对象，创建父类时，有初始化成员变量的先初始化成员变量，再调用构造方法
 */
public class Z extends X {
    Y y = new Y();//第三执行
    Z() {
        this("11");//调用自己其他的构造方法
        System.out.print("Z");//第五执行
    }
    Z(String s) {
        System.out.print("O");//第四执行
    }
    public static void main(String[] args) {
        new Z();
    }
}

class X {
    Y b = new Y();//第一执行
    X() {
        System.out.print("X");//第二执行
    }
}

class Y {
    Y() {
        System.out.print("Y");
    }
}


