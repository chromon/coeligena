package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 问题日志实体类
 *
 * <p>
 * Created by Ellery on 2017/10/19.
 */
@Entity
@Table(name = "question_logs")
public class QuestionLogsDO {

    /** 问题日志 id */
    private int id;

    /** 问题 id */
    private int questionId;

    /** 操作人员 id */
    private int userId;

    /** 日志事件 */
    private String event;

    /** 修改理由 */
    private String reason;

    /** 实际修改结果 */
    private String revisionText;

    /** 日志时间 */
    private Timestamp logTime;

    /**
     * 获取问题日志 id
     * @return 问题日志 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置问题日志 id
     * @param id 问题日志 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取问题 id
     * @return 问题 id
     */
    @Column(name = "question_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getQuestionId() {
        return questionId;
    }

    /**
     * 设置问题 id
     * @param questionId 问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取操作人员 id
     * @return 操作人员 id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 设置操作人员 id
     * @param userId 操作人员 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取日志事件
     * @return 日志事件
     */
    @Column(name = "event", nullable = false, length = 64, columnDefinition = "varchar(64)")
    public String getEvent() {
        return event;
    }

    /**
     * 设置日志事件
     * @param event 日志事件
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /**
     * 获取修改理由
     * @return 修改理由
     */
    @Column(name = "reason", nullable = false, columnDefinition = "text")
    public String getReason() {
        return reason;
    }

    /**
     * 设置修改理由
     * @param reason 修改理由
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取实际修改结果
     * @return 实际修改结果
     */
    @Column(name = "revision_text", nullable = false, columnDefinition = "text")
    public String getRevisionText() {
        return revisionText;
    }

    /**
     * 设置实际修改结果
     * @param revisionText 实际修改结果
     */
    public void setRevisionText(String revisionText) {
        this.revisionText = revisionText;
    }

    /**
     * 获取日志时间
     * @return 日志时间
     */
    @Column(name = "log_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getLogTime() {
        return logTime;
    }

    /**
     * 设置日志时间
     * @param logTime 日志时间
     */
    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }
}
