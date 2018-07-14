package com.coeligena.service.impl;

import com.coeligena.dao.QuestionCommentDAO;
import com.coeligena.function.paging.Page;
import com.coeligena.model.QuestionCommentsDO;
import com.coeligena.service.QuestionCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 查询全部问题评论
     * @param page 分页
     * @return 问题评论列表
     */
    @Override
    public List<QuestionCommentsDO> queryQuestionComments(Page page) {
        return this.questionCommentDAO.queryQuestionComments(page);
    }

    /**
     * 查询记录数
     * @return 问题评论数量
     */
    @Override
    public int queryQuestionCommentsCount() {
        return this.questionCommentDAO.queryQuestionCommentsCount();
    }

    @Autowired
    public void setQuestionCommentDAO(QuestionCommentDAO questionCommentDAO) {
        this.questionCommentDAO = questionCommentDAO;
    }
}
