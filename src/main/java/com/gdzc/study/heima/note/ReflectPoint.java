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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReflectPoint that = (ReflectPoint) o;

        if (x != that.x) return false;
        if (y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
