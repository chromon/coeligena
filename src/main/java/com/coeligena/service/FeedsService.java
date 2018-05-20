package com.coeligena.service;

import com.coeligena.model.FeedsDO;

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
}
