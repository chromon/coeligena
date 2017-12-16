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
public class TopicLockDO {

    /** 话题编辑锁定 id */
    private int id;

    /** 是否完全锁定 */
    private byte lockedAll;

    /** 是否锁定话题名称 */
    private byte lockedName;

    /** 是否锁定话题描述 */
    private byte lockedIntroduction;

    /** 是否锁定话题图片编辑 */
    private byte lockedImage;

    /** 是否锁定父话题 */
    private byte lockedParent;

    /** 是否锁定子话题 */
    private byte lockedChild;

    /** 话题 id */
    private int topicId;

    /**
     * 获取话题编辑锁定 id
     * @return 话题编辑锁定 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "locked_all", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLockedAll() {
        return lockedAll;
    }

    /**
     * 设置是否完全锁定
     * @param lockedAll 是否完全锁定
     */
    public void setLockedAll(byte lockedAll) {
        this.lockedAll = lockedAll;
    }

    /**
     * 判定是否锁定话题名称
     * @return 是否锁定话题名称
     */
    @Column(name = "locked_name", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLockedName() {
        return lockedName;
    }

    /**
     * 设置是否锁定话题名称
     * @param lockedName 是否锁定话题名称
     */
    public void setLockedName(byte lockedName) {
        this.lockedName = lockedName;
    }

    /**
     * 判定是否锁定话题描述
     * @return 是否锁定话题描述
     */
    @Column(name = "locked_introduction", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLockedIntroduction() {
        return lockedIntroduction;
    }

    /**
     * 设置是否锁定话题描述
     * @param lockedIntroduction 是否锁定话题描述
     */
    public void setLockedIntroduction(byte lockedIntroduction) {
        this.lockedIntroduction = lockedIntroduction;
    }

    /**
     * 判断是否锁定话题图片编辑
     * @return 是否锁定话题图片编辑
     */
    @Column(name = "locked_image", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLockedImage() {
        return lockedImage;
    }

    /**
     * 设置是否锁定话题图片编辑
     * @param lockedImage 是否锁定话题图片编辑
     */
    public void setLockedImage(byte lockedImage) {
        this.lockedImage = lockedImage;
    }

    /**
     * 判断是否锁定父话题
     * @return 是否锁定父话题
     */
    @Column(name = "locked_parent", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLockedParent() {
        return lockedParent;
    }

    /**
     * 设置是否锁定父话题
     * @param lockedParent 是否锁定父话题
     */
    public void setLockedParent(byte lockedParent) {
        this.lockedParent = lockedParent;
    }

    /**
     * 判断是否锁定子话题
     * @return 是否锁定子话题
     */
    @Column(name = "locked_child", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLockedChild() {
        return lockedChild;
    }

    /**
     * 设置是否锁定子话题
     * @param lockedChild 是否锁定子话题
     */
    public void setLockedChild(byte lockedChild) {
        this.lockedChild = lockedChild;
    }

    /**
     * 话题话题 id
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
