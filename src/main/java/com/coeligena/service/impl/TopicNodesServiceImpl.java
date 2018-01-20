package com.coeligena.service.impl;

import com.coeligena.dao.TopicNodesDAO;
import com.coeligena.model.TopicNodesDO;
import com.coeligena.service.TopicNodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *     话题节点信息实现类
 * </p>
 * Created by Ellery on 2018/1/20.
 */
@Service("topicNodesService")
public class TopicNodesServiceImpl implements TopicNodesService {

    private TopicNodesDAO topicNodesDAO;

    @Override
    public List<TopicNodesDO> queryTopicNodesByName(String topicName) {
        return topicNodesDAO.queryTopicNodes(topicName);
    }

    @Autowired
    public void setTopicNodesDAO(TopicNodesDAO topicNodesDAO) {
        this.topicNodesDAO = topicNodesDAO;
    }
}
