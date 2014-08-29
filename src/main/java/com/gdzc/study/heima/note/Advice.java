package com.gdzc.study.heima.note;

import java.lang.reflect.Method;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * AOP-面向切面编程-通告
 */
public interface Advice {
    void beforeMethod(Method method);
    void afterMethod(Method method);
}
