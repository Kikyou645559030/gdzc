package com.gdzc.study.heima.basetest;

/**
 * 题目六：编写一个延迟加载(懒汉式)的单例设计模式。
 * 注释有饿汉式单例设计模式
 * @author Liu_Zhichao
 */
public class Test6 {

	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建3个Employee的变量，都是指向同一个对象
		Employee e1 = Employee.getEmployee();
		Employee e2 = Employee.getEmployee();
		Employee e3 = Employee.getEmployee();
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
    }
}

/**
 * 员工实体类
 * @author Liu_Zhichao
 */
class Employee{
	private String id;//员工id
	private String name;//员工姓名
	
	private static Employee employee = null;

//    private static final Employee employee = new Employee();饿汉式单例设计模式

	//构造方法私有化，只能在本类中实例化对象
	//不能在其他类中实例化该类，只能通过调用getEmployee()方法来获取对象，这就是单例设计模式
	private Employee(){
	}
	
	//提供公有的方法获取Employee对象，在调用该方法时才实例化对象，这就是延迟加载的单例设计模式
    //加上synchronized可以保证线程安全
	public synchronized static Employee getEmployee(){
		if (employee == null) {
			employee = new Employee();
		}
		return employee;

//        return employee;饿汉式单例设计模式
	}

	/*
	 * 成员变量的get()、set()方法
	 */
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
