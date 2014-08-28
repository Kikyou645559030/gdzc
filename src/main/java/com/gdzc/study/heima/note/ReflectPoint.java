package com.gdzc.study.heima.note;

import java.util.Date;

/**
 * Created by Liu_Zhichao on 14-8-26.
 * 反射，坐标测试类
 */
public class ReflectPoint {
    private int x;
    public int y;
    private Date birthday = new Date();
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
