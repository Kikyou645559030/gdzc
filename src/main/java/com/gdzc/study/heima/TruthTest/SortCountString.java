package com.gdzc.study.heima.TruthTest;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by Liu_Zhichao on 14-9-7.
 * 黑马入学真实性测试--对一个字符串统计次数并排序，打印输出
 */
public class SortCountString {
    public static void main(String[] args){
        System.out.println(getSortCount("ajdasjdiajdldkscidhdj"));
    }

    private static String getSortCount(String str){
        String result = "";
        if (!str.isEmpty()){
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            Map<Character,Integer> map = new TreeMap<Character, Integer>();
            for (int i = 0; i < chars.length; i++){
                Character c = chars[i];
                if (map.containsKey(c)){
                    map.put(c,map.get(c) + 1);
                }else {
                    map.put(c,1);
                }
            }

            Set<Map.Entry<Character,Integer>> set = map.entrySet();
            for (Map.Entry<Character,Integer> entry : set){
                result += entry.getKey() + "(" + entry.getValue() + ")";
            }
        }
        return result;
    }
}
