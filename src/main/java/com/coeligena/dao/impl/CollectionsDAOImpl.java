package com.coeligena.dao.impl;

import com.coeligena.dao.CollectionsDAO;
import com.coeligena.model.CollectionsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    /**
     * 由回答 id 和收藏夹 id 查询收藏信息
     * @param answerId 回答 id
     * @param folderId 收藏夹 id
     * @return 收藏信息
     */
    @Override
    public CollectionsDO queryCollectionsByAnswerIdAndFolderId(int answerId, int folderId) {
        String sql = "from CollectionsDO cd where cd.answerId = :answerId and cd.collectionFolderId =:collectionFolderId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerId", answerId);
        query.setParameter("collectionFolderId", folderId);
        return (CollectionsDO) query.uniqueResult();
    }
}
