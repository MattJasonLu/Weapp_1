package com.ljc.mapper;

import com.ljc.pojo.Student;

import java.util.List;

/**
 * Created by matt on 2018/4/21.
 */
public interface StudentMapper {

    public void add(Student category);

    public void delete(int id);

    public Student get(int id);

    public void update(Student category);

    public List<Student> list();

    public int count();

}
