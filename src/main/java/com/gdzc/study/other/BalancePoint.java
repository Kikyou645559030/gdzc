package com.gdzc.study.other;

/**
 * 平衡点计算
 * Created by Liu_Zhichao on 2014/12/16 0016.
 */
public class BalancePoint {
	public static void main(String[] args) {
		int[] a = {-7,1,5,2,-5,1,3};
		System.out.println(findBalanceableNod(a));
	}

	/**
	 * 查找一个数组的平衡点
	 * @param a
	 * @return
	 */
	public static int findBalanceableNod(int[] a) {
		if (a == null) {
			return -1;
		}
		// 测试用例：平衡点为0位，为n-1位，为中间位，
		// a的每个为存了Integer.MAX_VALUE(所以用sum,subSum用long型)
		long sum = 0l;
		long subSum = 0l;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		for (int i = 0; i < a.length; i++) {
			if (subSum == sum - subSum - a[i]) {
				return i;
			} else {
				subSum += a[i];
			}
		}
		return -1;
	}
}
