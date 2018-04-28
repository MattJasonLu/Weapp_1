package com.ljc.controller;

import com.ljc.pojo.News;
import com.ljc.service.NewsService;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by matt on 2018/4/21.
 */
@Controller
public class NewsController {
    @Autowired
    NewsService newsService;

    @RequestMapping("listNews")
    public ModelAndView listNews(HttpServletRequest request, HttpServletResponse response) {

        // 数据库查询
        List<News> newsList = newsService.list();
        JSONArray array = JSONArray.fromArray(newsList.toArray(new News[newsList.size()]));
        System.out.println(array);

        // 页面测试
        ModelAndView mav = new ModelAndView();
        // 放入转发参数
        mav.addObject("message", array);

        // 放入jsp路径
        mav.setViewName("success");

        // 添加response信息流
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace(out);
        }
        out.append(array.toString());

        return mav;
    }
}
