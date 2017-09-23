package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 答案实体类
 *
 * <p>
 * Created by Ellery on 2017/9/23.
 */
@Entity
@Table(name = "answer")
public class Answer {

    // 答案 id
    private int id;

    // 问题 id
    private int questionId;

    // 作者 id
    private int authorId;

    // 答案
    private String answerContent;

    // 回答时间
    private Timestamp answerTime;

    // 评论数
    private int commentCount;

    // 是否为精华回答
    private int isTopAnswer;

    // 是否匿名回答
    private int isAnonymous;

    /**
     * 获取答案 id
     * @return 答案 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置回答 id
     * @param id 回答 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取问题 id
     * @return 问题 id
     */
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    /**
     * 设置问题 id
     * @param questionId 问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取作者 id
     * @return 作者 id
     */
    @Column(name = "author_id", nullable = false)
    public int getAuthorId() {
        return authorId;
    }

    /**
     * 设置作者 id
     * @param authorId 作者 id
     */
    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    /**
     * 获取回答内容
     * @return 回答内容
     */
    @Column(name = "answer_content", nullable = false)
    public String getAnswerContent() {
        return answerContent;
    }

    /**
     * 设置回答内容
     * @param answerContent
     */
    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    /**
     * 获取回答时间
     * @return 回答时间
     */
    @Column(name = "answer_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getAnswerTime() {
        return answerTime;
    }

    /**
     * 设置回答时间
     * @param answerTime 回答时间
     */
    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    /**
     * 获取评论数量
     * @return 评论数量
     */
    @Column(name = "comment_count", nullable = false)
    public int getCommentCount() {
        return commentCount;
    }

    /**
     * 设置评论数量
     * @param commentCount 评论数量
     */
    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * 判断是否是精华回答
     * @return 是否是精华回答
     */
    @Column(name = "is_top_answer", nullable = false)
    public int getIsTopAnswer() {
        return isTopAnswer;
    }

    /**
     * 设置是否是精华回答
     * @param isTopAnswer 是否是精华回答
     */
    public void setIsTopAnswer(int isTopAnswer) {
        this.isTopAnswer = isTopAnswer;
    }

    /**
     * 判断是否匿名
     * @return 是否匿名
     */
    @Column(name = "is_anonymous", nullable = false)
    public int getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置是否是匿名
     * @param isAnonymous 是否匿名
     */
    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
    }
}
