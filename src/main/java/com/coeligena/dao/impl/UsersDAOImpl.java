package com.coeligena.dao.impl;

import com.coeligena.dao.UsersDAO;
import com.coeligena.model.UsersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     用户信息持久化
 * </p>
 * Created by Ellery on 2017/12/20.
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加用户
     * @param usersDO 用户对象
     */
    @Override
    public void saveUsers(UsersDO usersDO) {
        this.getSession().save(usersDO);
    }

    /**
     * 由验证用户 id 查询用户详细信息
     * @param authUserId 验证用户 id
     * @return 用户详细信息
     */
    @Override
    public UsersDO queryUsersByAuthId(int authUserId) {
        String sql = "select u from UsersDO u where u.authUserId = :authUserId";
        UsersDO usersDO = (UsersDO) this.getSession().createQuery(sql)
                .setParameter("authUserId", authUserId).uniqueResult();
        return usersDO;
    }

    /**
     * 更新用户信息
     * @param usersDO 用户信息
     */
    @Override
    public void updateUsers(UsersDO usersDO) {
        this.getSession().update(usersDO);
    }

    /**
     * 由用户 id 查询用户详细信息
     * @param userId 用户 ic
     * @return 用户信息
     */
    @Override
    public UsersDO queryUserByUserId(int userId) {
        String sql = "select u from UsersDO u where u.id = :userId";
        UsersDO usersDO = (UsersDO) this.getSession().createQuery(sql)
                .setParameter("userId", userId).uniqueResult();
        return usersDO;
    }
}
