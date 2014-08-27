package com.gdzc.study.heima.entrance;

/**
 * 题目十：28人买可乐喝，3个可乐瓶盖可以换一瓶可乐，那么要买多少瓶可乐，够28人喝？
 * 假如是50人，又需要买多少瓶可乐？（需写出分析思路）
 * 
 * @author Liu_Zhichao
 */
public class Test10 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(cola(50));
	}
	
	/* 分析思路：
	 * 28个人喝可乐，3个瓶盖可以换一个，说明4个人只需要买3瓶可乐，用人数除以4就可以知道需要买多少次3瓶的，
	 * 如果刚好整除，则只需要用3乘以买3瓶的次数就够所有人喝了。
	 * 当不能整除4时，则需要用3乘以买3瓶的次数再加上不能整除4剩下的余数就可以够所有人喝了。
	 */
	//计算需要买多少瓶可乐的方法
	public static int cola(int num){
		if ((num % 4) == 0) {
			return (num / 4) * 3;
		} else {
			return (num / 4) * 3 + num % 4;
		}
	}
}
