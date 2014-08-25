package com.gdzc.study.heima.note;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 反射
 */
public class Reflect {
    public static void main(String[] args){
        Class c = (new Reflect()).getClass();
        System.out.println(c.toString());
        System.out.println(c.asSubclass(c));
        System.out.println(c.getCanonicalName());
        System.out.println(c.getClassLoader());
        System.out.println(c.getComponentType());
        System.out.println(c.getConstructors());
        System.out.println(c.getDeclaredFields());
        System.out.println(c.getDeclaredMethods());
        System.out.println(c.getModifiers());
        System.out.println(c.getPackage());
        System.out.println(c.getSimpleName());
        System.out.println(c.getSuperclass());
        System.out.println(c.getTypeParameters());
    }
}
