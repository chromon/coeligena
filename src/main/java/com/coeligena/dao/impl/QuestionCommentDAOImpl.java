package com.coeligena.dao.impl;

import com.coeligena.dao.QuestionCommentDAO;
import com.coeligena.function.paging.Page;
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
    public List<QuestionCommentsDO> queryQuestionComments(Page page) {
        String sql = "from QuestionCommentsDO";
        Query query = this.getSession().createQuery(sql);
        query.setFirstResult(page.getStartPos());
        query.setMaxResults(page.getPageSize());
        return query.list();
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

    /**
     * 更新问题评论信息
     * @param questionCommentsDO 问题评论信息
     */
    @Override
    public void updateQuestionComments(QuestionCommentsDO questionCommentsDO) {
        this.getSession().update(questionCommentsDO);
    }

    /**
     * 由问题评论 id 查询问题评论
     * @param commentId 问题
     * @return 问题评论信息
     */
    @Override
    public QuestionCommentsDO queryQuestionCommentById(int commentId) {
        String sql = "select qc from QuestionCommentsDO qc where qc.id = : commentId";
        return (QuestionCommentsDO) this.getSession().createQuery(sql)
                .setParameter("commentId", commentId).uniqueResult();
    }
}
