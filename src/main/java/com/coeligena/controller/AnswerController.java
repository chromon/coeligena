package com.coeligena.controller;

import com.coeligena.dto.AnswerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *     answer controller
 * </p>
 * Created by Ellery on 2018/6/12.
 */
@Controller
public class AnswerController {

    @RequestMapping(value="/answer-the-question", method = RequestMethod.POST)
    @ResponseBody
    public AnswerDTO AnswerQuestion(@ModelAttribute AnswerDTO answerDTO) {

        System.out.println(answerDTO.getAnonymous() + answerDTO.getAnswerContent() + answerDTO.getReprintType());

        return answerDTO;
    }
}
