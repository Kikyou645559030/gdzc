package com.gdzc.study.other;

/**
 * Created by Liu_Zhichao on 14-5-18.
 */
public class Point {
    private Integer x;
    private Integer y;
    private Integer z;

    public Point(){
        x = 0;
        y = 0;
        z = 0;
    }

    public Point(Integer x,Integer y,Integer z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void main(String[] args){
        Point p = new Point(2,3,4);
        Point pt = new Point();
        Integer count = p.count(pt);
        System.out.println(count);
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    public Integer getX(){
        return x;
    }

    public Integer getY(){
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public Integer count(Point point){
        Integer x = point.getX();
        Integer a = (this.x - x) * (this.x - x);
        Integer y = point.getY();
        Integer b = (this.y - y) * (this.y - y);
        Integer z = point.getZ();
        Integer c = (this.z - z) * (this.z - z);
        return a+b+c;
    }

    //判断一个点是否在一个圆内,假设p1是一个圆的圆心的坐标,p2是需要判断的点
    public Boolean distance(Point p1,Point p2){
        Integer p1Radius = p1.getZ();//p1假设为一个圆,这是半径
        Integer x1 = p1.getX();
        Integer y1 = p1.getY();
        Integer x2 = p2.getX();
        Integer y2 = p2.getY();
        Integer m = x1 > x2 ? x1 - x2 : x2 - x1;
        Integer n = y1 > y2 ? y1 - y2 : y2 - y1;
        Integer p = m * n;
        Boolean flag = false;
        if (p1Radius > p){
            flag = true;
        }
        return flag;
    }
}
