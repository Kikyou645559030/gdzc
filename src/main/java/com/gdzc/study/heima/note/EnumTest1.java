package com.gdzc.study.heima.note;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 枚举测试类，当枚举只有一个成员时，可以作为一种单例的实现方式
 */
public class EnumTest1 {
    public static void main(String[] args){
        //普通类模拟枚举
        WeekDay weekDay = WeekDay.MON;
        System.out.println(weekDay);

        //普通枚举
        WeekDay1 w1 = WeekDay1.FRI;
        System.out.println(w1);
        System.out.println(w1.name());
        System.out.println(w1.ordinal());
        System.out.println(w1.toString());
        System.out.println(WeekDay1.valueOf("SUN"));
        System.out.println(WeekDay1.values().length);

        WeekDay2 w2 = WeekDay2.FRI;
    }

    //普通枚举
    public enum WeekDay1{
        SUN,MON,TUE,WEN,THI,FRI,SAT;
    }

    //带构造方法以及有参构造方法的枚举
    public enum WeekDay2{
        SUN(0),MON,TUE,WEN,THI,FRI,SAT;

        WeekDay2(){
            System.out.println("first");
        }

        WeekDay2(int day){
            System.out.println("second" + day);
        }
    }

    //目前最复杂的一个枚举
    public enum TrafficLamp{
        //每一个类的子类，包括显示的时长以及下一个灯的对象
        RED(30){
            @Override
            public TrafficLamp nextLamp() {
                return GREEN;
            }
        },
        GREEN(45){
            @Override
            public TrafficLamp nextLamp() {
                return YELLOW;
            }
        },
        YELLOW(5){
            @Override
            public TrafficLamp nextLamp() {
                return RED;
            }
        };

        //下一个灯
        public abstract TrafficLamp nextLamp();

        private int time;//时长

        //有参构造方法，红绿灯时间
        TrafficLamp(int time) {
            this.time = time;
        }
    }
}
