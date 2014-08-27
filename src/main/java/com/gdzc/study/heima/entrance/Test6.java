package com.gdzc.study.heima.entrance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 题目六：已知一个类，定义如下：
   package cn.itcast.heima;
      public class DemoClass {
      	public void run(){System.out.println("welcome to heima!");}   
     }
(1) 写一个Properties格式的配置文件，配置类的完整名称。
(2) 写一个程序，读取这个Properties配置文件，获得类的完整名称并加载这个类，用反射 的方式运行run方法。
 * 
 * @author Liu_Zhichao
 */
public class Test6 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		try {
			//读取配置文件
			InputStream fis = new FileInputStream("src/main/resources/config.properties");
			Properties properties = new Properties();
			//加载配置文件
			properties.load(fis);
			//关闭流
			fis.close();
			//从配置文件中读取内容
			String className = properties.getProperty("className1");
			String methodName = properties.getProperty("methodName");
			//通过反射拿到方法
			Method method = Class.forName(className).getMethod(methodName);
			//再调用方法，通过反射创建这个类的实例作为参数
			method.invoke(Class.forName(className).newInstance());
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
