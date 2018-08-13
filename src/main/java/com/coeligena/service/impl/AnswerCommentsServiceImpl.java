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
@Service("answerComments")
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

    @Override
    public List<AnswerCommentsDO> queryAnswerCommentsByPage(Page page) {
        return this.answerCommentsDAO.queryAnswerCommentsByPage(page);
    }

    @Autowired
    public void setAnswerCommentsDAO(AnswerCommentsDAO answerCommentsDAO) {
        this.answerCommentsDAO = answerCommentsDAO;
    }
}
