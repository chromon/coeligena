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

    /**
     * 由问题 id 查询问题信息
     * @param questionId 问题 id
     * @return 问题信息
     */
    QuestionsDO queryQuestionById(int questionId);

    /**
     * 更新问题信息
     * @param questionsDO 问题信息
     */
    void modifyQuestion(QuestionsDO questionsDO);
}
