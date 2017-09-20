package com.coeligena.model;

import javax.persistence.*;

/**
 * 角色权限对应实体类
 *
 * <p>
 * Created by Ellery on 2017/9/20.
 */
@Entity
@Table(name = "role_permission")
public class RolePermission {

    // 角色权限对应 id
    private int id;

    // 角色 id
    private int roleId;

    // 权限 id
    private int permissionId;

    /**
     * 获取角色权限对应 id
     * @return 角色权限对应 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置角色权限对应 id
     * @param id 角色权限对应 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取角色 id
     * @return 角色 id
     */
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    /**
     * 设置 角色 id
     * @param roleId 角色 id
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限 id
     * @return 权限 id
     */
    @Column(name = "permission_id", nullable = false)
    public int getPermissionId() {
        return permissionId;
    }

    /**
     * 设置权限 id
     * @param permissionId 权限 id
     */
    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
