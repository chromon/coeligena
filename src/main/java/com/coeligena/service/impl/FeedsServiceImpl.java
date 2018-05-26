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

    @Override
    public List<FeedsDO> queryAllFeeds() {
        return feedsDAO.queryFeeds();
    }

    @Autowired
    public void setFeedsDAO(FeedsDAO feedsDAO) {
        this.feedsDAO = feedsDAO;
    }
}
