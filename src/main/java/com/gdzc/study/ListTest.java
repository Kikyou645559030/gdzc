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
        Iterator<String> iterator = (Iterator)list.iterator();
        while (iterator.hasNext()){
            hehe.add(iterator.next());
            iterator.remove();
        }
        System.out.println(list.size());
        for (String hh : hehe){
            System.out.print(hh+" ");
        }
    }

    public static void main(String[] args){
        fun();
    }
}
