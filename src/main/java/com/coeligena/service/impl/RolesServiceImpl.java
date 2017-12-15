package com.coeligena.service.impl;

import com.coeligena.dao.RolesDAO;
import com.coeligena.model.RolesDO;
import com.coeligena.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     角色业务逻辑实现类
 * </p>
 *
 * Created by Ellery on 2017/12/15.
 */
@Service("rolesService")
public class RolesServiceImpl implements RolesService{

    private RolesDAO rolesDAO;

    @Override
    public RolesDO queryRolesForSignUp(String roleName) {

        return rolesDAO.queryRolesByRoleName(roleName);
    }

    @Autowired
    public void setRolesDAO(RolesDAO rolesDAO) {
        this.rolesDAO = rolesDAO;
    }
}
