
'use strict';

$(document).ready(function() {
    NProgress.start();
    NProgress.inc(0.1);
    NProgress.done();
});

// 显示注册
$('#signUp_tab').on('click', function () {
    // 显示 tab 标签样式
    $('#signUp_tab').addClass('active');
    $('.slide-bar').addClass('slide-bar-left');
    // 显示注册 tab
    $('#signUpForm').removeClass('hide');
    $('#signInForm').addClass('hide');

    // $('#_btn').text('注册');
});

// 显示登录
$('#signIn_tab').on('click', function () {
    // 显示 tab 标签样式
    $('#signIn_tab').addClass('active');
    $('.slide-bar').removeClass('slide-bar-left');
    // 显示登录 tab
    $('#signUpForm').addClass('hide');
    $('#signInForm').removeClass('hide');
    // $('#_btn').text('登录');
});

// 显示手机验证码登录
var signin_flag = false;
$('.signin-switch-button').on('click', function () {
    if (signin_flag) {
        // 邮箱登录
        $('#account').attr('placeholder', '手机号或邮箱');
        $('#signIn_password_wrapper').removeClass('hide');
        $('#signIn_captcha_wrapper').removeClass('hide');
        $('#signIn_sms_wrapper').addClass('hide');
        $('.signin-switch-button').text('手机验证码登录');
        $('.unable-login').removeClass('hide');
        signin_flag = false;
    } else {
        // 手机验证码登录
        $('#account').attr('placeholder', '手机号');
        $('#signIn_password_wrapper').addClass('hide');
        $('#signIn_captcha_wrapper').addClass('hide');
        $('#signIn_sms_wrapper').removeClass('hide');
        $('.signin-switch-button').text('密码登录（手机号或邮箱）');
        $('.unable-login').addClass('hide');
        signin_flag = true;
    }
});