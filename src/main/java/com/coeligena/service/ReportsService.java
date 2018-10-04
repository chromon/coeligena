package com.coeligena.service;

import com.coeligena.model.ReportsDO;

/**
 * 举报信息业务逻辑接口
 * Created by Ellery on 2018/10/4.
 */
public interface ReportsService {

    /**
     * 添加举报信息
     * @param reportsDO 举报信息
     */
    void addReports(ReportsDO reportsDO);
}
