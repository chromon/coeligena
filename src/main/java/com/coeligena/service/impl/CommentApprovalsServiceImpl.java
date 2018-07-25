package com.coeligena.service.impl;

import com.coeligena.dao.CommentApprovalsDAO;
import com.coeligena.model.CommentApprovalsDO;
import com.coeligena.service.CommentApprovalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     添加评论业务实现类
 * </p>
 * Created by Ellery on 2018/7/22.
 */
@Service("commentApprovalsService")
public class CommentApprovalsServiceImpl implements CommentApprovalsService {

    private CommentApprovalsDAO commentApprovalsDAO;

    /**
     * 添加评论赞同
     * @param commentApprovalsDO 评论赞同
     */
    @Override
    public void saveCommentApprovals(CommentApprovalsDO commentApprovalsDO) {
        this.commentApprovalsDAO.addCommentApprovals(commentApprovalsDO);
    }

    /**
     * 由评论 id 和用户 id 查询是否由评论赞同
     * @param commentId 评论 id
     * @param userId 用户 id
     * @return 评论赞同信息
     */
    @Override
    public CommentApprovalsDO queryCommentApprByCommentIdAndUserId(int commentId, int userId) {
        return this.commentApprovalsDAO.queryCommentApprByCommentIdAndUserId(commentId, userId);
    }

    /**
     * 更新评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    @Override
    public void updateCommentApprovals(CommentApprovalsDO commentApprovalsDO) {
        this.commentApprovalsDAO.updateCommentApprovals(commentApprovalsDO);
    }

    /**
     * 删除评论赞同信息
     * @param commentApprovalsDO 评论赞同信息
     */
    @Override
    public void deleteCommentApprovals(CommentApprovalsDO commentApprovalsDO) {
        this.commentApprovalsDAO.deleteCommentApprovals(commentApprovalsDO);
    }

    @Autowired
    public void setCommentApprovalsDAO(CommentApprovalsDAO commentApprovalsDAO) {
        this.commentApprovalsDAO = commentApprovalsDAO;
    }
}
