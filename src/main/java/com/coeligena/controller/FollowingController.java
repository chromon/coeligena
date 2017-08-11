package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * following controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class FollowingController {

    @RequestMapping(value = "/people/{userId}/following/questions", method = RequestMethod.GET)
    public String following(@PathVariable int userId, Model model) {
        return "following";
    }
}
