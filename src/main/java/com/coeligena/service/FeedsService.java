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
}
