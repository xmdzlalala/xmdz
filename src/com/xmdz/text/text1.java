package com.xmdz.text;


import com.xmdz.domain.student;
import com.xmdz.service.StudentService;
import com.xmdz.service.impl.StudentServiceImpl;
import com.xmdz.utils.ServiceFactory;

import java.util.List;

public class text1 {
    public static void main(String[] args) {
        StudentService ss= (StudentService) ServiceFactory.getService(new StudentServiceImpl());
//        student s=new student("A003","ZHANGSAN",33);
//        ss.Insert(s);

        //查询所有记录
        List<student> slist =ss.getAll();

        for(student st:slist){
            System.out.println(st);
        }

    }
}
