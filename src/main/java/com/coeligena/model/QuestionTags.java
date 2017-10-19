package com.coeligena.model;

import javax.persistence.*;

/**
 * 问题标签实体类
 *
 * <p>
 * Created by Ellery on 2017/10/19.
 */
@Entity
@Table(name = "question_tags")
public class QuestionTags {

    /** 问题标签 id */
    private int id;

    /** 话题 id */
    private int questionTopicId;

    /** 标签所在的问题 id */
    private int questionId;

    /**
     * 获取标签 id
     * @return 标签 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置标签 id
     * @param id 标签 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取话题 id
     * @return 话题 id
     */
    @Column(name = "question_topic_id", nullable = false)
    public int getQuestionTopicId() {
        return questionTopicId;
    }

    /**
     * 设置话题 id
     * @param questionTopicId 话题 id
     */
    public void setQuestionTopicId(int questionTopicId) {
        this.questionTopicId = questionTopicId;
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
     * 设置为 id
     * @param questionId 问题 id
     */
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
