package com.ljc.controller;

import com.ljc.pojo.Course;
import com.ljc.pojo.Score;
import com.ljc.pojo.Student;
import com.ljc.service.CourseService;
import com.ljc.service.ScoreService;
import com.ljc.service.StudentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/5/2.
 */
@Controller
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    @RequestMapping("listScore")
    public ModelAndView listScore() {
        ModelAndView mav = new ModelAndView();
        List<Score> scoreList = scoreService.list();
        JSONArray array = new JSONArray();
        for (Score score : scoreList) {
            JSONObject jsonObject = new JSONObject();
            Student student = studentService.get(score.getStudentId());
            Course course = courseService.get(score.getCourseId());
            String name = course.getName();
            jsonObject.put("name", name);
            jsonObject.put("score", score.getScore());
            array.put(jsonObject);
        }
        mav.addObject("message", array);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("addScore")
    public ModelAndView addScore(Score score) {
        ModelAndView mav = new ModelAndView();
        JSONObject jsonObject = new JSONObject();
        try {
            scoreService.add(score);
            jsonObject.put("res", "success");
        } catch (Exception e) {
            jsonObject.put("res", "fail");
        }
        mav.addObject("message", jsonObject);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("deleteScore")
    public ModelAndView deleteScore(int id) {
        ModelAndView mav = new ModelAndView();
        JSONObject jsonObject = new JSONObject();
        try {
            scoreService.delete(id);
            jsonObject.put("res", "success");
        } catch (Exception e) {
            jsonObject.put("res", "fail");
        }
        mav.addObject("message", jsonObject);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("getScore")
    public ModelAndView getScore(Map params) {
        ModelAndView mav = new ModelAndView();
        List<Score> scoreList = scoreService.get(params);
        JSONArray array = new JSONArray();
        for (Score score : scoreList) {
            JSONObject jsonObject = new JSONObject();
            Student student = studentService.get(score.getStudentId());
            Course course = courseService.get(score.getCourseId());
            String name = course.getName();
            jsonObject.put("name", name);
            jsonObject.put("score", score.getScore());
            array.put(jsonObject);
        }
        mav.addObject("message", array);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("updateScore")
    public ModelAndView updateScore(Score score) {
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        try {
            scoreService.update(score);
            res.put("status", "success");
        } catch (Exception e) {
            res.put("status", "fail");
        }
        mav.addObject("message", res);
        return mav;
    }
}
