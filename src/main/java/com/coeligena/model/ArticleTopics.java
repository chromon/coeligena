package com.coeligena.model;

import javax.persistence.*;

/**
 * 专栏文章主题关联实体类
 *
 * <p>
 * Created by Ellery on 2017/10/26.
 */
@Entity
@Table(name = "article_topics")
public class ArticleTopics {

    /** 文章主题 id */
    private int id;

    /** 专栏主题 id */
    private int columnTopicId;

    /** 文章 id */
    private int articleId;

    /**
     * 获取文章主题
     * @return 文章主题 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置文章主题
     * @param id 文章主题 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取专栏主题
     * @return 专栏主题 id
     */
    @Column(name = "column_topic_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getColumnTopicId() {
        return columnTopicId;
    }

    /**
     * 设置专栏主题
     * @param columnTopicId 专栏主题
     */
    public void setColumnTopicId(int columnTopicId) {
        this.columnTopicId = columnTopicId;
    }

    /**
     * 获取文章
     * @return 文章 id
     */
    @Column(name = "article_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getArticleId() {
        return articleId;
    }

    /**
     * 设置文章
     * @param articleId 文章 id
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
}
