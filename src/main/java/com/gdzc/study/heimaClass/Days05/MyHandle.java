package com.gdzc.study.heimaClass.days05;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Liu_Zhichao on 14-9-16.
 * JAXP--自定义Handle，继承DefaultHandler，并重现3个方法
 */
public class MyHandle extends DefaultHandler {
    Boolean flag = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("one".equals(qName)){
            flag = true;
            System.out.println("开始标签：" + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (flag){
            String content = new String(ch,start,length);
                System.out.println("标签内容：" + content);
            flag = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    }
}
