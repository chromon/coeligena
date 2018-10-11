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

    /**
     * 由问题 id 和 用户 id 查询关注信息
     * @param questionId 问题 id
     * @param userId 用户 id
     * @return 关注信息
     */
    FollowDO queryFollowByQidAndUid(int questionId, int userId);

    /**
     * 删除问题关注
     * @param followDO 问题关注信息
     */
    void deleteFollow(FollowDO followDO);
}
