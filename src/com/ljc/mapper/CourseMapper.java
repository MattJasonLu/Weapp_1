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

    List<Course> get(Map params);

    void update(Course course);

}
