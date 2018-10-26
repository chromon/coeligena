package com.coeligena.service.impl;

import com.coeligena.dao.AnswersDAO;
import com.coeligena.function.paging.Page;
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

    /**
     * 由问题 id 查询回答列表，按排序分数降序排列
     * @param questionId 问题 id
     * @return 回答列表
     */
    @Override
    public List<AnswersDO> queryAnswersByQuestionIdSortedWSI(int questionId) {
        return answersDAO.queryAnswersByQuestionIdSortedWSI(questionId);
    }

    /**
     * 由问题 id 查询回答列表并分页
     * @param questionId 问题 id
     * @return 回答列表
     */
    @Override
    public List<AnswersDO> queryAnswersByQuestionIdWithPage(Page page, int questionId) {
        return answersDAO.queryAnswersByQuestionIdWithPage(page, questionId);
    }

    /**
     * 由问题 id 查询回答列表，按排序分数降序排列并分页
     * @param questionId 问题 id
     * @return 回答列表
     */
    @Override
    public List<AnswersDO> queryAnswersByQuestionIdSortedWSIWithPage(Page page, int questionId) {
        return answersDAO.queryAnswersByQuestionIdSortedWSIWithPage(page, questionId);
    }

    /**
     * 更新回答数据
     * @param answersDO 回答数据
     */
    @Override
    public void modifyAnswers(AnswersDO answersDO) {
       this.answersDAO.updateAnswers(answersDO);
    }

    /**
     * 由回答 id 查询回答
     * @param answersId 回答 id
     * @return 回答信息
     */
    @Override
    public AnswersDO queryAnswersById(int answersId) {
        return this.answersDAO.queryAnswersById(answersId);
    }

    /**
     * 由问题 id 查询回答数量
     * @param questionId 问题 id
     * @return 回答数量
     */
    @Override
    public int queryAnswersCountByQuestionId(int questionId) {
        return this.answersDAO.queryAnswersCountByQuestionId(questionId);
    }

    @Autowired
    public void setAnswersDAO(AnswersDAO answersDAO) {
        this.answersDAO = answersDAO;
    }
}
