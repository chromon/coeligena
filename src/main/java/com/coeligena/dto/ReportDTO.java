package com.coeligena.dto;

/**
 * report dto
 * Created by Ellery on 2018/10/4.
 */
public class ReportDTO {

    private int categoryId;

    private byte reportCategory;

    private int reportTypeId;

    private String reportText;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public byte getReportCategory() {
        return reportCategory;
    }

    public void setReportCategory(byte reportCategory) {
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
