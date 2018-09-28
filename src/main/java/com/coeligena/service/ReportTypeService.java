package com.coeligena.service;

import com.coeligena.model.ReportTypeDO;

import java.util.List;

/**
 * report type service
 * Created by Ellery on 2018/9/27.
 */
public interface ReportTypeService {

    /**
     * 查询全部根举报类型
     * @return 根举报类型列表
     */
    List<ReportTypeDO> queryRootReportType(int parentTypeId);
}
