package com.coeligena.dto;

import com.coeligena.model.ReportTypeDO;

import java.util.List;

/**
 * report type dto
 * Created by Ellery on 2018/10/1.
 */
public class ReportTypeDTO {

    private List<ReportTypeDO> reportTypeDOList;

    private ReportTypeDO reportTypeDO;

    public List<ReportTypeDO> getReportTypeDOList() {
        return reportTypeDOList;
    }

    public void setReportTypeDOList(List<ReportTypeDO> reportTypeDOList) {
        this.reportTypeDOList = reportTypeDOList;
    }

    public ReportTypeDO getReportTypeDO() {
        return reportTypeDO;
    }

    public void setReportTypeDO(ReportTypeDO reportTypeDO) {
        this.reportTypeDO = reportTypeDO;
    }
}
