package com.gdzc.study.heima.basetest;

/**
 * 第四题：编写一个函数，函数内输出一个字符串，并在主函数内调用它。
 *
 * @author Liu_Zhichao
 */
public class Test4 {

    /**
     * 程序的入口
     * @param args
     */
    public static void main(String[] args){
        print("Hello,黑马！");//调用输出字符串的方法
    }

    /**
     * 打印输出给出的字符串
     * @param s
     */
    public static void print(String s){
        System.out.println(s);
    }
}
