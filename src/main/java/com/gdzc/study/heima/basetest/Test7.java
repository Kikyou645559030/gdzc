package com.gdzc.study.heima.basetest;

/**
 * 题目七：编程列出一个字符串的全字符组合情况，原始字符串中没有重复字符。
 * 例如：原始字符串是"abc"，打印得到下列所有组合情况：
 "a" "b" "c"
 "ab" "bc" "ca" "ba" "cb" "ac"
 "abc" "acb" "bac" "bca" "cab" "cba"

 * @author Liu_Zhichao
 */
public class Test7 {
    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args){
        //调用get()方法
        get("abc","");
    }

    /**
     * 获取一个原始字符串的全部组合情况，第一个参数为原始字符串，第二个参数为临时变量，记录每一种组合
     * @param str
     * @param s
     */
    public static void get(String str,String s){
        //当临时变量字符串和原始字符串长度相等时，结束迭代
        if (s.length() == str.length()) {
            return;
        } else {
            //循环遍历原始字符串
            for (int i = 0; i < str.length(); i++) {
                //如果临时字符串已经包含第i个字符的时候，结束当前循环，再取下一个字符
                if (s.contains(String.valueOf(str.charAt(i)))) {
                    continue;
                } else {
                    //记录并打印每一个组合的字符串
                    s += str.charAt(i);
                    System.out.println(s);
                    //进行下一次递归
                    get(str,s);
                    //每次递归结束后，将刚才添加到临时字符串的字符去掉
                    s = s.substring(0, s.length()-1);
                }
            }
        }
    }
}
