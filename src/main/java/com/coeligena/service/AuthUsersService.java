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
    boolean checkUserEmailExists(String email);

    void saveUserForSignUp(AuthUsersDO authUsersDO);
}
