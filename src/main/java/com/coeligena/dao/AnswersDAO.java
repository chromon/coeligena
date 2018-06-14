package com.coeligena.dao;

import com.coeligena.model.AnswersDO;

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
}
