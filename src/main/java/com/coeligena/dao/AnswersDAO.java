package com.coeligena.dao;

import com.coeligena.model.AnswersDO;

import java.util.List;

/**
 * <p>
 *     回答数据访问对象
 * </p>
 * Created by Ellery on 2018/6/14.
 */
public interface AnswersDAO {

    /**
     * 添加回答
     * @param answersDO 回答
     */
    void addAnswer(AnswersDO answersDO);

    /**
     * 由问题 id 查询回答列表
     * @param questionId 问题 id
     * @return 回答列表
     */
    List<AnswersDO> queryAnswersByQuestionId(int questionId);
}
