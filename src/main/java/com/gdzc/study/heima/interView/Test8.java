package com.gdzc.study.heima.interview;

/**
 * Created by Liu_Zhichao on 14-8-31.
 * 谈谈你对反射，动态代理，类加载器的理解
 *
 *类加载器：所以类都需要通过类加载加载到内存中去，系统默认提供的有3中，BootStrap是最顶级的类加载器，
 * 不是由java编写，作用范围是rt.jar，ExtClassLoader作用范围是jdk目录下jre目录下的ext目录中的所有jar包，
 * AppClassLoader作用范围是classpath以及引用的其他jar包。自定义类加载器需要继承ClassLoader类，重写findClass方法
 *
 *反射：当一个类被类加载器加载到内存之后，成为二进制的字节码，可以通过这份字节码来反射得到这个类的相关信息，
 * 比如构造方法，成员变量，成员方法，实现的接口等等。
 *
 *动态代理：在一个类加载到内存之后，动态的来创建代理类，通过Proxy的方法来创建代理类，
 * 作用是可以在类的方法中加入系统功能，这就是面向切面的编程。
 *
 */
public class Test8 {
}
