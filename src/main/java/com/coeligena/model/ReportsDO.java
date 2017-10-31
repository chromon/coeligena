package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 举报实体类
 *
 * <p>
 * Created by Ellery on 2017/10/30.
 */
@Entity
@Table(name = "reports")
public class ReportsDO {

    /** 举报 id */
    private int id;

    /** 举报类型 */
    private int reportTypeId;

    /** 举报内容所属分类 1：问题，2：回答，3：评论  */
    private byte reportCategory;

    /** 举报内容所属分类对应的问题、评论、回答id */
    private int reportCategoryId;

    /** 举报时间 */
    private Timestamp reportTime;

    /** 举报理由 */
    private String reportReason;

    /** 是否处理完成，1：是，0：否 */
    private byte resolved;

    /** 举报用户 id */
    private int userId;

    /**
     * 获取举报 id
     * @return 举报 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置举报 id
     * @param id 举报 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取举报类型
     * @return 举报类型 id
     */
    @Column(name = "report_type_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getReportTypeId() {
        return reportTypeId;
    }

    /**
     * 设置举报类型
     * @param reportTypeId 举报类型 id
     */
    public void setReportTypeId(int reportTypeId) {
        this.reportTypeId = reportTypeId;
    }

    /**
     * 获取举报内容所属分类
     * @return 举报内容所属分类 1：问题，2：回答，3：评论
     */
    @Column(name = "report_category", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getReportCategory() {
        return reportCategory;
    }

    /**
     * 设置举报内容所属分类
     * @param reportCategory 举报内容所属分类 1：问题，2：回答，3：评论
     */
    public void setReportCategory(byte reportCategory) {
        this.reportCategory = reportCategory;
    }

    /**
     * 获取举报内容所属分类对应的问题、评论、回答 id
     * @return 举报内容所属分类对应的问题、评论、回答 id
     */
    @Column(name = "report_category_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getReportCategoryId() {
        return reportCategoryId;
    }

    /**
     * 设置举报内容所属分类对应的问题、评论、回答 id
     * @param reportCategoryId 举报内容所属分类对应的问题、评论、回答 id
     */
    public void setReportCategoryId(int reportCategoryId) {
        this.reportCategoryId = reportCategoryId;
    }

    /**
     * 获取举报时间
     * @return 举报时间
     */
    @Column(name = "report_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    public Timestamp getReportTime() {
        return reportTime;
    }

    /**
     * 设置举报时间
     * @param reportTime 举报时间
     */
    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    /**
     * 获取举报理由
     * @return 举报理由
     */
    @Column(name = "report_reason", nullable = false, length = 512, columnDefinition = "varchar(512)")
    public String getReportReason() {
        return reportReason;
    }

    /**
     * 设置举报理由
     * @param reportReason 举报理由
     */
    public void setReportReason(String reportReason) {
        this.reportReason = reportReason;
    }

    /**
     * 判断是否处理完成
     * @return 是否处理完成 1：是，0：否
     */
    @Column(name = "resolved", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getResolved() {
        return resolved;
    }

    /**
     * 设置是否处理完成
     * @param resolved 是否处理完成 1：是，0：否
     */
    public void setResolved(byte resolved) {
        this.resolved = resolved;
    }

    /**
     * 设置举报人
     * @return 举报人 id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 获取举报人
     * @param userId 举报人 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
