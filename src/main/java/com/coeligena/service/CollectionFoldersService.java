package com.coeligena.service;

import com.coeligena.model.CollectionFoldersDO;

import java.util.List;

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

    /**
     * 由创建用户 id 查询全部收藏夹信息
     * @param ownerId 用户 id
     * @return 收藏夹列表
     */
    List<CollectionFoldersDO> queryCollectionFoldersByOwnerId(int ownerId);

    /**
     * 更新收藏夹
     * @param collectionFoldersDO 收藏夹信息
     */
    void modifyCollectionFolders(CollectionFoldersDO collectionFoldersDO);

    /**
     * 由收藏夹 id 查询收藏夹信息
     * @param id 收藏夹 id
     * @return 收藏夹信息
     */
    CollectionFoldersDO queryCollectionFolderById(int id);
}
