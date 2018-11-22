package com.coeligena.dto;

import java.io.Serializable;

/**
 * follow dto
 * Created by Ellery on 2018/11/22.
 */
public class FollowDTO implements Serializable {

    private int userId;

    private int followedId;

    private int followAction;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFollowedId() {
        return followedId;
    }

    public void setFollowedId(int followedId) {
        this.followedId = followedId;
    }

    public int getFollowAction() {
        return followAction;
    }

    public void setFollowAction(int followAction) {
        this.followAction = followAction;
    }
}
