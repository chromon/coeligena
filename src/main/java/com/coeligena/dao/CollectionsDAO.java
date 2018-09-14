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
}
