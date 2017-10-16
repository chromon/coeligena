package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 问题关注实体类
 *
 * <p>
 * Created by Ellery on 2017/9/23.
 */
@Entity
@Table(name = "follow")
public class Follow {

    // 问题关注标识 id
    private int id;

    // 被关注的问题 id
    private int questionId;

    // 问题关注人 id
    private int followerId;

    // 关注时间
    private Timestamp followTime;

    /**
     * 获取问题关注 id
     * @return 问题关注 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置问题关注 id
     * @param id 问题关注 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取被关注的问题 id
     * @return 被关注的问题 id
     */
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    /**
     * 设置被关注的问题 id
     * @param questionId 被关注的问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取问题关注人的 id
     * @return 问题关注人的 id
     */
    @Column(name = "follower_id", nullable = false)
    public int getFollowerId() {
        return followerId;
    }

    /**
     * 设置问题关注人 id
     * @param followerId 问题关注人 id
     */
    public void setFollowerId(int followerId) {
        this.followerId = followerId;
    }

    /**
     * 获取关注时间
     * @return 关注时间
     */
    @Column(name = "follow_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getFollowTime() {
        return followTime;
    }

    /**
     * 设置关注时间
     * @param followTime 关注时间
     */
    public void setFollowTime(Timestamp followTime) {
        this.followTime = followTime;
    }
}
