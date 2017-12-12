package com.coeligena.controller;

import com.coeligena.annotation.csrf.RefreshCSRFToken;
import com.coeligena.annotation.csrf.VerifyCSRFToken;
import com.coeligena.function.captcha.CaptchaUtils;
import com.coeligena.model.AuthUsersDO;
import com.coeligena.service.AuthUsersService;
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

/**
 * welcome(signIn signUp) controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class WelcomeController {

    @Resource
    private CaptchaUtils captchaUtils;

    private AuthUsersService authUsersService;

    @Autowired
    public void setAuthUsersService(AuthUsersService authUsersService) {
        this.authUsersService = authUsersService;
    }

    @RefreshCSRFToken
    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signIn() {
        System.out.println("test controller");
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
    public String signUp() {
        System.out.println("[INFO] signup info");
        return "redirect:/index";
    }

    @VerifyCSRFToken
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login() {
        System.out.println("[INFO] login info");
        return "redirect:/index";
    }
}
