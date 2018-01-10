package com.coeligena.interceptor;

import com.coeligena.model.SiteInfoDO;
import com.coeligena.service.SiteInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *     站点信息拦截器
 * </p>
 * Created by Ellery on 2018/1/10.
 */
public class SiteInterceptor implements HandlerInterceptor {

    private SiteInfoService siteInfoService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object o) throws Exception {

        // 查询全局页面信息
        SiteInfoDO siteInfoDO = this.siteInfoService.querySiteInformation();
        if(siteInfoDO == null) {
            response.sendRedirect(request.getContextPath() + "/error");
            return false;
        }
        request.getSession().setAttribute("siteInfoDO", siteInfoDO);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }

    @Autowired
    public void setSiteInfoService(SiteInfoService siteInfoService) {
        this.siteInfoService = siteInfoService;
    }
}
