package com.coeligena.service.impl;

import com.coeligena.dao.FollowDAO;
import com.coeligena.model.FollowDO;
import com.coeligena.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 问题关注业务逻辑实现类
 * Created by Ellery on 2018/10/10.
 */
@Service("followService")
public class FollowServiceImpl implements FollowService {

    private FollowDAO followDAO;

    /**
     * 关注问题
     * @param followDO 问题关注信息
     */
    @Override
    public void saveQuestionFollow(FollowDO followDO) {
        this.followDAO.addQuestionFollow(followDO);
    }

    @Autowired
    public void setFollowDAO(FollowDAO followDAO) {
        this.followDAO = followDAO;
    }
}
