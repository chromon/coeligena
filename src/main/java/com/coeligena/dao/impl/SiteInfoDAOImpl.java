package com.coeligena.dao.impl;

import com.coeligena.dao.SiteInfoDAO;
import com.coeligena.model.SiteInfoDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>
 *     站点信息持久化
 * </p>
 * Created by Ellery on 2018/1/10.
 */
@Repository
public class SiteInfoDAOImpl implements SiteInfoDAO{

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public SiteInfoDO querySiteInfo() {
        String sql = "select s from SiteInfoDO s";
        SiteInfoDO siteInfoDO = (SiteInfoDO)this.getSession()
                .createQuery(sql).uniqueResult();
        return siteInfoDO;
    }
}
