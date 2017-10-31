package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 问题话题节点实体类
 *
 * <p>
 * Created by Ellery on 2017/10/17.
 */
@Entity
@Table(name = "topic_nodes")
public class TopicNodesDO {

    /** 话题节点 id */
    private int id;

    /** 话题名称 */
    private String topicName;

    /** 话题描述 */
    private String topicIntroduction;

    /** 话题图片路径 */
    private String imagePath;

    /** 话题关注者数量 */
    private int followCount;

    /** 话题创建时间 */
    private Timestamp createTime;

    /** 是否合并到其他节点，0：否，1：是 */
    private byte mergedTo;

    /**
     * 获取话题节点 id
     * @return 话题节点 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置话题节点 id
     * @param id 话题节点 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取话题名称
     * @return 话题名称
     */
    @Column(name = "topic_name", nullable = false, length = 256, columnDefinition = "varchar(256)")
    public String getTopicName() {
        return topicName;
    }

    /**
     * 设置话题名称
     * @param topicName 话题名称
     */
    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * 获取话题描述
     * @return 话题描述
     */
    @Column(name = "topic_introduction", nullable = false, columnDefinition = "text default ''")
    public String getTopicIntroduction() {
        return topicIntroduction;
    }

    /**
     * 设置话题描述
     * @param topicIntroduction 话题描述
     */
    public void setTopicIntroduction(String topicIntroduction) {
        this.topicIntroduction = topicIntroduction;
    }

    /**
     * 获取话题图片路径
     * @return 话题图片路径
     */
    @Column(name = "image_path", nullable = false, length = 512, columnDefinition = "varchar(512) default ''")
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 设置话题图片路径
     * @param imagePath 话题图片路径
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * 获取话题关注数量
     * @return 话题关注数量
     */
    @Column(name = "follow_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getFollowCount() {
        return followCount;
    }

    /**
     * 设置话题关注数量
     * @param followCount
     */
    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }

    /**
     * 获取话题创建时间
     * @return 话题创建时间
     */
    @Column(name = "create_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 设置话题创建时间
     * @param createTime 话题创建时间
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 判断是否合并到其他话题节点
     * @return 是否
     */
    @Column(name = "merged_to", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getMergedTo() {
        return mergedTo;
    }

    /**
     * 设置是否合并到其他话题节点
     * @param mergedTo 是否
     */
    public void setMergedTo(byte mergedTo) {
        this.mergedTo = mergedTo;
    }
}
