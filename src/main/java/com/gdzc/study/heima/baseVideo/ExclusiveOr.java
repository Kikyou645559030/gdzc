package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-7.
 * 异或(^)--位移运算符
 * 当两个相同时为false，两个不同时为true
 * true ^ true = false;
 * true ^ false = true;
 * false ^ true = true;
 * false ^ false = false;
 * >>右移(最高位是0就补0，最高位是1就补1)
 * <<左移
 * >>>无符号右移(最高位都用0补)
 */
public class ExclusiveOr {
    public static void main(String[] args){
        //向右位移，位移多少就是除以多少次2，如下面就是6/2/2
        Integer num1 = (6>>2);//0110-->0001
        System.out.println(num1);//结果为1
        //向左位移，位移多少就是乘以多少次2，如下面就是3*2*2
        Integer num2 = (3<<2);//0011-->1100
        System.out.println(num2);//结果为12
    }
}
