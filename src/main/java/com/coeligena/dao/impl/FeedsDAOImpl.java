package com.coeligena.dao.impl;

import com.coeligena.dao.FeedsDAO;
import com.coeligena.model.FeedsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *     动态信息持久化
 * </p>
 * Created by Ellery on 2018/5/20.
 */
@Repository
public class FeedsDAOImpl implements FeedsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加动态
     * @param feedsDO 动态
     */
    @Override
    public void addFeeds(FeedsDO feedsDO) {
        this.getSession().save(feedsDO);
    }

    /**
     * 查询全部动态
     * @return 动态列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<FeedsDO> queryFeeds() {
        String sql = "FROM FeedsDO";
        List<FeedsDO> feedsList =  this.getSession().createQuery(sql).list();
        return feedsList;
    }

    /**
     * 根据动态类型对应 id，动态类型以及动态发起人查询动态
     * @param feedsId 动态类型对应 id
     * @param feedsType 动态类型
     * @param feedsUserId 动态发起人
     * @return 动态信息
     */
    @Override
    public FeedsDO queryFeedsByIdType(int feedsId, int feedsType, int feedsUserId) {
        String sql = "from FeedsDO f where f.feedsId =:feedsId and f.feedsType =:feedsType and f.feedsUserId =:feedsUserId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("feedsId", feedsId);
        query.setParameter("feedsType", feedsType);
        query.setParameter("feedsUserId", feedsUserId);
        return (FeedsDO) query.uniqueResult();
    }

    /**
     * 删除动态
     * @param feedsDO 动态信息
     */
    @Override
    public void deleteFeeds(FeedsDO feedsDO) {
        this.getSession().delete(feedsDO);
    }
}
