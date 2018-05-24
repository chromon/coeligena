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

    /**
     * 由标签名称查询标签
     * @param topicName 标签名称
     * @return 查找到的标签列表
     */
    List<TopicNodesDO> queryTopicNodes(String topicName);
}
