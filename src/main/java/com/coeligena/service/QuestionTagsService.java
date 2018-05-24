package com.coeligena.service;

import com.coeligena.model.QuestionTagsDO;
import com.coeligena.model.TopicNodesDO;

import java.util.List;

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

    /**
     * 由问题 id 查询问题标签
     * @param questionId 待查询问题 id
     * @return 问题标签列表
     */
    List<TopicNodesDO> queryQuestionTagByQid(int questionId);
}
