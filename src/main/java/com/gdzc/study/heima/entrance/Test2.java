package com.gdzc.study.heima.entrance;

/**
 * 第二题：假如我们在开发一个系统时需要对员工进行建模，员工包含 3 个属性：姓名、工号以及工资。
 * 经理也是员工，除了含有员工的属性外，另为还有一个奖金属性。请使用继承的思想设计出员工类和经理类。
 * 要求类中提供必要的方法进行属性访问。
 * 
 * @author Liu_Zhichao
 */
public class Test2 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建对象，并调用set()方法设置属性值，调用get()方法访问属性值
		Manager manager = new Manager();
		manager.setName("黑马");
		manager.setNum("D476789420");
		manager.setSalary(10200.00);
		manager.setBonus(1860.00);
		System.out.println("姓名" + manager.getName());
		System.out.println("工号" + manager.getNum());
		System.out.println("工资" + manager.getSalary());
		System.out.println("奖金" + manager.getBonus());
	}
}

/**
 * 员工类
 * @author Liu_Zhichao
 */
class Employee{
	private String name;//员工姓名
	private String num;//员工工号
	private Double salary;//员工工资
	
	//属性私有化，通过提供get()、set()方法来设置和访问属性值
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}

/**
 * 经理类，继承员工类
 * @author Liu_Zhichao
 */
class Manager extends Employee{
	private Double bonus;//经理奖金

	//属性私有化，通过提供get()、set()方法来设置和访问属性值
	public Double getBonus() {
		return bonus;
	}

	public void setBonus(Double bonus) {
		this.bonus = bonus;
	}
}