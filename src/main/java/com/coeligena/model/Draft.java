package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 草稿实体类
 *
 * <p>
 * Created by Ellery on 2017/9/22.
 */
@Entity
@Table(name = "draft")
public class Draft {

    // 草稿 id
    private int id;

    // 草稿问题 id
    private int questionId;

    // 草稿内容
    private String draftContent;

    // 最后更新时间
    private Timestamp lastUpdate;

    // 是否匿名
    private int isAnonymous;

    // 草稿回答用户 id
    private int userId;

    /**
     * 获取草稿 id
     * @return 草稿 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置草稿 id
     * @param id 草稿 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取草稿问题 id
     * @return 草稿问题 id
     */
    @Column(name = "question_id", nullable = false)
    public int getQuestionId() {
        return questionId;
    }

    /**
     * 设置草稿问题 id
     * @param questionId 草稿问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    /**
     * 获取草稿内容
     * @return 草稿内容
     */
    @Column(name = "draft_content", nullable = false)
    public String getDraftContent() {
        return draftContent;
    }

    /**
     * 设置草稿内容
     * @param draftContent 草稿内容
     */
    public void setDraftContent(String draftContent) {
        this.draftContent = draftContent;
    }

    /**
     * 获取草稿最后更新时间
     * @return 最后更新时间
     */
    @Column(name = "last_update", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    /**
     * 设置最后更新时间
     * @param lastUpdate 最后更新时间
     */
    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
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
     * 设置是否匿名
     * @param isAnonymous 是否匿名
     */
    public void setIsAnonymous(int isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 获取草稿回答用户 id
     * @return 草稿回答用户 id
     */
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     * 设置草稿回答用户 id
     * @param userId 草稿回答用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
