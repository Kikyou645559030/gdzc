package com.gdzc.study.heimaClass.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

/**
 * Created by Liu_Zhichao on 14-9-15.
 * XML--工具类--JAXP
 * 1.提供解析XML的静态方法，返回Document
 * 2.提供回写Document到XML文件中的静态方法
 */
public class XMLHandleForJAXP {

    /**
     * 解析xml文件返回Document对象的静态方法
     * @param filePath
     * @return
     */
    public static Document getDocument(String filePath){
        //获取DocumentBuilder的工厂类
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            //获取能解析xml的对象DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //解析对应地址的xml文件，返回Document对象
            document = db.parse(filePath);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 将一个Document对象写入到指定的xml文件中的静态方法
     * @param document
     * @param targetFilePath
     */
    public static void writeXML(Document document, String targetFilePath){
        //获取Transformer的工厂类
        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            //获取Transformer的实例
            Transformer transformer = tf.newTransformer();
            //调用transform方法将Document对象写到xml文件中去
            // 注意：需要先将Document对象转为源树，再写入到结果树中去
            transformer.transform(new DOMSource(document),new StreamResult(targetFilePath));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
