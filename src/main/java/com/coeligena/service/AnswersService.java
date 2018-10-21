package com.coeligena.service;

import com.coeligena.model.AnswersDO;

import java.util.List;

/**
 * <p>
 *     回答信息业务实现接口
 * </p>
 * Created by Ellery on 2018/6/14.
 */
public interface AnswersService {

    /**
     * 添加回答
     * @param answersDO 回答
     */
    void saveAnswer(AnswersDO answersDO);

    /**
     * 由问题 id 查询回答列表
     * @param questionId 问题 id
     * @return 回答列表
     */
    List<AnswersDO> queryAnswersByQuestionId(int questionId);

    /**
     * 由问题 id 查询回答列表，按排序分数降序排列
     * @param questionId 问题 id
     * @return 回答列表
     */
    List<AnswersDO> queryAnswersByQuestionIdSortedWSI(int questionId);

    /**
     * 更新回答数据
     * @param answersDO 回答数据
     */
    void modifyAnswers(AnswersDO answersDO);

    /**
     * 由回答 id 查询回答
     * @param answersId 回答 id
     * @return 回答信息
     */
    AnswersDO queryAnswersById(int answersId);

    /**
     * 由问题 id 查询回答数量
     * @param questionId 问题 id
     * @return 回答数量
     */
    int queryAnswersCountByQuestionId(int questionId);
}
