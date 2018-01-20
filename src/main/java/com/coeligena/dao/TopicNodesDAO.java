package com.coeligena.dao;

import com.coeligena.model.TopicNodesDO;

import java.util.List;

/**
 * <p>
 *     话题节点访问对象
 * </p>
 *
 * Created by Ellery on 2018/1/20.
 */
public interface TopicNodesDAO {

    List<TopicNodesDO> queryTopicNodes(String topicName);
}
