package com.gdzc.study.heimaClass.days05;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * Created by Liu_Zhichao on 14-9-16.
 * JAXP--SAX
 */
public class SAXPractice {
    public static void main(String[] args) {
        parseXMLBySAX("src/main/java/com/gdzc/study/heimaClass/testFile/test2.xml");
    }

    //通过SAX方式解析XML
    public static void parseXMLBySAX(String filePath){
        //先获取SAX解析器的工厂类
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            //拿到SAX解析器
            SAXParser parser = factory.newSAXParser();
            //解析xml文件，第二个参数需要自己定义处理
            parser.parse(filePath,new MyHandle());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}