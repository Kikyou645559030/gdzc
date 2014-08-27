package com.gdzc.study.heima.entrance;

/**
 * 题目十：28人买可乐喝，3个可乐瓶盖可以换一瓶可乐，那么要买多少瓶可乐，够28人喝？
 * 假如是50人，又需要买多少瓶可乐？（需写出分析思路）
 * 有效的计算方法 a-(a/3)
 * @author Liu_Zhichao
 */
public class Test10 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(cola(7));
	}

	//计算需要买多少瓶可乐的方法
	public static int cola(int num){
        int sum = 0;//可乐总数
        int i = 0;//手中的瓶盖数
        int j = 0;//买的可乐数
        while (sum < num){
            sum++;
            i++;
            j++;
            if (i%3 == 0){//当有3个瓶盖时换一瓶，瓶盖成1个
                sum++;
                i = 1;
            }
        }
        return j;
	}
}
