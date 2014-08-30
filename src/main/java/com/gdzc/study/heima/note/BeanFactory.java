package com.gdzc.study.heima.note;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Liu_Zhichao on 14-8-30.
 * Bean工厂
 */
public class BeanFactory {
    private Properties properties = new Properties();

    /*
    加载配置文件
     */
    public BeanFactory(InputStream is){
        try {
            //使用load()加载文件
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    获取Bean实例对象
     */
    public Object getBean(String name){
        //拿到需要被实例对象的类名
        String className = properties.getProperty(name);
        Object bean = null;
        try {
            //创建实例对象
            Class clazz = Class.forName(className);
            bean = clazz.newInstance();
            //判断，如果是ProxyFactoryBean类型，则调用这个对象的方法来创建代理类，否则直接返回bean
            if (bean instanceof ProxyFactoryBean){
                //强转类型，通过反射读取配置文件创建advice对象的实例和target对象的实例
                ProxyFactoryBean proxyBean = (ProxyFactoryBean)bean;
                proxyBean.setAdvice((Advice)(Class.forName(properties.getProperty(name + ".advice")).newInstance()));
                proxyBean.setTarget(Class.forName(properties.getProperty(name + ".target")).newInstance());
                //调用getProxy()方法来获取代理类
                Object proxy = proxyBean.getProxy();
                return proxy;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
