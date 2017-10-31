package com.coeligena.model;

import javax.persistence.*;

/**
 * 回答邀请实体类
 *
 * <p>
 * Created by Ellery on 2017/10/19.
 */
@Entity
@Table(name = "invites")
public class InvitesDO {

    /** 邀请 id */
    private int id;

    /** 问题 id */
    private int questionId;

    /** 邀请人 id */
    private int inviterId;

    /** 被邀请人 id */
    private int inviteeId;

    /** 邀请时间 */
    private int inviteTime;

    /**
     * 获取邀请 id
     * @return 邀请 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置邀请 id
     * @param id 邀请 id
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
     * 获取邀请人 id
     * @return 邀请人 id
     */
    @Column(name = "inviter_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getInviterId() {
        return inviterId;
    }

    /**
     * 设置邀请人 id
     * @param inviterId 邀请人 id
     */
    public void setInviterId(int inviterId) {
        this.inviterId = inviterId;
    }

    /**
     * 获取被邀请人 id
     * @return 被邀请人 id
     */
    @Column(name = "invitee_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getInviteeId() {
        return inviteeId;
    }

    /**
     * 设置被邀请人 id
     * @param inviteeId 被邀请人 id
     */
    public void setInviteeId(int inviteeId) {
        this.inviteeId = inviteeId;
    }

    /**
     * 获取邀请时间
     * @return 邀请时间
     */
    @Column(name = "invite_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    public int getInviteTime() {
        return inviteTime;
    }

    /**
     * 设置邀请时间
     * @param inviteTime 邀请时间
     */
    public void setInviteTime(int inviteTime) {
        this.inviteTime = inviteTime;
    }
}
