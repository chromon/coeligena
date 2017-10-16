package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 问题实体类
 *
 * <p>
 * Created by Ellery on 2017/9/22.
 */
@Entity
@Table(name = "questions")
public class Questions {

    // 问题 id
    private int id;

    // 问题标题
    private String questionContent;

    // 问题内容
    private String questionDetail;

    // 提问时间
    private Timestamp questionTime;

    // 修改时间
    private Timestamp updateTime;

    // 答案数
    private int answerCount;

    // 浏览数
    private int viewCount;

    // 关注人数
    private int followerCount;

    // 评论数
    private int commentCount;

    // 提问 IP
    private String questionIP;

    // 问题是否被锁定
    private byte isLocked;

    // 是否匿名 1：是， 0：否
    private byte isAnonymous;

    // 是否是推荐问题
    private byte isRecommend;

    // 提问用户 id
    private int userId;

    /**
     * 获取问题 id
     * @return 问题 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置问题 id
     * @param id 问题 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取问题标题
     * @return 问题标题
     */
    @Column(name = "question_content", nullable = false, length = 256)
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * 设置问题标题
     * @param questionContent 问题标题
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    /**
     * 获取问题详情
     * @return 问题详情
     */
    @Column(name = "question_detail", nullable = false)
    public String getQuestionDetail() {
        return questionDetail;
    }

    /**
     * 设置问题详情
     * @param questionDetail 问题详情
     */
    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    /**
     * 获取答案数
     * @return 答案数
     */
    @Column(name = "answer_count", nullable = false)
    public int getAnswerCount() {
        return answerCount;
    }

    /**
     * 设置答案数
     * @param answerCount 答案数
     */
    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    /**
     * 获取关注人数
     * @return 关注人数
     */
    @Column(name = "follower_count", nullable = false)
    public int getFollowerCount() {
        return followerCount;
    }

    /**
     * 设置关注人数
     * @param followerCount 关注人数
     */
    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    /**
     * 获取最后更新日期
     * @return 最后跟新日期
     */
    @Column(name = "update_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置最后更新日期
     * @param updateTime 最后更新日期
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取浏览数
     * @return 浏览数
     */
    @Column(name = "view_count", nullable = false)
    public int getViewCount() {
        return viewCount;
    }

    /**
     * 设置浏览数
     * @param viewCount 浏览数
     */
    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    /**
     * 获取评论数
     * @return 评论数
     */
    @Column(name = "comment_count", nullable = false)
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数
     * @param commentCount 评论数
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 提问是否匿名
     * @return 提问是否匿名
     */
    @Column(name = "is_anonymous", nullable = false, columnDefinition = "tinyint")
    public byte getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置提问是否匿名
     * @param isAnonymous 提问是否匿名
     */
    public void setIsAnonymous(byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 获取提问时间
     * @return 提问时间
     */
    @Column(name = "question_time", nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getQuestionTime() {
        return questionTime;
    }

    /**
     * 设置提问时间
     * @param questionTime 提问时间
     */
    public void setQuestionTime(Timestamp questionTime) {
        this.questionTime = questionTime;
    }

    /**
     * 获取提问 IP
     * @return 提问 IP
     */
    @Column(name = "question_ip", nullable = false)
    public String getQuestionIP() {
        return questionIP;
    }

    /**
     * 设置提问 IP
     * @param questionIP 提问 IP
     */
    public void setQuestionIP(String questionIP) {
        this.questionIP = questionIP;
    }

    /**
     * 判断问题是否被锁定
     * @return 问题是否被锁定
     */
    @Column(name = "is_locked", nullable = false, columnDefinition = "tinyint")
    public byte getIsLocked() {
        return isLocked;
    }

    /**
     * 设置问题锁定
     * @param isLocked 问题锁定
     */
    public void setIsLocked(byte isLocked) {
        this.isLocked = isLocked;
    }

    /**
     * 判断是否是推荐问题
     * @return 推荐问题
     */
    @Column(name = "is_recommend", nullable = false, columnDefinition = "tinyint")
    public byte getIsRecommend() {
        return isRecommend;
    }

    /**
     * 设置推荐问题
     * @param isRecommend 推荐问题
     */
    public void setIsRecommend(byte isRecommend) {
        this.isRecommend = isRecommend;
    }

    /**
     * 获取提问用户 id
     * @return 提问用户 id
     */
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     * 设置提问用户 id
     * @param userId 提问用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
