package com.coeligena.service.impl;

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
import java.text.SimpleDateFormat;
import java.util.Date;

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
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        AnswerCommentsDO answerCommentsDO = new AnswerCommentsDO();
        answerCommentsDO.setAnswerId(2);
        answerCommentsDO.setCommentContent("junit test");
        answerCommentsDO.setCommentTime(now);
        answerCommentsService.saveAnswerComment(answerCommentsDO);

        Assert.assertEquals(answerCommentsService.queryAnswerCommentById(
                answerCommentsDO.getId()).getCommentContent(),"junit test");
    }
}
