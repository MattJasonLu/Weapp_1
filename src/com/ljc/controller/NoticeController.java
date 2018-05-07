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
import java.util.Date;
import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @RequestMapping("listNotice")
    public ModelAndView listNotice() {
        ModelAndView mav = new ModelAndView();
        List<Notice> noticeList = noticeService.list();

        JSONArray array = JSONArray.fromArray(noticeList.toArray(new Notice[noticeList.size()]));
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            obj.remove("time");
            obj.put("time", noticeList.get(i).getTimeStr());
        }

        mav.addObject("message", array);
        mav.setViewName("success");
        return mav;

    }

    @RequestMapping("addNotice")
    public ModelAndView addNotice(Notice notice) {
        ModelAndView mav = new ModelAndView();
        notice.setTime(new Date());
        notice.setAdminId(1);
        notice.setCategoryId(1);
        notice.setStudentId(1);
        noticeService.add(notice);

        JSONObject res = new JSONObject();
        res.put("status", "success");

        mav.addObject("message", res);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("deleteNotice")
    public ModelAndView deleteNotice(String id) {
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        try {
            noticeService.delete(id);
            res.put("status", "success");
        } catch (Exception e) {
            res.put("status", "fail");
        }
        mav.addObject("message", res);
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("getNotice")
    public ModelAndView getNotice(String content) {
        ModelAndView mav = new ModelAndView();
        List<Notice> noticeList = noticeService.get(content);
        JSONArray array = JSONArray.fromArray(noticeList.toArray(new Notice[noticeList.size()]));
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            obj.remove("time");
            obj.put("time", noticeList.get(i).getTimeStr());
        }
        mav.addObject("message", array);
        mav.setViewName("success");
        return mav;
    }

}
