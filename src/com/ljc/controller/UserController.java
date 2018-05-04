package com.ljc.controller;

import com.ljc.pojo.User;
import com.ljc.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by matt on 2018/4/22.
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("listUser")
    public ModelAndView listUser() {
        ModelAndView mav = new ModelAndView();
        List<User> userList= userService.list();

        // 放入转发参数
        mav.addObject("userList", userList);
        // 放入jsp路径
        mav.setViewName("listUser");
        return mav;
    }

    @RequestMapping("addUser")
    public ModelAndView addUser(User user, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        try {
            userService.add(user);
            mav.addObject("message", "success");
            res.put("status", "success");
        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("message", "fail");
            res.put("status", "fail");
        }
        try {
            response.getWriter().append(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("getUser")
    public ModelAndView getUser(User user) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        JSONObject res = new JSONObject();
        User getUser = userService.get(user);
        if (getUser != null) {
//                mav.addObject("message", getUser);
            res.put("status", "success");
            mav.addObject("message", res);
        } else {
            throw new Exception("用户名或密码输入错误！");
        }
        return mav;
    }

    @RequestMapping("updateUser")
    public ModelAndView updateUser(User user, HttpServletResponse response, String newPassword, String cfmPassword) {
        ModelAndView mav = new ModelAndView();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        JSONObject res = new JSONObject();
        try {
            User getUser = userService.get(user);
            if (getUser != null && newPassword.equals(cfmPassword)) {
                user.setPassword(newPassword);
                userService.update(user);
                res.put("status", "success");
            }
        } catch (Exception e) {
            res.put("status", "fail");
        }
        try {
            response.getWriter().append(res.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        mav.addObject("message", res);
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("deleteUser")
    public void deleteUser(User user) {
        User getUser = userService.get(user);
        if (getUser != null) {
            userService.delete(getUser.getId());
        }
    }

}
