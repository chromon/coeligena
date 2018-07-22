package com.coeligena.dao;

import com.coeligena.model.CommentApprovalsDO;

/**
 * comment approvals dao
 * Created by Ellery on 2018/7/22.
 */
public interface CommentApprovalsDAO {

    /**
     * 添加评论赞同
     * @param commentApprovalsDO 赞同评论信息
     */
    void addCommentApprovals(CommentApprovalsDO commentApprovalsDO);
}
