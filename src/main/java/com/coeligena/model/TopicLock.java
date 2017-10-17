package com.coeligena.model;

import javax.persistence.*;

/**
 * 话题编辑锁定实体类
 *
 * <p>
 * Created by Ellery on 2017/10/17.
 */
@Entity
@Table(name = "topic_lock")
public class TopicLock {

    /** 话题编辑锁定 id */
    private int id;

    /** 是否完全锁定 */
    private byte isLockedAll;

    /** 是否锁定话题名称 */
    private byte isLockedName;

    /** 是否锁定话题描述 */
    private byte isLockedIntroduction;

    /** 是否锁定话题图片编辑 */
    private byte isLockedImage;

    /** 是否锁定父话题 */
    private byte isLockedParent;

    /** 是否锁定子话题 */
    private byte isLockedChild;

    /** 话题 id */
    private int topicId;

    /**
     * 获取话题编辑锁定 id
     * @return 话题编辑锁定 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置话题编辑锁定 id
     * @param id 话题编辑锁定 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 判定是否完全锁定
     * @return 是否完全锁定
     */
    @Column(name = "is_locked_all", nullable = false, columnDefinition = "tinyint")
    public byte getIsLockedAll() {
        return isLockedAll;
    }

    /**
     * 设置是否完全锁定
     * @param isLockedAll 是否完全锁定
     */
    public void setIsLockedAll(byte isLockedAll) {
        this.isLockedAll = isLockedAll;
    }

    /**
     * 判定是否锁定话题名称
     * @return 是否锁定话题名称
     */
    @Column(name = "is_locked_name", nullable = false, columnDefinition = "tinyint")
    public byte getIsLockedName() {
        return isLockedName;
    }

    /**
     * 设置是否锁定话题名称
     * @param isLockedName 是否锁定话题名称
     */
    public void setIsLockedName(byte isLockedName) {
        this.isLockedName = isLockedName;
    }

    /**
     * 判定是否锁定话题描述
     * @return 是否锁定话题描述
     */
    @Column(name = "is_locked_introduction", nullable = false, columnDefinition = "tinyint")
    public byte getIsLockedIntroduction() {
        return isLockedIntroduction;
    }

    /**
     * 设置是否锁定话题描述
     * @param isLockedIntroduction 是否锁定话题描述
     */
    public void setIsLockedIntroduction(byte isLockedIntroduction) {
        this.isLockedIntroduction = isLockedIntroduction;
    }

    /**
     * 判断是否锁定话题图片编辑
     * @return 是否锁定话题图片编辑
     */
    @Column(name = "is_locked_image", nullable = false, columnDefinition = "tinyint")
    public byte getIsLockedImage() {
        return isLockedImage;
    }

    /**
     * 设置是否锁定话题图片编辑
     * @param isLockedImage 是否锁定话题图片编辑
     */
    public void setIsLockedImage(byte isLockedImage) {
        this.isLockedImage = isLockedImage;
    }

    /**
     * 判断是否锁定父话题
     * @return 是否锁定父话题
     */
    @Column(name = "is_locked_parent", nullable = false, columnDefinition = "tinyint")
    public byte getIsLockedParent() {
        return isLockedParent;
    }

    /**
     * 设置是否锁定父话题
     * @param isLockedParent 是否锁定父话题
     */
    public void setIsLockedParent(byte isLockedParent) {
        this.isLockedParent = isLockedParent;
    }

    /**
     * 判断是否锁定子话题
     * @return 是否锁定子话题
     */
    @Column(name = "is_locked_child", nullable = false, columnDefinition = "tinyint")
    public byte getIsLockedChild() {
        return isLockedChild;
    }

    /**
     * 设置是否锁定子话题
     * @param isLockedChild 是否锁定子话题
     */
    public void setIsLockedChild(byte isLockedChild) {
        this.isLockedChild = isLockedChild;
    }

    /**
     * 话题话题 id
     * @return 话题 id
     */
    @Column(name = "topic_id", nullable = false)
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
