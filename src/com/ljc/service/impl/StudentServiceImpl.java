package com.ljc.service.impl;

import com.ljc.mapper.StudentMapper;
import com.ljc.pojo.Student;
import com.ljc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by matt on 2018/4/21.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public void add(Student student) {
        studentMapper.add(student);
    }

    @Override
    public void delete(int id) {
        studentMapper.delete(id);
    }

    @Override
    public Student get(int id) {
        return studentMapper.get(id);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public List<Student> list(){
        return studentMapper.list();
    }

    @Override
    public int count() {
        return studentMapper.count();
    }

}
