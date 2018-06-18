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
}
