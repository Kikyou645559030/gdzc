package com.gdzc.study.heima.basetest;

/**
 * 题目十：小明的妈妈每天会给他20元零花钱。平日里，小明先花掉一半，再把一半存起来。
 * 每到周日，小明拿到钱后会把所有零花钱花掉一半。请编程计算，从周一开始，小明需要多少天才能存够100元？
 * 
 * @author Liu_Zhichao
 */
public class Test10 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建钱的实例化对象，并且初始金额为0
		Money money = new Money();
		//调用计算金额的方法
		countMoney(money,100.0);
	}
	
	//计算小明需要多少天存够100元的方法
	public static void countMoney(Money money,Double num){
		int count = 0;//定义一个变量统计需要多少天才能存够100元
		int days = 0;//定义一个变量统计星期
		//当存的钱不到100时进行循环
		while (money.getNum() < num) {
			count++;
			days++;
			//当天数等于7时，也就是周日时，先存钱，再用一半，星期计数归0
			if (7 == days) {
				Double temp = money.useHalfMoney(money.saveMoney(20.0));
				money.setNum(temp);
				days = 0;
			}else{
				//非周日时，先用一半的钱，再存钱
				Double temp = money.saveMoney(money.useHalfMoney(20.0));
				money.setNum(temp);
			}
		}
		System.out.println("小明需要"+count+"天才能存够100元！");
	}
}

/**
 * 钱的实体类
 * @author Liu_Zhichao
 */
class Money{
	private Double num = 0.0;//钱的数额，默认为0

	//get()、set()方法
	public Double getNum() {
		return num;
	}

	public void setNum(Double num) {
		this.num = num;
	}
	
	//存钱的方法
	public Double saveMoney(Double money){
		return num + money;
	}
	
	//花掉一半钱的方法
	public Double useHalfMoney(Double money){
		return money / 2;
	}
}
