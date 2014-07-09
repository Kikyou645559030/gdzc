package com.gdzc.study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-7-9.
 */
public class ListTest {

    public static void fun(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        List<String> hehe = new ArrayList<String>();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            hehe.add(iterator.next());
            iterator.remove();
        }

        for (Iterator i = list.iterator(); i.hasNext();){
            i.remove();
//            list.remove(i.next());不要这样去除元素，会有例外，使用Iterator就只能让它来管理
        }

        System.out.println(list.size());
        for (String hh : hehe){
            System.out.print(hh+" ");
        }

        int[] arr = {1,2,3,4,5};
        for (int i : arr){
            System.out.println(i);//增强for循环不能方便的删除集合中的内容，内部使用Iterator实现的
        }
    }

    public static void main(String[] args){
        fun();
    }
}
