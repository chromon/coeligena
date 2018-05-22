package com.coeligena.service;

import com.coeligena.model.QuestionsDO;

/**
 * <p>
 *     问题业务实现接口
 * </p>
 * Created by Ellery on 2018/5/18.
 */
public interface QuestionsService {

    /**
     * 添加问题
     * @param questionsDO 问题对象
     */
    void saveQuestion(QuestionsDO questionsDO);

    QuestionsDO queryQuestionById(int questionId);
}
