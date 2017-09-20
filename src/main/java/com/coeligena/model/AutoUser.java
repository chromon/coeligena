package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 用户验证实体类
 *
 * <p>
 * Created by Ellery on 2017/9/19.
 */
@Entity
@Table(name = "auto_user")
public class AutoUser {

    // 验证用户 id
    private int id;

    // 邮箱地址
    private String email;

    // 手机号码
    private String phone;

    // 密码
    private String password;

    // 密码盐
    private String salt;

    // 创建时间
    private Timestamp createTime;

    // 最后一次登录时间
    private Timestamp lastLoginTime;

    // 最近登录的 ip 地址
    private String lastLoginIP;

    // 启用状态：0-表示禁用，1-表示启用
    private short status;

    // 备注信息
    private String remark;

    /**
     * 获取用户验证 id
     * @return 用户验证 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置用户验证 id
     * @param id 用户验证 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取邮箱
     * @return 邮箱地址
     */
    @Column(name = "email", nullable = false, length = 128)
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号
     * @return 手机号码
     */
    @Column(name = "phone", nullable = false, length = 16)
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取密码
     * @return 密码
     */
    @Column(name = "password", nullable = false, length = 256)
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取密码盐
     * @return 密码盐
     */
    @Column(name = "salt", nullable = false, length = 128)
    public String getSalt() {
        return salt;
    }

    /**
     * 设置密码盐
     * @param salt 密码盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
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
     * 获取最后一次登录时间
     * @return 最后登录时间
     */
    @Column(name = "last_login_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后一次登录时间
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取最近登录的 ip 地址
     * @return 最后登录 ip
     */
    @Column(name = "last_login_ip", nullable = false, length = 15)
    public String getLastLoginIP() {
        return lastLoginIP;
    }

    /**
     * 设置最近登录的 ip 地址
     * @param lastLoginIP 最后登录 ip
     */
    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    /**
     * 获取启用状态：0-表示禁用，1-表示启用
     * @return 启用状态
     */
    @Column(name = "status", nullable = false)
    public short getStatus() {
        return status;
    }

    /**
     * 设置启用状态：0-表示禁用，1-表示启用
     * @param status  启用状态
     */
    public void setStatus(short status) {
        this.status = status;
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
