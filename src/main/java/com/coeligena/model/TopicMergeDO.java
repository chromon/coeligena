package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 问题话题合并表
 *  合并本话题至意义相近的其他话题。
 *  本话题会被删除，相关内容会自动迁移至目标话题中，同时添加话题别名。
 *  请将不常用的话题合并至常用话题。
 *
 * <p>
 * Created by Ellery on 2017/10/17.
 */
@Entity
@Table(name = "topic_merge")
public class TopicMergeDO {

    /** 话题合并 id */
    private int id;

    /** 合并到话题 id */
    private int mergedToId;

    /** 合并时间 */
    private Timestamp mergedTime;

    /** 话题 id */
    private int topicId;

    /**
     * 获取话题合并 id
     * @return 话题合并 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置话题合并 id
     * @param id 话题合并 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取合并到话题的 id
     * @return 合并到话题的 id
     */
    @Column(name = "merged_to_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getMergedToId() {
        return mergedToId;
    }

    /**
     * 设置合并到话题的 id
     * @param mergedToId 合并到话题的 id
     */
    public void setMergedToId(int mergedToId) {
        this.mergedToId = mergedToId;
    }

    /**
     * 获取合并时间
     * @return 合并时间
     */
    @Column(name = "merged_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getMergedTime() {
        return mergedTime;
    }

    /**
     * 设置合并时间
     * @param mergedTime 合并时间
     */
    public void setMergedTime(Timestamp mergedTime) {
        this.mergedTime = mergedTime;
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
