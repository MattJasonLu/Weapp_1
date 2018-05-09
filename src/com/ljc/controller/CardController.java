package com.ljc.controller;

import com.ljc.pojo.Card;
import com.ljc.service.CardService;
import com.sun.javafx.sg.PGShape;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by matt on 2018/5/9.
 */
@Controller
public class CardController {
    @Autowired
    CardService cardService;

    @RequestMapping("activeCard")
    public ModelAndView activeCard(int id) {
        ModelAndView mav = new ModelAndView();
        cardService.active(id);
        JSONObject res = new JSONObject();
        res.put("status", "success");
        mav.addObject("message", res);
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("invlidCard")
    public ModelAndView invlidCard(int id) {
        ModelAndView mav = new ModelAndView();
        cardService.invalid(id);
        JSONObject res = new JSONObject();
        res.put("status", "success");
        mav.addObject("message", res);
        mav.setViewName("success");

        return mav;
    }

    @RequestMapping("getCard")
    public ModelAndView getCard(int id) {
        ModelAndView mav = new ModelAndView();

        Card card = cardService.get(id);
        JSONObject res = JSONObject.fromBean(card);

        mav.addObject("message", res);
        mav.setViewName("success");

        return mav;
    }

}
