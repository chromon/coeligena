package com.coeligena.controller;

import com.coeligena.model.UsersDO;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * profile controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class ProfileController {

    private UsersService usersService;

    @RequestMapping(value = "/people/{userId}", method = RequestMethod.GET)
    public String profile(@PathVariable int userId, Model model) {

        // 查询个人主页信息
        UsersDO usersDO = usersService.queryUserByUserId(userId);
        model.addAttribute("profileInfo", usersDO);

        return "profile";
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
