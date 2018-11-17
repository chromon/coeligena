package com.coeligena.dao.impl;

import com.coeligena.dao.RelationshipsDAO;
import com.coeligena.model.RelationshipsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
}
