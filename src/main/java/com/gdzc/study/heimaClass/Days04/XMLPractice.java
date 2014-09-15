package com.gdzc.study.heimaClass.Days04;

/**
 * Created by Liu_Zhichao on 14-9-15.
 * XML--练习及总结--使用JAXP(sun公司提供的,不需要引入外部jar包)解析XML，缺点：不能很好的处理格式问题。
 *
 *S解析XML的两种主要方式：DOM解析和SAX解析
 * 1.DOM的缺点：当XML文件过大时，加载到内存中容易出现内存溢出，查询的速度没有SAX快。优点：能做增删改。
 * 2.SAX的缺点：不能进行增删改的操作。优点：查询效率高。
 *
 * 使用JAXP解析XML需要用到的相关类及包名：
 * 1.org.w3c.dom.Document-----------------------------通过DocumentBuilder对象的方法解析xml来获得此对象，
 *          使用getElementById()方法的时候需要xml文件有对ID的约束
 * 2.org.w3c.dom.Element--------------------------------通过Node强转可以得到，可以获得和设置属性，也可以移除属性。
 * 3.org.w3c.dom.Node-----------------------------------NodeList循环遍历出来的对象,有很多静态属性可以用(如:ELEMENT_NODE )，
 *          当静态属性对应getNodeType()时，可以使用强转得到Element对象。
 *          getAttributes()方法获取节点所有属性，返回值类型是NamedNodeMap。
 * 4.org.w3c.dom.NodeList------------------------------通过Document对象可以获得Node的集合，getLength()方法获得长度，
 *          item(int index)方法来获得元素
 * 5.javax.xml.parsers.DocumentBuilder--------------通过DocumentBuilderFactory对象的方法来获得此对象
 * 6.javax.xml.parsers.DocumentBuilderFactory----提供获得自身对象的静态方法(最终做解析XML用)
 * 7.javax.xml.transform.Transformer-------------------通过TransformerFactory对象的方法来获得此对象
 * 8.javax.xml.transform.TransformerFactory--------提供获得自身对象的静态方法(最终做XML回写用)
 * 9.javax.xml.transform.dom.DOMSource-----------Transformer对象调用回写方法时的第一个参数，
 *          可以new来创建，构造方法参数是一个Document对象
 * 10.javax.xml.transform.stream.StreamResult----Transformer对象调用回写方法时的第二个参数，
 *          可以new来创建，构造方法参数是一个xml文件(也可以是字符串的路径)
 *
 * CDATA区的写法：<![CDATA[文本内容]]>
 */
public class XMLPractice {
}
