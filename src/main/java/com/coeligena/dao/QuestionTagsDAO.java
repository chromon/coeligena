package com.coeligena.dao;

import com.coeligena.model.QuestionTagsDO;
import com.coeligena.model.TopicNodesDO;

import java.util.List;

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

    /**
     * 由问题 id 查询问题标签
     * @param questionId 待查询问题 id
     * @return 问题标签列表
     */
    List<TopicNodesDO> queryQuestionTagsByQid(int questionId);
}
