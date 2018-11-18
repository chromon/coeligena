package com.coeligena.dto;

import com.coeligena.model.UsersDO;

/**
 * profile dto
 * Created by Ellery on 2018/11/18.
 */
public class ProfileDTO {

    private UsersDO usersDO;

    private boolean followed;

    public UsersDO getUsersDO() {
        return usersDO;
    }

    public void setUsersDO(UsersDO usersDO) {
        this.usersDO = usersDO;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }
}
