package com.gdzc.study.heima.note;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 反射
 */
public class Reflect {
    public static void main(String[] args){
        try {
            //作用:返回这个类的字节码的三种方式c1/c2/c3，下面这种方式有两种区别
            // 1.如果这个类已经加载到内存就直接获得
            // 2.如果这个类还没有加载到内存，就要先调用类加载器加载到内存中，保存字节码
            Class c1 = Class.forName("java.lang.String");

            Class c2 = Reflect.class;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class c3 = (new Reflect()).getClass();
        System.out.println(c3.isPrimitive());//false判断字节码是不是基础数据类型的
        System.out.println(int.class.isPrimitive());//true
        System.out.println(int.class == Integer.class);//false
        System.out.println(int.class == Integer.TYPE);//true代表Integer所包装的基础数据类型的字节码
        System.out.println(int[].class.isPrimitive());//false
        System.out.println(int[].class.isArray());//true

        System.out.println(c3.toString());
        System.out.println(c3.asSubclass(c3));
        System.out.println(c3.getCanonicalName());
        System.out.println(c3.getClassLoader());
        System.out.println(c3.getComponentType());
        System.out.println(c3.getConstructors());
        System.out.println(c3.getDeclaredFields());
        System.out.println(c3.getDeclaredMethods());
        System.out.println(c3.getModifiers());
        System.out.println(c3.getPackage());
        System.out.println(c3.getSimpleName());
        System.out.println(c3.getSuperclass());
        System.out.println(c3.getTypeParameters());

        //new String(new StringBuffer("abc"));通过构造方法来实现
        //获取只有一个参数，参数类型为StringBuffer的构造方法对象
        try {
            Constructor constructor = String.class.getConstructor(StringBuffer.class);//得到某一个构造方法
            String s = (String)constructor.newInstance(new StringBuffer("abc"));//创建实例对象
            System.out.println(s.charAt(2));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //该方法内部先得到默认的构造方法，再用这个构造方法来创建实例对象
        try {
            String obj = (String)Class.forName("java.lang.String").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //九种预定义的Class实例对象,八种基础类型加void
        Class clazz = void.class;
    }
}
