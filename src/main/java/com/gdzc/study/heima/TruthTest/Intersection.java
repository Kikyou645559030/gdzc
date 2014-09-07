package com.gdzc.study.heima.TruthTest;

/**
 * Created by Liu_Zhichao on 14-9-7.
 * 黑马入学真实性测试--取两个字符串中最大相同的部分
 */
public class Intersection {
    public static void main(String[] args){
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "hfshfsfhsfhsfmnhfwefhwfncjsijce";
        String temp;
        String result = "";
        Integer len = Math.min(s1.length(),s2.length());
        for (int i = 0; i < len; i++){
            for (int j = i+1; j < len; j++){
                temp = s1.substring(i,j);
                if (s2.contains(temp) && temp.length() > result.length()){
                    result = temp;
                }
            }
        }

        System.out.println(result);
    }
}
