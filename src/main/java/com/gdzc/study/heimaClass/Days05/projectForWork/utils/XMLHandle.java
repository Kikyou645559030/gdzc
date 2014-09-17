package com.gdzc.study.heimaClass.days05.projectForWork.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Liu_Zhichao on 14-9-16.
 * 学生信息管理系统--XML--工具类--DOM4J
 */
public class XMLHandle {

    /**
     * 类中全是静态方法，所以创建实例对象没有意义，为了程序的严谨，可以将构造方法私有化
     */
    private XMLHandle(){}

    /**
     * @param filePath 接受一个字符串的xml文件路径
     * @return 会返回一个document对象
     */
    public static Document parseToDocument(String filePath){
        Document document = null;
        String postfix = filePath.substring(filePath.lastIndexOf('.'));
//        String postfix = filePath.substring(filePath.length() - 4);
        if (filePath != "" && filePath.length() > 0 && ".xml".equalsIgnoreCase(postfix)){
            SAXReader reader = new SAXReader();
            try {
                document = reader.read(filePath);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            return document;
        }
        System.out.println("系统找不到指定文件！");
        return document;
    }

    public static boolean writeToXMLFile(String filePath,Document document){
        String postfix = filePath.substring(filePath.lastIndexOf('.'));
        if (filePath != "" && !filePath.isEmpty() && ".xml".equalsIgnoreCase(postfix)){
            OutputFormat format = OutputFormat.createPrettyPrint();
            writeFile(filePath,document,format);
            return true;
        }
        System.out.println("文件路径有误，请检查！");
        return false;
    }

    private static void writeFile(String filePath, Document document, OutputFormat format){
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(filePath),format);
            writer.write(document);
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
