package com.gdzc.study;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * Created by Liu_Zhichao on 14-7-30.
 * 运行时加参数,参数为文件名,将文件中的内容读取出来,再打印到命令行
 */
public class TestPrintStream2 {
    public static void main(String[] args){
        String fileName = args[0];
        if (StringUtils.isNotBlank(fileName) && fileName != null){
            list(fileName,System.out);
        }
    }

    public static void list(String f,PrintStream ps){
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String s = null;
            while ((s = br.readLine()) != null){
                ps.println(s);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
