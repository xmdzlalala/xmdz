package com.xmdz.Dao;

import com.xmdz.domain.student;

import java.util.List;

public interface StudentDao {
    public student getById(String id);

    public void Insert(student s);

    List<student> getAll();
}
