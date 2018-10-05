package com.coeligena.controller;

import com.coeligena.dto.ReportDTO;
import com.coeligena.dto.ReportTypeDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.date.DateUtils;
import com.coeligena.function.info.Information;
import com.coeligena.model.ReportTypeDO;
import com.coeligena.model.ReportsDO;
import com.coeligena.service.ReportTypeService;
import com.coeligena.service.ReportsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * report controller
 * Created by Ellery on 2018/9/27.
 */
@Controller
public class ReportController {

    private ReportTypeService reportTypeService;
    private ReportsService reportsService;

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
                               @ModelAttribute ReportDTO reportDTO) throws JsonProcessingException {
        // 查询用户信息
        UserInfoDTO userInfoDTO = (UserInfoDTO) request.getSession().getAttribute("userInfoDTO");

        ReportsDO reportsDO = new ReportsDO();
        reportsDO.setReportTypeId(reportDTO.getReportTypeId());
        reportsDO.setReportCategory(reportDTO.getReportCategory());
        reportsDO.setReportCategoryId(reportDTO.getCategoryId());
        reportsDO.setReportTime(DateUtils.currentTime());
        if (reportDTO.getReportText() != null) {
            reportsDO.setReportReason(reportDTO.getReportText());
        } else {
            reportsDO.setReportReason("<空>");
        }
        reportsDO.setUserId(userInfoDTO.getUsersDO().getId());
        reportsService.saveReports(reportsDO);

        // 返回消息
        Information info = new Information();
        info.setInfoType("success");
        info.setInfoContent("report success.");

        // json 格式化
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(info);
    }

    @Autowired
    public void setReportTypeService(ReportTypeService reportTypeService) {
        this.reportTypeService = reportTypeService;
    }

    @Autowired
    public void setReportsService(ReportsService reportsService) {
        this.reportsService = reportsService;
    }
}
