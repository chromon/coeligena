package com.coeligena.dao.impl;

import com.coeligena.dao.QuestionCommentDAO;
import com.coeligena.model.QuestionCommentsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 问题评论信息持久化
 * Created by Ellery on 2018/7/2.
 */
@Repository
public class QuestionCommentDAOImpl implements QuestionCommentDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加问题评论
     * @param questionCommentsDO 问题评论信息
     */
    @Override
    public void addQuestionComment(QuestionCommentsDO questionCommentsDO) {
        this.getSession().save(questionCommentsDO);
    }
}
