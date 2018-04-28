package com.ljc.controller;

import com.ljc.pojo.Exam;
import com.ljc.service.ExamService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

/**
 * Created by matt on 2018/4/27.
 */
@Controller
public class ExamController {
    @Autowired
    ExamService examService;

    @RequestMapping("listExam")
    public ModelAndView listExam(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();

        List<Exam> examList = examService.list();

        JSONArray array = JSONArray.fromArray(examList.toArray(new Exam[examList.size()]));

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

}
