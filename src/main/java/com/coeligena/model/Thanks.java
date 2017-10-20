package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 回答感谢实体类
 *
 * <p>
 * Created by Ellery on 2017/10/20.
 */
@Entity
@Table(name = "thanks")
public class Thanks {

    /** 感谢 id */
    private int id;

    /** 被感谢回答 id */
    private int answerId;

    /** 发出感谢用户 id */
    private int thankerId;

    /** 感谢回答时间 */
    private Timestamp thankTime;

    /**
     * 获取感谢 id
     * @return 感谢 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置感谢 id
     * @param id 感谢 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取被感谢回答 id
     * @return 被感谢的回答 id
     */
    @Column(name = "answer_id", nullable = false)
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 设置被感谢的回答 id
     * @param answerId 被感谢的回答 id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取发出感谢用户 id
     * @return 发出感谢用户 id
     */
    @Column(name = "thanker_id", nullable = false)
    public int getThankerId() {
        return thankerId;
    }

    /**
     * 设置发出感谢用户 id
     * @param thankerId 发出感谢的用户 id
     */
    public void setThankerId(int thankerId) {
        this.thankerId = thankerId;
    }

    /**
     * 获取感谢时间
     * @return 感谢回答时间
     */
    @Column(name = "thank_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getThankTime() {
        return thankTime;
    }

    /**
     * 设置感谢回答 id
     * @param thankTime 感谢回答 id
     */
    public void setThankTime(Timestamp thankTime) {
        this.thankTime = thankTime;
    }
}
