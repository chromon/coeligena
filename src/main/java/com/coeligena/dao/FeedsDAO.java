package com.coeligena.dao;

import com.coeligena.model.FeedsDO;

/**
 * <p>
 *     动态信息接口
 * </p>
 * Created by Ellery on 2018/5/20.
 */
public interface FeedsDAO {

    /**
     * 添加动态
     * @param feedsDO 动态
     */
    void addFeeds(FeedsDO feedsDO);
}
