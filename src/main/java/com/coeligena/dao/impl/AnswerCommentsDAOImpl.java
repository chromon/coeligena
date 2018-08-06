package com.coeligena.dao.impl;

import com.coeligena.dao.AnswerCommentsDAO;
import com.coeligena.model.AnswerCommentsDO;
import com.coeligena.model.AnswersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     回答评论信息持久化
 * </p>
 * Created by Ellery on 2018/8/6.
 */
@Repository
public class AnswerCommentsDAOImpl implements AnswerCommentsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加回答评论
     * @param answerCommentsDO 回答评论信息
     */
    @Override
    public void addAnswerComment(AnswerCommentsDO answerCommentsDO) {
        this.getSession().save(answerCommentsDO);
    }
}
