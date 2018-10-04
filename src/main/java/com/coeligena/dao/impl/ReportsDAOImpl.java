package com.coeligena.dao.impl;

import com.coeligena.dao.ReportsDAO;
import com.coeligena.model.ReportsDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * 举报信息持久化
 * Created by Ellery on 2018/10/4.
 */
@Repository
public class ReportsDAOImpl implements ReportsDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 添加举报信息
     * @param reportsDO 举报信息
     */
    @Override
    public void addReports(ReportsDO reportsDO) {
        this.getSession().save(reportsDO);
    }
}
