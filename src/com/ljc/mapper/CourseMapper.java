package com.ljc.mapper;

import com.ljc.pojo.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/23.
 */
public interface CourseMapper {

    void add(Course course);

    void delete(int id);

    List<Course> list();

    Course getById(int id);

    List<Course> get(String keyword);

    void update(Course course);

}
