package com.gdzc.study.heima.note;

/**
 * Created by Liu_Zhichao on 14-8-26.
 * 反射，坐标测试类
 */
public class ReflectPoint {
    private int x;
    public int y;
    public  String str1 = "ball";
    public String str2 = "basketball";
    public String str3 = "Kikyou";

    public ReflectPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static void main(String[] args){
        System.out.println("调用主函数成功!");
        for (String s : args){
            System.out.println(s);
        }
    }
}
