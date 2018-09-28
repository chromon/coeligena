package com.coeligena.dao.impl;

import com.coeligena.dao.ReportTypeDAO;
import com.coeligena.model.ReportTypeDO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * report type dao impl
 * Created by Ellery on 2018/9/27.
 */
@Repository
public class ReportTypeDAOImpl implements ReportTypeDAO {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 查询全部根举报类型
     * @return 根举报类型列表
     */
    @Override
    public List<ReportTypeDO> queryRootReportType(int parentTypeId) {
        String sql = "from ReportTypeDO r where r.parentReportTypeId = :parentTypeId";
        Query query = this.getSession().createQuery(sql);
        query.setParameter("parentTypeId", parentTypeId);
        return query.list();
    }
}
