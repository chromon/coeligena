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
