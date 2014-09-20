package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-20.
 */
class Fu {
    private int id = 3;
    protected int num = 4;
    int count = 5;
}

class Zi extends Fu{
    int count = 6;
    Zi(){
        super();//只要创建子类对象就会隐式的调用父类无参的构造方法，创建父类对象
    }
    public void show(){
        System.out.println(num);
        System.out.println(this.count);
        System.out.println(super.count);
    }
}

public class Ma{
    public static void main(String[] args) {
        Zi z = new Zi();
        z.show();
        System.out.println(""+'a'+1);
    }
}
