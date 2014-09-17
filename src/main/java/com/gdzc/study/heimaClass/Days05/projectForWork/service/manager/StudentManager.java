package com.gdzc.study.heimaClass.days05.projectForWork.service.manager;

import com.gdzc.study.heimaClass.days05.projectForWork.dao.StudentDao;

/**
 * Created by Liu_Zhichao on 14-9-17.
 * 管理学生信息的实现类
 */
public class StudentManager {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
