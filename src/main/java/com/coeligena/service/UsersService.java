package com.coeligena.service;

import com.coeligena.model.UsersDO;

/**
 * <p>
 *     用户信息业务实现接口
 * </p>
 * Created by Ellery on 2017/12/20.
 */

public interface UsersService {

    /**
     * 添加用户
     * @param usersDO 用户对象
     */
    void saveUsersForSignUp(UsersDO usersDO);

    /**
     * 由验证用户 id 查询用户详细信息
     * @param authUserId 验证用户 id
     * @return 用户详细信息
     */
    UsersDO queryUsersByAuthUserId(int authUserId);

    /**
     * 更新用户信息
     * @param usersDO 用户信息
     */
    void modifyUsers(UsersDO usersDO);

    /**
     * 由用户 id 查询用户详细信息
     * @param userId 用户 ic
     * @return 用户信息
     */
    UsersDO queryUserByUserId(int userId);
}
