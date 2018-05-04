package com.ljc.service;

import com.ljc.pojo.Student;

import java.util.List;

/**
 * Created by matt on 2018/4/21.
 */
public interface StudentService {
    public void add(Student student);

    public void delete(int id);

    public Student get(int id);

    public void update(Student student);

    public List<Student> list();

    public int count();
}
