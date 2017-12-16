package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 回答投票实体类
 *
 * <p>
 * Created by Ellery on 2017/10/20.
 */
@Entity
@Table(name = "votes")
public class VotesDO {

    /** 投票 id */
    private int id;

    /** 回答 id */
    private int answerId;

    /** 投票用户 id */
    private int voterId;

    /** 投票时间 */
    private Timestamp voteTime;

    /** 投票类型 1:up、2:down、3:unconcern*/
    private byte voteType;

    /**
     * 获取投票 id
     * @return 投票 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    /**
     * 设置投票 id
     * @param id 投票 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取回答 id
     * @return 回答 id
     */
    @Column(name = "answer_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getAnswerId() {
        return answerId;
    }

    /**
     * 设置回答 id
     * @param answerId 回答 id
     */
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    /**
     * 获取投票用户 id
     * @return 投票用户 id
     */
    @Column(name = "voter_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getVoterId() {
        return voterId;
    }

    /**
     * 设置投票用户 id
     * @param voterId 投票用户 id
     */
    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    /**
     * 获取投票时间
     * @return 投票时间
     */
    @Column(name = "vote_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getVoteTime() {
        return voteTime;
    }

    /**
     * 设置投票时间
     * @param voteTime 投票时间
     */
    public void setVoteTime(Timestamp voteTime) {
        this.voteTime = voteTime;
    }

    /**
     * 获取投票类型
     * @return 投票类型
     */
    @Column(name = "vote_type", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getVoteType() {
        return voteType;
    }

    /**
     * 设置投票类型
     * @param voteType 投票类型
     */
    public void setVoteType(byte voteType) {
        this.voteType = voteType;
    }
}
