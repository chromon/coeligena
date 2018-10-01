package com.coeligena.controller;

import com.coeligena.dto.ReportTypeDTO;
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
    @RequestMapping(value = "/report-type-list", method = RequestMethod.POST)
    @ResponseBody
    public ReportTypeDTO allRootReportType(int parentReportTypeId) {
        ReportTypeDTO reportTypeDTO = new ReportTypeDTO();
        reportTypeDTO.setReportTypeDOList(reportTypeService.queryRootReportType(parentReportTypeId));
        ReportTypeDO reportTypeDO = reportTypeService.queryReportTypeById(parentReportTypeId);
        if (reportTypeDO == null) {
            reportTypeDO = new ReportTypeDO();
            reportTypeDO.setReportTypeContent("举报");
        }
        reportTypeDTO.setReportTypeDO(reportTypeDO);

        return reportTypeDTO;
    }

    @Autowired
    public void setReportTypeService(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }
}
