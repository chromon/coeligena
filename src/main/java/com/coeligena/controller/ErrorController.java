package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * error controller
 *
 * Created by Ellery on 2017/12/1.
 */

@Controller
public class ErrorController {

    @RequestMapping(value = "error", method = RequestMethod.GET)
    public String error() {
        return "error";
    }

    @RequestMapping(value = "404", method = RequestMethod.GET)
    public String error404() {
        return "error404";
    }

}
