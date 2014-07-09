package com.gdzc.study;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Liu_Zhichao on 14-7-9.
 */
public class SetTest {

    public static void main(String[] args){
        Set<String> s1 = new HashSet<String>();
        Set<String> s2 = new HashSet<String>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        s2.add("a");
        s2.add("b");
        s2.add("d");

        Set<String> sn = new HashSet<String>(s1);
        sn.retainAll(s2);//求交集
        Set<String> su = new HashSet<String>(s1);
        su.addAll(s2);
        System.out.println(sn);
        System.out.println(su);
    }
}
