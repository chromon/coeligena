package com.coeligena.controller;

import com.coeligena.dto.PostAnswerDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.model.AnswersDO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.AnswersService;
import com.coeligena.service.QuestionsService;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *     answer controller
 * </p>
 * Created by Ellery on 2018/6/12.
 */
@Controller
public class AnswerController {

    private UsersService usersService;
    private AnswersService answersService;
    private QuestionsService questionsService;

    @RequestMapping(value="/answer-the-question", method = RequestMethod.POST)
    @ResponseBody
    public AnswersDO answerQuestion(HttpServletRequest request,
                                    @ModelAttribute PostAnswerDTO postAnswerDTO) {

        System.out.println(postAnswerDTO.getAnonymous() + postAnswerDTO.getAnswerContent()
                + postAnswerDTO.getReprintType() + postAnswerDTO.getQuestionId());

        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 更新用户回答数
        UsersDO usersDO = userInfoDTO.getUsersDO();
        usersDO.setAnswerCount(usersDO.getAnswerCount() + 1);
        usersService.modifyUsers(usersDO);

        // 更新问题回答数
        QuestionsDO questionsDO = questionsService.queryQuestionById(
                Integer.parseInt(postAnswerDTO.getQuestionId()));
        questionsDO.setAnswerCount(questionsDO.getAnswerCount() + 1);
        questionsService.modifyQuestion(questionsDO);

        // 添加回答
        AnswersDO answersDO = new AnswersDO();
        answersDO.setQuestionId(Integer.parseInt(postAnswerDTO.getQuestionId()));
        answersDO.setAuthorId(usersDO.getId());
        answersDO.setAnswerContent(postAnswerDTO.getAnswerContent());
        answersDO.setAnswerTime(now);
        answersDO.setAnonymous(Byte.parseByte(postAnswerDTO.getAnonymous()));
        answersDO.setReprintType(Byte.parseByte(postAnswerDTO.getReprintType()));
        answersDO.setCommentType(Byte.parseByte(postAnswerDTO.getCommentType()));
        answersService.saveAnswer(answersDO);

        return answersDO;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setAnswersService(AnswersService answersService) {
        this.answersService = answersService;
    }

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }
}
