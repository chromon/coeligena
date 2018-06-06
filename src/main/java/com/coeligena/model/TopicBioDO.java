package com.coeligena.model;

import javax.persistence.*;

/**
 * 话题经验实体类
 *
 * <p>
 * Created by Ellery on 2018/6/6.
 */
@Entity
@Table(name = "topic_bio")
public class TopicBioDO {

    /** 话题经验 id */
    private int id;

    /** 父话题 id */
    private int topicId;

    /** 用户 id */
    private int userId;

    /**
     * 获取话题经验 id
     * @return 话题经验 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置话题经验 id
     * @param id 话题经验 id
     */
    public void setId(int id) {
        this.id = id;
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

    /**
     * 获取用户 id
     * @return 用户id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 设置用户 id
     * @param userId 用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
