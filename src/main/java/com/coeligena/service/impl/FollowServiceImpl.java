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

    /**
     * 由问题 id 和 用户 id 查询关注信息
     * @param questionId 问题 id
     * @param userId 用户 id
     * @return 关注信息
     */
    @Override
    public FollowDO queryFollowByQidAndUid(int questionId, int userId) {
        return this.followDAO.queryFollowByQidAndUid(questionId, userId);
    }

    /**
     * 删除问题关注
     * @param followDO 问题关注信息
     */
    @Override
    public void deleteFollow(FollowDO followDO) {
        this.followDAO.deleteFollow(followDO);
    }

    /**
     * 查询问题关注数量
     * @param questionId 问题 id
     * @return 关注数量
     */
    @Override
    public int queryQuestionFollowerCount(int questionId) {
        return this.followDAO.queryQuestionFollowerCount(questionId);
    }

    @Autowired
    public void setFollowDAO(FollowDAO followDAO) {
        this.followDAO = followDAO;
    }
}
