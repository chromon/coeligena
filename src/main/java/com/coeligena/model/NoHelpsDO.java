package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 回答没有帮助实体类
 *
 * <p>
 * Created by Ellery on 2017/10/21.
 */
@Entity
@Table(name = "nohelps")
public class NoHelpsDO {

    /** 回答没有帮助 id */
    private int id;

    /** 没有帮助的回答 id */
    private int answerId;

    /** 提交没有帮助用户 id */
    private int userId;

    /** 提交没有帮助时间 */
    private Timestamp noHelpTime;

    /**
     * 获取回答没有帮助 id
     * @return 回答没有帮助 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置回答没有帮助 id
     * @param id 回答没有帮助 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取没有帮助的回答 id
     * @return 没有帮助的回答 id
     */
    @Column(name = "answer_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 设置没有帮助的回答 id
     * @param answerId 没有帮助的回答 id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取提交没有帮助用户 id
     * @return 提交没有帮助用户 id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 设置提交没有帮助用户 id
     * @param userId 提交没有帮助用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取提交没有帮助时间
     * @return 提交没有帮助时间
     */
    @Column(name = "nohelp_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    public Timestamp getNoHelpTime() {
        return noHelpTime;
    }

    /**
     * 设置提交没有帮助时间
     * @param noHelpTime 提交没有帮助时间
     */
    public void setNoHelpTime(Timestamp noHelpTime) {
        this.noHelpTime = noHelpTime;
    }
}
