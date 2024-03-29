package com.coeligena.controller;

import com.coeligena.dto.CreateQuestionDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.digest.ContentDigest;
import com.coeligena.function.ip.IPAddress;
import com.coeligena.model.*;
import com.coeligena.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *     ask controller
 * </p>
 * Created by Ellery on 2018/1/19.
 */
@Controller
public class AskController {

    private TopicNodesService topicNodesService;
    private UsersService usersService;
    private QuestionsService questionsService;
    private QuestionTagsService questionTagsService;
    private FeedsService feedsService;

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 提问时话题自动补全
     * @param topicName 话题名称
     */
    @RequestMapping(value = "/topic-search", method = RequestMethod.GET)
    @ResponseBody
    public List<TopicNodesDO> topicAutoComplete(@RequestParam("topicName") String topicName) {

        // URL 解码
        try {
            topicName = URLDecoder.decode(topicName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        List<TopicNodesDO> topicNodesDOList = topicNodesService.queryTopicNodesByName(topicName);
        return topicNodesDOList;
    }

    /**
     * 首页提问
     * @param cqDTO 问题数据传出对象
     * @return 跳转到问题页面
     */
    @RequestMapping(value="/ask-question", method=RequestMethod.POST)
    @SuppressWarnings("unchecked")
    public String saveCourse(HttpServletRequest request,
                             @ModelAttribute CreateQuestionDTO cqDTO) {

        // 提问 业务操作，数据库持久化

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");
        if (userInfoDTO == null) {
            return "signin";
        }

        // 日期
        Timestamp now = DateUtils.currentTime();

        // 更新用户提问数
        UsersDO usersDO = userInfoDTO.getUsersDO();
        usersDO.setQuestionCount(usersDO.getQuestionCount() + 1);
        usersService.modifyUsers(usersDO);

        // 添加问题
        QuestionsDO questionsDO = new QuestionsDO();
        questionsDO.setQuestionContent(cqDTO.getQuestionContent());
        questionsDO.setQuestionDetail(cqDTO.getQuestionDetail());
        questionsDO.setQuestionDigest(ContentDigest.getDigest(cqDTO.getQuestionDetail(), 100, "..."));
        questionsDO.setQuestionTime(now);
        questionsDO.setUpdateTime(now);
        questionsDO.setQuestionIP(IPAddress.getIpAdrress(request));
        if (cqDTO.getAnonymous() == null || cqDTO.getAnonymous().equals("")) {
            cqDTO.setAnonymous("0");
        }
        questionsDO.setAnonymous(Byte.parseByte(cqDTO.getAnonymous()));
        questionsDO.setUserId(usersDO.getId());
        questionsService.saveQuestion(questionsDO);

        // 添加问题标签
        for (int i = 0; i < cqDTO.getTopics().length; i ++) {
            QuestionTagsDO  questionTagsDO = new QuestionTagsDO();
            questionTagsDO.setQuestionId(questionsDO.getId());
            questionTagsDO.setQuestionTopicId(Integer.parseInt(cqDTO.getTopics()[i]));
            questionTagsService.saveQuestionTag(questionTagsDO);
        }

        // 添加问题日志
        // TODO

        // 添加动态
        FeedsDO feedsDO = new FeedsDO();
        // 动态类型所对应的ID,如关注和提出问题对应的是问题ID，赞同回答和回答问题对应的是回答ID
        feedsDO.setFeedsId(questionsDO.getId());
        // 动态类型 1：关注该问题，2：赞同该回答，3：回答了该问题，4：提了一个问题
        byte feedsType = 4;
        feedsDO.setFeedsType(feedsType);
        feedsDO.setFeedsTime(now);
        feedsDO.setFeedsUserId(usersDO.getId());
        feedsService.saveFeeds(feedsDO);

        // redis cache
        // 发送 feed 有续集，存放提问用户动态信息
        redisTemplate.opsForZSet().add("user:" + usersDO.getId() + "::sendFeed",
                feedsDO, DateUtils.getDate());
        // 用户动态里可以看见自己的提问信息，所以接收 feed 有续集也要存放
        redisTemplate.opsForZSet().add("user:" + usersDO.getId() + "::receiveFeed",
                feedsDO, DateUtils.getDate());
        // 提问 feed 信息，发送到动态发布处理队列，用于提问之后的动态推送
        redisTemplate.convertAndSend("feedHandler", feedsDO);

        // 更新全局用户信息
        userInfoDTO.setUsersDO(usersDO);
        request.getSession().setAttribute("userInfoDTO", userInfoDTO);

        return "redirect:/question/" + questionsDO.getId();
    }

    @Autowired
    public void setTopicNodesService(TopicNodesService topicNodesService) {
        this.topicNodesService = topicNodesService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    @Autowired
    public void setQuestionTagsService(QuestionTagsService questionTagsService) {
        this.questionTagsService = questionTagsService;
    }

    @Autowired
    public void setFeedsService(FeedsService feedsService) {
        this.feedsService = feedsService;
    }
}
