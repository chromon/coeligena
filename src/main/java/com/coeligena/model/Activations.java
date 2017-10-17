package com.coeligena.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 账户激活数据实体类
 *
 * <p>
 * Created by Ellery on 2017/10/14.
 */
@Entity
@Table(name = "activations")
public class Activations {

    /** 账户激活数据 id */
    private int id;

    /** 账户激活码 */
    private String activationCode;

    /** 账户激活码类型，email url or phone code */
    private String activationTypeCode;

    /** 激活码创建时间 */
    private Timestamp createTime;

    /** 激活码过期时间 */
    private Timestamp expireTime;

    /** 激活码创建时 ip */
    private String createIP;

    /** 激活码激活时间 */
    private Timestamp activationTime;

    /** 激活 ip */
    private String activationIP;

    /** 用户 id */
    private int userId;

    /**
     * 激活数据 id
     * @return 激活数据 id
     */
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    /**
     * 设置激活数据 id
     * @param id 激活数据 id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取 激活码
     * @return 激活码
     */
    @Column(name = "activation_code", nullable = false, length = 32)
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * 设置激活码
     * @param activationCode 激活码
     */
    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    /**
     * 获取激活码 类型
     * @return 激活码类型
     */
    @Column(name = "activation_type_code", nullable = false, length = 16)
    public String getActivationTypeCode() {
        return activationTypeCode;
    }

    /**
     * 设置激活码类型
     * @param activationTypeCode 激活码类型
     */
    public void setActivationTypeCode(String activationTypeCode) {
        this.activationTypeCode = activationTypeCode;
    }

    /**
     * 获取激活码创建时间
     * @return 创建时间
     */
    @Column(name = "create_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 设置激活码创建时间
     * @param createTime 激活码创建时间
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取激活码过期时间
     * @return 过期时间
     */
    @Column(name = "expire_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Timestamp getExpireTime() {
        return expireTime;
    }

    /**
     * 设置激活码过期时间
     * @param expireTime 过期时间
     */
    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取激活码创建时 ip
     * @return 创建 ip
     */
    @Column(name = "create_ip", nullable = false, length = 15)
    public String getCreateIP() {
        return createIP;
    }

    /**
     * 设置创建激活码 ip
     * @param createIP 激活码 ip
     */
    public void setCreateIP(String createIP) {
        this.createIP = createIP;
    }

    /**
     * 获取激活时间
     * @return 激活时间
     */
    @Column(name = "activation_time", nullable = false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    public Timestamp getActivationTime() {
        return activationTime;
    }

    /**
     * 设置激活时间
     * @param activationTime
     */
    public void setActivationTime(Timestamp activationTime) {
        this.activationTime = activationTime;
    }

    /**
     * 获取激活 ip
     * @return 激活 ip
     */
    @Column(name = "activation_ip", nullable = false, length = 15)
    public String getActivationIP() {
        return activationIP;
    }

    /**
     * 设置激活 ip
     * @param activationIP 激活 ip
     */
    public void setActivationIP(String activationIP) {
        this.activationIP = activationIP;
    }

    /**
     * 获取激活用户 id
     * @return 激活用户 id
     */
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    /**
     *  设置激活用户 id
     * @param userId 用户 id
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
