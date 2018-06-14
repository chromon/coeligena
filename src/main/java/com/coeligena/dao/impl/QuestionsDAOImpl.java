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

    /**
     * 由问题 id 查询问题信息
     * @param questionId 问题 id
     * @return 问题信息
     */
    @Override
    public QuestionsDO queryQuestionById(int questionId) {
        String sql = "select q from QuestionsDO q where q.id = :questionId";
        QuestionsDO questionsDO = (QuestionsDO) this.getSession().createQuery(sql)
                .setParameter("questionId", questionId).uniqueResult();
        return questionsDO;
    }

    /**
     * 更新问题信息
     * @param questionsDO 问题信息
     */
    @Override
    public void updateQuestion(QuestionsDO questionsDO) {
        this.getSession().update(questionsDO);
    }
}
