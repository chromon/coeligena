package com.coeligena.interceptor;

import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.cookie.CookieUtils;
import com.coeligena.model.AuthUsersDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.AuthUsersService;
import com.coeligena.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 自动登陆拦截器
 * </P>
 * Created by Ellery on 2017/12/22.
 */
public class AuthorizedInterceptor implements HandlerInterceptor {

    @Resource
    private CookieUtils cookieUtils;

    private AuthUsersService authUsersService;
    private UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws Exception {

        String basePath = request.getScheme() + "://"+
                request.getServerName() + ":" +
                request.getServerPort()+ request.getContextPath() + "/";

        // 加密后用户名和密码的 cookie 名称
        String cookieNameEncrypt = cookieUtils.getEncryptName("CoeligenaCookieName");
        String cookiePassEncrypt = cookieUtils.getEncryptName("CoeligenaCookiePass");

        Cookie cookieName = cookieUtils.getCookieByName(request, cookieNameEncrypt);
        Cookie cookiePass = cookieUtils.getCookieByName(request, cookiePassEncrypt);

        if(cookieName != null && cookiePass != null &&
                "".equals(cookieName.getValue()) && "".equals(cookiePass.getValue())) {
            // cookie 存在
            String email = cookieName.getValue();
            String passwordEncrypted = cookiePass.getValue();

            AuthUsersDO authUsersDO = authUsersService.queryUserByEmail(email);

            if(authUsersDO != null) {
                String password = cookieUtils.getEncryptValue(authUsersDO.getPassword());
                if(passwordEncrypted.equals(password)) {
                    // cookie 正确，自动登陆
                    UsersDO usersDO = usersService.queryUsersByAuthUserId(authUsersDO.getId());
                    if(usersDO == null) {
                        response.sendRedirect(request.getContextPath() + "/error");
                    }
                    UserInfoDTO userInfoDTO = new UserInfoDTO();
                    userInfoDTO.setAuthUsersDO(authUsersDO);
                    userInfoDTO.setUsersDO(usersDO);
                    request.getSession().setAttribute("userInfoDTO", userInfoDTO);

                    response.sendRedirect(request.getContextPath() + "/index");
                    return true;

                } else {
                    // cookie 中的账号存在，但密码不正确，需重新登陆
                    System.out.println("1");
//                    response.sendRedirect(request.getContextPath() + "/signin");
                    return false;
                }
            } else {
                // cookie 中的账号不存在，需重新登陆
                System.out.println("2");
//                response.sendRedirect(request.getContextPath() + "/signin");
                return false;
            }

        } else {
            // cookie 不存在，重新登陆
            System.out.println("3");
            System.out.println(basePath + "signin");
//            response.sendRedirect(request.getContextPath() + "/signin");
            response.sendRedirect(basePath + "signin");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object o, Exception e) throws Exception {
    }

    @Autowired
    public void setAuthUsersService(AuthUsersService authUsersService) {
        this.authUsersService = authUsersService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
