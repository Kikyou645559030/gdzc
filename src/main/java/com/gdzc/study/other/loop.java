package com.gdzc.study.other;

import java.util.*;

/**
 * Created by Liu_Zhichao on 14-5-11.
 * break;跳出循环
 * countinue;结束当前一次循环
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
        List arrList = new ArrayList();//查询快，增删慢，效率高，线程不同步，不安全，底层是数组
        List likList = new LinkedList();//查询慢，增删快，效率高，线程不同呗，不安全，底层Hi链表
        List vector = new Vector();//查询快，增删慢，效率低，线程同步，安全，底层是数组

        Set hashSet = new HashSet();//不排序，底层是hash表
        Set treeSet = new TreeSet();//对元素进行排序，底层是二叉树
        HashSet likSet = new LinkedHashSet();//有序的

        Map hashMap = new HashMap();//对键不排序，线程不同步，效率高
        //怎么保证tree(底层是二叉树的)结构的排序，当元素具备比较性(自然排序)，
        // 实现Comparable接口，当集合具备比较性(比较器排序)，实现Comparator接口
        Map treeMap = new TreeMap();//对键排序，线程不同步，效率高
        HashMap likMap = new LinkedHashMap();
        Map hashTable = new Hashtable();//线程安全，效率低

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
