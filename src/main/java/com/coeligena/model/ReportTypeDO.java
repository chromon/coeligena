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
    private byte isCommon;

    /**
     * 获取举报类型 id
     * @return 举报类型 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @Column(name = "report_type_content", nullable = false, length = 64)
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
    @Column(name = "is_common", nullable = false, columnDefinition = "tinyint")
    public byte getIsCommon() {
        return isCommon;
    }

    /**
     * 设置是否是通用类型
     * @param isCommon 是否是通用类型
     */
    public void setIsCommon(byte isCommon) {
        this.isCommon = isCommon;
    }
}
