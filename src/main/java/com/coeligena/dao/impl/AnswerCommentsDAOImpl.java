package com.coeligena.dao.impl;

import com.coeligena.dao.AnswerCommentsDAO;
import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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

    /**
     * 分页查询回答评论
     * @param page 分页
     * @return 回答评论列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<AnswerCommentsDO> queryAnswerCommentsByPage(Page page, int answerId) {
        String sql = "from AnswerCommentsDO ac where ac.answerId =:answerId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerId", answerId);
        query.setFirstResult(page.getStartPos());
        query.setMaxResults(page.getPageSize());
        return query.list();
    }

    /**
     * 查询记录数
     * @return 记录数
     */
    @Override
    public int queryAnswerCommentsCount(int answerId) {
        String sql = "select count(*) from AnswerCommentsDO ac where ac.answerId =:answerId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerId", answerId);
        return ((Number)query.uniqueResult()).intValue();
    }

    /**
     * 由回答评论 id 查询评论
     * @param answerCommentId 评论 id
     * @return 回答评论
     */
    @Override
    public AnswerCommentsDO queryAnswerCommentsById(int answerCommentId) {
        String sql = "from AnswerCommentsDO ac where ac.id =:answerCommentId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerCommentId", answerCommentId);
        return (AnswerCommentsDO) query.uniqueResult();
    }
}
