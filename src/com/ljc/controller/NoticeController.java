package com.ljc.controller;

import com.ljc.pojo.Notice;
import com.ljc.service.NoticeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping("listNotice")
    public ModelAndView listNotice(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        List<Notice> noticeList = noticeService.list();

        JSONArray array = JSONArray.fromArray(noticeList.toArray(new Notice[noticeList.size()]));

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

    @RequestMapping("addNotice")
    public ModelAndView addNotice(HttpServletResponse response, Notice notice) {
        ModelAndView mav = new ModelAndView();

        noticeService.add(notice);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        JSONObject res = new JSONObject();
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace(out);
        }
        res.put("status", "success");
        out.append(res.toString());

        mav.addObject("message", res);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("deleteNotice")
    public ModelAndView deleteNotice(HttpServletResponse response, String id) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        try {
            noticeService.delete(id);
            res.put("status", "success");
            response.getWriter().append(res.toString());
        } catch (Exception e) {
            res.put("status", "fail");
        }
        mav.addObject("message", res);
        mav.setViewName("success");

        return mav;
    }

}
