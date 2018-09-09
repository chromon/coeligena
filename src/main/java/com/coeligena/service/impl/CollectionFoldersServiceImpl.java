package com.coeligena.service.impl;

import com.coeligena.dao.CollectionFoldersDAO;
import com.coeligena.model.CollectionFoldersDO;
import com.coeligena.service.CollectionFoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *     收藏夹信息实现类
 * </p>
 * Created by Ellery on 2018/9/9.
 */
@Service("collectionFoldersService")
public class CollectionFoldersServiceImpl implements CollectionFoldersService {

    private CollectionFoldersDAO collectionFoldersDAO;

    /**
     * 创建收藏夹
     * @param collectionFoldersDO 收藏夹详细信息
     */
    @Override
    public void saveCollectionFolders(CollectionFoldersDO collectionFoldersDO) {
        this.collectionFoldersDAO.saveCollectionFolders(collectionFoldersDO);
    }

    @Autowired
    public void setCollectionFoldersDAO(CollectionFoldersDAO collectionFoldersDAO) {
        this.collectionFoldersDAO = collectionFoldersDAO;
    }
}
