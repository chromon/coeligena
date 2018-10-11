package com.coeligena.dao.impl;

import com.coeligena.dao.FollowDAO;
import com.coeligena.model.FollowDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 问题关注数据持久化
 * Created by Ellery on 2018/10/10.
 */
@Repository
public class FollowDAOImpl implements FollowDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 关注问题
     * @param followDO 问题关注信息
     */
    @Override
    public void addQuestionFollow(FollowDO followDO) {
        this.getSession().save(followDO);
    }

    /**
     * 由问题 id 和 用户 id 查询关注信息
     * @param questionId 问题 id
     * @param userId 用户 id
     * @return 关注信息
     */
    @Override
    public FollowDO queryFollowByQidAndUid(int questionId, int userId) {
        String sql = "from FollowDO f where f.questionId = :questionId and f.followerId = :userId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("questionId", questionId);
        query.setParameter("userId", userId);
        return (FollowDO) query.uniqueResult();
    }

    /**
     * 删除问题关注
     * @param followDO 问题关注信息
     */
    @Override
    public void deleteFollow(FollowDO followDO) {
        this.getSession().delete(followDO);
    }
}
