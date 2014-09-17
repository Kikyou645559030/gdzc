package com.gdzc.study.heimaClass.util;

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
 * XML--工具类--DOM4J
 */
public class XMLHandleForDOM4J {

    /**
     * @param filePath
     * @return
     */
    public static Document parseToDocument(String filePath){
        Document document = null;
//        String postfix = filePath.substring(filePath.lastIndexOf('.'));//通过拿到最后一个点的下标来截取
        String postfix = filePath.substring(filePath.length() - 4);//通过减去后缀长度来截取后缀名
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

    public static boolean writeToXMLFile(String filePath,Document document,XMLFileStyle style){
        String postfix = filePath.substring(filePath.lastIndexOf('.'));
        if (filePath != "" && !filePath.isEmpty() && ".xml".equalsIgnoreCase(postfix)){
            OutputFormat format = null;
            if (XMLFileStyle.PRETTY == style){
                format = OutputFormat.createPrettyPrint();
                writeFile(filePath,document,format);
                return true;
            }else if (XMLFileStyle.COMPACT == style){
                format = OutputFormat.createCompactFormat();
                writeFile(filePath,document,format);
                return true;
            }else {
                writeFile(filePath,document);
                return true;
            }
        }
        System.out.println("文件路径有误，请检查！");
        return false;
    }

    private static void writeFile(String filePath, Document document){
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(filePath));
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
