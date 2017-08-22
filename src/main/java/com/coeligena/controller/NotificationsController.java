package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * notifications controller
 *
 * Created by Ellery on 2017/8/22.
 */

@Controller
public class NotificationsController {

    @RequestMapping(value = "/notifications", method = RequestMethod.GET)
    public String collections() {
        return "notifications";
    }
}
