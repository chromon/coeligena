package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 *     ask controller
 * </p>
 * Created by Ellery on 2018/1/19.
 */
@Controller
public class AskController {

    /**
     * 提问时话题自动补全
     * @param topicName 话题名称
     * @return 问题页面
     */
    @RequestMapping(value = "topic-search", method = RequestMethod.POST)
    public String topicAutoComplete(@ModelAttribute String topicName) {

        return "";
    }
}
