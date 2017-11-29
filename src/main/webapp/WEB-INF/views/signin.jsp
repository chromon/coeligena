<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  UsersDO: Ellery
  Date: 2017/8/7
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>编乎 - 发现更大的世界</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/signin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugin/nprogress/nprogress.css">
</head>
<body>
<div>
    <canvas id="canvas"></canvas>
    <div class="cent-box">
        <div class="cent-box-header">
            <h1 class="main-title"></h1>
            <h2 class="sub-title">与世界分享你编的知识、经验和见解</h2>
        </div>

        <div class="cont-main clearfix">
            <div class="index-tab">
                <div class="index-slide-nav">
                    <a id="signIn_tab" href="javascript:void(0)" class="active">登录</a>
                    <a id="signUp_tab" href="javascript:void(0)">注册</a>
                    <div class="slide-bar"></div>
                </div>
            </div>

            <!-- sign in -->
            <div class="form" id="signInFormWrapper">
                <form id="signInForm" action="${pageContext.request.contextPath}/login" method="POST">
                    <div class="group">
                        <div class="group-ipt account">
                            <input type="text" name="account" id="account" class="ipt" placeholder="手机号或邮箱">
                            <label class="error is-visible">email对应的账户不存在</label>
                        </div>
                        <div id="signIn_password_wrapper" class="group-ipt password">
                            <input type="password" name="signInPassword" id="signIn_password" class="ipt" placeholder="密码">
                            <label id="signInPasswordErr" class="error is-visible"></label>
                        </div>
                        <div id="signIn_sms_wrapper" class="group-ipt sms-verification hide">
                            <input name="sms-code" placeholder="短信验证码" maxlength="6" type="number">
                            <button type="button" class="send-code">获取验证码</button>
                        </div>
                        <div id="signIn_captcha_wrapper" class="group-ipt sms-verification">
                            <input id="signIn_captcha_code" placeholder="验证码" class="ipt" maxlength="4" type="text">
                            <span class="captcha-img-wrapper">
                                <img id="signIn_captcha_img" class="captcha-img" alt="点击刷新"
                                     src="${pageContext.request.contextPath}/captcha" onclick="getCaptcha(this.id)">
                            </span>
                            <label id="signInCaptchaErr" class="captcha-error is-visible"></label>
                        </div>
                    </div>

                    <div class="button">
                        <button id="signInSubmit" type="submit" class="_btn">登录</button>
                    </div>

                    <div class="signin-misc-wrapper clearfix">
                        <button type="button" class="signin-switch-button">手机验证码登录</button>
                        <a class="unable-login" href="#">无法登录？</a>
                    </div>

                    <div class="app-download">
                        <button class="app-toggleButton">
                            <span class="sprite-global-icon-app"></span>
                            <span class="app-toggleButtonText ">下载编乎 App</span>
                        </button>
                    </div>
                </form>
            </div><!-- end sign in -->

            <!-- sign up -->
            <div class="form hide" id="signUpFormWrapper">
                <form id="signUpForm" action="${pageContext.request.contextPath}/signup" method="POST">
                    <div class="group">
                        <div class="group-ipt fullName">
                            <input type="text" name="fullName" id="fullName" class="ipt" placeholder="姓名">
                            <label id="fullNameError" class="error is-visible"></label>
                        </div>
                        <div class="group-ipt email">
                            <input type="text" name="email" id="email" class="ipt" placeholder="邮箱">
                            <label id="emailError" class="error is-visible"></label>
                        </div>
                        <div class="group-ipt password">
                            <input type="password" name="signUpPassword" id="signUp_password" class="ipt" placeholder="密码（不少于6位）">
                            <label id="passwordError" class="error is-visible"></label>
                        </div>
                        <div id="signUp_captcha_wrapper" class="group-ipt sms-verification">
                            <input id="signUp_captcha_code" type="text" placeholder="验证码" class="ipt" maxlength="4">
                            <span class="captcha-img-wrapper">
                                <img id="signUp_captcha_img" class="captcha-img" alt="点击刷新"
                                     src="${pageContext.request.contextPath}/captcha" onclick="getCaptcha(this.id)">
                            </span>
                            <label id="signUpCaptchaErr" class="captcha-error is-visible"></label>
                        </div>
                    </div>

                    <div class="button">
                        <button id="signUpSubmit" type="submit" class="_btn">注册</button>
                    </div>

                    <div>
                        <p class="agreement-tip">点击「注册」按钮，即代表你同意<a href="/terms" target="_blank">《编乎协议》</a></p>
                        <a class="signup-entry-org" href="/org/signup">注册机构号</a>
                    </div>

                    <div class="app-download">
                        <button class="app-toggleButton">
                            <span class="sprite-global-icon-app"></span>
                            <span class="app-toggleButtonText ">下载编乎 App</span>
                        </button>
                    </div>
                </form>
            </div>
            <!-- end sign up -->
        </div>
    </div>

    <div class="footer">
        <span>© 2017 编乎</span>
        <span class="dot">·</span>
        <a target="_blank" href="#">编乎专栏</a>
        <span class="dot">·</span>
        <a target="_blank" href="/roundtable">编乎圆桌</a>
        <span class="dot">·</span>
        <a target="_blank" href="/explore">发现</a>
        <span class="dot">·</span>
        <a target="_blank" href="/app">移动应用</a>
        <span class="dot">·</span>
        <a href="/org/signin" class="footer-mobile-show">使用机构帐号登录</a>
        <span class="dot footer-mobile-show">·</span>
        <a href="/contact" class="footer-mobile-show">联系我们</a>
        <span class="dot">·</span>
        <a target="_blank" href="/careers">来编乎工作</a>
    </div>
</div>

<script src='<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js' type="text/javascript"></script>
<script src='<%=request.getContextPath()%>/resources/js/canvas.js' type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/resources/plugin/nprogress/nprogress.js" type="text/javascript"></script>
<script src='<%=request.getContextPath()%>/resources/js/signin.js' type="text/javascript"></script>
</body>
</html>
