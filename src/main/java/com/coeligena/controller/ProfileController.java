package com.coeligena.controller;

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

    @RequestMapping(value = "/people/{userId}", method = RequestMethod.GET)
    public String profile(@PathVariable int userId, Model model) {
        return "profile";
    }
}
