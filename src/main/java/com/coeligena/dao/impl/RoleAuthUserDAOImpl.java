package com.coeligena.dao.impl;

import com.coeligena.dao.RoleAuthUserDAO;
import com.coeligena.model.RoleAuthUserDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     角色验证用户数据访问类
 * </p>
 * Created by Ellery on 2017/12/16.
 */
@Repository
public class RoleAuthUserDAOImpl implements RoleAuthUserDAO{

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveRoleAuthUser(RoleAuthUserDO roleAuthUserDO) {
        this.getSession().save(roleAuthUserDO);
    }
}
