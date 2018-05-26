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

    /**
     * 添加用户
     * @param usersDO 用户对象
     */
    @Override
    public void saveUsersForSignUp(UsersDO usersDO) {
        this.usersDAO.saveUsers(usersDO);
    }

    /**
     * 由验证用户 id 查询用户详细信息
     * @param authUserId 验证用户 id
     * @return 用户详细信息
     */
    @Override
    public UsersDO queryUsersByAuthUserId(int authUserId) {
        return this.usersDAO.queryUsersByAuthId(authUserId);
    }

    /**
     * 更新用户信息
     * @param usersDO 用户信息
     */
    @Override
    public void modifyUsers(UsersDO usersDO) {
        this.usersDAO.updateUsers(usersDO);
    }

    @Override
    public UsersDO queryUserByUserId(int userId) {
        return this.usersDAO.queryUserByUserId(userId);
    }

    @Autowired
    public void setUsersDAO(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }
}
