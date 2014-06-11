package com.gdzc.study;

/**
 * 用面向对象的方式完成数三退一
 * Created by Liu_Zhichao on 14-6-11.
 */
public class Count3Quit1 {

    public static void main(String[] args){
        KidCircle kc = new KidCircle(500);
    }
}

//小孩对应的实体
class Kid{
    int id;
    Kid left;
    Kid right;
}

//一个小孩组成的圈的实体
class KidCircle{
    int count = 0;
    Kid first;
    Kid last;

    KidCircle(int n) {
        for (int i = 0; i < n; i++){
            add();
        }
    }

    //向圈里面添加一个小孩的方法
    void add(){
        Kid k = new Kid();
        k.id = count;
        if (count <= 0){
            first = k;
            last = k;
            k.left = k;
            k.right = k;
        }else {
            last.right = k;
            k.left = last;
            k.right = first;
            first.left = k;
            last = k;
        }
        count++;
    }

    //将圈里的小孩删除一个
    void delete(Kid k){
        if (count <= 0){
            return;
        }else if (count == 1){
            first = last = null;
        }else {
            k.left.right = k.right;
            k.right.left = k.left;
            if (k == first){
                first = k.right;
            }else if (k == last){
                last = k.left;
            }
        }
        count--;
    }
}
