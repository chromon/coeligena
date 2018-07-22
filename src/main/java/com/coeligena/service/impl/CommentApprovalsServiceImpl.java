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

    @Autowired
    public void setCommentApprovalsDAO(CommentApprovalsDAO commentApprovalsDAO) {
        this.commentApprovalsDAO = commentApprovalsDAO;
    }
}
