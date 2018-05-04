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
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by matt on 2018/4/27.
 */
@Controller
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("listLost")
    public ModelAndView listLost() {
        ModelAndView mav = new ModelAndView();
        List<Issue> lostList = issueService.getLost();
        JSONArray array = JSONArray.fromArray(lostList.toArray(new Issue[lostList.size()]));
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = (JSONObject) array.get(i);
            object.remove("time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String time = simpleDateFormat.format(lostList.get(i).getTime());
            object.put("time", time);
        }
        mav.addObject("message", array);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("listFix")
    public ModelAndView listFix() {
        ModelAndView mav = new ModelAndView();
        List<Issue> fixList = issueService.getFix();
        JSONArray array = JSONArray.fromArray(fixList.toArray(new Issue[fixList.size()]));
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = (JSONObject) array.get(i);
            object.remove("time");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String time = simpleDateFormat.format(fixList.get(i).getTime());
            object.put("time", time);
        }
        mav.addObject("message", array);
        mav.setViewName("success");
        return mav;
    }

}
