package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * inbox controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class InboxController {

    @RequestMapping(value = "/inbox", method = RequestMethod.GET)
    public String inbox() {
        return "inbox";
    }

    @RequestMapping(value = "/inbox/{messageId}", method = RequestMethod.GET)
    public String inboxDetail(@PathVariable("messageId") int messageId, Model model) {
        return "message";
    }
}
