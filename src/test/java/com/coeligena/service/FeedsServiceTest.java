package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.FeedsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * feeds service test
 * Created by Ellery on 2018/8/30.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class FeedsServiceTest {

    private FeedsService feedsService;

    @Test
    public void testSaveFeeds() {
        FeedsDO feedsDO = new FeedsDO();
        feedsDO.setFeedsTime(DateUtils.currentTime());
        feedsService.saveFeeds(feedsDO);

        Assert.assertEquals(feedsDO.getFeedsId(), 0);
    }

    @Test
    public void testQueryAllFeeds() {
        Assert.assertEquals(feedsService.queryAllFeeds().size(), 6);
    }

    @Autowired
    public void setFeedsService(FeedsService feedsService) {
        this.feedsService = feedsService;
    }
}
