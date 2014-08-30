package com.gdzc.study.heima.note;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Liu_Zhichao on 14-8-28.
 * JavaBean、内省--对JavaBean的简单
 * Introspector--内省(类名也是英文名)
 * PropertyDescriptor--属性描述
 * BeanInfo--这个类封装了把一个Java类当做JavaBean来看的结果信息，通过调用静态方法Introspector.getBeanInfo()来获取
 */
public class IntroSpectorTest {
    public static void main(String[] args){
        String propertyName = "x";
        ReflectPoint rp = new ReflectPoint(4,4);
        try {
//            Java7的新特性，可以直接创建map
//            Map map = {name:"",age:12};
//            BeanUtils.setProperty(map,"name","Kikyou");还可以给map设值
            Object value = 7;
            //通过Apache提供的工具包来获取和设置JavaBean的属性，所有设置和获取的属性值都当做String类型来处理
            System.out.println(BeanUtils.getProperty(rp,propertyName));
            BeanUtils.setProperty(rp,propertyName,value);
            System.out.println(rp.getX());

            //通过BeanUtils工具类还可以设置属性的级联属性，不过需要级联属性的上一级属性有初始化的对象
            BeanUtils.setProperty(rp,"birthday.time","1111");
            System.out.println(BeanUtils.getProperty(rp,"birthday.time"));

            //PropertyUtils工具类也可以对JavaBean属性设值，区别是PropertyUtils是用属性原来的类型来设置和获取值
            PropertyUtils.setProperty(rp,propertyName,9);
            System.out.println(PropertyUtils.getProperty(rp,propertyName));

            //通过获取PropertyDescriptor来获取设置JavaBean的属性，有两种获取PropertyDescriptor的方式
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, rp.getClass());
            getProperty(pd, rp);
            setProperty(pd, rp, value);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    //选取代码块重构方法生成
    private static Object getProperty(PropertyDescriptor pd, Object rp) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Method getMethod = pd.getReadMethod();
        Object resultGet = getMethod.invoke(rp);
        return resultGet;
    }

    //选取代码块重构方法生成
    private static void setProperty(PropertyDescriptor pd, Object rp, Object value) throws IllegalAccessException, InvocationTargetException, IntrospectionException {
        //第一种 简便方式获取set()方法设值
        Method setMethod = pd.getWriteMethod();
        setMethod.invoke(rp,value);

        //第二种 通过获取BeanInfo对象来得到所有的PropertyDescriptor，再判断选择需要的来进行设值
        BeanInfo bi = Introspector.getBeanInfo(rp.getClass());
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        for (PropertyDescriptor pdp : pds){
            if ("x".equals(pdp.getName())){
                Method setFun = pdp.getWriteMethod();
                setFun.invoke(rp,value);
            }
        }
    }
}
