package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.ThanksDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * thanks service test
 * Created by Ellery on 2018/9/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class ThanksServiceTest {

    private ThanksService thanksService;

    @Test
    public void testSaveThanks() {
        ThanksDO thanksDO = new ThanksDO();
        thanksDO.setThankTime(DateUtils.currentTime());
        thanksService.saveThank(thanksDO);

        Assert.assertEquals(thanksDO.getId(), 1);
    }

    @Test
    public void testQueryThanksByAnswerIdAndUId() {
        ThanksDO thanksDO = new ThanksDO();
        thanksDO.setThankTime(DateUtils.currentTime());
        thanksService.saveThank(thanksDO);

        Assert.assertEquals(thanksService
                .queryThanksByAnswerIdAndUId(0, 0).getId(), 1);
    }

    @Test
    public void testDeleteThanks() {
        ThanksDO thanksDO = new ThanksDO();
        thanksDO.setThankTime(DateUtils.currentTime());
        thanksService.saveThank(thanksDO);

        thanksService.deleteThank(thanksDO);
    }

    @Autowired
    public void setThanksService(ThanksService thanksService) {
        this.thanksService = thanksService;
    }
}
