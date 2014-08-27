package com.gdzc.study.heima.entrance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 题目七：编写程序，循环接收用户从键盘输入多个字符串，直到输入“end”时循环结束，并将所有已输入的字符串按字典顺序倒序打印。
 * 
 * @author Liu_Zhichao
 */
public class Test7 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建一个list来装用户输入的字符串的集合
		List<String> list = new ArrayList<String>();
		BufferedReader br = null;
		//死循环，让里面的代码来决定什么时候结束
		while(true){
			//创建一个输入流，从键盘上读取输入的内容
			br = new BufferedReader(new InputStreamReader(System.in));
			//临时变量，记录每一次循环用户输入的字符串
			String sb = null;
			try {
				//读取用户输入的每一行
				if ((sb = br.readLine()) != null) {
					//将每一行的字符串都添加到list集合中
					list.add(sb);
					//判断，当用户输入字符串是"end"的时候，将所有字符串按字典倒序排列并打印输出
					if ("end".equals(sb)) {
						//调用sort()方法将一个装有String类型的list集合排序后返回
						List<String> tempList = sort(list);
						//循环遍历打印输出集合中的元素
						for (String word : tempList) {
							System.out.println(word);
						}
						//关闭流
						br.close();
						//结束死循环，方法结束
						return;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }

	//一个对装有String类型的集合按字典倒序排序的方法
	private static List<String> sort(List<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				//双层for循环拿到相邻的两个字符串，调用compareToIgnoreCase()方法做忽略大小写的比较
				if (list.get(j).compareToIgnoreCase(list.get(i)) > 0) {
					//如果第二个比第一个要大，就调换它们的位置
					String temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temp);
				}
			}
		}
		return list;
	}
}
