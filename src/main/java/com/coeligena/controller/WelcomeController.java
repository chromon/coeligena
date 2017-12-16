package com.coeligena.controller;

import com.coeligena.annotation.csrf.RefreshCSRFToken;
import com.coeligena.annotation.csrf.VerifyCSRFToken;
import com.coeligena.dao.RoleAuthUserDAO;
import com.coeligena.dto.SignUpFormDTO;
import com.coeligena.function.captcha.CaptchaUtils;
import com.coeligena.function.ip.IPAddress;
import com.coeligena.function.security.Encrypt;
import com.coeligena.function.security.Salt;
import com.coeligena.model.AuthUsersDO;
import com.coeligena.model.RoleAuthUserDO;
import com.coeligena.model.RolesDO;
import com.coeligena.service.AuthUsersService;
import com.coeligena.service.RoleAuthUserService;
import com.coeligena.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Salt salt;

    private AuthUsersService authUsersService;
    private RolesService rolesService;
    private RoleAuthUserService roleAuthUserService;

    @RefreshCSRFToken
    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signIn() {
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
        return authUsersService.checkUserEmailExists(authUsersDO.getEmail());
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signUp(HttpServletRequest request,
                         @ModelAttribute SignUpFormDTO signUpFormDTO) {

        // 查询 “未验证用户” 角色信息
        RolesDO rolesDO = rolesService.queryRolesForSignUp("UnauthenticatedUser");

        AuthUsersDO authUsersDO = new AuthUsersDO();

        // email
        authUsersDO.setEmail(signUpFormDTO.getEmail());

        // 密码盐
        String passwordSalt = Encrypt.toHex(salt.getSalt());
        authUsersDO.setSalt(passwordSalt);

        // 密码加密
        String passwordEncrypt = Encrypt.getDigest("SHA-256",
                signUpFormDTO.getSignUpPassword());
        String password = Encrypt.getDigest("SHA-256",
                passwordEncrypt + passwordSalt);
        authUsersDO.setPassword(password);

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

        System.out.println("[INFO] signup info");
        return "redirect:/signin";
    }

    @VerifyCSRFToken
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login() {
        System.out.println("[INFO] login info");
        return "redirect:/index";
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
}
