package com.xmdz.service.impl;

import com.xmdz.Dao.StudentDao;
import com.xmdz.domain.student;
import com.xmdz.service.StudentService;
import com.xmdz.utils.SqlSessionUtils;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao= SqlSessionUtils.getSession().getMapper(StudentDao.class);

    @Override
    public student getById(String id) {
        student s=studentDao.getById(id);
        return s;

    }

    @Override
    public void Insert(student s) {

        studentDao.Insert(s);
    }

    @Override
    public List<student> getAll() {
        List<student> slist= studentDao.getAll();
        return slist;
    }


}
