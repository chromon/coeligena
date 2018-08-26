package com.coeligena.service.impl;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.AnswerCommentsDO;
import com.coeligena.service.AnswerCommentsService;
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
public class AnswerCommentsServiceImplTest {

    @Autowired
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
}
