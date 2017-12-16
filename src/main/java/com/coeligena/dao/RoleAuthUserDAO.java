package com.coeligena.dao;

import com.coeligena.model.RoleAuthUserDO;

/**
 * <p>
 *     角色验证用户数据访问接口
 * </p>
 * Created by Ellery on 2017/12/16.
 */
public interface RoleAuthUserDAO {

    void saveRoleAuthUser(RoleAuthUserDO roleAuthUserDO);
}
