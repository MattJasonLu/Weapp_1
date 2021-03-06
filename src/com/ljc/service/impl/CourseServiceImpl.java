package com.ljc.service.impl;

import com.ljc.mapper.CourseMapper;
import com.ljc.pojo.Course;
import com.ljc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/23.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Override
    public void add(Course course) {
        courseMapper.add(course);
    }

    @Override
    public void delete(int id) {
        courseMapper.delete(id);
    }

    @Override
    public Course getById(int id) {
        return courseMapper.getById(id);
    }

    @Override
    public List<Course> list() {
        return courseMapper.list();
    }

    @Override
    public List<Course> get(String keyword) {
        return courseMapper.get(keyword);
    }


    @Override
    public void update(Course course) {
        courseMapper.update(course);
    }
}
