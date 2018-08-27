package com.coeligena.dao.impl;

import com.coeligena.dao.AnswersDAO;
import com.coeligena.model.AnswersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *     回答信息持久化实现类
 * </p>
 * Created by Ellery on 2018/6/14.
 */
@Repository
@Transactional
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

    /**
     * 由问题 id 查询回答列表
     * @param questionId 问题 id
     * @return 回答列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<AnswersDO> queryAnswersByQuestionId(int questionId) {
        String sql = "select a from AnswersDO a where a.questionId=:questionId";
        return this.getSession().createQuery(sql)
                .setParameter("questionId", questionId).list();
    }

    /**
     * 由回答 id 查询回答
     * @param answersId 回答 id
     * @return 回答信息
     */
    @Override
    public AnswersDO queryAnswersById(int answersId) {
        String sql = "select a from AnswersDO a where a.id=:answersId";
        return (AnswersDO) this.getSession().createQuery(sql)
                .setParameter("answersId", answersId).uniqueResult();
    }

    /**
     * 更新回答数据
     * @param answersDO 回答数据
     */
    @Override
    public void updateAnswers(AnswersDO answersDO) {
        this.getSession().update(answersDO);
    }

    /**
     * 由问题 id 查询回答数量
     * @param questionId 问题 id
     * @return 回答数量
     */
    @Override
    public int queryAnswersCountByQuestionId(int questionId) {
        String sql = "select count(*) from AnswersDO ad where ad.questionId =:questionId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("questionId", questionId);
        return ((Number)query.uniqueResult()).intValue();
    }
}
