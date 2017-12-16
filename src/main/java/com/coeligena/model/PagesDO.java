package com.coeligena.model;

import javax.persistence.*;

/**
 * 页面信息表
 *
 * <p>
 * Created by Ellery on 2017/10/30.
 */
@Entity
@Table(name = "pages")
public class PagesDO {

    /** 页面信息 id */
    private int  id;

    /** 页面 url */
    private String urlToken;

    /** 页面 title */
    private String title;

    /** 页面关键字 */
    private String keywords;

    /** 页面描述 */
    private String description;

    /** 页面 content 信息 */
    private String contents;

    /** 页面是否可用 */
    private int enabled;

    /**
     * 获取页面信息 id
     * @return 页面信息 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置页面信息 id
     * @param id 页面信息 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取页面 url
     * @return 页面 url
     */
    @Column(name = "url_token", nullable = false, length = 32, columnDefinition = "varchar(32)")
    public String getUrlToken() {
        return urlToken;
    }

    /**
     * 设置页面 rul
     * @param urlToken 页面 url
     */
    public void setUrlToken(String urlToken) {
        this.urlToken = urlToken;
    }

    /**
     * 获取页面 title
     * @return 页面 title
     */
    @Column(name = "title", length = 256, columnDefinition = "varchar(256) default ''")
    public String getTitle() {
        return title;
    }

    /**
     * 设置页面 title
     * @param title 页面 title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取页面关键字
     * @return 页面关键字
     */
    @Column(name = "keywords", length = 256, columnDefinition = "varchar(256) default ''")
    public String getKeywords() {
        return keywords;
    }

    /**
     * 设置页面关键字
     * @param keywords 页面关键字
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * 获取页面描述
     * @return 页面描述
     */
    @Column(name = "description", length = 256, columnDefinition = "varchar(256) default ''")
    public String getDescription() {
        return description;
    }

    /**
     * 设置页面描述
     * @param description 页面描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取页面 content 信息
     * @return 页面 content 信息
     */
    @Column(name = "contents", columnDefinition = "text")
    public String getContents() {
        return contents;
    }

    /**
     * 设置页面 content 信息
     * @param contents 页面 content 信息
     */
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
     * 判断页面是否可用
     * @return 页面是否可用
     */
    @Column(name = "enabled", nullable = false, columnDefinition = "int(11) default '0'")
    public int getEnabled() {
        return enabled;
    }

    /**
     * 设置页面是否可用
     * @param enabled 页面是否可用
     */
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
