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
}
