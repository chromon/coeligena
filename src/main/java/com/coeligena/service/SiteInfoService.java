package com.coeligena.service;

import com.coeligena.model.SiteInfoDO;

/**
 * <p>
 *     站点信息业务逻辑
 * </p>
 * Created by Ellery on 2018/1/10.
 */
public interface SiteInfoService {
    /**
     * 查询站点信息
     * @return 站点信息
     */
    SiteInfoDO querySiteInformation();
}
