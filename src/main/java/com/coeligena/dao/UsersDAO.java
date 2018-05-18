package com.coeligena.dao;

import com.coeligena.model.UsersDO;

/**
 * <p>
 *     用户信息数据访问对象
 * </p>
 *
 * Created by Ellery on 2017/12/20.
 */
public interface UsersDAO {

    /**
     * 添加用户
     * @param usersDO 用户对象
     */
    void saveUsers(UsersDO usersDO);

    /**
     * 由验证用户 id 查询用户详细信息
     * @param authUserId 验证用户 id
     * @return 用户详细信息
     */
    UsersDO queryUsersByAuthId(int authUserId);

    /**
     * 更新用户信息
     * @param usersDO 用户信息
     */
    void updateUsers(UsersDO usersDO);
}
