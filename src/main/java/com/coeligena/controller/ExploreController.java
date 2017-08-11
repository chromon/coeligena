package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * explore controller
 *
 * Created by Ellery on 2017/8/10.
 */

@Controller
public class ExploreController {

    @RequestMapping(value = "/explore", method = RequestMethod.GET)
    public String explore() {
        return "explore";
    }
}
