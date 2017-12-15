package com.coeligena.service;

import com.coeligena.model.RolesDO;

/**
 * <p>
 *    角色相关业务逻辑接口
 * </p>
 *
 * Created by Ellery on 2017/12/15.
 */
public interface RolesService {

    /**
     * 由角色名称查询角色对象
     * @param roleName 待查询角色名称
     * @return 角色对象
     */
    RolesDO queryRolesForSignUp(String roleName);
}
