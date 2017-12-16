package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 专栏实体类
 *
 * <p>
 * Created by Ellery on 2017/10/25.
 */
@Entity
@Table(name = "columns")
public class ColumnsDO {

    /** 专栏 id */
    private int id;

    /** 专栏名称 */
    private String columnName;

    /** 专栏介绍 */
    private String columnIntro;

    /** 专栏关注人数 */
    private int columnFollowersCount;

    /** 专栏文章数 */
    private int articleCount;

    /** 专栏创建时间 */
    private Timestamp columnCreateTime;

    /** 专栏是否被锁定 0：否，1：是 */
    private byte locked;

    /** 专栏作者 id */
    private int columnAuthorId;

    /**
     * 获取专栏 id
     * @return 专栏 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置专栏 id
     * @param id 专栏 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取专栏名称
     * @return 专栏名称
     */
    @Column(name = "column_name", nullable = false, length = 128, columnDefinition = "varchar(128)")
    public String getColumnName() {
        return columnName;
    }

    /**
     * 设置专栏名称
     * @param columnName 专栏名称
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * 获取专栏介绍
     * @return 专栏介绍
     */
    @Column(name = "column_intro", nullable = false, length = 256, columnDefinition = "varchar(256)")
    public String getColumnIntro() {
        return columnIntro;
    }

    /**
     * 设置专栏介绍
     * @param columnIntro 专栏介绍
     */
    public void setColumnIntro(String columnIntro) {
        this.columnIntro = columnIntro;
    }

    /**
     * 获取专栏关注人数
     * @return 专栏关注人数
     */
    @Column(name = "column_followers_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getColumnFollowersCount() {
        return columnFollowersCount;
    }

    /**
     * 设置专栏关注人数
     * @param columnFollowersCount 专栏关注人数
     */
    public void setColumnFollowersCount(int columnFollowersCount) {
        this.columnFollowersCount = columnFollowersCount;
    }

    /**
     * 获取专栏文章数
     * @return 专栏文章数
     */
    @Column(name = "article_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getArticleCount() {
        return articleCount;
    }

    /**
     * 设置专栏文章数
     * @param articleCount 专栏文章数
     */
    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    /**
     * 设置专栏创建时间
     * @return 专栏创建时间
     */
    @Column(name = "column_create_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    public Timestamp getColumnCreateTime() {
        return columnCreateTime;
    }

    /**
     * 获取专栏创建时间
     * @param columnCreateTime 专栏创建时间
     */
    public void setColumnCreateTime(Timestamp columnCreateTime) {
        this.columnCreateTime = columnCreateTime;
    }

    /**
     * 获取专栏是否锁定，0：否，1：是
     * @return 专栏是否锁定
     */
    @Column(name = "locked", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLocked() {
        return locked;
    }

    /**
     * 设置专栏锁定
     * @param locked 专栏是否锁定
     */
    public void setLocked(byte locked) {
        this.locked = locked;
    }

    /**
     * 获取专栏作者 id
     * @return 专栏作者 id
     */
    @Column(name = "column_author_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getColumnAuthorId() {
        return columnAuthorId;
    }

    /**
     * 设置专栏作者 id
     * @param columnAuthorId 专栏作者 id
     */
    public void setColumnAuthorId(int columnAuthorId) {
        this.columnAuthorId = columnAuthorId;
    }
}
