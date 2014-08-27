package com.gdzc.study.heima.entrance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目九：编写一个程序，它先将键盘上输入的一个字符串转换成十进制整数，然后打印出这个十进制整数对应的二进制形式。
 * 这个程序要考虑输入的字符串不能转换成一个十进制整数的情况，并对转换失败的原因要区分出是数字太大，
 * 还是其中包含有非数字字符的情况。提示：十进制数转二进制数的方式是用这个数除以2，余数就是二进制数的最低位，
 * 接着再用得到的商作为被除数去除以2，这次得到的余数就是次低位，如此循环，直到被除数为0为止。
 * 其实，只要明白了打印出一个十进制数的每一位的方式（不断除以10，得到的余数就分别是个位，十位，百位），
 * 就很容易理解十进制数转二进制数的这种方式。
 * 
 * @author Liu_Zhichao
 */
public class Test9 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println("请输入一个非负的整数，按回车确认!输入esc或者ESC结束！");
		//死循环，可以多次输入数字转换二进制
		while(true){
			try {
				//创建输入流，准备读取用户输入的字符串
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				//定义临时变量，记录每一次用户输入需要转换的字符串
				String temp = null;
				//读取用户输入的内容
				if ((temp = br.readLine()) != null) {
					//当用户输入esc或者ESC的时候，关闭输入流并结束死循环
					if ("esc".equalsIgnoreCase(temp)) {
						br.close();
						return;
					}
					//首先调用isValidNum()方法，判断用户输入的是否是一个合法的数字(这里只考虑正整数)
					if (isValidNum(temp)) {
						//将用户输入的字符串转换为数字
						Integer num = Integer.valueOf(temp);
						//调用toBinary()方法将数字转换为二进制的数，并打印输出
						System.out.println(num + "的二进制数是：" + toBinary(num));
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 判断一个字符串是否为正整数
	 */
	public static boolean isValidNum(String num){
		//判断用户输入的字符是否为空，并给予提示
		if (!num.isEmpty()) {
			//用正则表达式判断用户输入的是否是全数字，并给予提示
			if (num.matches("\\d+")) {
				try{
					//捕捉异常，当有异常时说明用户输入的数字超过int类型的最大值，给予提示
					Integer.valueOf(num);
					return true;
				}catch (NumberFormatException e){
					System.out.println("您输入的数字已经超过int的最大值");
					return false;
				}
			}else{
				System.out.println("您输入的字符中包含非数字字符");
				return false;
			}
		}else{
			System.out.println("未检测到字符");
			return false;
		}
	}
	
	/*
	 * 获取一个正整数的二进制数
	 * 由于一些大的数字转换成的二进制数非常长，所以不能用Integer或者Long做返回值
	 */
	private static StringBuilder toBinary(Integer num) {
		//创建一个StringBuilder对象来存放num每一次和2求余的值
		StringBuilder sb = new StringBuilder();
		//循环求num和2相除的余，并将余数添加到sb中
		while(num != 0){
			int temp= num % 2;
			num /= 2;
			sb.append(temp);
		}
		//先求出来的余数是二进制的最低位，所以需要反转一下
		sb.reverse();
		return sb;
	}
}
