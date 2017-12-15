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
    public boolean checkUserEmailExists(String email) {

        AuthUsersDO authUsersDO = this.authUsersDAO.queryAuthUserByEmail(email);

        return authUsersDO != null;
    }

    @Override
    public void saveUserForSignUp(AuthUsersDO authUsersDO) {
        this.authUsersDAO.saveAuthUser(authUsersDO);
    }

    @Autowired
    public void setAuthUsersDAO(AuthUsersDAO authUsersDAO) {
        this.authUsersDAO = authUsersDAO;
    }
}
