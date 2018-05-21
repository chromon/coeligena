package com.coeligena.dao;

import com.coeligena.model.QuestionsDO;

/**
 * <P>
 *     问题数据访问对象
 * </P>
 *
 * Created by Ellery on 2018/5/18.
 */
public interface QuestionsDAO {

    /**
     * 添加问题
     * @param questionsDO 问题对象
     */
    void addQuestion(QuestionsDO questionsDO);

    /**
     * 由问题 id 查询问题详情
     * @param questionId 问题 id
     * @return 问题
     */
    QuestionsDO queryQuestionById(int questionId);
}
