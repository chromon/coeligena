package com.coeligena.service;

import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;

import java.util.List;

/**
 * <p>
 *      回答评论业务逻辑接口
 * </p>
 * Created by Ellery on 2018/8/6.
 */
public interface AnswerCommentsService {

    /**
     * 添加回答评论
     * @param answerCommentsDO 回答评论信息
     */
    void saveAnswerComment(AnswerCommentsDO answerCommentsDO);

    /**
     * 查询回答评论列表
     * @param page 分页
     * @return 回答评论信息
     */
    List<AnswerCommentsDO> queryAnswerCommentsByPage(Page page);

    /**
     * 查询回答评论数
     * @return 评论数
     */
    int queryAnswerCommentsCount();
}
