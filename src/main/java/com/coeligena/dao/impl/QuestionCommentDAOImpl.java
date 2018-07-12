package com.coeligena.dao.impl;

import com.coeligena.dao.QuestionCommentDAO;
import com.coeligena.model.QuestionCommentsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 查询全部问题评论
     * @return 问题评论列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<QuestionCommentsDO> queryQuestionComments() {
        String sql = "from QuestionCommentsDO";
        return this.getSession().createQuery(sql).list();
    }

    /**
     * 查询记录数
     * @return 问题评论数量
     */
    @Override
    public int queryQuestionCommentsCount() {
        String sql = "select count(*) from QuestionCommentsDO";
        Query query = this.getSession().createQuery(sql);
        return ((Number)query.uniqueResult()).intValue();
    }
}
