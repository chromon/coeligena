package com.coeligena.dao.impl;

import com.coeligena.dao.FollowDAO;
import com.coeligena.model.FollowDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 问题关注数据持久化
 * Created by Ellery on 2018/10/10.
 */
@Repository
public class FollowDAOImpl implements FollowDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 关注问题
     * @param followDO 问题关注信息
     */
    @Override
    public void addQuestionFollow(FollowDO followDO) {
        this.getSession().save(followDO);
    }
}
