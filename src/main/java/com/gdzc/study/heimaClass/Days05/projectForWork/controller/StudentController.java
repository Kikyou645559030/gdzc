package com.gdzc.study.heimaClass.days05.projectForWork.controller;

import com.gdzc.study.heimaClass.days05.projectForWork.entity.Student;
import com.gdzc.study.heimaClass.days05.projectForWork.service.StudentService;
import com.gdzc.study.heimaClass.days05.projectForWork.service.manager.StudentManager;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 处理学生信息的控制器
 */
public class StudentController {

    private static StudentService studentService = new StudentManager();

    public static void main(String[] args) {
        addStudent("001", "张三", "69");//添加学生
//        reviseStudent("002",null,"99");//修改学生
//        replaceStudent(new Student("004","","91"),"003");//替换学生
//        removeStudentById("004");//删除学生
//        removeStudents("001","003");//批量删除学生，可以输入多个学号
//        removeAllStudent();//删除所有学生
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