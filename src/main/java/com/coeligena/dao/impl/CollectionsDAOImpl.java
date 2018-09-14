package com.coeligena.dao.impl;

import com.coeligena.dao.CollectionsDAO;
import com.coeligena.model.CollectionsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 收藏信息持久化
 *
 * Created by Ellery on 2018/9/14.
 */
@Repository
public class CollectionsDAOImpl implements CollectionsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加回答到收藏夹
     * @param collectionsDO 收藏信息
     */
    @Override
    public void addCollections(CollectionsDO collectionsDO) {
        this.getSession().save(collectionsDO);
    }
}
