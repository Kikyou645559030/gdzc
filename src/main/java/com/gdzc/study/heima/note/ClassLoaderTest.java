package com.gdzc.study.heima.note;

import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-8-29.
 * 类加载器--系统默认的三个为BootStrap(非Java写的,最顶级的)、ExtClassLoader(继承前面的)、AppClassLoader(继承前面的)
 */
public class ClassLoaderTest {
    public static void main(String[] args){
        System.out.println(ReflectPoint.class.getClassLoader().getClass().getName());
        //System这个类是由BootStrap类加载器加载的，而这个加载器是唯一一个不是用Java写的，所以获取的结果为null
        System.out.println(System.class.getClassLoader());

        //循环打印类加载器的父类
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        while (loader != null){
            System.out.println(loader.getClass().getName());
            loader  =loader.getParent();
        }

        //测试自定义类加载器，加密和解密，先编译ClassLoaderAttachment，运行MyClassLoader将编译后的class文件加密，
        //然后输出到自定义的目录，再运行ClassLoaderTest，
        //先对文件解密，然后再使用自定义类加载器加载指定的class文件返回二进制字节码
        try {
            Class clazz = new MyClassLoader().loadClass("ClassLoaderAttachment");
            Date date = (Date)clazz.newInstance();
            System.out.println(date);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
