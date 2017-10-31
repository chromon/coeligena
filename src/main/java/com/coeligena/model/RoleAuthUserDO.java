package com.coeligena.model;

import javax.persistence.*;

/**
 * 验证用户与角色对照实体类
 *
 * <p>
 * Created by Ellery on 2017/9/20.
 */
@Entity
@Table(name = "role_auth_user")
public class RoleAuthUserDO {

    /** 验证用户与角色对应 id */
    private int id;

    /** 角色 id */
    private int roleId;

    /** 验证用户验证 id */
    private int authUserId;

    /**
     * 获取验证用户与角色对应 id
     * @return 验证用户与角色对应 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置验证用户与角色对应 id
     * @param id 验证用户与角色对应 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取角色 id
     * @return 角色 id
     */
    @Column(name = "role_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getRoleId() {
        return roleId;
    }

    /**
     * 设置角色 id
     * @param roleId 角色 id
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取验证用户 id
     * @return 验证用户 id
     */
    @Column(name = "auth_user_id", nullable = false, columnDefinition = "int(11) default '0'")
    public int getAuthUserId() {
        return authUserId;
    }

    /**
     * 设置验证用户 id
     * @param authUserId 验证用户 id
     */
    public void setAuthUserId(int authUserId) {
        this.authUserId = authUserId;
    }
}
