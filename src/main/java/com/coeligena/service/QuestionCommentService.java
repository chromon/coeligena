package com.coeligena.service;

import com.coeligena.model.QuestionCommentsDO;

/**
 * 问题评论信息业务接口
 * Created by Ellery on 2018/7/2.
 */
public interface QuestionCommentService {

    /**
     * 添加问题评论
     * @param questionCommentsDO 问题评论信息
     */
    void saveQuestionComment(QuestionCommentsDO questionCommentsDO);
}
