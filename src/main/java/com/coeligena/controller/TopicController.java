package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * topic controller
 *
 * Created by Ellery on 2017/8/10.
 */

@Controller
public class TopicController {

    @RequestMapping(value = "/topic", method = RequestMethod.GET)
    public String topic() {
        return "topic";
    }
}
