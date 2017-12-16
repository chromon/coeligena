package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 专栏文章实体类
 *
 * <p>
 * Created by Ellery on 2017/10/26.
 */
@Entity
@Table(name = "articles")
public class ArticlesDO {

    /** 专栏文章 id */
    private int id;

    /** 文章标题 */
    private String articleTitle;

    /** 文章正文 */
    private String articleContent;

    /** 文章题图 */
    private String titleImage;

    /** 创作时间 */
    private Timestamp composeTime;

    /** 文章更新时间 */
    private Timestamp composeUpdateTime;

    /** 评论数量 */
    private int commentsCount;

    /** 浏览数量 */
    private int viewsCount;

    /** 点赞数量 */
    private int approvalCount;

    /** 文章是否被锁定 */
    private byte locked;

    /** 专栏 id */
    private int columnId;

    /** 文章作者 id */
    private int author_id;

    /**
     * 获取文章 id
     * @return 文章 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置文章 id
     * @param id 文章 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取文章标题
     * @return 文章标题
     */
    @Column(name = "article_title", nullable = false, length = 256, columnDefinition = "varchar(256)")
    public String getArticleTitle() {
        return articleTitle;
    }

    /**
     * 设置文章标题
     * @param articleTitle 文章标题
     */
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    /**
     * 获取文章正文
     * @return 文章正文
     */
    @Column(name = "article_content", nullable = false, columnDefinition = "mediumtext")
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 设置文章正文
     * @param articleContent 文章正文
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    /**
     * 获取文章题图
     * @return 文章题图路径
     */
    @Column(name = "title_image", length = 256, columnDefinition = "varchar(256) default ''")
    public String getTitleImage() {
        return titleImage;
    }

    /**
     * 设置文章题图
     * @param titleImage 文章题图路径
     */
    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    /**
     * 获取文章创作时间
     * @return 文章创作时间
     */
    @Column(name = "compose_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    public Timestamp getComposeTime() {
        return composeTime;
    }

    /**
     * 设置文章创作时间
     * @param composeTime 文章创作时间
     */
    public void setComposeTime(Timestamp composeTime) {
        this.composeTime = composeTime;
    }

    /**
     * 获取文章更新时间
     * @return 文章更新时间
     */
    @Column(name = "compose_update_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getComposeUpdateTime() {
        return composeUpdateTime;
    }

    /**
     * 设置文章更新时间
     * @param composeUpdateTime 文章更新时间
     */
    public void setComposeUpdateTime(Timestamp composeUpdateTime) {
        this.composeUpdateTime = composeUpdateTime;
    }

    /**
     * 获取评论数量
     * @return 评论数量
     */
    @Column(name = "comments_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getCommentsCount() {
        return commentsCount;
    }

    /**
     * 设置评论数量
     * @param commentsCount 评论数量
     */
    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    /**
     * 获取文章浏览数量
     * @return 文章浏览数量
     */
    @Column(name = "views_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getViewsCount() {
        return viewsCount;
    }

    /**
     * 设置文章浏览数量
     * @param viewsCount 文章浏览数量
     */
    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    /**
     * 获取赞同数量
     * @return 文章点赞数量
     */
    @Column(name = "approval_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getApprovalCount() {
        return approvalCount;
    }

    /**
     * 设置文章点赞数量
     * @param approvalCount 文章点赞数量
     */
    public void setApprovalCount(int approvalCount) {
        this.approvalCount = approvalCount;
    }

    /**
     * 判断文章是否锁定
     * @return 是否被锁定
     */
    @Column(name ="locked", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLocked() {
        return locked;
    }

    /**
     * 设置文章锁定
     * @param locked 文章是否锁定
     */
    public void setLocked(byte locked) {
        this.locked = locked;
    }

    /**
     * 获取文章所属专栏 id
     * @return 专栏 id
     */
    @Column(name = "column_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getColumnId() {
        return columnId;
    }

    /**
     * 设置文章所属专栏 id
     * @param columnId 专栏 id
     */
    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    /**
     * 获取文章作者
     * @return 文章作者 id
     */
    @Column(name = "author_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getAuthor_id() {
        return author_id;
    }

    /**
     * 设置文章作者
     * @param author_id 文章作者 id
     */
    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}
