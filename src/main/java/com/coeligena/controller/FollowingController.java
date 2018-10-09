package com.coeligena.controller;

import com.coeligena.function.info.Information;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * following controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class FollowingController {

    @RequestMapping(value = "/follow-question", method = RequestMethod.POST)
    @ResponseBody
    public String followQuestion(int questionId) throws JsonProcessingException {

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("answer comment vote success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    @RequestMapping(value = "/following/questions", method = RequestMethod.GET)
    public String following(Model model) {
        return "following";
    }
}
