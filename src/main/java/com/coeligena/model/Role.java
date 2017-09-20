package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 角色实体类
 * <p>
 *     一定数量的权限的几何，权限的载体
 *
 * <p>
 * Created by Ellery on 2017/9/19.
 */
@Entity
@Table(name = "role")
public class Role {

    // 角色 id
    private int id;

    // 角色名称
    private String roleName;

    // 父角色 id
    private int pid;

    // 启用状态：0-表示禁用，1-表示启用
    private short status;

    // 创建时间
    private Timestamp createTime;

    // 更改时间
    private Timestamp updateTime;

    // 备注信息
    private String remark;

    /**
     * 获取角色 id
     * @return 角色 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置角色 id
     * @param id 角色 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     * @return 角色名称
     */
    @Column(name = "rolename", nullable = false, length = 32)
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取父角色 id
     * @return 父角色 id
     */
    @Column(name = "pid")
    public int getPid() {
        return pid;
    }

    /**
     * 设置父角色 id
     * @param pid 父角色 id
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * 获取启用状态：0-表示禁用，1-表示启用
     * @return 启用状态码
     */
    @Column(name = "status", nullable = false)
    public short getStatus() {
        return status;
    }

    /**
     * 设置启用状态：0-表示禁用，1-表示启用
     * @param status 启用状态码
     */
    public void setStatus(short status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     * @return 创建时间
     */
    @Column(name = "create_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更改时间
     * @return 更改时间
     */
    @Column(name = "update_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更改时间
     * @param updateTime 更改时间
     */
    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注信息
     * @return 备注信息
     */
    @Column(name = "remark", nullable = false, length = 256)
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
