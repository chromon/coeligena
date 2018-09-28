package com.coeligena.dao;

import com.coeligena.model.ReportTypeDO;

import java.util.List;

/**
 * report type dao
 * Created by Ellery on 2018/9/27.
 */
public interface ReportTypeDAO {

    /**
     * 查询全部根举报类型
     * @return 根举报类型列表
     */
    List<ReportTypeDO> queryRootReportType(int parentTypeId);
}
