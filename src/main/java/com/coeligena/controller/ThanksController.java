package com.coeligena.controller;

import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.model.ThanksDO;
import com.coeligena.service.ThanksService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * thanks controller
 * Created by Ellery on 2018/9/18.
 */
@Controller
public class ThanksController {

    private ThanksService thanksService;

    /**
     * 添加回答感谢
     * @param answerId 被感谢回答 id
     * @return 信息
     */
    @RequestMapping(value="/answer-thanks", method = RequestMethod.POST)
    @ResponseBody
    public String addThanks(HttpServletRequest request,
                            int answerId) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        ThanksDO thanksDO = new ThanksDO();
        thanksDO.setAnswerId(answerId);
        thanksDO.setThankUserId(userInfoDTO.getUsersDO().getId());
        thanksDO.setThankTime(DateUtils.currentTime());
        thanksService.saveThank(thanksDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("add thanks success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    /**
     * 取消回答感谢
     * @param answerId 回答 id
     * @return 信息
     */
    @RequestMapping(value="/cancel-answer-thanks", method = RequestMethod.POST)
    @ResponseBody
    public String cancelThanks(HttpServletRequest request,
                               int answerId) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        ThanksDO thanksDO = thanksService.queryThanksByAnswerIdAndUId(answerId, userInfoDTO.getUsersDO().getId());
        thanksService.deleteThank(thanksDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("cancel thanks success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    @Autowired
    public void setThanksService(ThanksService thanksService) {
        this.thanksService = thanksService;
    }
}
