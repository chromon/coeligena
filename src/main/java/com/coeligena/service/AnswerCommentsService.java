package com.coeligena.service;

import com.coeligena.model.AnswerCommentsDO;

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
}
