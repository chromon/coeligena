package com.coeligena.controller;

import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.model.FollowDO;
import com.coeligena.service.FollowService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * following controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class FollowingController {

    private FollowService followService;

    @RequestMapping(value = "/follow-question", method = RequestMethod.POST)
    @ResponseBody
    public String followQuestion(HttpServletRequest request, int questionId) throws JsonProcessingException {

        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 关注问题
        FollowDO followDO = new FollowDO();
        followDO.setQuestionId(questionId);
        followDO.setFollowerId(userInfoDTO.getUsersDO().getId());
        followDO.setFollowTime(DateUtils.currentTime());
        followService.saveQuestionFollow(followDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("follow question success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    @RequestMapping(value = "/following/questions", method = RequestMethod.GET)
    public String following(Model model) {
        return "following";
    }

    @Autowired
    public void setFollowService(FollowService followService) {
        this.followService = followService;
    }
}
