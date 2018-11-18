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

    /**
     * 由用户 id 和被关注用户 id 查询关注信息
     * @param userId 用户 id
     * @param followedId 被关注用户 id
     * @return 关注信息
     */
    RelationshipsDO queryRelationshipsByUidAndFid(int userId, int followedId);
}
