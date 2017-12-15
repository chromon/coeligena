package com.coeligena.dao;

import com.coeligena.model.AuthUsersDO;

/**
 * <p>
 *     验证用户数据访问对象类
 * </p>
 *
 * Created by Ellery on 2017/12/6.
 */
public interface AuthUsersDAO {

    /**
     * 由 email 地址查询验证用户
     * @param email 待查询 email 地址
     * @return 验证用户实体
     */
    AuthUsersDO queryAuthUserByEmail(String email);


    /**
     * 存储用户
     * @param authUsersDO
     */
    void saveAuthUser(AuthUsersDO authUsersDO);
}
