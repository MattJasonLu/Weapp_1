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
    public ModelAndView listCourse(HttpServletResponse response) {

        ModelAndView mav = new ModelAndView();

        List<Course> courseList = courseService.list();

        JSONArray array = JSONArray.fromArray(courseList.toArray(new Course[courseList.size()]));

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace(out);
        }
        out.append(array.toString());

        mav.addObject("message", array);
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("addCourse")
    public ModelAndView addCourse(Course course, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        try {
            courseService.add(course);
            res.put("status", "请求成功");
            response.getWriter().append(res.toString());
        } catch (Exception e) {
            res.put("status", "请求失败");
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("deleteCourse")
    public ModelAndView deleteCourse(int id, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        try {
            courseService.delete(id);
            res.put("status", "请求成功");
            response.getWriter().append(res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("getCourse")
    public ModelAndView getCourse(Map params, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        try {
            List<Course> courseList = courseService.get(params);
            JSONArray array = JSONArray.fromArray(courseList.toArray(new Course[courseList.size()]));
            response.getWriter().append(array.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
