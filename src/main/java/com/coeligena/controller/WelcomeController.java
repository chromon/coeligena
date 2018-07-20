package com.coeligena.controller;

import com.coeligena.annotation.csrf.RefreshCSRFToken;
import com.coeligena.annotation.csrf.VerifyCSRFToken;
import com.coeligena.dto.SignInFormDTO;
import com.coeligena.dto.SignUpFormDTO;
import com.coeligena.dto.UserInfoDTO;
import com.coeligena.function.cookie.CookieUtils;
import com.coeligena.function.captcha.CaptchaUtils;
import com.coeligena.function.ip.IPAddress;
import com.coeligena.function.security.PasswordUtils;
import com.coeligena.model.*;
import com.coeligena.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 * welcome(signIn signUp) controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class WelcomeController {

    /**
     * 验证码工具类
     */
    @Resource
    private CaptchaUtils captchaUtils;
    /**
     * 密码加密工具类
     */
    @Resource
    private PasswordUtils passwordUtils;
    /**
     * cookie 工具类
     */
    @Resource
    private CookieUtils cookieUtils;

    private AuthUsersService authUsersService;
    private RolesService rolesService;
    private RoleAuthUserService roleAuthUserService;
    private UsersService usersService;

    private boolean checkCaptcha = false;

    /**
     * 登陆页面跳转预处理
     *      刷新 csrf token
     *      是否显示验证码
     * @param model model
     * @return 登陆页面
     */
    @RefreshCSRFToken
    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signIn(Model model) {
        // 是否使用验证码
        // this.checkCaptcha = true;
        model.addAttribute("checkCaptcha", this.checkCaptcha);
        return "signin";
    }

    /**
     * 获取验证码
     * @param request httpservletrequest
     * @param response httpservletresponse
     * @throws IOException exception
     */
    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public void captcha(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        // 得到验证码
        captchaUtils.getCaptchaCode(request, response);
    }

    /**
     * 验证邮件地址是否唯一
     * @param authUsersDO authUsersDO
     * @return 验证码
     */
    @RequestMapping(value = "check-email", method = RequestMethod.POST)
    public @ResponseBody boolean checkEmail(@ModelAttribute AuthUsersDO authUsersDO) {
        return authUsersService.queryUserEmailExists(authUsersDO.getEmail());
    }

    /**
     * 注册处理
     * @param request httpservletrequest
     * @param signUpFormDTO 注册数据传输
     * @param model model
     * @return 跳转到登陆页面
     */
    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request,
                         @ModelAttribute SignUpFormDTO signUpFormDTO, Model model) {

        // 查询 “未验证用户” 角色信息
        RolesDO rolesDO = rolesService.queryRolesForSignUp("UnauthenticatedUser");

        AuthUsersDO authUsersDO = new AuthUsersDO();

        // email
        authUsersDO.setEmail(signUpFormDTO.getEmail());

        // 获取密码盐以及加密后密码
        Map<String, String> passMap = passwordUtils.getEncryptPassword(
                signUpFormDTO.getSignUpPassword());
        authUsersDO.setSalt(passMap.get("salt"));
        authUsersDO.setPassword(passMap.get("password"));

        // 默认 ip
        authUsersDO.setLastLoginIP(IPAddress.getIpAdrress(request));

        // 日期
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        Timestamp now = Timestamp.valueOf(dateFormat);

        authUsersDO.setCreateTime(now);
        authUsersDO.setLastLoginTime(now);
        authUsersDO.setMutedTime(now);

        // 存储用户
        authUsersService.saveUserForSignUp(authUsersDO);

        // 存储用户角色对应信息
        RoleAuthUserDO roleAuthUserDO = new RoleAuthUserDO();
        roleAuthUserDO.setAuthUserId(authUsersDO.getId());
        roleAuthUserDO.setRoleId(rolesDO.getId());

        roleAuthUserService.saveRoleAuthUser(roleAuthUserDO);

        // 创建用户信息数据
        UsersDO usersDO = new UsersDO();
        usersDO.setAuthUserId(authUsersDO.getId());
        usersDO.setFullname(signUpFormDTO.getFullName());
        usersService.saveUsersForSignUp(usersDO);

        // 跳转页面发送注册成功通知消息
        request.getSession().setAttribute("signUpSuccess", true);

        // TODO 发送验证邮件

        return "redirect:/signin";
    }

    /**
     * 登录处理
     * @param request httpservletrequest
     * @param response httpservletresponse
     * @param signInFormDTO 登陆数据传输对象
     * @param model model
     * @return 主页
     */
    @VerifyCSRFToken
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @ModelAttribute SignInFormDTO signInFormDTO, Model model) {
        // 登录
        HttpSession session = request.getSession(true);

        // 存在验证码错误
        if (this.checkCaptcha) {
            String captchaCode = (String) session.getAttribute("captchaCode");
            if (! captchaCode.equals(signInFormDTO.getSignInCaptcha())) {
                model.addAttribute("captchaError", true);
                return "signin";
            }
        }

        // 不存在验证码，无需验证；或存在验证码，同时验证码正确
        AuthUsersDO authUsersDO = authUsersService.queryUserByEmail(
                signInFormDTO.getAccount());
        if (authUsersDO != null) {
            // 账户存在
            String signInPassword = signInFormDTO.getSignInPassword();

            String salt = authUsersDO.getSalt();
            String password = passwordUtils.checkPassword(salt, signInPassword);
            if (password.equals(authUsersDO.getPassword())) {
                // 验证成功
                // 设置 cookie
                int maxAge = 30 * 24 * 60 * 60;
                cookieUtils.addCookie(response,
                        cookieUtils.getEncryptName("CoeligenaCookieName"),
                        authUsersDO.getEmail(), maxAge);
                cookieUtils.addCookie(response,
                        cookieUtils.getEncryptName("CoeligenaCookiePass"),
                        cookieUtils.getEncryptValue(authUsersDO.getPassword()), maxAge);

                // 传输用户信息到前台
                UsersDO usersDO = this.usersService.queryUsersByAuthUserId(authUsersDO.getId());

                if (usersDO == null) {
                    return "error";
                }
                UserInfoDTO userInfoDTO = new UserInfoDTO();
                userInfoDTO.setAuthUsersDO(authUsersDO);
                userInfoDTO.setUsersDO(usersDO);
                session.setAttribute("userInfoDTO", userInfoDTO);

                return "redirect:/index";
            } else {
                // 用户名或密码错误
                model.addAttribute("accountError", true);
                return "signin";
            }
        } else {
            // 账户不存在
            model.addAttribute("accountNotExist", true);
            return "signin";
        }
    }

    /**
     * 登出处理
     * @param request httpservletrequest
     * @param response httpservletresponse
     * @return 登陆页面
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {

        // 清空 session
        Enumeration<String> em = request.getSession().getAttributeNames();
        while (em.hasMoreElements()) {
            request.getSession().removeAttribute(em.nextElement());
        }
        request.getSession().invalidate();

        // 清空 cookie
        cookieUtils.removeCookie(response, cookieUtils.getEncryptName("CoeligenaCookieName"));
        cookieUtils.removeCookie(response, cookieUtils.getEncryptName("CoeligenaCookiePass"));

        return "redirect:/signin";
    }

    @Autowired
    public void setAuthUsersService(AuthUsersService authUsersService) {
        this.authUsersService = authUsersService;
    }

    @Autowired
    public void setRolesService(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @Autowired
    public void setRoleAuthUserService(RoleAuthUserService roleAuthUserService) {
        this.roleAuthUserService = roleAuthUserService;
    }

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }
}
