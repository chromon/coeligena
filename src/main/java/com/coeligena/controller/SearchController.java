package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * profile controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class SearchController {

//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public String profile(@RequestParam("type") String type,
//                          @RequestParam("q") String q, Model model) {
//        return "search";
//    }

    @RequestMapping(value = "/search", params = { "type","q" }, method = RequestMethod.GET)
    public String profile(@RequestParam("type") String type,
                          @RequestParam("q") String q, Model model) {
        return "search";
    }
}
