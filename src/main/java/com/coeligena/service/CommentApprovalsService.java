package com.coeligena.service;

import com.coeligena.model.CommentApprovalsDO;

/**
 * <p>
 *     评论赞同业务实现接口
 * </p>
 * Created by Ellery on 2018/7/22.
 */
public interface CommentApprovalsService {

    /**
     * 添加评论赞同
     * @param commentApprovalsDO 评论赞同
     */
    void saveCommentApprovals(CommentApprovalsDO commentApprovalsDO);

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
    void modifyCommentApprovals(CommentApprovalsDO commentApprovalsDO);

    /**
     * 删除评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    void deleteCommentApprovals(CommentApprovalsDO commentApprovalsDO);
}
