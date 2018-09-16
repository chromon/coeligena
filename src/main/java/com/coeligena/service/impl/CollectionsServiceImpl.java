package com.coeligena.service.impl;

import com.coeligena.dao.CollectionsDAO;
import com.coeligena.model.CollectionsDO;
import com.coeligena.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收藏信息业务实现类
 * Created by Ellery on 2018/9/14.
 */
@Service("collectionsService")
public class CollectionsServiceImpl implements CollectionsService {

    private CollectionsDAO collectionsDAO;

    /**
     * 添加回答到收藏夹
     * @param collectionsDO 收藏信息
     */
    @Override
    public void saveCollections(CollectionsDO collectionsDO) {
        this.collectionsDAO.addCollections(collectionsDO);
    }

    /**
     * 由回答 id 和收藏夹 id 查询收藏信息
     * @param answerId 回答 id
     * @param folderId 收藏夹 id
     * @return 收藏信息
     */
    @Override
    public CollectionsDO queryCollectionByAnswerIdAndFolderId(int answerId, int folderId) {
        return this.collectionsDAO.queryCollectionsByAnswerIdAndFolderId(answerId, folderId);
    }

    @Autowired
    public void setCollectionsDAO(CollectionsDAO collectionsDAO) {
        this.collectionsDAO = collectionsDAO;
    }
}
