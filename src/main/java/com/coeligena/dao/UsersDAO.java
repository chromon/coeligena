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

    void saveUsers(UsersDO usersDO);

    UsersDO queryUsersByAuthId(int authUserId);
}
