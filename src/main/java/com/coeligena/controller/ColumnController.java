package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *     column controller
 * </p>
 * Created by Ellery on 2018/5/8.
 */
@Controller
public class ColumnController {

    @RequestMapping(value = "/column/{columnId}", method = RequestMethod.GET)
    public String column(@PathVariable int columnId, Model model) {
        return "columns";
    }
}
