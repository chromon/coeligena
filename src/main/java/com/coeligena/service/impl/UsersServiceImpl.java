package com.coeligena.service.impl;

import com.coeligena.dao.UsersDAO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *      用户信息业务实现类
 * </p>
 * Created by Ellery on 2017/12/20.
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {

    private UsersDAO usersDAO;

    @Override
    public void saveUsersForSignUp(UsersDO usersDO) {
        this.usersDAO.saveUsers(usersDO);
    }

    @Override
    public UsersDO queryUsersByAuthUserId(int authUserId) {
        return this.usersDAO.queryUsersByAuthId(authUserId);
    }

    @Autowired
    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }
}
