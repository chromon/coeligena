package com.coeligena.service;

import com.coeligena.model.QuestionTagsDO;

/**
 * <p>
 *     问题标签业务逻辑接口
 * </p>
 * Created by Ellery on 2018/5/20.
 */
public interface QuestionTagsService {

    /**
     * 添加问题标签
     * @param questionTagsDO 问题标签
     */
    void saveQuestionTag(QuestionTagsDO questionTagsDO);
}
