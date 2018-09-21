package com.coeligena.controller;

import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.model.NoHelpsDO;
import com.coeligena.service.NoHelpsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * no help controller
 * Created by Ellery on 2018/9/20.
 */
@Controller
public class NoHelpController {

    private NoHelpsService noHelpsService;

    /**
     * 添加没有帮助
     * @param request http servlet request
     * @param answerId 没有帮助的回答 id
     * @return info
     * @throws JsonProcessingException exception
     */
    @RequestMapping(value="/answer-nohelp", method = RequestMethod.POST)
    @ResponseBody
    public String addNoHelp(HttpServletRequest request,
                            int answerId) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 没有帮助信息
        NoHelpsDO noHelpsDO = new NoHelpsDO();
        noHelpsDO.setAnswerId(answerId);
        noHelpsDO.setUserId(userInfoDTO.getUsersDO().getId());
        noHelpsDO.setNoHelpTime(DateUtils.currentTime());

        this.noHelpsService.saveNoHelp(noHelpsDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("add no help success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    /**
     * 添加没有帮助
     * @param request http servlet request
     * @param answerId 没有帮助的回答 id
     * @return info
     * @throws JsonProcessingException exception
     */
    @RequestMapping(value="/cancel-answer-nohelp", method = RequestMethod.POST)
    @ResponseBody
    public String cancelNoHelp(HttpServletRequest request,
                            int answerId) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        NoHelpsDO noHelpsDO = noHelpsService.queryNoHelpByAnswerIdAndUid(
                answerId, userInfoDTO.getUsersDO().getId());
        noHelpsService.deleteNoHelp(noHelpsDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("cancel no help success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    @Autowired
    public void setNoHelpsService(NoHelpsService noHelpsService) {
        this.noHelpsService = noHelpsService;
    }
}
