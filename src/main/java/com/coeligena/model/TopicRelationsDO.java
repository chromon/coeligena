package com.coeligena.model;

import javax.persistence.*;

/**
 * 话题关系实体类
 *
 * <p>
 * Created by Ellery on 2017/10/17.
 */
@Entity
@Table(name = "topic_relations")
public class TopicRelationsDO {

    /** 话题关系 id */
    private int id;

    /** 父话题 id */
    private int parentTopicId;

    /** 子话题 id */
    private int childTopicId;

    /**
     * 获取话题关系 id
     * @return 话题关系 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置话题关系 id
     * @param id 话题关系 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取父话题 id
     * @return 父话题 id
     */
    @Column(name = "parent_topic_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getParentTopicId() {
        return parentTopicId;
    }

    /**
     * 设置父话题 id
     * @param parentTopicId 父话题 id
     */
    public void setParentTopicId(int parentTopicId) {
        this.parentTopicId = parentTopicId;
    }

    /**
     * 获取子话题 id
     * @return 子话题 id
     */
    @Column(name = "child_topic_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getChildTopicId() {
        return childTopicId;
    }

    /**
     * 设置子话题 id
     * @param childTopicId 子话题 id
     */
    public void setChildTopicId(int childTopicId) {
        this.childTopicId = childTopicId;
    }
}
