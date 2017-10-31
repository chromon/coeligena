package com.coeligena.model;

import javax.persistence.*;

/**
 * 话题别名实体类
 *
 * <p>
 * Created by Ellery on 2017/10/18.
 */
@Entity
@Table(name = "topic_alias")
public class TopicAliasDO {

    /** 话题别名 id */
    private int id;

    /** 话题别名 */
    private String topicAlias;

    /** 话题 id */
    private int topicId;

    /**
     * 获取话题别名 id
     * @return 话题别名 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置话题别名 id
     * @param id 话题别名 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取话题别名
     * @return 话题别名
     */
    @Column(name = "topic_alias", nullable = false, length = 256, columnDefinition = "varchar(256)")
    public String getTopicAlias() {
        return topicAlias;
    }

    /**
     * 设置话题别名
     * @param topicAlias 话题别名
     */
    public void setTopicAlias(String topicAlias) {
        this.topicAlias = topicAlias;
    }

    /**
     * 获取话题 id
     * @return 话题 id
     */
    @Column(name = "topic_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getTopicId() {
        return topicId;
    }

    /**
     * 设置话题 id
     * @param topicId 话题 id
     */
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}
