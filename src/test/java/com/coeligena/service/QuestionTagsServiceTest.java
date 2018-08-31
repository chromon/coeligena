package com.coeligena.service;

import com.coeligena.model.QuestionTagsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * question tags service test
 * Created by Ellery on 2018/8/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class QuestionTagsServiceTest {

    private QuestionTagsService questionTagsService;

    @Test
    public void testSaveQuestionTag() {
        QuestionTagsDO questionTagsDO = new QuestionTagsDO();
        questionTagsService.saveQuestionTag(questionTagsDO);

        Assert.assertEquals(questionTagsDO.getQuestionId(), 0);
    }

    @Test
    public void testQueryQuestionTagsByQid() {
        Assert.assertEquals(questionTagsService
                .queryQuestionTagByQid(1).size(), 2);
    }

    @Autowired
    public void setQuestionTagsService(QuestionTagsService questionTagsService) {
        this.questionTagsService = questionTagsService;
    }
}
