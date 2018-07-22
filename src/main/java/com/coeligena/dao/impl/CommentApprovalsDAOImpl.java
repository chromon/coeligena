package com.coeligena.dao.impl;

import com.coeligena.dao.CommentApprovalsDAO;
import com.coeligena.model.CommentApprovalsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
