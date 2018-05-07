package com.ljc.controller;

import com.ljc.pojo.Course;
import com.ljc.service.CourseService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/23.
 */
@Controller
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("listCourse")
    public ModelAndView listCourse() {

        ModelAndView mav = new ModelAndView();

        List<Course> courseList = courseService.list();

        JSONArray array = JSONArray.fromArray(courseList.toArray(new Course[courseList.size()]));

        mav.addObject("message", array);
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("addCourse")
    public ModelAndView addCourse(Course course) {
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        try {
            courseService.add(course);
            res.put("status", "请求成功");

        } catch (Exception e) {
            res.put("status", "请求失败");
            e.printStackTrace();
        }
        mav.addObject("message", res);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("deleteCourse")
    public ModelAndView deleteCourse(int id) {
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        try {
            courseService.delete(id);
            res.put("status", "请求成功");
            mav.addObject("message", res);
            mav.setViewName("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("getCourse")
    public ModelAndView getCourse(String keyword) {
        ModelAndView mav = new ModelAndView();
        try {
            List<Course> courseList = courseService.get(keyword);
            JSONArray array = JSONArray.fromArray(courseList.toArray(new Course[courseList.size()]));
            mav.addObject("message", array);
            mav.setViewName("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("updateCourse")
    public ModelAndView updateCourse(Course course, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            courseService.update(course);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
