package com.coeligena.dao.impl;

import com.coeligena.dao.AuthUsersDAO;
import com.coeligena.model.AuthUsersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     验证用户业务实现类
 * </p>
 *
 * Created by Ellery on 2017/12/6.
 */
@Repository
public class AuthUsersDAOImpl implements AuthUsersDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public AuthUsersDO queryAuthUserByEmail(String email) {
        String sql = "select au from AuthUsersDO au where au.email = :email";
        AuthUsersDO authUsersDO = (AuthUsersDO) this.getSession().createQuery(sql)
                .setParameter("email", email).uniqueResult();
        return authUsersDO;
    }
}
