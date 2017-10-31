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
    private byte secLicence;

    /** 是否是精华回答 0：否，1：是  */
    private byte topAnswer;

    /** 是否匿名回答 0：否，1：是 */
    private byte anonymous;

    /** 是否强制折叠 0：否，1：是 */
    private byte forceFold;

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
    @Column(name = "question_id", nullable = false, columnDefinition = "int(11) default '0'")
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
    @Column(name = "author_id", nullable = false, columnDefinition = "int(11) default '0'")
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
     * @param answerContent 回答内容
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
     * 获取反对数
     * @return 反对数
     */
    @Column(name = "against_count", nullable = false, columnDefinition = "int(11) default '0'")
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
     * 获取评论数
     * @return 评论数
     */
    @Column(name = "comment_count", nullable = false, columnDefinition = "int(11) default '0'")
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
    @Column(name = "thanks_count", nullable = false, columnDefinition = "int(11) default '0'")
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
    @Column(name = "nohelp_count", nullable = false, columnDefinition = "int(11) default '0'")
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
    @Column(name = "sec_licence", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getSecLicence() {
        return secLicence;
    }

    /**
     * 设置是否作者保留权利
     * @param secLicence 是否作者保留权利
     */
    public void setSecLicence(byte secLicence) {
        this.secLicence = secLicence;
    }

    /**
     * 判断是否是精华回答
     * @return 是否是精华回答
     */
    @Column(name = "top_answer", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getTopAnswer() {
        return topAnswer;
    }

    /**
     * 设置是否是精华回答
     * @param topAnswer 是否是精华回答
     */
    public void setTopAnswer(byte topAnswer) {
        this.topAnswer = topAnswer;
    }

    /**
     * 判断是否是匿名回答
     * @return 是否是匿名回答
     */
    @Column(name = "anonymous", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getAnonymous() {
        return anonymous;
    }

    /**
     * 设置是否是匿名回答
     * @param anonymous 是否是匿名回答
     */
    public void setAnonymous(byte anonymous) {
        this.anonymous = anonymous;
    }

    /**
     * 判断是否是强制折叠
     * @return 是否是强制折叠
     */
    @Column(name = "force_fold", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getForceFold() {
        return forceFold;
    }

    /**
     * 设置是否是强制折叠
     * @param forceFold 是否是强制折叠
     */
    public void setForceFold(byte forceFold) {
        this.forceFold = forceFold;
    }
}
