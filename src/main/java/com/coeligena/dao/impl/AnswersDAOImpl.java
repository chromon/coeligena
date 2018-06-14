package com.coeligena.dao.impl;

import com.coeligena.dao.AnswersDAO;
import com.coeligena.model.AnswersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     回答信息持久化实现类
 * </p>
 * Created by Ellery on 2018/6/14.
 */
@Repository
public class AnswersDAOImpl implements AnswersDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加回答
     * @param answersDO 回答
     */
    @Override
    public void addAnswer(AnswersDO answersDO) {
        this.getSession().save(answersDO);
    }
}
