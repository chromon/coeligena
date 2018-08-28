package com.coeligena.service;

import com.coeligena.model.AuthUsersDO;

/**
 * <p>
 *     验证用户业务逻辑接口
 * </p>
 *
 * Created by Ellery on 2017/12/9.
 */
public interface AuthUsersService {

    /**
     * 检查用户邮件是否已注册
     * @param email 用户邮件
     * @return 是否存在
     */
    boolean queryUserEmailExists(String email);

    /**
     * 存储用户
     * @param authUsersDO 用户信息
     */
    void saveUserForSignUp(AuthUsersDO authUsersDO);

    /**
     * 由邮件地址查询用户
     * @param email 邮件地址
     * @return 用户信息
     */
    AuthUsersDO queryUserByEmail(String email);
}
