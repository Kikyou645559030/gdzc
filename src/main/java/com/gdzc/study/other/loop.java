package com.gdzc.study.other;

import java.util.*;

/**
 * Created by Liu_Zhichao on 14-5-11.
 */
public class loop {
    public static void main(String[] args){
        count(50);

        iteratorTest();
    }

    /*规律数1 1 2 3 5 8 13...第三个数等于前两个之和*/
    private static void count(int x){
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 2;i < x;i++){
            if (x == 1 || x == 2){
                System.out.println(a);
            } else {
                c = a + b;
                a = b;
                b = c;
            }
        }
        System.out.println("--------------->"+c);
    }

    /*
    Iterator----ListIterator（继承）
    Comparable----Comparator（比较器）
     */
    private static void iteratorTest(){
        List arrList = new ArrayList();
        List likList = new LinkedList();
        List vector = new Vector();

        Set hashSet = new HashSet();
        Set treeSet = new TreeSet();
        HashSet likSet = new LinkedHashSet();

        Map hashMap = new HashMap();
        Map treeMap = new TreeMap();
        HashMap likMap = new LinkedHashMap();
        Map hashTable = new Hashtable();

        hashSet.add("111");
        hashSet.add("222");
        Iterator iterator1 = hashSet.iterator();

        while (iterator1.hasNext()){}

        Iterator iterator2 = null;
        for (iterator2 = arrList.iterator();iterator2.hasNext();){
            System.out.println(iterator2.next());
        }

        //遍历Map的方法
        Iterator iterator3 = hashMap.keySet().iterator();

        Iterator iterator4 = treeMap.entrySet().iterator();
        while (iterator4.hasNext()){
            Map.Entry entry = (Map.Entry) iterator4.next();
        }
    }
}
