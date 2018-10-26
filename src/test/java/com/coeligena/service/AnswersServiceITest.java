package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.function.paging.Page;
import com.coeligena.model.AnswersDO;
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
public class AnswersServiceITest {

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

    @Test
    public void testQueryAnswersByQuestionIdSortedWSI() {
        Assert.assertEquals(
                answersService.queryAnswersByQuestionIdSortedWSI(1).size(),
                answersService.queryAnswersCountByQuestionId(1));
    }

    @Test
    public void testQueryAnswerByQuestionIdWithPage() {

        Page page = new Page(1, 2);
        page.setSize(15);
        page.setNavigatePages(3);
        page.init();

        Assert.assertEquals(
                answersService.queryAnswersByQuestionIdWithPage(page, 1).size(),
                2);
    }

    @Test
    public void testQueryAnswersByQuestionIdSortedWSIWithPage() {

        Page page = new Page(1, 2);
        page.setSize(15);
        page.setNavigatePages(3);
        page.init();

        Assert.assertEquals(
                answersService.queryAnswersByQuestionIdSortedWSIWithPage(page, 1).size(),
                2);
    }
}
