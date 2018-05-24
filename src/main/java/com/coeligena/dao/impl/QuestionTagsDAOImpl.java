package com.coeligena.dao.impl;

import com.coeligena.dao.QuestionTagsDAO;
import com.coeligena.model.QuestionTagsDO;
import com.coeligena.model.TopicNodesDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *     问题标签持久化
 * </p>
 * Created by Ellery on 2018/5/20.
 */
@Repository
public class QuestionTagsDAOImpl implements QuestionTagsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加问题标签
     * @param questionTagsDO 问题标签
     */
    @Override
    public void addQuestionTag(QuestionTagsDO questionTagsDO) {
        this.getSession().save(questionTagsDO);
    }

    /**
     * 由问题 id 查询问题标签
     * @param questionId 待查询问题 id
     * @return 问题标签列表
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<TopicNodesDO> queryQuestionTagsByQid(int questionId) {
        String sql = "select tn from QuestionTagsDO qt, TopicNodesDO tn where qt.questionTopicId = tn.id and qt.questionId = :questionId";
        List<TopicNodesDO> topicNodesDOList = this.getSession()
                .createQuery(sql).setParameter("questionId", questionId).list();
        return topicNodesDOList;
    }
}
