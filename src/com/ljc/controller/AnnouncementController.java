package com.ljc.controller;

import com.ljc.pojo.Announcement;
import com.ljc.service.AnnouncementService;
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
 * Created by matt on 2018/4/22.
 */
@Controller
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @RequestMapping("addAnnouncement")
    public void addAnnouncement(Announcement announcement, HttpServletResponse response) {
        announcementService.add(announcement);
        // 添加response信息流
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        res.put("status", "请求成功");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace(out);
        }
        out.append(res.toString());
    }

    @RequestMapping("listAnnouncement")
    public ModelAndView listAnnouncement(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        List<Announcement> announcementList = announcementService.list();
        JSONArray array = JSONArray.fromArray(announcementList.toArray(new Announcement[announcementList.size()]));

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

    @RequestMapping("getAnnouncement")
    public void getAnnouncement(Announcement announcement) {
        System.out.println(announcement);
        List<Announcement> announcements = announcementService.get(announcement);
        for (Announcement a :
                announcements) {
            System.out.println(a);
        }
    }

}
