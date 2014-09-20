package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-20.
 * -模板设计模式
 * -将部分固定的逻辑以具体方法实现，将一些不确定的逻辑定为抽象方法强制子类重写
 * 也可以将一些方法定义默认的内容，供子类选择性的重写
 */
public class TemplateMethod {
    public static void main(String[] args) {
        CodeRun codeRun = new CodeRun();
        codeRun.getMilliSecond();
    }
}

abstract class getTime{
    /**
     * 将固定相同功能的代码用final修饰，供子类调用就行了，不允许重写
     */
    public final void getMilliSecond(){
        Long start = System.currentTimeMillis();
        codeRunTime();
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    /**
     * 将相同特征但不确定的功能封装抽象成一个方法，让子类自己去实现具体代码
     * -模板设计模式中不一定要抽象，要理解这个设计模式的理念
     */
    public abstract void codeRunTime();
}

class CodeRun extends getTime{

    @Override
    public void codeRunTime() {
        int count = 100;
        for (int i = 0; i <= 5000; i++) {
            System.out.print(i);
            if (count == i){
                count += 100;
                System.out.println();
            }
        }
    }
}
