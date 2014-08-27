package com.gdzc.study.heima.entrance;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * 第一题：写一个方法，此方法可将obj对象中名为propertyName的属性的值设置为value.   
 * public void setProperty(Object obj, String propertyName, Object value){}
 * 
 * @author Liu_Zhichao
 */
public class Test1 {
	
	private String propertyName;
	
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建一个对象，并调用方法，打印输出propertyName的值
		Test1 t = new Test1();
		setProperty(t, "propertyName", new Date());
		System.out.println("propertyName:" + t.propertyName);
	}
	
	/**
	 * 将一个对象的名为propertyName属性的值设置为value
	 * @param obj
	 * @param propertyName
	 * @param value
	 */
	public static void setProperty(Object obj,String propertyName,Object value){
		try {
			//通过反射拿到对象的成员变量，使用getDeclaredField()方法可以拿到private修饰的成员变量
			Field field = obj.getClass().getDeclaredField(propertyName);
			//使用暴力反射来对private修饰的成员变量进行操作
			field.setAccessible(true);
			//给这个对象的属性设置值,由于接受的参数value是Object类型的，所以需要转换一下才能设值
			field.set(obj, String.valueOf(value));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}