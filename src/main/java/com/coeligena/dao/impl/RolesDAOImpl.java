package com.coeligena.dao.impl;

import com.coeligena.dao.RolesDAO;
import com.coeligena.model.RolesDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     角色业务实现类
 * </p>
 *
 * Created by Ellery on 2017/12/15.
 */
@Repository
public class RolesDAOImpl implements RolesDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public RolesDO queryRolesByRoleName(String roleName) {
        String sql = "select ro from RolesDO ro where ro.roleName = :roleName";
        return (RolesDO) this.getSession().createQuery(sql)
                .setParameter("roleName", roleName).uniqueResult();
    }
}
