package com.coeligena.model;

import javax.persistence.*;

/**
 * 专栏主题实体类
 *
 * <p>
 * Created by Ellery on 2017/10/26.
 */
@Entity
@Table(name = "column_topics")
public class ColumnTopicsDO {

    /** 专栏主题 id */
    private int id;

    /** 专栏主题名称 */
    private String topicName;

    /** 专栏主题包含文章数 */
    private int articleCount;

    /** 专栏 id */
    private int columnId;

    /**
     * 获取专栏主题
     * @return 专栏主题 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置专栏主题
     * @param id 专栏主题 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取专栏主题名称
     * @return 专栏主题名称
     */
    @Column(name = "topic_name", nullable = false, length = 64)
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置专栏主题名称
     * @param topicName 专栏主题名称
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * 获取专栏主题包含文章数
     * @return 专栏主题包含文章数
     */
    @Column(name = "article_count", nullable = false)
    public int getArticleCount() {
        return articleCount;
    }

    /**
     * 设置专栏主题包含文章数
     * @param articleCount 专栏主题包含文章数
     */
    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    /**
     * 获取所属专栏
     * @return 所属专栏 id
     */
    @Column(name = "column_id", nullable = false)
    public int getColumnId() {
        return columnId;
    }

    /**
     * 设置主题所属专栏
     * @param columnId 专栏 id
     */
    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }
}
