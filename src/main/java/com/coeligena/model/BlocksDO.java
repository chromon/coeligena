package com.coeligena.model;

import javax.persistence.*;

/**
 * 屏蔽用户实体类
 *
 * <p>
 * Created by Ellery on 2017/10/24.
 */
@Entity
@Table(name = "blocks")
public class BlocksDO {

    /** 屏蔽 id */
    private int id;

    /** 当前用户 id */
    private int userId;

    /** 被屏蔽用户 id */
    private int blockedId;

    /**
     * 获取屏蔽 id
     * @return 屏蔽 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置屏蔽 id
     * @param id 屏蔽 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取当前用户 id
     * @return 当前用户 id
     */
    @Column(name = "user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getUserId() {
        return userId;
    }

    /**
     * 设置当前用户 id
     * @param userId 当前用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 获取被屏蔽用户 id
     * @return 被屏蔽用户 id
     */
    @Column(name = "blocked_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getBlockedId() {
        return blockedId;
    }

    /**
     * 设置被屏蔽用户 id
     * @param blockedId 被屏蔽用户 id
     */
    public void setBlockedId(int blockedId) {
        this.blockedId = blockedId;
    }
}
