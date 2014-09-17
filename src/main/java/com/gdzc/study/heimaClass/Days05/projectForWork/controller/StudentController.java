package com.gdzc.study.heimaClass.days05.projectForWork.controller;

import com.gdzc.study.heimaClass.days05.projectForWork.common.Parameters;
import com.gdzc.study.heimaClass.days05.projectForWork.entity.Student;
import com.gdzc.study.heimaClass.days05.projectForWork.service.StudentService;
import com.gdzc.study.heimaClass.days05.projectForWork.service.manager.StudentManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 学生信息管理系统--处理学生信息的控制器
 */
public class StudentController {

    private static StudentService studentService = new StudentManager();

    /**
     * -该学生信息管理系统已有功能
     * -1.添加单个学生
     * -2.修改单个学生信息
     * -3.替换单个学生(可以作为修改学号功能)
     * -4.删除单个学生(可以通过id和对象两种方式)
     * -5.批量删除学生(通过可变参数，根据id删除多个学生)
     * -6.全部删除
     * -7.根据学号查询单个学生
     * -8.根据姓名查询多个学生
     * -9.查询所有学生
     * -欠缺的功能
     * -1.对学生人数、信息之类的数据统计
     * -2.没有通过可变参数查询多个姓名或者id
     * -3.不能通过分数段来查询和统计学生
     * @param args
     */
    public static void main(String[] args) {
//        addStudent("005", "张三", "98");//添加学生
//        reviseStudent("002",null,"99");//修改学生
//        replaceStudent(new Student("004","","91"),"003");//替换学生
//        removeStudentById("004");//删除学生
//        removeStudents("001","003");//批量删除学生，可以输入多个学号
//        removeAllStudent();//删除所有学生
//        findStudentById("003");//根据学号查询学生
//        findStudentsByName("张三");//根据姓名查询学生
        findAllStudent();//查询所有学生
    }

    /**
     * 添加学生信息
     * @param id
     * @param name
     * @param math
     */
    public static void addStudent(String id,String name,String math){
        if (!"".equals(id) && id != null && !"".equals(name) && name != null){
            Student student = new Student(id,name,math);
            studentService.addStudent(student);
        }
    }

    /**
     * 修改学生信息，第一项参数必填，第二三项参数可以为null或者空串
     * @param id
     * @param name
     * @param math
     */
    public static void reviseStudent(String id,String name,String math){
        if (!"".equals(id) && id != null){
            Student student = new Student(id,name,math);
            studentService.reviseStudent(student);
        }
    }

    /**
     * 替换学生,第二项参数必填，第一项参数student对象的属性可以为null或者空串，表示不修改的属性
     * @param student
     * @param id
     */
    public static void replaceStudent(Student student,String id){
        if (!"".equals(id) && id != null){
            studentService.replaceStudentById(student,id);
        }
    }

    /**
     * 根据学号删除对应的学生
     * @param id
     */
    public static void removeStudentById(String id){
        if (!"".equals(id) && id != null){
            studentService.removeStudentById(id);
        }
    }

    /**
     * 根据学号查询学生
     * @param id
     */
    public static void findStudentById(String id){
        if (!"".equals(id) && id != null){
            Student student = studentService.findStudentById(id);
            if (Parameters.ERROR.equals(student.getName())){
                System.out.println("没有找到学号是" + id + "的学生！");
            }else {
                System.out.println(student);
            }
        }
    }

    /**
     * 根据姓名查询学生
     * @param name
     */
    public static void findStudentsByName(String name){
        if (!"".equals(name) && name != null){
            List<Student> students = studentService.findStudentByName(name);
            if (students.size() > 0){
                for (Student student : students){
                    System.out.println("姓名叫" + name + "的学生：" + student);
                }
            }else {
                System.out.println("没有找到姓名叫" + name + "的学生！");
            }
        }
    }

    /**
     * 查询所有学生信息
     */
    public static void findAllStudent(){
        List<Student> students = studentService.findAll();
        if (students.size() > 0){
            for (Student student : students){
                System.out.println(student);
            }
        }else {
            System.out.println("没有学生！");
        }
    }

    /**
     * 批量删除学生
     * @param ids
     */
    public static void removeStudents(String ... ids){
        if (ids.length > 0){
            List<String> list = Arrays.asList(ids);
            studentService.removeBatchStudent(list);
        }
    }

    /**
     * 删除所有学生
     */
    public static void removeAllStudent(){
        studentService.removeAllStudent();
    }
}