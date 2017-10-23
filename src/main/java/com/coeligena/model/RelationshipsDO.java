package com.coeligena.model;

import javax.persistence.*;

/**
 * 用户关注关系实体类
 *
 * <p>
 * 用户之间关系：
 *  关注
 *  粉丝
 *  双向关注(互粉)
 *  无关系
 *
 * <p>
 * 查询关注列表
 * 查询粉丝列表
 * 查询双向关注列表
 * 判断两个用户的关系
 * 查询带关系状态的任一列表
 *
 * <p>
 * Created by Ellery on 2017/9/21.
 */
@Entity
@Table(name = "relationships")
public class RelationshipsDO {

    /** 用户关系 id */
    private int id;

    /** 用户 id */
    private int userId;

    /** 当前用户关注的人 id */
    private int followedId;

    /**
     * 获取用户关系 id
     * @return 用户关系 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置用户关系 id
     * @param id 用户关系 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取用户 id
     * @return 用户 id
     */
    @Column(name = "user_id", nullable = false)
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

    /**
     * 获取被当前用户关注者 id
     * @return 被当前用户关注者 id
     */
    @Column(name = "followed_id", nullable = false)
    public int getFollowedId() {
        return followedId;
    }

    /**
     * 设置被当前用户关注者 id
     * @param followedId 被当前用户关注者 id
     */
    public void setFollowedId(int followedId) {
        this.followedId = followedId;
    }
}
