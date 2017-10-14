<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  Users: Ellery
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
    <title>编乎 - 与世界分享你编的知识、经验和见解</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/signin.css">
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
                    <a id="signIn_tab" href="#" class="active">登录</a>
                    <a id="signUp_tab" href="#">注册</a>
                    <div class="slide-bar"></div>
                </div>
            </div>

            <div class="form" id="signInForm">
                <div class="group">
                    <div class="group-ipt account">
                        <input type="text" name="account" id="account" class="ipt" placeholder="手机号或邮箱">
                    </div>
                    <div class="group-ipt password">
                        <input type="password" name="password" id="signIn_password" class="ipt" placeholder="密码">
                    </div>
                    <div class="group-ipt captcha hide">
                        <input type="text" name="captcha" id="signIn_captcha" class="ipt" placeholder="验证码">
                    </div>
                </div>

                <div class="button">
                    <button type="submit" class="_btn">登录</button>
                </div>

                <div class="remember clearfix">
                    <label class="remember-me">
                        <span class="icon">
                            <span class="selected"></span>
                        </span>
                        <input type="checkbox" name="remember-me" id="signIn_RememberMe" class="remember-me-check" checked>记住我
                    </label>
                    <label class="forgot-password">
                        <a href="#">出现问题？</a>
                    </label>
                </div>
            </div>

            <div class="form hide" id="signUpForm">
                <div class="group">
                    <div class="group-ipt fullName">
                        <input type="text" name="fullName" id="fullName" class="ipt" placeholder="姓名">
                    </div>
                    <div class="group-ipt email">
                        <input type="text" name="email" id="email" class="ipt" placeholder="邮箱">
                    </div>
                    <div class="group-ipt password">
                        <input type="password" name="password" id="signUp_password" class="ipt" placeholder="密码（不少于6位）">
                    </div>
                    <div class="group-ipt captcha hide">
                        <input type="text" name="captcha" id="signUp_captcha" class="ipt" placeholder="验证码">
                    </div>
                </div>

                <div class="button">
                    <button type="submit" class="_btn">注册</button>
                </div>

                <div class="remember clearfix">
                    <label class="remember-me">
                        <span class="icon">
                            <span class="selected"></span>
                        </span>
                        <input type="checkbox" name="remember-me" id="signUp_RememberMe" class="remember-me-check" checked>记住我
                    </label>
                    <label class="forgot-password">
                        <a href="#">出现问题？</a>
                    </label>
                </div>

            </div>
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

<script type="text/javascript" src='<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/js/canvas.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/js/signin.js'></script>
</body>
</html>
