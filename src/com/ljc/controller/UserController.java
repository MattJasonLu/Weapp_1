package com.ljc.controller;

import com.ljc.pojo.User;
import com.ljc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
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
    public void addUser(User user) {
        userService.add(user);
        System.out.println(user);
    }

    @RequestMapping("getUser")
    public ModelAndView getUser(User user, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("success");
        try {
            User getUser = userService.get(user);

            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");

            if (getUser != null) {
                mav.addObject("message", getUser);
                response.getWriter().append(getUser.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
            mav.addObject("message", "fail");
        }
        return mav;
    }

    @RequestMapping("updateUser")
    public void updateUser(User user) {
        User getUser = userService.get(user);
        if (getUser != null) {
            userService.update(user);
        }
    }

    @RequestMapping("deleteUser")
    public void deleteUser(User user) {
        User getUser = userService.get(user);
        if (getUser != null) {
            userService.delete(getUser.getId());
        }
    }

}
