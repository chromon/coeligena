package com.coeligena.dao.impl;

import com.coeligena.dao.TopicNodesDAO;
import com.coeligena.model.TopicNodesDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *     话题节点持久化
 * </p>
 * Created by Ellery on 2018/1/20.
 */
@Repository
public class TopicNodesDAOImpl implements TopicNodesDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 由标签名称查询标签
     * @param topicName 标签名称
     * @return 查找到的标签列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<TopicNodesDO> queryTopicNodes(String topicName) {
        String sql = "select tn from TopicNodesDO tn where tn.topicName like :topicName";
        List<TopicNodesDO> topicNodesDOList = this.getSession()
                .createQuery(sql).setParameter("topicName", "%" + topicName + "%").list();

        return topicNodesDOList;
    }
}
