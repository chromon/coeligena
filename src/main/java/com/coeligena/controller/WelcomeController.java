package com.coeligena.controller;

import com.coeligena.annotation.csrf.RefreshCSRFToken;
import com.coeligena.annotation.csrf.VerifyCSRFToken;
import com.coeligena.dto.SignInFormDTO;
import com.coeligena.dto.SignUpFormDTO;
import com.coeligena.function.cookie.CookieUtils;
import com.coeligena.function.captcha.CaptchaUtils;
import com.coeligena.function.ip.IPAddress;
import com.coeligena.function.security.Encrypt;
import com.coeligena.function.security.PasswordUtils;
import com.coeligena.model.AuthUsersDO;
import com.coeligena.model.RoleAuthUserDO;
import com.coeligena.model.RolesDO;
import com.coeligena.model.UsersDO;
import com.coeligena.service.AuthUsersService;
import com.coeligena.service.RoleAuthUserService;
import com.coeligena.service.RolesService;
import com.coeligena.service.UsersService;
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
import java.util.Map;

/**
 * welcome(signIn signUp) controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class WelcomeController {

    @Resource
    private CaptchaUtils captchaUtils;
    @Resource
    private PasswordUtils passwordUtils;
    @Resource
    private CookieUtils cookieUtils;

    private AuthUsersService authUsersService;
    private RolesService rolesService;
    private RoleAuthUserService roleAuthUserService;
    private UsersService usersService;

    private boolean checkCaptcha = false;

    @RefreshCSRFToken
    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signIn(Model model) {
        // 是否使用验证码
        model.addAttribute("checkCaptcha", this.checkCaptcha);
        return "signin";
    }

    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public void captcha(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        // 得到验证码
        captchaUtils.getCaptchaCode(request, response);
    }

    @RequestMapping(value = "checkEmail", method = RequestMethod.POST)
    public @ResponseBody boolean checkEmail(@ModelAttribute AuthUsersDO authUsersDO) {
        return authUsersService.queryUserEmailExists(authUsersDO.getEmail());
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request,
                         @ModelAttribute SignUpFormDTO signUpFormDTO) {

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

        return "redirect:/signin";
    }

    @VerifyCSRFToken
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
                        @ModelAttribute SignInFormDTO signInFormDTO, Model model) {
        // 登录
        HttpSession session = request.getSession(true);

        // 存在验证码错误
        if(this.checkCaptcha) {
            String captchaCode = (String) session.getAttribute("captchaCode");
            if(! captchaCode.equals(signInFormDTO.getSignInCaptcha())) {
                model.addAttribute("captchaError", true);
                return "signin";
            }
        }

        // 不存在验证码，无需验证；或存在验证码，同时验证码正确
        AuthUsersDO authUsersDO = authUsersService.queryUserByEmail(
                signInFormDTO.getAccount());
        if(authUsersDO != null) {
            // 账户存在
            String account = signInFormDTO.getAccount();
            String signInPassword = signInFormDTO.getSignInPassword();

            String salt = authUsersDO.getSalt();
            String password = passwordUtils.checkPassword(salt, signInPassword);
            if(password.equals(authUsersDO.getPassword())) {
                // 验证成功
                // 设置 cookie
                int maxAge = 30*24*60*60;
                cookieUtils.addCookie(response,
                        cookieUtils.getEncryptName("CoeligenaCookieName" + authUsersDO.getId()),
                        cookieUtils.getEncryptValue(authUsersDO.getEmail()), maxAge);
                cookieUtils.addCookie(response,
                        cookieUtils.getEncryptName("CoeligenaCookiePass" + authUsersDO.getId()),
                        cookieUtils.getEncryptValue(authUsersDO.getPassword()), maxAge);

                // 传输用户信息到前台
//                UserInfoDTO  userInfoDTO = new UserInfoDTO();
//                userInfoDTO.setAuthUsersDO(authUsersDO);
//                userInfoDTO.setUsersDO(usersDO);
//                session.setAttribute("userInfoDTO", userInfoDTO);

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
