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
 * report type service test
 * Created by Ellery on 2018/9/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class ReportTypeServiceTest {

    private ReportTypeService reportTypeService;

    @Test
    public void testQueryRootReportType() {
        Assert.assertEquals(this.reportTypeService.queryRootReportType().size(), 6);
    }

    @Autowired
    public void setReportTypeService(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }
}
