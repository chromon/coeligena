package com.coeligena.dto;

import com.coeligena.model.AuthUsersDO;
import com.coeligena.model.UsersDO;

/**
 * <P>
 *     用户信息传输对象
 * </P>
 * Created by Ellery on 2017/12/20.
 */
public class UserInfoDTO {

    private AuthUsersDO authUsersDO;

    private UsersDO usersDO;

    public AuthUsersDO getAuthUsersDO() {
        return authUsersDO;
    }

    public void setAuthUsersDO(AuthUsersDO authUsersDO) {
        this.authUsersDO = authUsersDO;
    }

    public UsersDO getUsersDO() {
        return usersDO;
    }

    public void setUsersDO(UsersDO usersDO) {
        this.usersDO = usersDO;
    }
}
