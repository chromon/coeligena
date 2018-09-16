package com.coeligena.dao;

import com.coeligena.model.CollectionsDO;

/**
 * <p>
 *     收藏信息数据访问对象
 * </p>
 * Created by Ellery on 2018/9/14.
 */
public interface CollectionsDAO {

    /**
     * 添加回答到收藏夹
     * @param collectionsDO 收藏信息
     */
    void addCollections(CollectionsDO collectionsDO);

    /**
     * 由回答 id 和收藏夹 id 查询收藏信息
     * @param answerId 回答 id
     * @param folderId 收藏夹 id
     * @return 收藏信息
     */
    CollectionsDO queryCollectionsByAnswerIdAndFolderId(int answerId, int folderId);
}
