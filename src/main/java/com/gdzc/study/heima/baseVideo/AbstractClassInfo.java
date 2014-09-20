package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-20.
 * -抽象方法一定在抽象类中，抽象类不一定必须要有抽象方法，抽象类和抽象方法都使用abstract关键字来修饰
 * -不能通过new来创建抽象类的实例，因为如果能，调用抽象方法没有意义
 * -子类继承抽象类的时候，必须要实现全部的抽象方法，否则子类也是抽象类，因为会拥有父类的抽象方法
 */
public abstract class AbstractClassInfo {

    public abstract void show();

    public void getName(){
        System.out.println("呵呵");
    }
}
