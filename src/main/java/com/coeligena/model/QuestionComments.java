package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 问题评论实体类
 *
 * <p>
 * Created by Ellery on 2017/9/24.
 */
@Entity
@Table(name = "question_comments")
public class QuestionComments {

    /** 评论 id */
    private int id;

    /** 被评论的问题 id */
    private int questionId;

    /** 发表评论用户 id */
    private int reviewerId;

    /** 被回复评论的 id */
    private int parentCommentId;

    /** 评论内容 */
    private String commentContent;

    /** 评论时间 */
    private Timestamp commentTime;

    /** 是否是精选评论 */
    private byte isFeaturedComments;

    /** 评论赞同数 */
    private int approvalCount;

    /**
     * 获取评论 id
     * @return 评论 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置评论 id
     * @param id 评论 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取被评论的问题 id
     * @return 被评论的问题 id
     */
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    /**
     * 设置被评论的问题 id
     * @param questionId 被评论的问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取发表评论的用户 id
     * @return 发表评论的用户 id
     */
    @Column(name = "reviewer_id", nullable = false)
    public int getReviewerId() {
        return reviewerId;
    }

    /**
     * 设置发表评论的用户 id
     * @param reviewerId 发表评论的用户 id
     */
    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 获取被回复的评论 id
     * @return 被回复的评论 id
     */
    @Column(name = "parent_comment_id", nullable = false)
    public int getParentCommentId() {
        return parentCommentId;
    }

    /**
     * 设置被回复的评论 id
     * @param parentCommentId 被回复的评论 id
     */
    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    /**
     * 获取评论内容
     * @return 评论内容
     */
    @Column(name = "comment_content", nullable = false)
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评论内容
     * @param commentContent 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    /**
     * 获取评论时间
     * @return 评论时间
     */
    @Column(name = "comment_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评论时间
     * @param commentTime 评论时间
     */
    public void setCommentTime(Timestamp commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 判断是否是精品评论
     * @return 是否是精品评论
     */
    @Column(name = "is_featured_comments", nullable = false, columnDefinition = "tinyint")
    public byte getIsFeaturedComments() {
        return isFeaturedComments;
    }

    /**
     * 设置是否是精品评论
     * @param isFeaturedComments 是否是精品评论
     */
    public void setIsFeaturedComments(byte isFeaturedComments) {
        this.isFeaturedComments = isFeaturedComments;
    }

    /**
     * 获取评论赞同数
     * @return 评论赞同数
     */
    @Column(name = "approval_count", nullable = false)
    public int getApprovalCount() {
        return approvalCount;
    }

    /**
     * 设置评论赞同数
     * @param approvalCount 评论赞同数
     */
    public void setApprovalCount(int approvalCount) {
        this.approvalCount = approvalCount;
    }
}