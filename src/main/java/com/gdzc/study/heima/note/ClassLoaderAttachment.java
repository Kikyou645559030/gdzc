package com.gdzc.study.heima.note;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * 测试用-类加载器附件
 * 测试用-动态类的实例化
 */
public class ClassLoaderAttachment extends Date implements InvocationHandler{
    public String toString(){
        return "Hello,Kikyou!";
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
