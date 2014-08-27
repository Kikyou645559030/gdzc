package com.gdzc.study.heima.entrance;

/**
 * 第三题：定义一个交通灯枚举，包含红灯、绿灯、黄灯，需要有获得下一个灯的方法，
 * 例如：红灯获取下一个灯是绿灯，绿灯获取下一个灯是黄灯。
 * 
 * @author Liu_Zhichao
 */
public class Test3 {
	
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//调用获取下一个灯的方法
		TrafficLamp.red.nextLamp();
		TrafficLamp.green.nextLamp();
		TrafficLamp.yellow.nextLamp();
	}
}

/**
 * 交通信号灯的枚举
 * @author Liu_Zhichao
 */
enum TrafficLamp{
	red(25){
		@Override
		public TrafficLamp nextLamp() {
			System.out.println("红灯下一个是" + green);
			return green;
		}
	},green(30){
		@Override
		public TrafficLamp nextLamp() {
			System.out.println("绿灯下一个是" + yellow);
			return yellow;
		}
	},yellow(5){
		@Override
		public TrafficLamp nextLamp() {
			System.out.println("黄灯下一个是" + red);
			return red;
		}
	};
	
	private int time;//交通信号灯显示的时长
	
	TrafficLamp(int time){
		this.time = time;
	}
	
	//交通信号灯的抽象方法，获取下一个灯
	public abstract TrafficLamp nextLamp();
}
