package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * setting controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class SettingController {

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String setting() {
        return "setting";
    }
}
