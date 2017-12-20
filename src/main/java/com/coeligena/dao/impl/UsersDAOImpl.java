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

    @Override
    public void saveUsers(UsersDO usersDO) {
        this.getSession().save(usersDO);
    }
}
