package com.gdzc.study.heima.note;

/**
 * Created by Liu_Zhichao on 14-8-25.
 * 普通类模拟枚举
 * 1.私有构造方法
 * 2.每个元素用静态成员变量表示
 * 3.可以有若干个公有方法或抽象方法
 */
public abstract class WeekDay {
    private WeekDay(){}

    public static final WeekDay MON = new WeekDay(){

        @Override
        public WeekDay nextDay() {
            return SUN;
        }
    };

    public static final WeekDay SUN = new WeekDay(){

        @Override
        public WeekDay nextDay() {
            return MON;
        }
    };

    public abstract WeekDay nextDay();

    public String toString(){
        return this == MON ? "星期一" : "星期天";
    }
}
