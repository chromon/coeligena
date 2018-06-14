package com.coeligena.service.impl;

import com.coeligena.dao.AnswersDAO;
import com.coeligena.model.AnswersDO;
import com.coeligena.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     回答业务实现类
 * </p>
 * Created by Ellery on 2018/6/14.
 */
@Service("answersService")
public class AnswersServiceImpl implements AnswersService {

    private AnswersDAO answersDAO;

    /**
     * 添加回答
     * @param answersDO 回答
     */
    @Override
    public void saveAnswer(AnswersDO answersDO) {
        this.answersDAO.addAnswer(answersDO);
    }

    @Autowired
    public void setAnswersDAO(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }
}
