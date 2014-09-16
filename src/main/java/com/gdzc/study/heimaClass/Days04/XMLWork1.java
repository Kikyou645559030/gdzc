package com.gdzc.study.heimaClass.Days04;

import com.gdzc.study.heimaClass.util.XMLHandleForJAXP;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by Liu_Zhichao on 14-9-15.
 * XML练习--JAXP
 * 课后作业第一题：在指定的节点之前插入新节点listener
 * 课后作业第二题：获取标签的属性值
 */
public class XMLWork1 {
    public static void main(String[] args){
        //第一题作业方法
//        insertElement("src/main/java/com/gdzc/study/heimaClass/testFile/test1.xml","web.context.ContextLoaderListener");
        //第二题作业方法
        getAttributeValue("src/main/java/com/gdzc/study/heimaClass/testFile/test1.xml","id");
    }

    //一个向xml文件中插入监听器的方法,第一个参数是xml文件的路径，第二个参数是插入的监听器的名字
    public static void insertElement(String filePath,String className){
        //通过XMLHandle工具类解析xml文件获得Document对象
        Document document = XMLHandleForJAXP.getDocument(filePath);
        //创建新的父结点
        Element newListener = document.createElement("listener");
        //创建新的子节点
        Element element = document.createElement("listener-class");
        //在结点中添加给定的文本内容
        element.setTextContent(className);
        //将子节点添加到父结点中去
        newListener.appendChild(element);
        //获取被插入的结点
        Node oldListener = document.getElementsByTagName("listener").item(0);
        //获取被插入结点的父节点
        Node parentNode = oldListener.getParentNode();
        //插入结点
        parentNode.insertBefore(newListener,oldListener);
        //调用writeXML()方法回写document文档到xml文件中去
        XMLHandleForJAXP.writeXML(document, filePath);
    }

    //一个获取xml文件元素属性的方法，第一个参数是xml文件的路径，第二个参数是需要获得的属性名称
    public static void getAttributeValue(String filePath ,String attribute){
        //拿到Document对象
        Document document = XMLHandleForJAXP.getDocument(filePath);
        //拿到第一个filter节点
        Node filter = document.getElementsByTagName("filter").item(0);
        //拿到所以的孩子节点
        NodeList nodes = filter.getChildNodes();
        //循环遍历所有节点
        for (int i = 0; i < nodes.getLength(); i++){
            //拿到每一个孩子节点，并判断是否是Element节点
            Node node = nodes.item(i);
            //!!!注意：下面的判断非常重要
            if (Node.ELEMENT_NODE == node.getNodeType()){
//                node.getAttributes().getNamedItem(attribute);//可以直接通过node拿到属性
                //强转为Element节点
                Element element = (Element)node;
                //判断该节点是否有被查看的属性
                if (element.hasAttribute(attribute)){
                    //打印输出节点名称+属性名称+属性值
                    System.out.println(element.getTagName() + ":" + element.getAttributeNode(attribute).getName() + ":" +
                            element.getAttribute(attribute));
                }
                if (element.hasAttribute("name")){
                    System.out.println(element.getTagName() + ":" + element.getAttributeNode("name").getName() + ":" +
                            element.getAttribute("name"));
                }
            }
        }
    }
}
