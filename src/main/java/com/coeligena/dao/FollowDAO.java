package com.coeligena.dao;

import com.coeligena.model.FollowDO;

/**
 * 问题关注数据访问对象
 * Created by Ellery on 2018/10/10.
 */
public interface FollowDAO {

    /**
     * 关注问题
     * @param followDO 问题关注信息
     */
    void addQuestionFollow(FollowDO followDO);

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
