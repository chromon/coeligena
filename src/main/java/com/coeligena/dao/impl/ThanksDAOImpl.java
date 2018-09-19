package com.coeligena.dao.impl;

import com.coeligena.dao.ThanksDAO;
import com.coeligena.model.ThanksDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *  感谢信息持久化
 * </p>
 * Created by Ellery on 2018/9/19.
 */
@Repository
public class ThanksDAOImpl implements ThanksDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加用户感谢
     * @param thanksDO 感谢信息
     */
    @Override
    public void addThank(ThanksDO thanksDO) {
        this.getSession().save(thanksDO);
    }

    /**
     * 有回答 id 和感谢用户 id 查询感谢信息
     * @param answerId 问题 id
     * @param thankUserId 用户 id
     * @return 详细信息
     */
    @Override
    public ThanksDO queryThanksByAnswerIdAndUId(int answerId, int thankUserId) {
        String sql = "select t from ThanksDO t where t.answerId = :answerId and t.thankUserId = :thankUserId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerId", answerId);
        query.setParameter("thankUserId", thankUserId);
        return (ThanksDO) query.uniqueResult();
    }

    /**
     * 删除感谢
     * @param thanksDO 感谢信息
     */
    @Override
    public void deleteThank(ThanksDO thanksDO) {
        this.getSession().delete(thanksDO);
    }
}
