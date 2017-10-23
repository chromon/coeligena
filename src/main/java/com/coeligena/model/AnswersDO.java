package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 回答实体类
 *
 * <p>
 * Created by Ellery on 2017/10/19.
 */
@Entity
@Table(name = "answers")
public class AnswersDO {

    /** 回答 id */
    private int id;

    /** 问题 id */
    private int questionId;

    /** 作者 id */
    private int authorId;

    /** 回答 */
    private String answerContent;

    /** 回答时间 */
    private Timestamp answerTime;

    /** 反对数 */
    private int againstCount;

    /** 赞同数 */
    private int approvalCount;

    /** 评论数 */
    private int commentCount;

    /** 感谢数 */
    private int thanksCount;

    /** 没有帮助数 */
    private int noHelpCount;

    /** 是否作者保留权利 0：否，1：是  */
    private byte isSecLicence;

    /** 是否是精华回答 0：否，1：是  */
    private byte isTopAnswer;

    /** 是否匿名回答 0：否，1：是 */
    private byte isAnonymous;

    /** 是否强制折叠 0：否，1：是 */
    private byte isForceFold;

    /**
     * 获取回答 id
     * @return 回答 id
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
    @Column(name = "answer_content", nullable = false, columnDefinition = "mediumtext")
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
     * @param answerTime
     */
    public void setAnswerTime(Timestamp answerTime) {
        this.answerTime = answerTime;
    }

    /**
     * 获取反对数
     * @return 反对数
     */
    @Column(name = "against_count", nullable = false)
    public int getAgainstCount() {
        return againstCount;
    }

    /**
     * 设置反对数
     * @param againstCount 反对数
     */
    public void setAgainstCount(int againstCount) {
        this.againstCount = againstCount;
    }

    /**
     * 获取赞同数
     * @return 赞同数
     */
    @Column(name = "approval_count", nullable = false)
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
     * 获取感谢数
     * @return 感谢数
     */
    @Column(name = "thanks_count", nullable = false)
    public int getThanksCount() {
        return thanksCount;
    }

    /**
     * 设置感谢数
     * @param thanksCount 感谢数
     */
    public void setThanksCount(int thanksCount) {
        this.thanksCount = thanksCount;
    }

    /**
     * 获取没有帮助数
     * @return 没有帮助数
     */
    @Column(name = "nohelp_count", nullable = false)
    public int getNoHelpCount() {
        return noHelpCount;
    }

    /**
     * 设置没有帮助数
     * @param noHelpCount 没有帮助数
     */
    public void setNoHelpCount(int noHelpCount) {
        this.noHelpCount = noHelpCount;
    }

    /**
     * 判断是否作者保留权利
     * @return 是否作者保留权利
     */
    @Column(name = "is_sec_licence", nullable = false, columnDefinition = "tinyint")
    public byte getIsSecLicence() {
        return isSecLicence;
    }

    /**
     * 设置是否作者保留权利
     * @param isSecLicence 是否作者保留权利
     */
    public void setIsSecLicence(byte isSecLicence) {
        this.isSecLicence = isSecLicence;
    }

    /**
     * 判断是否是精华回答
     * @return 是否是精华回答
     */
    @Column(name = "is_top_answer", nullable = false, columnDefinition = "tinyint")
    public byte getIsTopAnswer() {
        return isTopAnswer;
    }

    /**
     * 设置是否是精华回答
     * @param isTopAnswer 是否是精华回答
     */
    public void setIsTopAnswer(byte isTopAnswer) {
        this.isTopAnswer = isTopAnswer;
    }

    /**
     * 判断是否是匿名回答
     * @return 是否是匿名回答
     */
    @Column(name = "is_anonymous", nullable = false, columnDefinition = "tinyint")
    public byte getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 设置是否是匿名回答
     * @param isAnonymous 是否是匿名回答
     */
    public void setIsAnonymous(byte isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 判断是否是强制折叠
     * @return 是否是强制折叠
     */
    @Column(name = "is_force_fold", nullable = false, columnDefinition = "tinyint")
    public byte getIsForceFold() {
        return isForceFold;
    }

    /**
     * 设置是否是强制折叠
     * @param isForceFold 是否是强制折叠
     */
    public void setIsForceFold(byte isForceFold) {
        this.isForceFold = isForceFold;
    }
}
