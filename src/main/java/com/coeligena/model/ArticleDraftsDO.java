package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 专栏文章草稿实体类
 *
 * <p>
 * Created by Ellery on 2017/10/26.
 */
@Entity
@Table(name = "article_drafts")
public class ArticleDraftsDO {

    /** 草稿 id */
    private int id;

    /** 草稿所在专栏 id */
    private int columnId;

    /** 草稿内容 */
    private String draftContent;

    /** 草稿上次更新时间 */
    private Timestamp lastUpdateTime;

    /** 是否匿名 */
    private byte anonymous;

    /** 作者 id */
    private int userId;

    /**
     * 获取草稿 id
     * @return 草稿 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置草稿 id
     * @param id 草稿 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取草稿所在专栏 id
     * @return 草稿所在专栏 id
     */
    @Column(name = "column_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getColumnId() {
        return columnId;
    }

    /**
     * 设置草稿所在专栏 id
     * @param columnId 草稿所在专栏 id
     */
    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取草稿内容
     * @return 草稿内容
     */
    @Column(name = "draft_content", nullable = false, columnDefinition = "mediumtext")
    public String getDraftContent() {
        return draftContent;
    }

    /**
     * 设置草稿内容
     * @param draftContent 草稿内容
     */
    public void setDraftContent(String draftContent) {
        this.draftContent = draftContent;
    }

    /**
     * 获取最后更新时间
     * @return 最后更新时间
     */
    @Column(name = "last_update_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * 设置草稿最后更新时间
     * @param lastUpdateTime 草稿最后更新时间
     */
    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 判断草稿是否匿名
     * @return 草稿是否匿名
     */
    @Column(name = "anonymous", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getAnonymous() {
        return anonymous;
    }

    /**
     * 设置草稿是否匿名
     * @param anonymous 草稿是否匿名
     */
    public void setAnonymous(byte anonymous) {
        this.anonymous = anonymous;
    }

    /**
     * 获取草稿作者 id
     * @return 草稿作者 id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 设置草稿作者 id
     * @param userId 设置草稿作者 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
