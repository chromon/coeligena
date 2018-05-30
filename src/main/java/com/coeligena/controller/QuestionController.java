package com.coeligena.controller;

import com.coeligena.dao.QuestionsDAO;
import com.coeligena.model.QuestionsDO;
import com.coeligena.model.TopicNodesDO;
import com.coeligena.service.QuestionTagsService;
import com.coeligena.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
    public String question(@PathVariable int questionId, Model model) {
        // 查询问题信息
        QuestionsDO questionsDO = questionsService.queryQuestionById(questionId);

        // 查询问题标签
        List<TopicNodesDO> questionTagsList = questionTagsService.queryQuestionTagByQid(questionsDO.getId());

        model.addAttribute("questionsDO", questionsDO);
        model.addAttribute("questionTagsList", questionTagsList);
        model.addAttribute("fromAnswer", false);
        return "question";
    }

    @RequestMapping(value = "/question/{questionId}/answer/{answerId}", method = RequestMethod.GET)
    public String questionAnswer(@PathVariable int questionId,
                                 @PathVariable int answerId, Model model) {

        QuestionsDO questionsDO = questionsService.queryQuestionById(questionId);

        model.addAttribute("questionsDO", questionsDO);
        return "question";
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
}
