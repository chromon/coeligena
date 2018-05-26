package com.coeligena.dao;

import com.coeligena.model.FeedsDO;

import java.util.List;

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

    /**
     * 查询全部动态
     * @return 动态列表
     */
    List<FeedsDO> queryFeeds();
}
