package com.coeligena.controller;

import com.coeligena.model.QuestionsDO;
import com.coeligena.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * question controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class QuestionController {

    private QuestionsService questionsService;

    @RequestMapping(value = "/question/{questionId}", method = RequestMethod.GET)
    public String question(@PathVariable int questionId, Model model) {

        QuestionsDO questionsDO = questionsService.queryQuestionById(questionId);
        model.addAttribute("questionsDO", questionsDO);
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
}
