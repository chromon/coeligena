package com.coeligena.dao;

import com.coeligena.model.QuestionTagsDO;

/**
 * <P>
 *     问题标签数据访问对象
 * </P>
 * Created by Ellery on 2018/5/20.
 */
public interface QuestionTagsDAO {

    /**
     * 添加问题标签
     * @param questionTagsDO 问题标签
     */
    void addQuestionTag(QuestionTagsDO questionTagsDO);
}
