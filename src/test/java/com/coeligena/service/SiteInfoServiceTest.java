package com.coeligena.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * site info service test
 * Created by Ellery on 2018/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class SiteInfoServiceTest {

    private SiteInfoService siteInfoService;

    @Test
    public void testQuerySiteInformation() {
        Assert.assertEquals(siteInfoService
                .querySiteInformation().getCopyRight(), "2018");
    }

    @Autowired
    public void setSiteInfoService(SiteInfoService siteInfoService) {
        this.siteInfoService = siteInfoService;
    }
}
