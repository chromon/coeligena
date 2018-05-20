package com.coeligena.dao.impl;

import com.coeligena.dao.QuestionTagsDAO;
import com.coeligena.model.QuestionTagsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     问题标签持久化
 * </p>
 * Created by Ellery on 2018/5/20.
 */
@Repository
public class QuestionTagsDAOImpl implements QuestionTagsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加问题标签
     * @param questionTagsDO 问题标签
     */
    @Override
    public void addQuestionTag(QuestionTagsDO questionTagsDO) {
        this.getSession().save(questionTagsDO);
    }
}
