package com.coeligena.service;

import com.coeligena.model.RoleAuthUserDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * role auth user service test
 * Created by Ellery on 2018/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class RoleAuthUserServiceTest {

    private RoleAuthUserService roleAuthUserService;

    @Test
    public void testSaveAuthUser() {
        RoleAuthUserDO roleAuthUserDO = new RoleAuthUserDO();
        roleAuthUserService.saveRoleAuthUser(roleAuthUserDO);

        Assert.assertEquals(roleAuthUserDO.getRoleId(), 0);
    }

    @Autowired
    public void setRoleAuthUserService(RoleAuthUserService roleAuthUserService) {
        this.roleAuthUserService = roleAuthUserService;
    }
}
