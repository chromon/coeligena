package com.coeligena.dao.impl;

import com.coeligena.dao.QuestionsDAO;
import com.coeligena.model.QuestionsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <P>
 *     问题信息持久化
 * </P>
 * Created by Ellery on 2018/5/18.
 */
@Repository
public class QuestionsDAOImpl implements QuestionsDAO{

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加问题
     * @param questionsDO 问题对象
     */
    @Override
    public void addQuestion(QuestionsDO questionsDO) {
        this.getSession().save(questionsDO);
    }
}
