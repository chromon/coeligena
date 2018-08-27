package com.coeligena.service.impl;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.AnswersDO;
import com.coeligena.service.AnswersService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * junit test AnswersServiceImpl
 * Created by Ellery on 2018/8/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class AnswersServiceImplTest {

    @Autowired
    private AnswersService answersService;

    @Test
    public void testQueryAnswerById() {
        Assert.assertEquals(answersService
                .queryAnswersById(1).getId(), 1);
    }

    @Test
    public void testSaveAnswer() {
        Timestamp now = DateUtils.currentTime();

        AnswersDO answersDO = new AnswersDO();
        answersDO.setAnswerContent("test answer");
        answersDO.setAnswerDigest("test answer");
        answersDO.setCover("");
        answersDO.setAnswerTime(now);
        answersService.saveAnswer(answersDO);

        Assert.assertEquals(answersService
                .queryAnswersById(answersDO.getId()).getId(), answersDO.getId());
    }

    @Test
    public void testModifyAnswers() {
        Timestamp now = DateUtils.currentTime();

        AnswersDO answersDO = new AnswersDO();
        answersDO.setAnswerContent("test answer");
        answersDO.setAnswerDigest("test answer");
        answersDO.setCover("");
        answersDO.setAnswerTime(now);
        answersService.saveAnswer(answersDO);

        answersDO.setAnswerContent("test answer 2");
        answersService.modifyAnswers(answersDO);

        Assert.assertEquals(answersService.queryAnswersById(
                answersDO.getId()).getAnswerContent(), "test answer 2");
    }

    @Test
    public void testQueryAnswersCountByQuestionId() {
        Assert.assertEquals(answersService
                .queryAnswersCountByQuestionId(1), 15);
    }

    @Test
    public void testQueryAnswerByQuestionId() {
        Assert.assertEquals(
                answersService.queryAnswersByQuestionId(1).size(),
                answersService.queryAnswersCountByQuestionId(1));
    }
}
