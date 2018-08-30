package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.function.paging.Page;
import com.coeligena.model.QuestionCommentsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * question comment service test
 * Created by Ellery on 2018/8/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class QuestionCommentServiceTest {

    private QuestionCommentService questionCommentService;

    @Test
    public void testSaveQuestionComment() {
        QuestionCommentsDO questionCommentsDO = new QuestionCommentsDO();
        questionCommentsDO.setCommentContent("test comment.");
        questionCommentsDO.setCommentTime(DateUtils.currentTime());
        questionCommentService.saveQuestionComment(questionCommentsDO);

        Assert.assertEquals(questionCommentsDO.getCommentContent(), "test comment.");
    }

    @Test
    public void testQueryQuestionCommentCount() {
        Assert.assertEquals(questionCommentService
                .queryQuestionCommentsCount(1), 11);
    }

    @Test
    public void testQueryQuestionComments() {
        Page page = new Page(1, 2);
        page.setSize(questionCommentService.queryQuestionCommentsCount(1));
        page.setNavigatePages(3);
        page.init();

        Assert.assertEquals(questionCommentService
                .queryQuestionComments(page, 1).size(), 2);
    }

    @Test
    public void testQueryQuestionCommentById() {
        QuestionCommentsDO questionCommentsDO = new QuestionCommentsDO();
        questionCommentsDO.setCommentContent("test comment.");
        questionCommentsDO.setCommentTime(DateUtils.currentTime());
        questionCommentService.saveQuestionComment(questionCommentsDO);

        Assert.assertEquals(questionCommentService
                .queryQuestionCommentById(questionCommentsDO.getId()).getCommentContent(),
                questionCommentsDO.getCommentContent());
    }

    @Test
    public void testModifyQuestionComments() {
        QuestionCommentsDO questionCommentsDO = new QuestionCommentsDO();
        questionCommentsDO.setCommentContent("test comment.");
        questionCommentsDO.setCommentTime(DateUtils.currentTime());
        questionCommentService.saveQuestionComment(questionCommentsDO);

        questionCommentsDO.setCommentContent("test comment 2.");
        questionCommentService.modifyQuestionComments(questionCommentsDO);

        Assert.assertEquals(questionCommentService
                .queryQuestionCommentById(questionCommentsDO.getId()).getCommentContent(),
                questionCommentsDO.getCommentContent());
    }

    @Autowired
    public void setQuestionCommentService(QuestionCommentService questionCommentService) {
        this.questionCommentService = questionCommentService;
    }
}
