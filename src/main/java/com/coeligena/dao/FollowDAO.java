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
}
