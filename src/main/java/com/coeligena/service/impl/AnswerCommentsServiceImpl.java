package com.coeligena.service.impl;

import com.coeligena.dao.AnswerCommentsDAO;
import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;
import com.coeligena.service.AnswerCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *     回答评论业务员逻辑实现类
 * </p>
 * Created by Ellery on 2018/8/6.
 */
@Service("answerCommentsService")
public class AnswerCommentsServiceImpl implements AnswerCommentsService {

    private AnswerCommentsDAO answerCommentsDAO;

    /**
     * 添加回答评论
     * @param answerCommentsDO 回答评论信息
     */
    @Override
    public void saveAnswerComment(AnswerCommentsDO answerCommentsDO) {
        this.answerCommentsDAO.addAnswerComment(answerCommentsDO);
    }

    /**
     * 分页查询回答评论
     * @param page 分页
     * @return 回答评论详细信息
     */
    @Override
    public List<AnswerCommentsDO> queryAnswerCommentsByPage(Page page, int answerId) {
        return this.answerCommentsDAO.queryAnswerCommentsByPage(page, answerId);
    }

    /**
     * 回答评论数
     * @return 回答评论数
     */
    @Override
    public int queryAnswerCommentsCount(int answerId) {
        return this.answerCommentsDAO.queryAnswerCommentsCount(answerId);
    }

    /**
     * 由评论 id 查询评论
     * @param answerCommentId 评论 id
     * @return 评论详细信息
     */
    @Override
    public AnswerCommentsDO queryAnswerCommentById(int answerCommentId) {
        return this.answerCommentsDAO.queryAnswerCommentsById(answerCommentId);
    }

    /**
     * 更新回答评论信息
     * @param answerCommentsDO 回答评论信息
     */
    @Override
    public void modifyAnswerComment(AnswerCommentsDO answerCommentsDO) {
       this.answerCommentsDAO.updateAnswerComments(answerCommentsDO);
    }

    @Autowired
    public void setAnswerCommentsDAO(AnswerCommentsDAO answerCommentsDAO) {
        this.answerCommentsDAO = answerCommentsDAO;
    }
}
