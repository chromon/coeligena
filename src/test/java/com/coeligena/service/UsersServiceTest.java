package com.coeligena.service;

import com.coeligena.model.UsersDO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * users service test
 * Created by Ellery on 2018/9/2.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/configs/application-context.xml"})
@Transactional
@Rollback
public class UsersServiceTest {

    private UsersService usersService;

    @Test
    public void testSaveUserForSignUp() {
        UsersDO usersDO = new UsersDO();
        usersDO.setFullname("test");
        usersService.saveUsersForSignUp(usersDO);

        Assert.assertEquals(usersDO.getAuthUserId(), 0);
    }

    @Test
    public void testQueryUsersByAuthUserId() {
        UsersDO usersDO = new UsersDO();
        usersDO.setFullname("test");
        usersService.saveUsersForSignUp(usersDO);

        Assert.assertEquals(usersService.queryUsersByAuthUserId(
                usersDO.getAuthUserId()).getFullname(), "test");
    }

    @Test
    public void testModifyUsers() {
        UsersDO usersDO = new UsersDO();
        usersDO.setFullname("test");
        usersService.saveUsersForSignUp(usersDO);

        usersDO.setFullname("test2");
        usersService.modifyUsers(usersDO);

        Assert.assertEquals(usersService.queryUsersByAuthUserId(
                usersDO.getAuthUserId()).getFullname(), "test2");
    }

    @Test
    public void testQueryUserByUserId() {
        UsersDO usersDO = new UsersDO();
        usersDO.setFullname("test");
        usersService.saveUsersForSignUp(usersDO);

        Assert.assertEquals(usersService.queryUserByUserId(
                usersDO.getId()).getFullname(), "test");
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
