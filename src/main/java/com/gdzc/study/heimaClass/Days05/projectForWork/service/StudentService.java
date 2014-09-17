package com.gdzc.study.heimaClass.days05.projectForWork.service;

import com.gdzc.study.heimaClass.days05.projectForWork.entity.Student;

import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 学生信息管理系统--处理学生信息的接口
 */
public interface StudentService {

    /**
     * 添加学生的接口
     * @param student
     */
    public void addStudent(Student student);

    /**
     * 修改学生的接口
     * @param student
     */
    public void reviseStudent(Student student);

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    public Student findStudentById(String id);

    /**
     * 根据学生姓名查询学生
     * @param name
     * @return
     */
    public List<Student> findStudentByName(String name);

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> findAll();

    /**
     * 替换指定学号的学生，可以用做修改学号
     * @param student
     * @param oldStudentId
     */
    public void replaceStudentById(Student student, String oldStudentId);

    /**
     * 替换学生，可以用做修改学号
     * @param newStudent
     * @param oldStudent
     */
    public void replaceStudent(Student newStudent, Student oldStudent);

    /**
     * 根据学号删除学生
     * @param id
     */
    public void removeStudentById(String id);

    /**
     * 删除学生
     * @param student
     */
    public void removeStudent(Student student);

    /**
     * 删除所有学生
     */
    public void removeAllStudent();

    /**
     * 批量删除学生
     * @param ids
     */
    public void removeBatchStudent(List<String> ids);
}
