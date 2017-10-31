package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 私信消息实体类
 *
 * <p>
 * Created by Ellery on 2017/10/27.
 */
@Entity
@Table(name = "private_messages")
public class PrivateMessagesDO {

    /** 用户消息 id */
    private int id;

    /** 发送用户 id */
    private int senderId;

    /** 接收用户 id */
    private int recipientId;

    /** 消息内容 id */
    private int textId;

    /** 发送时间 */
    private Timestamp sendTime;

    /** 阅读时间 */
    private Timestamp readTime;

    /** 消息类型 */
    private String messageType;

    /** 发送用户是否删除 */
    private byte senderIsDel;

    /** 接收用户是否删除 */
    private byte recipientIsDel;

    /** 消息是否已读 */
    private byte unRead;

    /**
     * 获取用户消息 id
     * @return 用户消息 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置用户消息 id
     * @param id 用户消息 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取发送用户
     * @return 发送用户 id
     */
    @Column(name = "sender_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getSenderId() {
        return senderId;
    }

    /**
     * 设置发送用户
     * @param senderId 发送用户 id
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    /**
     * 获取接收用户 id
     * @return 接收用户 id
     */
    @Column(name = "recipient_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getRecipientId() {
        return recipientId;
    }

    /**
     * 设置接收用户 id
     * @param recipientId 接收用户 id
     */
    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    /**
     * 获取消息内容
     * @return 消息内容 id
     */
    @Column(name = "text_id", nullable = false, columnDefinition = "int(11) default '0'")
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
     * 获取发送时间
     * @return 发送时间
     */
    @Column(name = "send_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    public Timestamp getSendTime() {
        return sendTime;
    }

    /**
     * 设置发送时间
     * @param sendTime 发送时间
     */
    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    /**
     * 获取阅读时间
     * @return 阅读时间
     */
    @Column(name = "read_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getReadTime() {
        return readTime;
    }

    /**
     * 设置阅读时间
     * @param readTime 阅读时间
     */
    public void setReadTime(Timestamp readTime) {
        this.readTime = readTime;
    }

    /**
     * 获取消息类型
     * @return 消息类型
     */
    @Column(name = "message_type", nullable = false, length = 64, columnDefinition = "varchar(64)")
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
     * 判断发送用户是否删除
     * @return 发送用户是否删除
     */
    @Column(name = "sender_isdel", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getSenderIsDel() {
        return senderIsDel;
    }

    /**
     * 设置发送用户是否删除
     * @param senderIsDel 发送用户是否删除
     */
    public void setSenderIsDel(byte senderIsDel) {
        this.senderIsDel = senderIsDel;
    }

    /**
     * 判断接收用户是否删除
     * @return 接收用户是否删除
     */
    @Column(name = "recipient_isdel", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getRecipientIsDel() {
        return recipientIsDel;
    }

    /**
     * 设置接收用户是否删除
     * @param recipientIsDel
     */
    public void setRecipientIsDel(byte recipientIsDel) {
        this.recipientIsDel = recipientIsDel;
    }

    /**
     * 判断是否已读
     * @return 是否已读
     */
    @Column(name = "unread", nullable = false, columnDefinition = "tinyint(4) default '1'")
    public byte getUnRead() {
        return unRead;
    }

    /**
     * 设置是否已读
     * @param unRead 是否已读
     */
    public void setUnRead(byte unRead) {
        this.unRead = unRead;
    }
}
