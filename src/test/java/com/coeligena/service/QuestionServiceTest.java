package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.QuestionsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * question service test
 * Created by Ellery on 2018/8/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class QuestionServiceTest {

    private QuestionsService questionsService;

    @Test
    public void testSaveQuestion() {
        QuestionsDO questionsDO = new QuestionsDO();
        questionsDO.setQuestionContent("test question service");
        questionsDO.setQuestionDetail("test question service");
        questionsDO.setQuestionDigest("test ...");
        questionsDO.setQuestionIP("127.0.0.1");
        questionsDO.setQuestionTime(DateUtils.currentTime());
        questionsDO.setUpdateTime(DateUtils.currentTime());
        questionsService.saveQuestion(questionsDO);

        Assert.assertEquals(questionsDO.getUserId(), 0);
    }

    @Test
    public void testQueryQuestionById() {
        QuestionsDO questionsDO = new QuestionsDO();
        questionsDO.setQuestionContent("test question service");
        questionsDO.setQuestionDetail("test question service");
        questionsDO.setQuestionDigest("test ...");
        questionsDO.setQuestionIP("127.0.0.1");
        questionsDO.setQuestionTime(DateUtils.currentTime());
        questionsDO.setUpdateTime(DateUtils.currentTime());
        questionsService.saveQuestion(questionsDO);

        Assert.assertEquals(questionsService
                .queryQuestionById(questionsDO.getId()).getUserId(), 0);
    }

    @Test
    public void testModifyQuestion() {
        QuestionsDO questionsDO = new QuestionsDO();
        questionsDO.setQuestionContent("test question service");
        questionsDO.setQuestionDetail("test question service");
        questionsDO.setQuestionDigest("test ...");
        questionsDO.setQuestionIP("127.0.0.1");
        questionsDO.setQuestionTime(DateUtils.currentTime());
        questionsDO.setUpdateTime(DateUtils.currentTime());
        questionsService.saveQuestion(questionsDO);

        questionsDO.setQuestionContent("hehe");
        questionsService.modifyQuestion(questionsDO);

        Assert.assertEquals(questionsService
                .queryQuestionById(questionsDO.getId()).getQuestionContent(), "hehe");
    }

    @Autowired
    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }
}
