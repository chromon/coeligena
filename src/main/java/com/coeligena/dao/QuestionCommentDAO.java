package com.coeligena.dao;

import com.coeligena.model.QuestionCommentsDO;

import java.util.List;

/**
 * 问题评论数据访问对象
 * Created by Ellery on 2018/7/2.
 */
public interface QuestionCommentDAO {

    /**
     * 添加问题评论
     * @param questionCommentsDO 问题评论信息
     */
    void addQuestionComment(QuestionCommentsDO questionCommentsDO);

    /**
     * 查询全部问题评论
     * @return 问题评论列表
     */
    List<QuestionCommentsDO> queryQuestionComments();
}
