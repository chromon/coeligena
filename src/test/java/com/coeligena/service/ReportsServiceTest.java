package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.ReportsDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * reports service test
 * Created by Ellery on 2018/10/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class ReportsServiceTest {

    private ReportsService reportsService;

    @Test
    public void testAddReports() {
        ReportsDO reportsDO = new ReportsDO();
        reportsDO.setReportCategoryId(0);
        reportsDO.setReportTime(DateUtils.currentTime());
        reportsDO.setReportReason("");
        reportsService.addReports(reportsDO);

        Assert.assertEquals(reportsDO.getId(), 0);
    }

    @Autowired
    public void setReportsService(ReportsService reportsService) {
        this.reportsService = reportsService;
    }
}
