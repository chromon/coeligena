package com.coeligena.service.impl;

import com.coeligena.dao.RelationshipsDAO;
import com.coeligena.model.RelationshipsDO;
import com.coeligena.service.RelationshipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * relationships service impl
 * Created by Ellery on 2018/11/17.
 */
@Service("relationshipsService")
public class RelationshipsServiceImpl implements RelationshipsService {

    private RelationshipsDAO relationshipsDAO;

    /**
     * 添加关注信息
     * @param relationshipsDO 关注信息
     */
    @Override
    public void saveRelationships(RelationshipsDO relationshipsDO) {
        this.relationshipsDAO.saveRelationships(relationshipsDO);
    }

    /**
     * 取消关注
     * @param relationshipsDO 关注信息
     */
    @Override
    public void deleteRelationships(RelationshipsDO relationshipsDO) {
        this.relationshipsDAO.deleteRelationships(relationshipsDO);
    }

    @Autowired
    public void setRelationshipsDAO(RelationshipsDAO relationshipsDAO) {
        this.relationshipsDAO = relationshipsDAO;
    }
}
