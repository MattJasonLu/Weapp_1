package com.ljc.service;

import com.ljc.pojo.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/23.
 */
public interface CourseService {

    void add(Course course);

    void delete(int id);

    Course get(int id);

    List<Course> list();

    List<Course> get(String keyword);

    void update(Course course);

}
