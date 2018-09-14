package com.coeligena.dao.impl;

import com.coeligena.dao.CollectionFoldersDAO;
import com.coeligena.model.CollectionFoldersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *     收藏夹信息持久化
 * </p>
 * Created by Ellery on 2018/9/9.
 */
@Repository
public class CollectionFolderDAOImpl implements CollectionFoldersDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    /**
     * 创建收藏夹
     * @param collectionFoldersDO 收藏夹详细信息
     */
    @Override
    public void saveCollectionFolders(CollectionFoldersDO collectionFoldersDO) {
        this.getSession().save(collectionFoldersDO);
    }

    /**
     * 由创建用户 id 查询全部收藏夹信息
     * @param ownerId 用户 id
     * @return 收藏夹列表
     */
    @Override
    public List<CollectionFoldersDO> queryCollectionFoldersByOwnerId(int ownerId) {
        String sql = "from CollectionFoldersDO cf where cf.ownerId =:ownerId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("ownerId", ownerId);
        return query.list();
    }

    /**
     * 更新收藏夹
     * @param collectionFoldersDO 收藏夹信息
     */
    @Override
    public void updateCollectionFolders(CollectionFoldersDO collectionFoldersDO) {
        this.getSession().update(collectionFoldersDO);
    }

    /**
     * 由收藏夹 id 查询收藏夹信息
     * @param id 收藏夹 id
     * @return 收藏夹信息
     */
    @Override
    public CollectionFoldersDO queryCollectionFolderById(int id) {
        String sql = "from CollectionFoldersDO cf where cf.id =:id";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("id", id);
        return (CollectionFoldersDO) query.uniqueResult();
    }
}
