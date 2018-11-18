package com.coeligena.dao.impl;

import com.coeligena.dao.RelationshipsDAO;
import com.coeligena.model.RelationshipsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * relationships dao impl
 * Created by Ellery on 2018/11/17.
 */
@Repository
public class RelationshipsDAOImpl implements RelationshipsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加关注信息
     * @param relationshipsDO 关注信息
     */
    @Override
    public void saveRelationships(RelationshipsDO relationshipsDO) {
        this.getSession().save(relationshipsDO);
    }

    /**
     * 取消关注
     * @param relationshipsDO 关注信息
     */
    @Override
    public void deleteRelationships(RelationshipsDO relationshipsDO) {
        this.getSession().delete(relationshipsDO);
    }

    /**
     * 由用户 id 和被关注用户 id 查询关注信息
     * @param userId 用户 id
     * @param followedId 被关注用户 id
     * @return 关注信息
     */
    @Override
    public RelationshipsDO queryRelationshipsByUidAndFid(int userId, int followedId) {
        String sql = "from RelationshipsDO r where r.userId =:userId and r.followedId =:followedId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("followedId", followedId);
        return (RelationshipsDO) query.uniqueResult();
    }
}
