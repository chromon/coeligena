package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswerCommentsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.annotation.Rollback;

import java.sql.Timestamp;

/**
 * junit test AnswerCommentsServiceImpl
 * Created by Ellery on 2018/8/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class AnswerCommentsServiceTest {

    private AnswerCommentsService answerCommentsService;

    @Test
    public void testSaveAnswerComments() {
        Timestamp now = DateUtils.currentTime();

        AnswerCommentsDO answerCommentsDO = new AnswerCommentsDO();
        answerCommentsDO.setAnswerId(2);
        answerCommentsDO.setCommentContent("junit test");
        answerCommentsDO.setCommentTime(now);
        answerCommentsService.saveAnswerComment(answerCommentsDO);

        Assert.assertEquals(answerCommentsService.queryAnswerCommentById(
                answerCommentsDO.getId()).getCommentContent(),"junit test");
    }

    @Test
    public void testQueryAnswerCommentCount() {
        Assert.assertEquals(answerCommentsService
                .queryAnswerCommentsCount(2), 14);
    }

    @Test
    public void testQueryAnswerCommentByPage() {
        // 初始化分页信息
        Page page = new Page(1, 2);
        page.setSize(answerCommentsService.queryAnswerCommentsCount(2));
        page.setNavigatePages(3);
        page.init();

        Assert.assertEquals(answerCommentsService
                .queryAnswerCommentsByPage(page, 2).size(), 2);
    }

    @Test
    public void testQueryAnswerCommentById() {
        AnswerCommentsDO answerCommentsDO = answerCommentsService.queryAnswerCommentById(2);
        Assert.assertEquals(answerCommentsDO.getId(), 2);
    }

    @Test
    public void testModifyAnswerComment() {
        Timestamp now = DateUtils.currentTime();
        AnswerCommentsDO answerCommentsDO = new AnswerCommentsDO();
        answerCommentsDO.setAnswerId(2);
        answerCommentsDO.setCommentContent("junit test");
        answerCommentsDO.setCommentTime(now);
        answerCommentsService.saveAnswerComment(answerCommentsDO);

        answerCommentsDO.setCommentContent("junit test 2");
        answerCommentsService.modifyAnswerComment(answerCommentsDO);

        Assert.assertEquals(answerCommentsService.queryAnswerCommentById(answerCommentsDO.getId()).getCommentContent(), "junit test 2");
    }

    @Autowired
    public void setAnswerCommentsService(AnswerCommentsService answerCommentsService) {
        this.answerCommentsService = answerCommentsService;
    }
}
