package com.coeligena.dao;

import com.coeligena.model.AnswerCommentsDO;

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
}
