package com.coeligena.controller;

import com.coeligena.dto.FeedsDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.model.FeedsDO;
import com.coeligena.model.FollowDO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.service.FeedsService;
import com.coeligena.service.FollowService;
import com.coeligena.service.QuestionsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * following controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class FollowingController {

    private FollowService followService;
    private QuestionsService questionsService;
    private FeedsService feedsService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 关注问题
     * @param request http servlet request
     * @param questionId 问题 id
     * @return 信息
     * @throws JsonProcessingException json exception
     */
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

        // 修改问题关注数量
        QuestionsDO questionsDO = this.questionsService.queryQuestionById(questionId);
        questionsDO.setFollowerCount(questionsDO.getFollowerCount() + 1);
        this.questionsService.modifyQuestion(questionsDO);

        // 添加动态
        FeedsDO feedsDO = new FeedsDO();
        // 动态类型所对应的ID,如关注和提出问题对应的是问题ID，赞同回答和回答问题对应的是回答ID
        feedsDO.setFeedsId(questionsDO.getId());
        // 动态类型 1：关注该问题，2：赞同该回答，3：回答了该问题，4：提了一个问题
        byte feedsType = 1;
        feedsDO.setFeedsType(feedsType);
        feedsDO.setFeedsTime(DateUtils.currentTime());
        feedsDO.setFeedsUserId(userInfoDTO.getUsersDO().getId());
        feedsService.saveFeeds(feedsDO);

        // 关注问题 feed 信息，发送到动态发布处理队列，用于关注信息的动态推送
        redisTemplate.convertAndSend("feedHandler", feedsDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("follow question success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    /**
     * 取消关注问题
     * @param request http servlet request
     * @param questionId 问题 id
     * @return 信息
     * @throws JsonProcessingException json exception
     */
    @RequestMapping(value = "/cancel-follow-question", method = RequestMethod.POST)
    @ResponseBody
    public String cancelFollowQuestion(HttpServletRequest request, int questionId) throws JsonProcessingException {

        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 取消关注问题
        FollowDO followDO = this.followService.queryFollowByQidAndUid(questionId, userInfoDTO.getUsersDO().getId());
        this.followService.deleteFollow(followDO);

        // 修改问题关注数量
        QuestionsDO questionsDO = this.questionsService.queryQuestionById(questionId);
        questionsDO.setFollowerCount(questionsDO.getFollowerCount() - 1);
        this.questionsService.modifyQuestion(questionsDO);

        // 删除 feeds
        FeedsDO feedsDO = feedsService.queryFeedsByIdType(questionId, 1, userInfoDTO.getUsersDO().getId());
        FeedsDTO feedsDTO = new FeedsDTO();
        feedsDTO.setFeedsDO(feedsDO);
        feedsService.deleteFeeds(feedsDO);

        // 取消关注问题 feed 信息，发送到取消动态发布处理队列，用于取消关注信息的动态推送
        redisTemplate.convertAndSend("cancelFeedHandler", feedsDTO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("cancel follow question success.");

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

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Autowired
    public void setFeedsService(FeedsService feedsService) {
        this.feedsService = feedsService;
    }
}
