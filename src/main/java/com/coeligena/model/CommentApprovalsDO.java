package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 评论赞同实体类
 *
 * <p>
 * Created by Ellery on 2017/10/20.
 */
@Entity
@Table(name = "comment_approvals")
public class CommentApprovalsDO {

    /** 评论赞同 id */
    private int id;

    /** 被赞同评论 id */
    private int commentId;

    /** 评论赞同类型，1：问题评论，2：回答评论  */
    private byte commentType;

    /** 评论动作类型，1：赞，2：踩  */
    private byte commentAction;

    /** 评论点赞时间 */
    private Timestamp approvalTime;

    /** 点赞用户 id */
    private int userId;

    /**
     * 获取评论赞同 id
     * @return 评论赞同 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置评论赞同 id
     * @param id 评论赞同 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取被点赞评论 id
     * @return 被点赞评论 id
     */
    @Column(name = "comment_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getCommentId() {
        return commentId;
    }

    /**
     * 设置被点赞评论 id
     * @param commentId 被点赞评论 id
     */
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    /**
     * 评论类型
     * @return 评论类型
     */
    @Column(name = "comment_type", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getCommentType() {
        return commentType;
    }

    /**
     * 评论类型
     * @param commentType 评论类型
     */
    public void setCommentType(byte commentType) {
        this.commentType = commentType;
    }

    /**
     * 评论动作类型
     * @return 赞踩
     */
    @Column(name = "comment_action", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getCommentAction() {
        return commentAction;
    }

    /**
     * 设置评论动作类型
     * @param commentAction 赞踩
     */
    public void setCommentAction(byte commentAction) {
        this.commentAction = commentAction;
    }

    /**
     * 获取点赞时间
     * @return 点赞时间
     */
    @Column(name = "approval_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getApprovalTime() {
        return approvalTime;
    }

    /**
     * 设置点赞时间
     * @param approvalTime 点赞时间
     */
    public void setApprovalTime(Timestamp approvalTime) {
        this.approvalTime = approvalTime;
    }

    /**
     * 获取点赞用户 id
     * @return 点赞用户 id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 设置点赞用户 id
     * @param userId 点赞用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
