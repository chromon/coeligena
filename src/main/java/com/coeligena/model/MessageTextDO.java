package com.coeligena.model;

import javax.persistence.*;

/**
 * 私信内容实体类
 *
 * <p>
 * Created by Ellery on 2017/10/27.
 */
@Entity
@Table(name = "message_text")
public class MessageTextDO {

    /** 私信内容 id */
    private int id;

    /** 私信内容 */
    private String content;

    /**
     * 获取私信内容 id
     * @return 私信内容 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置私信内容 id
     * @param id 私信内容 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取私信内容
     * @return 私信内容
     */
    @Column(name = "content", nullable = false, columnDefinition = "text")
    public String getContent() {
        return content;
    }

    /**
     * 设置私信内容
     * @param content 私信内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}
