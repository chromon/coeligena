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
@Table(name = "question")
public class Question {

    // 问题 id
    private int id;

    // 问题标题
    private String questionTitle;

    // 问题内容
    private String questionContent;

    // 答案数
    private int answerNum;

    // 关注人数
    private int followerNum;

    // 修改时间
    private Timestamp lastUpdate;

    // 浏览数
    private int scanNum;

    // 评论数
    private int commentNum;

    // 是否匿名 1：是， 0：否
    private int isAnonymous;

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
    @Column(name = "question_title", nullable = false, length = 256)
    public String getQuestionTitle() {
        return questionTitle;
    }

    /**
     * 设置问题标题
     * @param questionTitle 问题标题
     */
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    /**
     * 获取问题详情
     * @return 问题详情
     */
    @Column(name = "question_content", nullable = false)
    public String getQuestionContent() {
        return questionContent;
    }

    /**
     * 设置问题详情
     * @param questionContent 问题详情
     */
    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    /**
     * 获取答案数
     * @return 答案数
     */
    @Column(name = "answer_num", nullable = false)
    public int getAnswerNum() {
        return answerNum;
    }

    /**
     * 设置答案数
     * @param answerNum 答案数
     */
    public void setAnswerNum(int answerNum) {
        this.answerNum = answerNum;
    }

    /**
     * 获取关注人数
     * @return 关注人数
     */
    @Column(name = "follower_num", nullable = false)
    public int getFollowerNum() {
        return followerNum;
    }

    /**
     * 设置关注人数
     * @param followerNum 关注人数
     */
    public void setFollowerNum(int followerNum) {
        this.followerNum = followerNum;
    }

    /**
     * 获取最后更新日期
     * @return 最后跟新日期
     */
    @Column(name = "last_update", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * 设置最后更新日期
     * @param lastUpdate 最后更新日期
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * 获取浏览数
     * @return 浏览数
     */
    @Column(name = "scan_num", nullable = false)
    public int getScanNum() {
        return scanNum;
    }

    /**
     * 设置浏览数
     * @param scanNum 浏览数
     */
    public void setScanNum(int scanNum) {
        this.scanNum = scanNum;
    }

    /**
     * 获取评论数
     * @return 评论数
     */
    @Column(name = "comment_num", nullable = false)
    public int getCommentNum() {
        return commentNum;
    }

    /**
     * 设置评论数
     * @param commentNum 评论数
     */
    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    /**
     * 提问是否匿名
     * @return 提问是否匿名
     */
    @Column(name = "is_anonymous", nullable = false)
    public int getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置提问是否匿名
     * @param isAnonymous 提问是否匿名
     */
    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
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
