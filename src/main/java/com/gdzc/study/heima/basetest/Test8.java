package com.gdzc.study.heima.basetest;


/**
 * 题目八：编程打印所有的3位质数，质数特点：只能被1和其本身整除
 * 
 * @author Liu_Zhichao
 */
public class Test8 {

	public static void main(String[] args){
		getPrime(100,999);
	}
	
	/**
	 * 计算一个整数区间中的质数，最小值不能小于3
	 * @param start
	 * @param end
	 */
	public static void getPrime(int start,int end){
		//定义一个临时变量记录一个数是否能被除1和自身外的数整除，0表示能被其他数整除
		Integer num = 0;
		//判断，只处理最小值不小于3的区间
		if (2 < start) {
			for (int i = start; i <= end; i++) {
				//除数只除到被除数一半，提高效率
				for (int j = 2; j < i / 2; j++) {
					//如果i能被其他数整除，结束该层循环
					if ((i % j) == 0) {
						num = 0;
						break;
					}else{
						//如果i不能被其他数整除，记录当前i的值
						num = i;
					}
				}
				//每次循环内层循环结束，num不等于0时，说明该数是质数，打印到控制台上
				if(num != 0){
					System.out.print(num + " ");
				}
			}
		}else{
			System.out.println("最小值小于3不做计算！");
		}
	}
}
