package com.gdzc.study.heimaClass.days05.projectForWork.dao;

import com.gdzc.study.heimaClass.days05.projectForWork.entity.Student;

import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 处理学生信息的dao
 */
public class StudentDao {

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    public Student selectStudentById(String id){
        return null;
    }

    /**
     * 根据姓名查询学生
     * @param name
     * @return
     */
    public List<Student> selectStudentsByName(String name){
        return null;
    }

    /**
     * 查询所有学生
     * @return
     */
    public List<Student> selectAll(){
        return null;
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    public Student insertStudent(Student student){

        return null;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public Student updateStudent(Student student){
        return null;
    }

    /**
     * 用新的学生替换指定id的学生，可以用作修改id用
     * @param newStudent
     * @param oldStudentId
     * @return
     */
    public Student replaceStudent(Student newStudent, String oldStudentId){
        return null;
    }

    /**
     * 替换学生，可以用作修改id用
     * @param newStudent
     * @param oldStudent
     * @return
     */
    public Student replaceStudent(Student newStudent, Student oldStudent){
        return null;
    }

    /**
     * 根据id删除学生信息
     * @param id
     * @return
     */
    public boolean deleteStudentById(String id){
        return true;
    }

    /**
     * 删除学生
     * @param student
     * @return
     */
    public boolean deleteStudent(Student student){
        return true;
    }

    /**
     * 删除所有学生
     */
    public void deleteAllStudent(){
    }

    /**
     * 批量删除学生
     * @param ids
     */
    public void deleteBatchStudent(List<String> ids){
    }
}
