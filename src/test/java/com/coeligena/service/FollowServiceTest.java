package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.FollowDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * test follow service
 * Created by Ellery on 2018/10/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class FollowServiceTest {

    private FollowService followService;

    @Test
    public void testSaveQuestionFollow() {
        FollowDO followDO = new FollowDO();
        followDO.setFollowTime(DateUtils.currentTime());
        this.followService.saveQuestionFollow(followDO);

        Assert.assertEquals(followDO.getId(), 1);
    }

    @Test
    public void testQueryFollowByQidAndUid() {
        Assert.assertEquals(this.followService.queryFollowByQidAndUid(1, 1).getId(), 2);
    }

    @Test
    public void testDeleteFollow() {
        FollowDO followDO = new FollowDO();
        followDO.setFollowTime(DateUtils.currentTime());
        this.followService.saveQuestionFollow(followDO);

        this.followService.deleteFollow(followDO);
    }

    @Autowired
    public void setFollowService(FollowService followService) {
        this.followService = followService;
    }
}
