package com.ljc.controller;

import com.ljc.pojo.Turnover;
import com.ljc.service.TurnoverService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by matt on 2018/4/28.
 */
@Controller
public class TurnoverController {

    @Autowired
    TurnoverService turnoverService;

    @RequestMapping("listTurnover")
    public ModelAndView listTurnover(HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();

        List<Turnover> turnoverList = turnoverService.list();
        JSONArray array = JSONArray.fromArray(turnoverList.toArray(new Turnover[turnoverList.size()]));

        try {
            response.getWriter().append(array.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mav.addObject("message", array);
        mav.setViewName("success");

        return mav;
    }

}
