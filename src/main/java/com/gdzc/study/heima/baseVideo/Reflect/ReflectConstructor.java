package com.gdzc.study.heima.baseVideo.Reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * -反射-反射获取构造方法，并通过Class字节码创建实例对象
 * Created by Liu_Zhichao on 14-10-6.
 */
public class ReflectConstructor {
    public static void main(String[] args) {
        try {
            //通过反射获得字节码，再通过字节码获取类指定的构造方法(也可以获取所有构造方法)，代表的是某一个构造方法。
            Constructor constructor = String.class.getConstructor(StringBuffer.class);
            //注意通过构造方法创建实例对象时，有参数的情况下参数类型一定要正确。
            String str1 = (String) constructor.newInstance(new StringBuffer("abc"));

            //直接通过Class来创建实例对象，但是只能通过无参构造方法创建，如果没有无参构造方法则抛出异常
            String str2 = String.class.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
