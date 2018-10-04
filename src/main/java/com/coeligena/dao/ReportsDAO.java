package com.coeligena.dao;

import com.coeligena.model.ReportsDO;

/**
 * 举报信息数据访问对象
 * Created by Ellery on 2018/10/4.
 */
public interface ReportsDAO {

    /**
     * 添加举报信息
     * @param reportsDO 举报信息
     */
    void addReports(ReportsDO reportsDO);
}
