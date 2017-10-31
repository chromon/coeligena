package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 权限实体类
 *
 * <p>
 * Created by Ellery on 2017/9/20.
 */
@Entity
@Table(name = "permissions")
public class PermissionsDO {

    /** 权限 id */
    private int id;

    /** 权限名称，对应应用控制器、应用、方法名 */
    private String name;

    /** 权限名称 */
    private String title;

    /** 启用状态码 */
    private byte status;

    /** 备注信息 */
    private String remark;

    /** 排序值（默认是50） */
    private int sort;

    /** 父权限 id */
    private int pid;

    /** 权限类型：1-表示应用（模块）, 2-表示控制器, 3-表示方法 */
    private byte level;

    /** 权限创建时间 */
    private Timestamp createTime;

    /** 权限更新时间 */
    private Timestamp updateTime;

    /**
     * 获取权限 id
     * @return 权限 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置权限 id
     * @param id 权限 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取权限名称，对应应用控制器、应用、方法名）
     * @return 权限名称
     */
    @Column(name = "name", nullable = false, length = 32, columnDefinition = "varchar(32)")
    public String getName() {
        return name;
    }

    /**
     * 设置权限名称
     * @param name 权限名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取权限名称
     * @return 权限名称
     */
    @Column(name = "title", length = 64, columnDefinition = "varchar(64) default ''")
    public String getTitle() {
        return title;
    }

    /**
     * 设置权限名称
     * @param title 权限名称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取启用状态
     * @return 启用状态码
     */
    @Column(name = "status", nullable = false, columnDefinition = "tinyint(4) default '1'")
    public byte getStatus() {
        return status;
    }

    /**
     * 设置启用状态码
     * @param status 启用状态码
     */
    public void setStatus(byte status) {
        this.status = status;
    }

    /**
     * 获取备注信息
     * @return 备注信息
     */
    @Column(name = "remark", length = 256, columnDefinition = "varchar(256) default ''")
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

    /**
     * 获取排序值
     * @return 排序值
     */
    @Column(name = "sort", columnDefinition = "int(11) default '50'")
    public int getSort() {
        return sort;
    }

    /**
     * 设置排序值
     * @param sort 排序值
     */
    public void setSort(int sort) {
        this.sort = sort;
    }

    /**
     * 获取父权限 id
     * @return 父权限 id
     */
    @Column(name = "pid", nullable = false, columnDefinition = "int(11) default '0'")
    public int getPid() {
        return pid;
    }

    /**
     * 设置父权限 id
     * @param pid 父权限 id
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * 获取权限类型
     * @return 权限类型
     */
    @Column(name = "level", nullable = false, columnDefinition = "tinyint(4) default '0'")
    public byte getLevel() {
        return level;
    }

    /**
     * 设置权限类型
     * @param level 权限类型
     */
    public void setLevel(byte level) {
        this.level = level;
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
}
