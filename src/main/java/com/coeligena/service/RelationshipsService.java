package com.coeligena.service;

import com.coeligena.model.RelationshipsDO;

/**
 * relationships service
 * Created by Ellery on 2018/11/17.
 */
public interface RelationshipsService {

    /**
     * 添加关注信息
     * @param relationshipsDO 关注信息
     */
    void saveRelationships(RelationshipsDO relationshipsDO);

    /**
     * 取消关注
     * @param relationshipsDO 关注信息
     */
    void deleteRelationships(RelationshipsDO relationshipsDO);
}
