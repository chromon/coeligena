package com.coeligena.service;

import com.coeligena.model.FollowDO;

/**
 * 问题关注业务逻辑
 * Created by Ellery on 2018/10/10.
 */
public interface FollowService {

    /**
     * 关注问题
     * @param followDO 问题关注信息
     */
    void saveQuestionFollow(FollowDO followDO);
}
