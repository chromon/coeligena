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

    /**
     * 由评论 id 和用户 id 查询是否由评论赞同
     * @param commentId 评论 id
     * @param userId 用户 id
     * @return 评论赞同信息
     */
    CommentApprovalsDO queryCommentApprByCommentIdAndUserId(int commentId, byte commentType, int userId);

    /**
     * 更新评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    void updateCommentApprovals(CommentApprovalsDO commentApprovalsDO);

    /**
     * 删除评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    void deleteCommentApprovals(CommentApprovalsDO commentApprovalsDO);
}
