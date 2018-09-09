package com.coeligena.dao.impl;

import com.coeligena.dao.CollectionFoldersDAO;
import com.coeligena.model.CollectionFoldersDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

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
}
