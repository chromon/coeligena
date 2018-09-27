package com.coeligena.controller;

import com.coeligena.model.ReportTypeDO;
import com.coeligena.model.ReportsDO;
import com.coeligena.service.ReportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * report controller
 * Created by Ellery on 2018/9/27.
 */
@Controller
public class ReportController {

    private ReportTypeService reportTypeService;

    /**
     * 举报类型列表 ajax
     * @return 举报类型
     */
    @RequestMapping(value = "/report-type-list", method = RequestMethod.GET)
    @ResponseBody
    public List<ReportTypeDO> allRootReportType() {
        List<ReportTypeDO> reportTypeDOList = reportTypeService.queryRootReportType();
        return reportTypeDOList;
    }

    @Autowired
    public void setReportTypeService(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }
}
