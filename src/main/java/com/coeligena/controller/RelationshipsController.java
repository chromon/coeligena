package com.coeligena.controller;

import com.coeligena.function.info.Information;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * relationships controller
 * Created by Ellery on 2018/11/16.
 */
@Controller
public class RelationshipsController {


    @RequestMapping(value="/follow-user", method= RequestMethod.POST)
    public String followUser(HttpServletRequest request, int followId,
                             int followAction) throws JsonProcessingException {

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("follow success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }
}
