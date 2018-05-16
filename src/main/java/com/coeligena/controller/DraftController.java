package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *     draft controller
 * </p>
 * Created by Ellery on 2018/5/15.
 */
@Controller
public class DraftController {

    @RequestMapping(value = "/draft", method = RequestMethod.GET)
    public String draft() {
        return "draft";
    }

}
