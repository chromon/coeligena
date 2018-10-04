package com.coeligena.service.impl;

import com.coeligena.dao.ReportsDAO;
import com.coeligena.model.ReportsDO;
import com.coeligena.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 举报业务逻辑实现类
 * Created by Ellery on 2018/10/4.
 */
@Service("reportsService")
public class ReportsServiceImpl implements ReportsService {

    private ReportsDAO reportsDAO;

    /**
     * 添加举报信息
     * @param reportsDO 举报信息
     */
    @Override
    public void addReports(ReportsDO reportsDO) {
        reportsDAO.addReports(reportsDO);
    }

    @Autowired
    public void setReportsDAO(ReportsDAO reportsDAO) {
        this.reportsDAO = reportsDAO;
    }
}
