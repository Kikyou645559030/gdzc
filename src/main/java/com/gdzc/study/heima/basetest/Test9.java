package com.gdzc.study.heima.basetest;

/**
 * 题目九：写一个正则表达式，可以匹配尾号5连的手机号。
 * 规则: 第1位是1，第二位可以是数字3458其中之一，后面4位任意数字，最后5位为任意相同的数字。
 * 例如：18601088888、13912366666
 * 
 * @author Liu_Zhichao
 */
public class Test9 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//正则表达式，第一位数是1(表达式的"1")，第二位是3458之一(表达式的"[3458]")，
		//第3到6为任意数字(表达式的"\\d{4}")，第7位单独分组(表达式的"(\\d)")，
		//第8到11位都是前面分组的第一个字符(表达式的"\\1{4}")，\\1表示取分组第一个字符
		System.out.println("18467566666".matches("1[3458]\\d{4}(\\d)\\1{4}"));
	}
}
