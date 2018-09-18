package com.coeligena.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * thanks controller
 * Created by Ellery on 2018/9/18.
 */
@Controller
public class ThanksController {

    /**
     * 添加回答感谢
     * @param answerId 被感谢回答 id
     * @return 信息
     */
    @RequestMapping(value="/answer-thanks", method = RequestMethod.POST)
    @ResponseBody
    public String addThanks(int answerId) {

        return "";
    }

    /**
     * 取消回答感谢
     * @param answerId 回答 id
     * @return 信息
     */
    @RequestMapping(value="/cancel-answer-thanks", method = RequestMethod.POST)
    @ResponseBody
    public String cancelThanks(int answerId) {

        return "";
    }
}
