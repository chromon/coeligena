package com.coeligena.service.impl;

import com.coeligena.dao.FeedsDAO;
import com.coeligena.model.FeedsDO;
import com.coeligena.service.FeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *     动态信息业务实现类
 * </p>
 * Created by Ellery on 2018/5/20.
 */
@Service("feedsService")
public class FeedsServiceImpl implements FeedsService {

    private FeedsDAO feedsDAO;

    /**
     * 添加动态
     * @param feedsDO 动态
     */
    @Override
    public void saveFeeds(FeedsDO feedsDO) {
        this.feedsDAO.addFeeds(feedsDO);
    }

    /**
     * 查询全部动态
     * @return 动态列表
     */
    @Override
    public List<FeedsDO> queryAllFeeds() {
        return feedsDAO.queryFeeds();
    }

    /**
     * 根据动态类型对应 id，动态类型以及动态发起人查询动态
     * @param feedsId 动态类型对应 id
     * @param feedsType 动态类型
     * @param feedsUserId 动态发起人
     * @return 动态信息
     */
    @Override
    public FeedsDO queryFeedsByIdType(int feedsId, byte feedsType, int feedsUserId) {
        return feedsDAO.queryFeedsByIdType(feedsId, feedsType, feedsUserId);
    }

    /**
     * 删除动态
     * @param feedsDO 动态信息
     */
    @Override
    public void deleteFeeds(FeedsDO feedsDO) {
        this.feedsDAO.deleteFeeds(feedsDO);
    }

    @Autowired
    public void setFeedsDAO(FeedsDAO feedsDAO) {
        this.feedsDAO = feedsDAO;
    }
}
