package com.coeligena.service;

import com.coeligena.model.CollectionFoldersDO;

/**
 * <p>
 *     收藏夹信息业务实现接口
 * </p>
 * Created by Ellery on 2018/9/9.
 */
public interface CollectionFoldersService {

    /**
     * 创建收藏夹
     * @param collectionFoldersDO 收藏夹详细信息
     */
    void saveCollectionFolders(CollectionFoldersDO collectionFoldersDO);
}
