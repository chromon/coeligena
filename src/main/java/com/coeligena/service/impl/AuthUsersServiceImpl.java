package com.coeligena.service.impl;

import com.coeligena.dao.AuthUsersDAO;
import com.coeligena.model.AuthUsersDO;
import com.coeligena.service.AuthUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *    验证用户业务逻辑实现类
 * </p>
 *
 * Created by Ellery on 2017/12/9.
 */
@Service("authUsersService")
public class AuthUsersServiceImpl implements AuthUsersService {

    private AuthUsersDAO authUsersDAO;

    @Override
    public boolean queryUserEmailExists(String email) {

        AuthUsersDO authUsersDO = this.authUsersDAO.queryAuthUserByEmail(email);

        return authUsersDO != null;
    }
    /**
     * 存储用户
     * @param authUsersDO 用户信息
     */
    @Override
    public void saveUserForSignUp(AuthUsersDO authUsersDO) {
        this.authUsersDAO.saveAuthUser(authUsersDO);
    }

    /**
     * 由 email 地址查询验证用户
     * @param email 待查询 email 地址
     * @return 验证用户实体
     */
    @Override
    public AuthUsersDO queryUserByEmail(String email) {
        AuthUsersDO authUsersDO = this.authUsersDAO.queryAuthUserByEmail(email);
        return authUsersDO;
    }

    @Autowired
    public void setAuthUsersDAO(AuthUsersDAO authUsersDAO) {
        this.authUsersDAO = authUsersDAO;
    }
}
