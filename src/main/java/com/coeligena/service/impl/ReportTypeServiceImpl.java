package com.coeligena.service.impl;

import com.coeligena.dao.ReportTypeDAO;
import com.coeligena.model.ReportTypeDO;
import com.coeligena.service.ReportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * report type service impl
 * Created by Ellery on 2018/9/27.
 */
@Service("reportTypeService")
public class ReportTypeServiceImpl implements ReportTypeService {

    private ReportTypeDAO reportTypeDAO;

    /**
     * 查询全部根举报类型
     * @return 根举报类型列表
     */
    @Override
    public List<ReportTypeDO> queryRootReportType(int parentTypeId) {
        return this.reportTypeDAO.queryRootReportType(parentTypeId);
    }

    @Autowired
    public void setReportTypeDAO(ReportTypeDAO reportTypeDAO) {
        this.reportTypeDAO = reportTypeDAO;
    }
}
