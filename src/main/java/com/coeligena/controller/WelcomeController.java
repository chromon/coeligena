package com.coeligena.controller;

import com.coeligena.function.captcha.CaptchaUtils;
import com.github.bingoohuang.patchca.service.Captcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

/**
 * welcome(signIn signUp) controller
 *
 * Created by Ellery on 2017/8/11.
 */

@Controller
public class WelcomeController {

    @Resource
    private CaptchaUtils captchaUtils;

    @RequestMapping(value = "signin", method = RequestMethod.GET)
    public String signIn() {
        return "signin";
    }

    @RequestMapping(value = "captcha", method = RequestMethod.GET)
    public void captcha(HttpServletRequest request,
                        HttpServletResponse response) throws IOException {
        // 禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setContentType("image/png");
        HttpSession session = request.getSession(true);
        OutputStream outputStream = response.getOutputStream();

        // 得到验证码对象,有验证码图片和验证码字符串
        Captcha captcha = captchaUtils.getCCS().getCaptcha();

        // 取得验证码字符串放入Session
        String captchaCode = captcha.getChallenge();
        System.out.println("[INFO] captcha word: " + captchaCode);

        session.setAttribute("captchaCode", captchaCode);

        // 取得验证码图片并输出
        BufferedImage bufferedImage = captcha.getImage();
        ImageIO.write(bufferedImage, "png", outputStream);

        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String signUp() {
        System.out.println("[INFO] signup info");
        return "redirect:/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login() {
        System.out.println("[INFO] login info");
        return "redirect:/index";
    }
}
