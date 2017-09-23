package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 动态实体类
 *
 * <p>
 * Created by Ellery on 2017/9/23.
 */
@Entity
@Table(name = "feeds")
public class Feeds {

    // 动态 id
    private int id;

    // 动态类型所对应的 id,
    // 如关注和提出问题对应的是问题 id
    // 赞同答案和回答问题对应的是答案 id
    private int feedsId;

    // 动态类型
    // 1：关注该问题，2：赞同该回答，
    // 3：回答了该问题，4：提了一个问题
    private String feedsType;

    // 父动态类型所对应的 id，
    // 赞同答案和回答问题对应的是问题 id
    private int parentFeedsId;

    // 父动态类型
    // 1：赞同该回答——对应问题，
    // 2：回答了该问题——对应问题
    private String parentFeedsType;

    // 动态产生时间
    private Timestamp feedsTime;

    // 动态发起人
    private int feedsUserId;

    /**
     * 获取动态 id
     * @return 动态 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置动态 id
     * @param id 动态 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取动态类型所对应的 id
     *  如关注和提出问题对应的是问题 id，赞同答案和回答问题对应的是答案 id
     * @return 问题或答案 id
     */
    @Column(name = "feeds_id", nullable = false)
    public int getFeedsId() {
        return feedsId;
    }

    /**
     * 设置动态类型所对应的 id
     * @param feedsId 动态类型对应的 id
     */
    public void setFeedsId(int feedsId) {
        this.feedsId = feedsId;
    }

    /**
     * 获取动态类型
     * 1：关注该问题，2：赞同该回答，3：回答了该问题，4：提了一个问题
     * @return 动态类型
     */
    @Column(name = "feeds_type", nullable = false, length = 64)
    public String getFeedsType() {
        return feedsType;
    }

    /**
     * 设置动态类型
     * @param feedsType 动态类型
     */
    public void setFeedsType(String feedsType) {
        this.feedsType = feedsType;
    }

    /**
     * 父动态类型所对应的 id，赞同答案和回答问题对应的是问题ID
     * @return 父动态类型所对应的 id
     */
    @Column(name = "parent_feeds_id", nullable = false)
    public int getParentFeedsId() {
        return parentFeedsId;
    }

    /**
     * 设置父动态类型所对应的 id
     * @param parentFeedsId 父动态类型所对应的 id
     */
    public void setParentFeedsId(int parentFeedsId) {
        this.parentFeedsId = parentFeedsId;
    }

    /**
     * 父动态类型
     * 1：赞同该回答 —— 对应问题，2：回答了该问题 —— 对应问题
     * @return 父动态类型
     */
    @Column(name = "parent_feeds_type", nullable = false, length = 64)
    public String getParentFeedsType() {
        return parentFeedsType;
    }

    /**
     * 设置父动态类型
     * @param parentFeedsType 父动态类型
     */
    public void setParentFeedsType(String parentFeedsType) {
        this.parentFeedsType = parentFeedsType;
    }

    /**
     * 获取动态时间
     * @return 动态时间
     */
    @Column(name = "feeds_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    public Timestamp getFeedsTime() {
        return feedsTime;
    }

    /**
     * 设置动态时间
     * @param feedsTime 动态时间
     */
    public void setFeedsTime(Timestamp feedsTime) {
        this.feedsTime = feedsTime;
    }

    /**
     * 获取动态发起人 id
     * @return 动态发起人 id
     */
    @Column(name = "feeds_user_id", nullable = false)
    public int getFeedsUserId() {
        return feedsUserId;
    }

    /**
     * 设置动态发起人 id
     * @param feedsUserId 动态发起人 id
     */
    public void setFeedsUserId(int feedsUserId) {
        this.feedsUserId = feedsUserId;
    }
}