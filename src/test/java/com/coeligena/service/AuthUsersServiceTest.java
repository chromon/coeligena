package com.coeligena.service;

import com.coeligena.function.date.DateUtils;
import com.coeligena.model.AuthUsersDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * auth users service test
 * Created by Ellery on 2018/8/29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class AuthUsersServiceTest {

    private AuthUsersService authUsersService;

    @Test
    public void testQueryUserEmailExist() {
        Assert.assertEquals(authUsersService
                .queryUserByEmail("xxxx").getEmail(),
                "xxxx");
    }

    @Test
    public void testSaveAuthUserForSignUp() {
        AuthUsersDO authUsersDO = new AuthUsersDO();
        authUsersDO.setEmail("test@test.test");
        authUsersDO.setPassword("123456");
        authUsersDO.setSalt("salt");
        authUsersDO.setCreateTime(DateUtils.currentTime());
        authUsersDO.setLastLoginTime(DateUtils.currentTime());
        authUsersDO.setLastLoginIP("127.0.0.1");
        authUsersDO.setMutedTime(DateUtils.currentTime());
        authUsersService.saveUserForSignUp(authUsersDO);

        Assert.assertEquals(authUsersService
                .queryUserEmailExists("test@test.test"), true);
    }

    @Test
    public void testQueryUserByEmail() {
        AuthUsersDO authUsersDO = new AuthUsersDO();
        authUsersDO.setEmail("test@test.test");
        authUsersDO.setPassword("123456");
        authUsersDO.setSalt("salt");
        authUsersDO.setCreateTime(DateUtils.currentTime());
        authUsersDO.setLastLoginTime(DateUtils.currentTime());
        authUsersDO.setLastLoginIP("127.0.0.1");
        authUsersDO.setMutedTime(DateUtils.currentTime());
        authUsersService.saveUserForSignUp(authUsersDO);

        Assert.assertEquals(authUsersService
                .queryUserByEmail("test@test.test").getEmail(),
                "test@test.test");
    }

    @Autowired
    public void setAuthUsersService(AuthUsersService authUsersService) {
        this.authUsersService = authUsersService;
    }
}
