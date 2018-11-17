package com.coeligena.dao;

import com.coeligena.model.RelationshipsDO;

/**
 * relationships dao
 * Created by Ellery on 2018/11/17.
 */
public interface RelationshipsDAO {

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
