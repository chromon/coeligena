package com.coeligena.service;

import com.coeligena.model.AnswersDO;

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
}
