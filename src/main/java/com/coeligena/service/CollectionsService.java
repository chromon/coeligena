package com.coeligena.service;

import com.coeligena.model.CollectionsDO;

/**
 * 收藏信息业务实现接口
 * Created by Ellery on 2018/9/14.
 */
public interface CollectionsService {

    /**
     * 添加回答到收藏夹
     * @param collectionsDO 收藏信息
     */
    void saveCollections(CollectionsDO collectionsDO);

    /**
     * 由回答 id 和收藏夹 id 查询收藏信息
     * @param answerId 回答 id
     * @param folderId 收藏夹 id
     * @return 收藏信息
     */
    CollectionsDO queryCollectionByAnswerIdAndFolderId(int answerId, int folderId);
}
