package com.ljc.controller;

import com.ljc.pojo.Issue;
import com.ljc.service.IssueService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Controller
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("listIssue")
    public ModelAndView listIssue(HttpServletResponse response) {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        ModelAndView mav = new ModelAndView();
        try {
            List<Issue> issueList = issueService.list();
            JSONArray array = JSONArray.fromArray(issueList.toArray(new Issue[issueList.size()]));
            response.getWriter().append(array.toString());
            mav.addObject("message", array);
            mav.setViewName("success");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mav;
    }

    @RequestMapping("addIssue")
    public ModelAndView addIssue(HttpServletResponse response, Issue issue) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        try {
            issueService.add(issue);
            res.put("status", "success");
        } catch (Exception e) {
            res.put("status", "fail");
        }

        return mav;
    }

    @RequestMapping("deleteIssue")
    public ModelAndView deleteIssue(HttpServletResponse response, int id) {
        ModelAndView mav = new ModelAndView();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        JSONObject res = new JSONObject();

        try {
            issueService.delete(id);
            response.getWriter().append(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping("updateIssue")
    public ModelAndView updateIssue(HttpServletResponse response, Issue issue) {
        ModelAndView mav = new ModelAndView();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        try {
            issueService.update(issue);
            res.put("status", "success");
        } catch (Exception e) {
            res.put("status", "fail");
        }
        try {
            response.getWriter().append(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping("getIssue")
    public ModelAndView getIssue(HttpServletResponse response, String content) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ModelAndView mav = new ModelAndView();
        try {
            List<Issue> issueList = issueService.get(content);
            JSONArray array = JSONArray.fromArray(issueList.toArray(new Issue[issueList.size()]));
            response.getWriter().append(array.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

}
