package com.coeligena.controller;

import com.coeligena.dto.CreateQuestionDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.ip.IPAddress;
import com.coeligena.model.AuthUsersDO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.model.TopicNodesDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.QuestionsService;
import com.coeligena.service.TopicNodesService;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String saveCourse(HttpServletRequest request,
                             @ModelAttribute CreateQuestionDTO cqDTO) {

        // 提问 业务操作，数据库持久化
        System.out.println(cqDTO.getQuestionContent());
        System.out.println(cqDTO.getQuestionDetail());
//        System.out.println(cqDTO.getTopics()[0] + "=" +cqDTO.getTopics()[1] + "=" +cqDTO.getTopics()[2]);
        System.out.println(cqDTO.getAnonymous());

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");
        if (userInfoDTO == null) {
            return "signin";
        }

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 更新用户提问数
        UsersDO usersDO = userInfoDTO.getUsersDO();
        usersDO.setQuestionCount(usersDO.getQuestionCount() + 1);
        usersService.modifyUsers(usersDO);

        // 添加问题
        QuestionsDO questionsDO = new QuestionsDO();
        questionsDO.setQuestionContent(cqDTO.getQuestionContent());
        questionsDO.setQuestionDetail(cqDTO.getQuestionDetail());
        questionsDO.setQuestionTime(now);
        questionsDO.setUpdateTime(now);
        questionsDO.setQuestionIP(IPAddress.getIpAdrress(request));
        questionsDO.setAnonymous(Byte.parseByte(cqDTO.getAnonymous()));
        questionsDO.setUserId(usersDO.getId());
        questionsService.saveQuestion(questionsDO);

        // 添加问题标签

        // 添加问题日志

        // 添加动态

        // 更新全局用户信息
        userInfoDTO.setUsersDO(usersDO);

        return "question";
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
}
