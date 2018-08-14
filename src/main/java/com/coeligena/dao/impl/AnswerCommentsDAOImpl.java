package com.coeligena.dao.impl;

import com.coeligena.dao.AnswerCommentsDAO;
import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;
import com.coeligena.model.AnswersDO;
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
    public List<AnswerCommentsDO> queryAnswerCommentsByPage(Page page) {
        String sql = "from AnswerCommentsDO";
        Query query = this.getSession().createQuery(sql);
        query.setFirstResult(page.getStartPos());
        query.setMaxResults(page.getPageSize());
        return query.list();
    }

    /**
     * 查询记录数
     * @return 记录数
     */
    @Override
    public int queryAnswerCommentsCount() {
        String sql = "select count(*) from AnswerCommentsDO";
        Query query = this.getSession().createQuery(sql);
        return ((Number)query.uniqueResult()).intValue();
    }
}
