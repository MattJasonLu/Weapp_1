package com.ljc.controller;

import com.ljc.pojo.Announcement;
import com.ljc.service.AnnouncementService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
@Controller
public class AnnouncementController {

    @Autowired
    AnnouncementService announcementService;

    @RequestMapping("addAnnouncement")
    public ModelAndView addAnnouncement(Announcement announcement) {
        announcement.setTime(new Date());
        announcement.setCreaterId(1);
        ModelAndView mav = new ModelAndView();
        JSONObject res = new JSONObject();
        announcementService.add(announcement);
        res.put("status", "success");
        mav.addObject("message", res);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("listAnnouncement")
    public ModelAndView listAnnouncement() {
        ModelAndView mav = new ModelAndView();
        List<Announcement> announcementList = announcementService.list();
        JSONArray array = JSONArray.fromArray(announcementList.toArray(new Announcement[announcementList.size()]));
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            obj.remove("time");
            obj.put("time", announcementList.get(i).getTimeStr());
        }
        mav.addObject("message", array);
        mav.setViewName("success");

        return mav;

    }

    @RequestMapping("getAnnouncement")
    public ModelAndView getAnnouncement(String keyword, HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ModelAndView mav = new ModelAndView();
        if (keyword != null) {
            List<Announcement> announcementList = announcementService.getByKeyword(keyword);
            JSONArray array = JSONArray.fromArray(announcementList.toArray(new Announcement[announcementList.size()]));
            for (int i = 0; i < array.length(); i++) {
                JSONObject obj = (JSONObject) array.get(i);
                obj.remove("time");
                obj.put("time", announcementList.get(i).getTimeStr());
            }
            mav.addObject("message", array);
        }
        mav.setViewName("success");
        return mav;

    }

    @RequestMapping("deleteAnnouncement")
    public ModelAndView deleteAnnouncement(int id) {
        ModelAndView mav = new ModelAndView();
        announcementService.delete(id);
        JSONObject res = new JSONObject();
        res.put("status", "success");
        mav.addObject("message", res);
        mav.setViewName("success");
        return mav;
    }

}
