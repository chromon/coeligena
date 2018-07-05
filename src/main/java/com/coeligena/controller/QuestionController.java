package com.coeligena.controller;

import com.coeligena.dto.AnswersDTO;
import com.coeligena.dto.CommentDTO;
import com.coeligena.dto.QuestionCommentDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.model.*;
import com.coeligena.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * question controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class QuestionController {

    private QuestionsService questionsService;
    private QuestionTagsService questionTagsService;
    private AnswersService answersService;
    private UsersService usersService;
    private QuestionCommentService questionCommentService;

    /**
     * 问题页面
     * @param questionId 问题 id
     * @param model model
     * @return 问题页
     */
    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
    public String question(@PathVariable int questionId, Model model) {
        // 查询问题信息
        QuestionsDO questionsDO = questionsService.queryQuestionById(questionId);

        // 查询问题标签
        List<TopicNodesDO> questionTagsList = questionTagsService.queryQuestionTagByQid(questionsDO.getId());

        // 查询回答列表
        List<AnswersDO> answersList = answersService.queryAnswersByQuestionId(questionId);
        List<AnswersDTO> answersDTOList = new ArrayList<>();
        for (AnswersDO answersDO: answersList) {
            // 查询作者信息
            UsersDO usersDO = usersService.queryUserByUserId(answersDO.getAuthorId());

            AnswersDTO answersDTO = new AnswersDTO();
            answersDTO.setUsersDO(usersDO);
            answersDTO.setAnswersDO(answersDO);
            answersDTOList.add(answersDTO);
        }

        model.addAttribute("questionsDO", questionsDO);
        model.addAttribute("questionTagsList", questionTagsList);
        model.addAttribute("fromAnswer", false);
        model.addAttribute("answersDTOList", answersDTOList);
        return "question";
    }

    /**
     * 问题页特定回答
     * @param questionId 问题 id
     * @param answerId 问题回答
     * @param model model
     * @return 问题页
     */
    @RequestMapping(value = "/question/{questionId}/answer/{answerId}", method = RequestMethod.GET)
    public String questionAnswer(@PathVariable int questionId,
                                 @PathVariable int answerId, Model model) {

        QuestionsDO questionsDO = questionsService.queryQuestionById(questionId);

        model.addAttribute("questionsDO", questionsDO);
        return "question";
    }

    /**
     * 提交问题评论 ajax 请求
     * @param request httpservletrequest
     * @param questionCommentDTO 问题评论信息
     * @return 问题评论相关信息 dto
     */
    @RequestMapping(value = "/question-comment", method = RequestMethod.POST)
    @ResponseBody
    public CommentDTO questionComment(HttpServletRequest request,
                                      @ModelAttribute QuestionCommentDTO questionCommentDTO) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        // 保存问题评论信息
        QuestionCommentsDO questionCommentsDO = new QuestionCommentsDO();
        questionCommentsDO.setQuestionId(questionCommentDTO.getQuestionId());
        questionCommentsDO.setReviewerId(questionCommentDTO.getReviewerId());
        questionCommentsDO.setParentCommentId(questionCommentDTO.getParentCommentId());
        questionCommentsDO.setCommentContent(questionCommentDTO.getCommentContent());
        questionCommentsDO.setCommentTime(now);
        questionCommentsDO.setUserId(userInfoDTO.getUsersDO().getId());
        questionCommentService.saveQuestionComment(questionCommentsDO);

        // 更新问题评论数




        // 查询被评论者信息
        UsersDO reviewer = usersService.queryUserByUserId(questionCommentDTO.getReviewerId());

        // 返回信息
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setQuestionId(questionCommentDTO.getQuestionId());
        commentDTO.setQuestionCommentsDO(questionCommentsDO);
        commentDTO.setReviewer(reviewer);
        commentDTO.setUser(userInfoDTO.getUsersDO());

        return commentDTO;
    }

    /**
     * 查询问题评论列表
     * @return 问题评论列表
     */
    @RequestMapping(value = "/question-comment-list", method = RequestMethod.GET)
    @ResponseBody
    public List<CommentDTO> questionCommentList() {

        List<CommentDTO> commentDTOList = new ArrayList<>();

        // 查询全部评论
        List<QuestionCommentsDO> questionCommentsDOList = this.questionCommentService.queryQuestionComments();
        for (QuestionCommentsDO questionCommentsDO: questionCommentsDOList) {

            CommentDTO commentDTO = new CommentDTO();

            // 查询被评论用户信息
            UsersDO reviewer = null;
            if (questionCommentsDO.getReviewerId() != 0) {
                reviewer = this.usersService.queryUserByUserId(questionCommentsDO.getReviewerId());
            }

            // 查询评论用户信息
            UsersDO user = this.usersService.queryUserByUserId(questionCommentsDO.getUserId());

            commentDTO.setReviewer(reviewer);
            commentDTO.setQuestionCommentsDO(questionCommentsDO);
            commentDTO.setUser(user);

            commentDTOList.add(commentDTO);
        }

        return commentDTOList;
    }

    @RequestMapping(value = "/question/invited", method = RequestMethod.GET)
    public String questionInvited() {
        return "invited";
    }

    @RequestMapping(value = "/question/{questionId}/log", method = RequestMethod.GET)
    public String questionLog(@PathVariable int questionId, Model model) {
        return "log";
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
    public void setAnswersService(AnswersService answersService) {
        this.answersService = answersService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @Autowired
    public void setQuestionCommentService(QuestionCommentService questionCommentService) {
        this.questionCommentService = questionCommentService;
    }
}
