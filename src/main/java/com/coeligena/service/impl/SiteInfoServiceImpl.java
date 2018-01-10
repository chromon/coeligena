package com.coeligena.service.impl;

import com.coeligena.dao.SiteInfoDAO;
import com.coeligena.model.SiteInfoDO;
import com.coeligena.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <P>
 *     站点信息业务实现类
 * </P>
 * Created by Ellery on 2018/1/10.
 */
@Service("siteInfoService")
public class SiteInfoServiceImpl implements SiteInfoService {

    private SiteInfoDAO siteInfoDAO;

    @Override
    public SiteInfoDO querySiteInformation() {

        return this.siteInfoDAO.querySiteInfo();
    }

    @Autowired
    public void setSiteInfoDAO(SiteInfoDAO siteInfoDAO) {
        this.siteInfoDAO = siteInfoDAO;
    }
}
