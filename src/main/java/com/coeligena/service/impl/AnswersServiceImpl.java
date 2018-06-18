package com.coeligena.service.impl;

import com.coeligena.dao.AnswersDAO;
import com.coeligena.model.AnswersDO;
import com.coeligena.service.AnswersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 由问题 id 查询回答列表
     * @param questionId 问题 id
     * @return 回答列表
     */
    @Override
    public List<AnswersDO> queryAnswersByQuestionId(int questionId) {
        return answersDAO.queryAnswersByQuestionId(questionId);
    }

    @Autowired
    public void setAnswersDAO(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }
}
