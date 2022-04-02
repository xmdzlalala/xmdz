package com.xmdz.service;

import com.xmdz.domain.student;

import java.util.List;

public interface StudentService {
    public student getById(String id);

    public void Insert(student s);

    List<student> getAll();
}
