package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.CommentApprovalsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * comment approvals service test
 * Created by Ellery on 2018/8/29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class CommentApprovalsServiceTest {

    private CommentApprovalsService commentApprovalsService;

    @Test
    public void testSaveCommentApprovals() {
        CommentApprovalsDO commentApprovalsDO = new CommentApprovalsDO();
        commentApprovalsDO.setApprovalTime(DateUtils.currentTime());
        commentApprovalsService.saveCommentApprovals(commentApprovalsDO);

        Assert.assertEquals(commentApprovalsDO.getCommentId(), 0);
    }

    @Test
    public void testQueryCommentApprByCommentIdAndUserId() {
        CommentApprovalsDO commentApprovalsDO = new CommentApprovalsDO();
        commentApprovalsDO.setApprovalTime(DateUtils.currentTime());
        commentApprovalsService.saveCommentApprovals(commentApprovalsDO);

        Assert.assertEquals(commentApprovalsService
                .queryCommentApprByCommentIdAndUserId(0, 0).getCommentType(),
                0);
    }

    @Test
    public void testModifyCommentApprovals() {
        CommentApprovalsDO commentApprovalsDO = new CommentApprovalsDO();
        commentApprovalsDO.setApprovalTime(DateUtils.currentTime());
        commentApprovalsService.saveCommentApprovals(commentApprovalsDO);

        commentApprovalsDO.setCommentAction((byte) 2);
        commentApprovalsService.modifyCommentApprovals(commentApprovalsDO);

        Assert.assertEquals(commentApprovalsService
                .queryCommentApprByCommentIdAndUserId(0, 0).getCommentAction(), 2);
    }

    @Test
    public void testDeleteCommentApprovals() {
        CommentApprovalsDO commentApprovalsDO = new CommentApprovalsDO();
        commentApprovalsDO.setApprovalTime(DateUtils.currentTime());
        commentApprovalsService.saveCommentApprovals(commentApprovalsDO);

        commentApprovalsService.deleteCommentApprovals(commentApprovalsDO);

        Assert.assertEquals(commentApprovalsService
                .queryCommentApprByCommentIdAndUserId(0, 0), null);
    }


    @Autowired
    public void setCommentApprovalsService(CommentApprovalsService commentApprovalsService) {
        this.commentApprovalsService = commentApprovalsService;
    }
}
