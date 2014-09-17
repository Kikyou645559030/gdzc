package com.gdzc.study.heimaClass.days05.projectForWork.service.manager;

import com.gdzc.study.heimaClass.days05.projectForWork.dao.StudentDao;
import com.gdzc.study.heimaClass.days05.projectForWork.entity.Student;
import com.gdzc.study.heimaClass.days05.projectForWork.service.StudentService;

import java.util.List;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 管理学生信息的实现类
 */
public class StudentManager implements StudentService{
    private StudentDao studentDao = new StudentDao();//处理数据的dao对象

    @Override
    public void addStudent(Student student) {
        studentDao.insertStudent(student);
    }

    @Override
    public void reviseStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void replaceStudentById(Student student, String oldStudentId) {
        studentDao.replaceStudent(student,oldStudentId);
    }

    @Override
    public void replaceStudent(Student newStudent, Student oldStudent) {
        studentDao.replaceStudent(newStudent,oldStudent.getId());
    }

    @Override
    public void removeStudentById(String id) {
        studentDao.deleteStudentById(id);
    }

    @Override
    public void removeStudent(Student student) {
        studentDao.deleteStudentById(student.getId());
    }

    @Override
    public void removeAllStudent() {
        studentDao.deleteAllStudent();
    }

    @Override
    public void removeBatchStudent(List<String> ids) {
        for (String id : ids){
            if (!"".equals(id) && id != null){
                studentDao.deleteStudentById(id);
            }
        }
    }
}
