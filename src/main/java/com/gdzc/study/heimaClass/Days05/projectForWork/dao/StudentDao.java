package com.gdzc.study.heimaClass.days05.projectForWork.dao;

import com.gdzc.study.heimaClass.days05.projectForWork.common.Parameters;
import com.gdzc.study.heimaClass.days05.projectForWork.entity.Student;
import com.gdzc.study.heimaClass.days05.projectForWork.utils.XMLHandle;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 处理学生信息的dao
 */
public class StudentDao {
    private String path = Parameters.PATH;//存储数据的xml路径

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    public Student selectStudentById(String id){
        Document document = XMLHandle.parseToDocument(path);
        Student student = new Student(id,Parameters.ERROR,Parameters.ERROR);
        if (document != null){
            Element idElement = (Element)document.selectSingleNode("//id[@num='" + id + "']");
            List<Element> list = idElement.getParent().elements();
            student.setName(list.get(1).getText());
            student.setMath(list.get(2).getText());
        }
        return student;
    }

    /**
     * 根据姓名查询学生
     * @param name
     * @return
     */
    public List<Student> selectStudentsByName(String name){
        Document document = XMLHandle.parseToDocument(path);
        List<Student> resultList = new ArrayList<Student>();
        if (document != null){
            List<Element> students = new ArrayList<Element>();
            List<Element> elements = document.selectNodes("/students/student/name");
            for (Element element : elements){
                if (name.equals(element.getText())){
                    students.add(element.getParent());
                }
            }
            if (students.size() > 0){
                for (Element element : students){
                    Student student = new Student();
                    Element id = element.element(Parameters.ID);
                    student.setId(id.getText());
                    student.setName(name);
                    Element math = element.element(Parameters.MATH);
                    student.setMath(math.getText());
                    resultList.add(student);
                }
            }
        }
        return resultList;
    }

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> selectAll(){
        Document document = XMLHandle.parseToDocument(path);
        List<Student> resultList = new ArrayList<Student>();
        if (document != null){
            Element root = document.getRootElement();
            List<Element> list = root.elements();
            for (Element element : list){
                Student student = new Student();
                Element id = element.element(Parameters.ID);
                student.setId(id.getText());
                Element name = element.element(Parameters.NAME);
                student.setName(name.getText());
                Element math = element.element(Parameters.MATH);
                student.setMath(math.getText());
                resultList.add(student);
            }
        }
        return resultList;
    }

    /**
     * 添加学生
     * @param student
     */
    public void insertStudent(Student student){
        Document document = XMLHandle.parseToDocument(path);
        if (document != null){
            Element root = document.getRootElement();
            Element stu = DocumentHelper.createElement(Parameters.STUDENT);
            Element id = DocumentHelper.createElement(Parameters.ID);
            id.addText(student.getId()).addAttribute(Parameters.NUM,student.getId());
            Element name = DocumentHelper.createElement(Parameters.NAME);
            name.addText(student.getName());
            Element math = DocumentHelper.createElement(Parameters.MATH);
            if (student.getMath() != null){
                math.addText(student.getMath());
            }
            stu.add(id);
            stu.add(name);
            stu.add(math);
            root.add(stu);
            XMLHandle.writeToXMLFile(path,document);
        }
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public void updateStudent(Student student){
        Document document = XMLHandle.parseToDocument(path);
        if (document != null){
            Element id = (Element)document.selectSingleNode("//id[@num='" + student.getId() + "']");
            Element parent = id.getParent();
            if (student.getName() != null && !"".equals(student.getName())){
                Element name = parent.element(Parameters.NAME);
                name.setText(student.getName());//注意set和add的区别
            }
            if (student.getMath() != null && !"".equals(student.getMath())){
                Element math = parent.element(Parameters.MATH);
                math.setText(student.getMath());
            }
            XMLHandle.writeToXMLFile(path,document);
        }
    }

    /**
     * 用新的学生替换指定id的学生，可以用作修改id用
     * @param newStudent
     * @param oldStudentId
     */
    public void replaceStudent(Student newStudent, String oldStudentId){
        Document document = XMLHandle.parseToDocument(path);
        if (document != null){
            Element id = (Element)document.selectSingleNode("//id[@num='" + oldStudentId + "']");
            List<Element> list = id.getParent().elements();
            if (newStudent.getId() != null && !"".equals(newStudent.getId())){
                Element newId = DocumentHelper.createElement(Parameters.ID);
                newId.addText(newStudent.getId()).addAttribute(Parameters.NUM,newStudent.getId());
                list.set(0,newId);
            }
            if (newStudent.getName() != null && !"".equals(newStudent.getName())){
                Element newName = DocumentHelper.createElement(Parameters.NAME);
                newName.addText(newStudent.getName());
                list.set(1,newName);
            }
            if (newStudent.getMath() != null && !"".equals(newStudent.getMath())){
                Element newMath = DocumentHelper.createElement(Parameters.MATH);
                newMath.addText(newStudent.getMath());
                list.set(2,newMath);
            }
            XMLHandle.writeToXMLFile(path,document);
        }
    }

    /**
     * 根据id删除学生信息
     * @param id
     */
    public void deleteStudentById(String id){
        Document document = XMLHandle.parseToDocument(path);
        if (document != null){
            document.selectSingleNode("//id[@num='" + id + "']").getParent().detach();
            XMLHandle.writeToXMLFile(path,document);
        }
    }

    /**
     * 删除所有学生
     */
    public void deleteAllStudent(){
        Document document = XMLHandle.parseToDocument(path);
        if (document != null){
            List<Element> list = document.getRootElement().elements();
            list.clear();
            XMLHandle.writeToXMLFile(path,document);
        }
    }
}
