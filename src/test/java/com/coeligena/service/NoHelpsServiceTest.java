package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.NoHelpsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * no helps service test
 * Created by Ellery on 2018/9/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class NoHelpsServiceTest {

    private NoHelpsService noHelpsService;

    @Test
    public void testSaveNoHelp() {
        NoHelpsDO noHelpsDO = new NoHelpsDO();
        noHelpsDO.setNoHelpTime(DateUtils.currentTime());
        this.noHelpsService.saveNoHelp(noHelpsDO);

        Assert.assertEquals(noHelpsDO.getId(), 1);
    }

    @Test
    public void testQueryNoHelpByAnswerIdAndUid() {
        NoHelpsDO noHelpsDO = new NoHelpsDO();
        noHelpsDO.setNoHelpTime(DateUtils.currentTime());
        this.noHelpsService.saveNoHelp(noHelpsDO);

        Assert.assertEquals(noHelpsService.queryNoHelpByAnswerIdAndUid(0, 0).getId(), 1);
    }

    @Test
    public void testDeleteNoHelp() {
        NoHelpsDO noHelpsDO = new NoHelpsDO();
        noHelpsDO.setNoHelpTime(DateUtils.currentTime());
        this.noHelpsService.saveNoHelp(noHelpsDO);

        this.noHelpsService.deleteNoHelp(noHelpsDO);
    }

    @Autowired
    public void setNoHelpsService(NoHelpsService noHelpsService) {
        this.noHelpsService = noHelpsService;
    }
}
