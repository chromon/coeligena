package com.coeligena.service;

import com.coeligena.model.TopicNodesDO;

import java.util.List;

/**
 * <p>
 *     话题节点信息类
 * </p>
 * Created by Ellery on 2018/1/20.
 */
public interface TopicNodesService {

    List<TopicNodesDO> queryTopicNodesByName(String topicName);
}
