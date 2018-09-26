package com.coeligena.model;

import javax.persistence.*;

/**
 * 举报类型实体类
 *
 * <p>
 * Created by Ellery on 2017/10/30.
 */
@Entity
@Table(name = "report_type")
public class ReportTypeDO {

    /** 举报类型 id */
    private int id;

    /** 举报类型 */
    private String reportTypeContent;

    /** 上级举报类型 */
    private int parentReportTypeId;

    /** 是否需要填写详细信息 */
    private byte requireDetails;

    /** 是否有子类型 */
    private byte subReportType;

    /** 是否是通用类型（即回答评论类型） */
    private byte common;

    /**
     * 获取举报类型 id
     * @return 举报类型 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置举报类型 id
     * @param id 举报类型 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取举报类型
     * @return 举报类型
     */
    @Column(name = "report_type_content", nullable = false, length = 64, columnDefinition = "varchar(64)")
    public String getReportTypeContent() {
        return reportTypeContent;
    }

    /**
     * 设置举报类型
     * @param reportTypeContent 举报类型
     */
    public void setReportTypeContent(String reportTypeContent) {
        this.reportTypeContent = reportTypeContent;
    }

    /**
     * 获取当前类型的上级类型
     * @return 上级类型
     */
    @Column(name="parent_report_type_id", nullable = false, columnDefinition = "default '0'")
    public int getParentReportTypeId() {
        return parentReportTypeId;
    }

    /**
     * 设置当前类型的上级类型
     * @param parentReportTypeId 上级类型 id
     */
    public void setParentReportTypeId(int parentReportTypeId) {
        this.parentReportTypeId = parentReportTypeId;
    }

    /**
     * 判断是否需要填写详细信息
     * @return 是否
     */
    @Column(name = "require_details", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getRequireDetails() {
        return requireDetails;
    }

    /**
     * 设置是否需要填写详细信息
     * @param requireDetails 是否
     */
    public void setRequireDetails(byte requireDetails) {
        this.requireDetails = requireDetails;
    }

    /**
     * 判断是否有子类型
     * @return 是否
     */
    @Column(name = "sub_report_type", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getSubReportType() {
        return subReportType;
    }

    /**
     * 设置是否有子类型
     * @param subReportType 是否有子类型
     */
    public void setSubReportType(byte subReportType) {
        this.subReportType = subReportType;
    }

    /**
     * 判断是否是通用类型
     * @return 是否是通用类型
     */
    @Column(name = "common", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getCommon() {
        return common;
    }

    /**
     * 设置是否是通用类型
     * @param common 是否是通用类型
     */
    public void setCommon(byte common) {
        this.common = common;
    }
}
