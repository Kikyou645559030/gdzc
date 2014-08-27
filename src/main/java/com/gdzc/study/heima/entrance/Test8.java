package com.gdzc.study.heima.entrance;


/**
 * 题目八：将字符串中进行反转。abcde --> edcba
 * 
 * @author Liu_Zhichao
 */
public class Test8 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建一个StringBuilder对象
		StringBuilder sb = new StringBuilder("abcde");
		//调用StringBuilder的反转方法，最后对字符串打印输出
		sb.reverse();
		System.out.println(sb);
		
		//调用下面对字符串反转处理的方法
		System.out.println(reversal("abcdefgh"));
	}
	
	//将一个字符串进行反转处理后返回
	public static String reversal(String s){
		//将字符串转换成char[]数组
		char[] c = s.toCharArray();
		//定义一个临时变量
		StringBuilder result = new StringBuilder();
		//将数组从最后个依次往前取出来
		for (int i = c.length - 1; i >= 0; i--) {
			//将取出来的字符添加到临时变量中去
			result.append(c[i]);
		}
		//返回这个临时变量的字符串形式
		return result.toString();
	}
}
