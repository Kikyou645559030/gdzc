package com.gdzc.study.heimaClass.Days05;

import com.gdzc.study.heimaClass.util.StaticFinalParameter;
import com.gdzc.study.heimaClass.util.XMLFileStyle;
import com.gdzc.study.heimaClass.util.XMLHandleForDOM4J;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-16.
 * DOM4J解析XML
 */
public class DOM4JPractice {
    public static void main(String[] args) {
//        removeElement(StaticFinalParameter.filePathForXML2,"three");
        addElement(StaticFinalParameter.filePathForXML2);
        insertElement(StaticFinalParameter.filePathForXML2,2);
        replaceElement(StaticFinalParameter.filePathForXML2,1);
        getElement(StaticFinalParameter.filePathForXML2,"");
    }

    /**
     * 通过指定的XPath查找节点
     * @param filePath
     * @param xPath
     */
    public static void getElement(String filePath,String xPath){
        //通过自定义工具类来解析XML，返回document对象
        Document document = XMLHandleForDOM4J.parseToDocument(filePath);
        if (document != null){
            Node node = document.selectSingleNode("");
            List<Node> nodes = document.selectNodes(xPath);
        }
    }

    /**
     * 添加节点的方法
     * @param filePath
     */
    public static void addElement(String filePath){
        //通过自定义工具类来解析XML，返回document对象
        Document document = XMLHandleForDOM4J.parseToDocument(filePath);
        if (document != null){
            //拿到根节点
            Element root = document.getRootElement();
            //拿到root下所有节点的集合
            List<Element> list = root.elements();
            //拿到需要被添加节点的父节点
            Element lastSecond = list.get(2);
            //创建要被添加的新节点
            Element newElement = DocumentHelper.createElement("four");
            //添加文本内容
            newElement.addText("呵呵");
            //将新节点添加到父节点下
            lastSecond.add(newElement);
//            list.add(newElement);//通过list集合来添加
            //调用工具类自定义的回写方法，将document写到xml文件中，并指定格式
            XMLHandleForDOM4J.writeToXMLFile(filePath,document,XMLFileStyle.PRETTY);
        }
    }

    /**
     * 插入节点的方法
     * @param filePath
     * @param index
     */
    public static void insertElement(String filePath,int index){
        //通过自定义工具类来解析XML，返回document对象
        Document document = XMLHandleForDOM4J.parseToDocument(filePath);
        if (document != null){
            //拿到根节点
            Element root = document.getRootElement();
            //拿到root下所有节点的集合
            List<Element> list = root.elements();
            //创建要被添加的新节点
            Element third = DocumentHelper.createElement("third");
            Element one = DocumentHelper.createElement("one");
            Element two = DocumentHelper.createElement("two");
            Element three = DocumentHelper.createElement("three");
            //添加文本内容
            one.addText("呵呵");
            two.addText("嘎嘎");
            three.addText("咳咳");
            //将子节点添加到third节点上
            third.add(one);
            third.add(two);
            third.add(three);
            //使用list集合的插入元素操作来插入子节点
            list.add(index,third);
            //调用工具类自定义的回写方法，将document写到xml文件中，并指定格式
            XMLHandleForDOM4J.writeToXMLFile(filePath,document,XMLFileStyle.PRETTY);
        }
    }

    /**
     * 替换节点的方法
     * @param filePath
     * @param index
     */
    public static void replaceElement(String filePath,int index){
        //通过自定义工具类来解析XML，返回document对象
        Document document = XMLHandleForDOM4J.parseToDocument(filePath);
        if (document != null){
            //拿到根节点
            Element root = document.getRootElement();
            //拿到root下所有节点的集合
            List<Element> list = root.elements();
            //拿到第一个节点下的所有子节点
            List<Element> firstElements = list.get(0).elements();
            //创建要被替换的新节点
            Element newElement = DocumentHelper.createElement("four");
            //添加文本内容
            newElement.addText("哟西");
            //将新节点添加到父节点下
            firstElements.set(index,newElement);
            //调用工具类自定义的回写方法，将document写到xml文件中，并指定格式
            XMLHandleForDOM4J.writeToXMLFile(filePath,document,XMLFileStyle.PRETTY);
        }
    }

    /**
     * 删除节点的方法
     * @param filePath
     * @param elementName
     */
    //没做非空处理
    @Deprecated
    public static void removeElement(String filePath,String elementName){
        //通过自定义工具类来解析XML，返回document对象
        Document document = XMLHandleForDOM4J.parseToDocument(filePath);
        //拿到根节点
        Element root = document.getRootElement();
        //拿到root下的所有second节点集合
        List<Element> list = root.elements("second");
        //拿到集合中的第一个元素
        Element second = list.get(0);
        //拿到需要被删除的元素名称
        Element three = second.element(elementName);
        //通过父节点删除子节点
        second.remove(three);
        //回写document对象到xml文件中，并指定格式
        XMLHandleForDOM4J.writeToXMLFile(filePath,document, XMLFileStyle.PRETTY);
    }
}