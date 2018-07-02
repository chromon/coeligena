package com.coeligena.service.impl;

import com.coeligena.dao.QuestionCommentDAO;
import com.coeligena.model.QuestionCommentsDO;
import com.coeligena.service.QuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 问题评论业务实现类
 * Created by Ellery on 2018/7/2.
 */
@Service("questionCommentService")
public class QuestionCommentServiceImpl implements QuestionCommentService {

    private QuestionCommentDAO questionCommentDAO;

    /**
     * 添加问题评论
     * @param questionCommentsDO 问题评论信息
     */
    @Override
    public void saveQuestionComment(QuestionCommentsDO questionCommentsDO) {
        this.questionCommentDAO.addQuestionComment(questionCommentsDO);
    }

    @Autowired
    public void setQuestionCommentDAO(QuestionCommentDAO questionCommentDAO) {
        this.questionCommentDAO = questionCommentDAO;
    }
}
