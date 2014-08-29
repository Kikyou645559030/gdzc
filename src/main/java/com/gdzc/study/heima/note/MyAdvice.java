package com.gdzc.study.heima.note;


import java.lang.reflect.Method;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * AOP-面向切面编程-通告，将系统功能封装为一个对象
 */
public class MyAdvice implements Advice {
    long beginTime = 0;

    //在某个方法之前开始计时
    @Override
    public void beforeMethod(Method method) {
        beginTime = System.currentTimeMillis();
    }

    //在某个方法之后计算调用该方法用时
    @Override
    public void afterMethod(Method method) {
        long endTime = System.currentTimeMillis();
        System.out.println(method.getName() + " running time of:" + (endTime - beginTime));
    }
}
