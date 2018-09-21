package com.coeligena.dao.impl;

import com.coeligena.dao.NoHelpDAO;
import com.coeligena.model.NoHelpsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 没有帮助数据持久化
 * Created by Ellery on 2018/9/21.
 */
@Repository
public class NoHelpDAOImpl implements NoHelpDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加回答没有帮助数据
     * @param noHelpsDO 回答没有帮助信息
     */
    @Override
    public void addNoHelp(NoHelpsDO noHelpsDO) {
        this.getSession().save(noHelpsDO);
    }

    /**
     * 由回答 id 和用户 id 查询回答没有帮助信息
     * @param answerId 回答 id
     * @param userId 用户 id
     * @return 回答没有帮助信息
     */
    @Override
    public NoHelpsDO queryNoHelpByAnswerIdAndUid(int answerId, int userId) {
        String sql = "select n from NoHelpsDO n where n.answerId = :answerId and n.userId = :userId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("answerId", answerId);
        query.setParameter("userId", userId);
        return (NoHelpsDO) query.uniqueResult();
    }

    /**
     * 删除没有帮助信息
     * @param noHelpsDO 没有帮助信息
     */
    @Override
    public void deleteNoHelp(NoHelpsDO noHelpsDO) {
        this.getSession().delete(noHelpsDO);
    }
}
