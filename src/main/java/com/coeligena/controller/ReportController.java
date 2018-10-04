package com.coeligena.controller;

import com.coeligena.dto.ReportDTO;
import com.coeligena.dto.ReportTypeDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.model.ReportTypeDO;
import com.coeligena.model.ReportsDO;
import com.coeligena.service.ReportTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * 举报
     * @param request http servlet request
     * @param reportDTO 举报信息
     * @return 状态信息
     */
    @RequestMapping(value = "/report-answer", method = RequestMethod.POST)
    @ResponseBody
    public String reportAnswer(HttpServletRequest request,
                               @ModelAttribute ReportDTO reportDTO) {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        ReportsDO reportsDO = new ReportsDO();



        return "";
    }

    @Autowired
    public void setReportTypeService(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }
}
