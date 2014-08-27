package com.gdzc.study.heima.entrance;

import java.util.ArrayList;
import java.util.List;

/**
 * 第四题：一个ArrayList对象aList中存有若干个字符串元素，现欲遍历该ArrayList对象，
 * 删除其中所有值为"abc"的字符串元素，请用代码实现。
 * 
 * @author Liu_Zhichao
 */
public class Test4 {
	/**
	 * 程序的入口
	 * @param args
	 */
	public static void main(String[] args){
		//创建List集合，并添加10个元素，两个为"abc"
		List<String> aList = new ArrayList<String>();
		aList.add("aaa");
		aList.add("abc");//添加的"abc"
		aList.add("abb");
		aList.add("acb");
		aList.add("bca");
		aList.add("bac");
		aList.add("cba");
		aList.add("abc");//添加的"abc"
		aList.add("cbb");
		aList.add("aba");
		//循环遍历集合，如果有元素和"abc"相等就删除这个元素
		for (int i = 0; i < aList.size(); i++) {
			if("abc".equals(aList.get(i))){
				aList.remove(i);
			}
		}
		System.out.println(aList.size());
	}
}
