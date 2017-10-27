package com.coeligena.model;

import javax.persistence.*;

/**
 * 消息组实体类
 * 	（^为直接插入存储 ， #为动态读取）
 *
 * <p>
 * 用户对用户：
 * 	1. 私信（私信页面） ^ -- PrivateMsg
 *
 * <p>
 * 系统对用户：
 * <p>
 * 	1. 提醒（提醒页面）
 * 		*某人（trigger_id）邀请你回答一个问题（question_id）^
 *      -- InviteMsg
 * 		*某人（trigger_id）评论（comment_id）了你的问题（question_id）^
 *      -- CommentQuestionMsg
 * 		*某人（trigger_id）回答（answer_id）了你的问题（question_id）^
 *      -- AnswerQuestionMsg
 * 		*某人（trigger_id）评论（comment_id）了你在某问题（question_id）下的回答（answer_id）^
 *      -- CommentAnswerMsg
 * 		*某人（trigger_id）赞同了你在某问题（question_id）下的回答（answer_id）^
 *      -- AgreeAnswerMsg
 * 		*某人（trigger_id）感谢了你在某问题（question_id）下的回答（answer_id）^
 *      -- ThankAnswerMsg
 *      *某人（trigger_id）赞同了你在问题（question_id）下的评论（comment_id）^
 *      -- AgreeQuestionComment
 *      *某人（trigger_id）赞同了你在问题（question_id）下某人（answerer_id）回答下的评论（comment_id）^
 *      -- AgreeAnswerComment
 *      *某人（trigger_id）赞同了你在专栏文章（article_id）下的评论（comment_id）^
 *      -- AgreeArticleComment
 * 		*二级回复 某人（trigger_id）回复了你在某问题（question_id）下的评论（comment_id）^
 *      -- ReplyQuestionCommentMsg
 * 		*二级回复 某人（trigger_id）回复了你在某问题（question_id）下某人（answerer_id）回答下的评论（comment_id）^
 *      -- ReplyAnswerCommentMsg
 * 		*二级回复 某人（trigger_id）回复了你在某专栏文章（article_id）下的评论（comment_id）^
 *      -- ReplyArticleCommentMsg
 * 		*某人（trigger_id）关注了你^
 *      -- FollowingYouMsg
 * 		*@用户（trigger_id） 提到了你^
 *      -- AtYouMsg
 * 		**某人（trigger_id）在你关注的问题（question_id）发表了一个新回答（answer_id） #
 *      -- NewAnswerMsg
 * <p>
 * 	2. 系统通知（私信页面）
 * 		*系统公告私信 #	-- SystemMessage
 *
 * <p>
 * Created by Ellery on 2017/10/27.
 */
@Entity
@Table(name = "message_groups")
public class MessageGroupsDO {

    /** 消息组 id */
    private int id;

    /** 触发用户 id */
    private int triggerId;

    /** 问题 id */
    private int questionId;

    /** 专栏 id */
    private int articleId;

    /** 回答 id */
    private int answerId;

    /** 回答用户 id */
    private int answererId;

    /** 评论 id */
    private int commentId;

    /** 用户 id */
    private int userId;

    /**
     * 获取消息组 id
     * @return 消息组 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置消息组 id
     * @param id 消息组 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取触发用户
     * @return 触发用户 id
     */
    @Column(name = "trigger_id", nullable = false)
    public int getTriggerId() {
        return triggerId;
    }

    /**
     * 设置触发用户
     * @param triggerId 触发用户 id
     */
    public void setTriggerId(int triggerId) {
        this.triggerId = triggerId;
    }

    /**
     * 获取问题
     * @return 问题 id
     */
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    /**
     * 设置问题
     * @param questionId 问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取专栏文章
     * @return 专栏文章 id
     */
    @Column(name = "article_id", nullable = false)
    public int getArticleId() {
        return articleId;
    }

    /**
     * 设置专栏文章
     * @param articleId 专栏文章 id
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取回答
     * @return 回答 id
     */
    @Column(name = "answer_id", nullable = false)
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 设置回答
     * @param answerId 回答 id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取回答用户
     * @return 回答用户 id
     */
    @Column(name = "answerer_id", nullable = false)
    public int getAnswererId() {
        return answererId;
    }

    /**
     * 设置回答用户
     * @param answererId 回答用户 id
     */
    public void setAnswererId(int answererId) {
        this.answererId = answererId;
    }

    /**
     * 获取评论
     * @return 评论 id
     */
    @Column(name = "comment_id", nullable = false)
    public int getCommentId() {
        return commentId;
    }

    /**
     * 设置评论
     * @param commentId 评论 id
     */
    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取用户
     * @return 用户 id
     */
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     * 设置用户
     * @param userId 用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
