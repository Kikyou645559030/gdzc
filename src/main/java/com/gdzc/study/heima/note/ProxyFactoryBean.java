package com.gdzc.study.heima.note;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Liu_Zhichao on 14-8-30.
 * 动态代理类的Bean工厂
 */
public class ProxyFactoryBean {
    private Advice advice;
    private Object target;

    //创建代理类，并加上系统功能
    public Object getProxy(){
        Object proxyBean = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.beforeMethod(method);
                Object obj = method.invoke(proxy,args);
                advice.afterMethod(method);
                return obj;
            }
        });
        return proxyBean;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
