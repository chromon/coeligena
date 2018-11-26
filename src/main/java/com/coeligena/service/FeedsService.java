package com.coeligena.service;

import com.coeligena.model.FeedsDO;

import java.util.List;

/**
 * <p>
 *     动态信息业务实现接口
 * </p>
 * Created by Ellery on 2018/5/20.
 */
public interface FeedsService {

    /**
     * 添加动态
     * @param feedsDO 动态
     */
    void saveFeeds(FeedsDO feedsDO);

    /**
     * 查询全部动态
     * @return 动态列表
     */
    List<FeedsDO> queryAllFeeds();

    /**
     * 根据动态类型对应 id，动态类型以及动态发起人查询动态
     * @param feedsId 动态类型对应 id
     * @param feedsType 动态类型
     * @param feedsUserId 动态发起人
     * @return 动态信息
     */
    FeedsDO queryFeedsByIdType(int feedsId, byte feedsType, int feedsUserId);


    /**
     * 删除动态
     * @param feedsDO 动态信息
     */
    void deleteFeeds(FeedsDO feedsDO);
}
