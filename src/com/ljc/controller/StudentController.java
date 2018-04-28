package com.ljc.controller;

import com.ljc.pojo.Student;
import com.ljc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by matt on 2018/4/21.
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("listStudent")
    public ModelAndView listStudent(){
        ModelAndView mav = new ModelAndView();
        List<Student> cs= studentService.list();

        // 放入转发参数
        mav.addObject("cs", cs);
        // 放入jsp路径
        mav.setViewName("listStudent");
        return mav;
    }



}
