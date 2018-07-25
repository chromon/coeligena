package com.coeligena.dao;

import com.coeligena.function.paging.Page;
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
     * @param page 分页
     * @return 问题评论列表
     */
    List<QuestionCommentsDO> queryQuestionComments(Page page);

    /**
     * 查询记录数
     * @return 记录数
     */
    int queryQuestionCommentsCount();

    /**
     * 更新问题评论信息
     * @param questionCommentsDO 问题评论信息
     */
    void updateQuestionComments(QuestionCommentsDO questionCommentsDO);

    /**
     * 由问题评论 id 查询问题评论
     * @param commentId 问题
     * @return 问题评论信息
     */
    QuestionCommentsDO queryQuestionCommentById(int commentId);
}
