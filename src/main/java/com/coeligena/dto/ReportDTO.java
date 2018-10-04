package com.coeligena.dto;

/**
 * report dto
 * Created by Ellery on 2018/10/4.
 */
public class ReportDTO {

    private int answerId;

    private int reportCategory;

    private int reportTypeId;

    private String reportText;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(int reportCategory) {
        this.reportCategory = reportCategory;
    }

    public int getReportTypeId() {
        return reportTypeId;
    }

    public void setReportTypeId(int reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }
}
