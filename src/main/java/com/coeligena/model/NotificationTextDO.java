package com.coeligena.model;

import javax.persistence.*;

/**
 * 公共提醒内容实体类
 *
 * <p>
 * Created by Ellery on 2017/10/27.
 */
@Entity
@Table(name = "notification_text")
public class NotificationTextDO {

    /** 提醒内容 id */
    private int id;

    /** 提醒内容 */
    private String content;

    /**
     * 获取提醒内容 id
     * @return 提醒内容 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置提醒内容 id
     * @param id 设置提醒内容 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取消息内容
     * @return 消息内容
     */
    @Column(name = "content", nullable = false, columnDefinition = "text")
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
