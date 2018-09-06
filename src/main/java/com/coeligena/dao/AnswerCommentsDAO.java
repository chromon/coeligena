package com.coeligena.dao;

import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;

import java.util.List;

/**
 * <p>
 *     回答评论数据访问对象
 * </p>
 * Created by Ellery on 2018/8/6.
 */
public interface AnswerCommentsDAO {

    /**
     * 添加回答评论
     * @param answerCommentsDO 回答评论信息
     */
    void addAnswerComment(AnswerCommentsDO answerCommentsDO);

    /**
     * 分页查询回答评论
     * @param page 分页
     * @param answerId 回答 id
     * @return 回答评论列表
     */
    List<AnswerCommentsDO> queryAnswerCommentsByPage(Page page, int answerId);

    /**
     * 查询记录数
     * @return 记录数
     */
    int queryAnswerCommentsCount(int answerId);

    /**
     * 由回答评论 id 查询评论
     * @param answerCommentId 评论 id
     * @return 回答评论
     */
    AnswerCommentsDO queryAnswerCommentsById(int answerCommentId);

    /**
     * 更新回答评论信息
     * @param answerCommentsDO 回答评论信息
     */
    void updateAnswerComments(AnswerCommentsDO answerCommentsDO);
}
