package com.coeligena.model;

import javax.persistence.*;

/**
 * 设置实体类
 *
 * <p>
 * Created by Ellery on 2017/10/24.
 */
@Entity
@Table(name = "settings")
public class SettingsDO {

    /** 设置 id */
    private int id;

    /** 是否隐私保护（站外搜索到我的内容，不会被显示姓名）0：否，1：是  */
    private byte isPrivacyProtection;

    /** 别人给我发私信，0：允许所有人给我发私信，1：只允许我关注的人给我发私信  */
    private byte messageReceive;

    /** 开启陌生人私信箱，0：否，1：是 */
    private byte strangerInbox;

    /** 有私信时邮件提醒，0：否，1：是 */
    private byte messageEmail;

    /** 邀请我回答问题，0：接收所有人的消息，1：只接收关注人的消息  */
    private byte inviteMe;

    /** 关注的问题有了新回答，0：接收所有人的消息，1：只接收关注人的消息  */
    private byte newAnswer;

    /** 关注的专栏有了新文章，0：接收消息，1：不接收消息  */
    private byte newArticle;

    /** 关注的人有了新的电子书，0：接收消息，1：不接收消息 */
    private byte newBook;

    /** @ /评论我，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte atCommentMe;

    /** 赞同、感谢我，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte agreeThankMe;

    /** 赞了我的评论，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte likeComment;

    /** 赞了我的文章，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte likeArticle;

    /** 赞了我的电子书，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte likeBook;

    /** 赞赏了我的文章，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte admireArticle;

    /** 有人关注了我，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte followMe;

    /** 有人关注了我的专栏，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte followColumn;

    /** 有人关注了我的收藏，0：接收所有人的消息，1：只接收关注人的消息，2：不接收任何人的消息 */
    private byte followCollection;

    /** 是否接受每周精选，0：否，1：是  */
    private byte weeklyEmail;

    /** 新产品或活动通知，0：否，1：是 */
    private byte newProductEmail;

    /**
     * 获取设置 id
     * @return 设置 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 配置设置 id
     * @param id 设置 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 判断是否隐私保护
     * @return 是否隐私保护
     */
    @Column(name = "is_privacy_protection", nullable = false, columnDefinition = "tinyint default '1'")
    public byte getIsPrivacyProtection() {
        return isPrivacyProtection;
    }

    /**
     * 设置是否隐私保护
     * @param isPrivacyProtection 是否隐私保护
     */
    public void setIsPrivacyProtection(byte isPrivacyProtection) {
        this.isPrivacyProtection = isPrivacyProtection;
    }

    /**
     * 获取别人给我发私信设置
     * @return 别人是否给我发私信
     */
    @Column(name = "message_receive", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getMessageReceive() {
        return messageReceive;
    }

    /**
     * 设置别人是否可以给我发私信
     * @param messageReceive 别人是否可以给我发私信
     */
    public void setMessageReceive(byte messageReceive) {
        this.messageReceive = messageReceive;
    }

    /**
     * 判断是否开启陌生人信箱
     * @return 是否开启陌生人信箱
     */
    @Column(name = "stranger_inbox", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getStrangerInbox() {
        return strangerInbox;
    }

    /**
     * 设置是否开启陌生人信箱
     * @param strangerInbox 是否开启陌生人信箱
     */
    public void setStrangerInbox(byte strangerInbox) {
        this.strangerInbox = strangerInbox;
    }

    /**
     * 判断是否有私信时邮件提醒
     * @return 是否有私信时邮件提醒
     */
    @Column(name = "message_email", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getMessageEmail() {
        return messageEmail;
    }

    /**
     * 设置是否有私信时邮件提醒
     * @param messageEmail 是否有私信时邮件提醒
     */
    public void setMessageEmail(byte messageEmail) {
        this.messageEmail = messageEmail;
    }

    /**
     * 判断是否可以邀请我回答问题
     * @return 是否可以邀请我回答问题
     */
    @Column(name = "invite_me", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getInviteMe() {
        return inviteMe;
    }

    /**
     * 设置是否可以邀请我回答问题
     * @param inviteMe 是否可以邀请我回答问题
     */
    public void setInviteMe(byte inviteMe) {
        this.inviteMe = inviteMe;
    }

    /**
     * 判断是否接收关注的问题有了新答案消息
     * @return 是否接收关注的问题有了新答案消息
     */
    @Column(name = "new_answer", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getNewAnswer() {
        return newAnswer;
    }

    /**
     * 设置是否接收关注的问题有了新答案消息
     * @param newAnswer 是否接收关注的问题有了新答案消息
     */
    public void setNewAnswer(byte newAnswer) {
        this.newAnswer = newAnswer;
    }

    /**
     * 判断是否接收关注的专栏有了新文章消息
     * @return 是否接收关注的专栏有了新文章消息
     */
    @Column(name = "new_article", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getNewArticle() {
        return newArticle;
    }

    /**
     * 设置是否接收关注的专栏有了新文章消息
     * @param newArticle 是否接收关注的专栏有了新文章消息
     */
    public void setNewArticle(byte newArticle) {
        this.newArticle = newArticle;
    }

    /**
     * 判断是否接收关注的人有了新电子书消息
     * @return 是否接收关注的人有了新电子书消息
     */
    @Column(name = "new_book", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getNewBook() {
        return newBook;
    }

    /**
     * 设置是否接收关注的人有了新电子书消息
     * @param newBook 是否接收关注的人有了新电子书消息
     */
    public void setNewBook(byte newBook) {
        this.newBook = newBook;
    }

    /**
     * 判断是否接收 @ 和评论我的消息
     * @return 是否接收 @ 和评论我的消息
     */
    @Column(name = "at_comment_me", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getAtCommentMe() {
        return atCommentMe;
    }

    /**
     * 设置是否接收 @ 和评论我的消息
     * @param atCommentMe 是否接收 @ 和评论我的消息
     */
    public void setAtCommentMe(byte atCommentMe) {
        this.atCommentMe = atCommentMe;
    }

    /**
     * 判断是否接收赞同、感谢我的消息
     * @return 是否接收赞同、感谢我的消息
     */
    @Column(name = "agree_thank_me", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getAgreeThankMe() {
        return agreeThankMe;
    }

    /**
     * 设置是否接收赞同、感谢我的消息
     * @param agreeThankMe 是否接收赞同、感谢我的消息
     */
    public void setAgreeThankMe(byte agreeThankMe) {
        this.agreeThankMe = agreeThankMe;
    }

    /**
     * 判断是否接收赞了我的评论消息
     * @return 是否接收赞了我的评论消息
     */
    @Column(name = "like_comment", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getLikeComment() {
        return likeComment;
    }

    /**
     * 设置是否接收赞了我的评论消息
     * @param likeComment 是否接收赞了我的评论消息
     */
    public void setLikeComment(byte likeComment) {
        this.likeComment = likeComment;
    }

    /**
     * 判断是否接收赞了我的文章的消息
     * @return 是否接收赞了我的文章的消息
     */
    @Column(name = "like_article", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getLikeArticle() {
        return likeArticle;
    }

    /**
     * 设置是否接收赞了我的文章的消息
     * @param likeArticle 是否接收赞了我的文章的消息
     */
    public void setLikeArticle(byte likeArticle) {
        this.likeArticle = likeArticle;
    }

    /**
     * 判断是否接收赞了我的电子书的消息
     * @return 是否接收赞了我的电子书的消息
     */
    @Column(name = "like_book", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getLikeBook() {
        return likeBook;
    }

    /**
     * 设置是否接收赞了我的电子书的消息
     * @param likeBook 是否接收赞了我的电子书的消息
     */
    public void setLikeBook(byte likeBook) {
        this.likeBook = likeBook;
    }

    /**
     * 判断是否接收赞赏了我的文章消息
     * @return 是否接收赞赏了我的文章消息
     */
    @Column(name = "admire_article", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getAdmireArticle() {
        return admireArticle;
    }

    /**
     * 设置是否接收赞赏了我的文章消息
     * @param admireArticle 是否接收赞赏了我的文章消息
     */
    public void setAdmireArticle(byte admireArticle) {
        this.admireArticle = admireArticle;
    }

    /**
     * 判断是否接收有人关注了我的消息
     * @return 是否接收有人关注了我的消息
     */
    @Column(name = "follow_me", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getFollowMe() {
        return followMe;
    }

    /**
     * 设置是否接收有人关注了我的消息
     * @param followMe 是否接收有人关注了我的消息
     */
    public void setFollowMe(byte followMe) {
        this.followMe = followMe;
    }

    /**
     * 判断是否接收有人关注了我的专栏消息
     * @return 是否接收有人关注了我的专栏消息
     */
    @Column(name = "follow_column", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getFollowColumn() {
        return followColumn;
    }

    /**
     * 设置是否接收有人关注了我的专栏消息
     * @param followColumn 是否接收有人关注了我的专栏消息
     */
    public void setFollowColumn(byte followColumn) {
        this.followColumn = followColumn;
    }

    /**
     * 判断是否接收有人关注了我的收藏消息
     * @return 是否接收有人关注了我的收藏消息
     */
    @Column(name = "follow_collection", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getFollowCollection() {
        return followCollection;
    }

    /**
     * 设置是否接收有人关注了我的收藏消息
     * @param followCollection 是否接收有人关注了我的收藏消息
     */
    public void setFollowCollection(byte followCollection) {
        this.followCollection = followCollection;
    }

    /**
     * 判断是否接收每周精选
     * @return 是否接收每周精选
     */
    @Column(name = "weekly_email", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getWeeklyEmail() {
        return weeklyEmail;
    }

    /**
     * 设置是否接收每周精选
     * @param weeklyEmail 是否接收每周精选
     */
    public void setWeeklyEmail(byte weeklyEmail) {
        this.weeklyEmail = weeklyEmail;
    }

    /**
     * 判断是否接收新产品或活动通知
     * @return 是否接收新产品或活动通知
     */
    @Column(name = "new_roduct_email", nullable = false, columnDefinition = "tinyint default '0'")
    public byte getNewProductEmail() {
        return newProductEmail;
    }

    /**
     * 设置是否接收新产品或活动通知
     * @param newProductEmail 是否接收新产品或活动通知
     */
    public void setNewProductEmail(byte newProductEmail) {
        this.newProductEmail = newProductEmail;
    }
}
