package com.coeligena.dao.impl;

import com.coeligena.dao.CommentApprovalsDAO;
import com.coeligena.model.CommentApprovalsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 评论赞同数据访问对象实现
 * Created by Ellery on 2018/7/22.
 */
@Repository
public class CommentApprovalsDAOImpl implements CommentApprovalsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加评论赞同
     * @param commentApprovalsDO 赞同评论信息
     */
    @Override
    public void addCommentApprovals(CommentApprovalsDO commentApprovalsDO) {
        this.getSession().save(commentApprovalsDO);
    }

    /**
     * 由评论 id 和用户 id 查询是否由评论赞同
     * @param commentId 评论 id
     * @param userId 用户 id
     * @return 评论赞同信息
     */
    @Override
    public CommentApprovalsDO queryCommentApprByCommentIdAndUserId(int commentId, int userId) {
        String sql = "select ca from CommentApprovalsDO ca where ca.commentId = :commentId and ca.userId = :userId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("commentId", commentId);
        query.setParameter("userId", userId);

        return (CommentApprovalsDO) query.uniqueResult();
    }

    /**
     * 更新评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    @Override
    public void updateCommentApprovals(CommentApprovalsDO commentApprovalsDO) {
        this.getSession().update(commentApprovalsDO);
    }

    /**
     * 删除评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    @Override
    public void deleteCommentApprovals(CommentApprovalsDO commentApprovalsDO) {
        this.getSession().delete(commentApprovalsDO);
    }
}
