package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 话题日志实体类
 *
 * <p>
 * Created by Ellery on 2017/10/18.
 */
@Entity
@Table(name = "topic_logs")
public class TopicLogsDO {

    /** 话题日志 id */
    private int id;

    /** 话题节点 id */
    private int topicId;

    /** 日志操作人员 id */
    private int userId;

    /** 日志事件 */
    private String event;

    /** 修改理由 */
    private String reason;

    /** 实际修改结果 */
    private String revisionText;

    /** 日志记录时间 */
    private Timestamp logTime;

    /**
     * 获取话题日志 id
     * @return 话题日志 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置话题日志 id
     * @param id 话题日志 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取话题节点 id
     * @return 话题节点 id
     */
    @Column(name = "topic_id", nullable = false)
    public int getTopicId() {
        return topicId;
    }

    /**
     * 设置话题节点 id
     * @param topicId 话题节点 id
     */
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    /**
     * 获取日志操作人员 id
     * @return 日志操作人员 id
     */
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     * 设置日志操作人员 id
     * @param userId 日志操作人员 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取日志事件
     * @return 日志事件
     */
    @Column(name = "event", nullable = false, length = 64)
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
     * 获取日志修改理由
     * @return 日志修改理由
     */
    @Column(name = "reason", nullable = false, columnDefinition = "text")
    public String getReason() {
        return reason;
    }

    /**
     * 设置日志修改理由
     * @param reason 日志修改理由
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
     * 获取日志录时间
     * @return 日志记录时间
     */
    @Column(name = "log_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getLogTime() {
        return logTime;
    }

    /**
     * 设置日志记录时间
     * @param logTime 日志记录时间
     */
    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }
}
