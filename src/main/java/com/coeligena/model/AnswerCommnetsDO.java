package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 回答评论实体类
 *
 * <p>
 * Created by Ellery on 2017/10/20.
 */
@Entity
@Table(name = "answer_comments")
public class AnswerCommnetsDO {

    /** 评论 id */
    private int id;

    /** 被评论回答 id */
    private int answerId;

    /** 评论用户 id */
    private int reviewerId;

    /** 被回复评论 id */
    private int parentCommentId;

    /** 评论内容 */
    private String commentContent;

    /** 评论时间 */
    private Timestamp commentTime;

    /** 评论赞同数 */
    private int approvalCount;

    /** 是否是精选评论 0：否，1：是 */
    private byte featuredComment;

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
     * 获取回答 id
     * @return 回答 id
     */
    @Column(name = "answer_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 设置回答 id
     * @param answerId 回答 id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取评论用户 id
     * @return 评论用户 id
     */
    @Column(name = "reviewer_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getReviewerId() {
        return reviewerId;
    }

    /**
     * 设置评论用户 id
     * @param reviewerId 评论用户 id
     */
    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    /**
     * 获取被回复评论的id
     * @return 被回复评论的 id
     */
    @Column(name = "parent_comment_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getParentCommentId() {
        return parentCommentId;
    }

    /**
     * 设置被回复评论的 id
     * @param parentCommentId 被回复评论的 id
     */
    public void setParentCommentId(int parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    /**
     * 获取评论内容
     * @return 评论内容
     */
    @Column(name = "comment_content", nullable = false, columnDefinition = "text")
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
    @Column(name = "comment_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
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
     * 获取赞同数
     * @return 赞同数
     */
    @Column(name = "approval_count", nullable = false, columnDefinition = "int(11) default '0'")
    public int getApprovalCount() {
        return approvalCount;
    }

    /**
     * 设置赞同数
     * @param approvalCount 赞同数
     */
    public void setApprovalCount(int approvalCount) {
        this.approvalCount = approvalCount;
    }

    /**
     * 判断是否是精选评论
     * @return 是否是精选评论
     */
    @Column(name = "featured_comment", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getFeaturedComment() {
        return featuredComment;
    }

    /**
     * 设置是否是精选评论
     * @param featuredComment 是否是精选评论
     */
    public void setFeaturedComment(byte featuredComment) {
        this.featuredComment = featuredComment;
    }
}
