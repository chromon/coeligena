package com.coeligena.service.impl;

import com.coeligena.dao.RoleAuthUserDAO;
import com.coeligena.model.RoleAuthUserDO;
import com.coeligena.service.RoleAuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     角色用户业务逻辑实现类
 * </p>
 * Created by Ellery on 2017/12/16.
 */
@Service("roleAuthUserService")
public class RoleAuthUserServiceImpl implements RoleAuthUserService {

    private RoleAuthUserDAO roleAuthUserDAO;

    @Override
    public void saveRoleAuthUser(RoleAuthUserDO roleAuthUserDO) {
        this.roleAuthUserDAO.saveRoleAuthUser(roleAuthUserDO);
    }

    @Autowired
    public void setRoleAuthUserDAO(RoleAuthUserDAO roleAuthUserDAO) {
        this.roleAuthUserDAO = roleAuthUserDAO;
    }
}
