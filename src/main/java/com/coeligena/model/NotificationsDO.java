package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 公共提醒消息实体类
 *
 * <p>
 * Created by Ellery on 2017/10/27.
 */
@Entity
@Table(name = "notifications")
public class NotificationsDO {

    /** 公共消息 id */
    private int id;

    /** 消息内容 id */
    private int textId;

    /** 消息发送时间 */
    private Timestamp sendTime;

    /** 消息阅读时间 */
    private Timestamp readTime;

    /** 消息类型 */
    private String messageType;

    /** 是否已读 */
    private byte isRead;

    /** 关注问题的用户组  0:默认所有人 */
    private int messageGroupId;

    /**
     * 获取公共消息 id
     * @return 公共消息 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置公共消息 id
     * @param id 公共消息 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取消息内容
     * @return 消息内容 id
     */
    @Column(name = "text_id", nullable = false)
    public int getTextId() {
        return textId;
    }

    /**
     * 设置消息内容
     * @param textId 消息内容 id
     */
    public void setTextId(int textId) {
        this.textId = textId;
    }

    /**
     * 获取消息发送时间
     * @return 消息发送时间
     */
    @Column(name = "send_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getSendTime() {
        return sendTime;
    }

    /**
     * 设置消息发送时间
     * @param sendTime 消息发送时间
     */
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取消息阅读时间
     * @return 消息阅读时间
     */
    @Column(name = "read_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getReadTime() {
        return readTime;
    }

    /**
     * 设置消息阅读时间
     * @param readTime 消息阅读时间
     */
    public void setReadTime(Timestamp readTime) {
        this.readTime = readTime;
    }

    /**
     * 获取消息类型
     * @return 消息类型
     */
    @Column(name = "message_type", nullable = false, length = 64)
    public String getMessageType() {
        return messageType;
    }

    /**
     * 设置消息类型
     * @param messageType 消息类型
     */
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    /**
     * 判断是否已读
     * @return 是否已读
     */
    @Column(name = "is_read", nullable = false, columnDefinition = "tinyint")
    public byte getIsRead() {
        return isRead;
    }

    /**
     * 设置是否已读
     * @param isRead 是否已读
     */
    public void setIsRead(byte isRead) {
        this.isRead = isRead;
    }

    /**
     * 获取关注问题的用户组
     * @return 关注问题的用户组 id
     */
    @Column(name = "message_group_id", nullable = false)
    public int getMessageGroupId() {
        return messageGroupId;
    }

    /**
     * 设置关注问题的用户组
     * @param messageGroupId 关注问题的用户组 id
     */
    public void setMessageGroupId(int messageGroupId) {
        this.messageGroupId = messageGroupId;
    }
}
