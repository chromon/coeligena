package com.coeligena.dao;

import com.coeligena.model.RolesDO;

/**
 * <p>
 *     角色数据访问
 * </p>
 *
 * Created by Ellery on 2017/12/15.
 */
public interface RolesDAO {

    /**
     * 由角色名称查询角色信息
     * @param roleName 待查询角色名称
     * @return 角色信息对象
     */
    RolesDO queryRolesByRoleName(String roleName);
}
