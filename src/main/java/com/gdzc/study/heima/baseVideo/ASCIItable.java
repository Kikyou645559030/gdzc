package com.gdzc.study.heima.baseVideo;

/**
 * Created by Liu_Zhichao on 14-9-7.
 * ASCII--编码表--转义字符
 * \n:换行。\b:退格。\r:按下回车键(windows系统中是由两个字符来表示的\r\n)。\t:制表符。
 */
public class ASCIItable {
    public static void main(String[] args){
        for (int i = 0; i < 128; i++){
            System.out.print((char)i + " ");
        }
    }
}
