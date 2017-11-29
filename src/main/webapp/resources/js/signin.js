
'use strict';

$(function(){

    // 进度条
    NProgress.start();
    NProgress.inc(0.1);
    NProgress.done();

});

// 显示注册
var signUp_tab = $('#signUp_tab');
var signIn_tab = $('#signIn_tab');
var slide_bar = $('.slide-bar');
var signUpFormWrapper = $('#signUpFormWrapper');
var signInFormWrapper = $('#signInFormWrapper');

signUp_tab.on('click', function () {
    // 显示 tab 标签样式
    signUp_tab.addClass('active');
    slide_bar.addClass('slide-bar-left');
    // 显示注册 tab
    signUpFormWrapper.removeClass('hide');
    signInFormWrapper.addClass('hide');

});

// 显示登录
signIn_tab.on('click', function () {
    // 显示 tab 标签样式
    signIn_tab.addClass('active');
    slide_bar.removeClass('slide-bar-left');
    // 显示登录 tab
    signUpFormWrapper.addClass('hide');
    signInFormWrapper.removeClass('hide');

});

// 显示手机验证码登录
var signIn_flag = false;
var signIn_switch_button = $('.signin-switch-button');
var account = $('#account');
var signIn_password_wrapper = $('#signIn_password_wrapper');
var signIn_captcha_wrapper = $('#signIn_captcha_wrapper');
var signIn_sms_wrapper = $('#signIn_sms_wrapper');
var unable_login = $('.unable-login');

signIn_switch_button.on('click', function () {
    if (signIn_flag) {
        // 邮箱登录
        account.attr('placeholder', '手机号或邮箱');
        signIn_password_wrapper.removeClass('hide');
        signIn_captcha_wrapper.removeClass('hide');
        signIn_sms_wrapper.addClass('hide');
        signIn_switch_button.text('手机验证码登录');
        unable_login.removeClass('hide');
        signIn_flag = false;
    } else {
        // 手机验证码登录
        account.attr('placeholder', '手机号');
        signIn_password_wrapper.addClass('hide');
        signIn_captcha_wrapper.addClass('hide');
        signIn_sms_wrapper.removeClass('hide');
        signIn_switch_button.text('密码登录（手机号或邮箱）');
        unable_login.addClass('hide');
        signIn_flag = true;
    }
});

// 刷新验证码
function getCaptcha(id) {

    // 获取 base path
    var localObj = window.location;
    var contextPath = localObj.pathname.split("/")[1];
    var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

    $('#' + id)[0].src = basePath + '/captcha?' + Math.random();
}

// 校验注册 fullName
var fullNameSel = $('#fullName');
var fullNameError = $('#fullNameError');
function checkFullName() {
    var fullName = fullNameSel.val().trim();

    var len_en = 0;
    var len_cn = 0;

    // 获取字符串长度，中文算两个字符
    for (var i = 0; i < fullName.length; i ++) {
        var a = fullName.charAt(i);
        if (a.match(/[^\x00-\xff]/ig) != null) {
            len_cn += 2;
        } else {
            len_en += 1;
        }
    }

    var label_text1 = '姓名最短为2个汉字或3个英文字符';
    var label_text2 = '姓名最长为10个汉字或20个英文字符';

    if (len_cn < 1) {
        if (len_en < 3) {
            // 全英文少于 3 个字母
            fullNameError.text(label_text1);
            return false;
        } else if (20 < len_en) {
            // 全英文大于 20 个字母
            fullNameError.text(label_text2);
            return false;
        }
    }

    if (len_en < 1) {
        if (len_cn < 4) {
            // 全中文少于 2 个汉字
            fullNameError.text(label_text1);
            return false;
        } else if (20 < len_cn) {
            // 全中文大于 10 个汉字
            fullNameError.text(label_text2);
            return false;
        }
    }

    if ((2 < len_cn) && (1 < len_en) && (20 < len_cn + len_en)) {
        // 中英文混合，且长度大于 20
        fullNameError.text(label_text2);
        return false;
    }

    fullNameError.text('');
    return true;
}
fullNameSel.on('blur', checkFullName);

// 校验注册邮箱地址
var emailSel = $('#email');
var emailError = $('#emailError');
function checkSignUpEmail() {
    var email = emailSel.val().trim();
    var reg = /^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/;
    if (!reg.test(email)) {
        emailError.text('请输入正确的邮箱地址');
        return false;
    }

    emailError.text('');
    return true;
}
emailSel.on('blur', checkSignUpEmail);

// 校验注册密码
var passwordSel = $('#signUp_password');
var passwordError = $('#passwordError');
function checkSignUpPWD() {
    var password = passwordSel.val().trim();
    var reg = /^[a-zA-Z][a-zA-Z0-9_]{5,127}$/;
    if (!reg.test(password)) {
        passwordError.text('请输入6-128位的密码');
        return false;
    }

    passwordError.text('');
    return true;
}
passwordSel.on('blur', checkSignUpPWD);

// 校验注册验证码
var signUpCaptcha = $('#signUp_captcha_code');
var signUpCaptchaErr = $('#signUpCaptchaErr');
function checkSignUpCaptcha() {
    var captchaCode = signUpCaptcha.val().trim();
    var reg = /^[a-zA-Z0-9]{4}$/;
    if (!reg.test(captchaCode)) {
        signUpCaptchaErr.text('请输入正确的验证码');
        return false;
    }

    signUpCaptchaErr.text('');
    return true;
}
signUpCaptcha.on('blur', checkSignUpCaptcha);

// 注册提交
var signUpSubmit = $('#signUpSubmit');
var signUpForm = $('#signUpForm');
signUpSubmit.on('click', function () {
    if(checkFullName() & checkSignUpEmail() & checkSignUpPWD() & checkSignUpCaptcha()) {
        signUpForm.submit();
    }
});

// 校验登录密码
var signInPasswordSel = $('#signIn_password');
var signInPasswordError = $('#signInPasswordErr');
function checkSignInPWD() {
    var password = signInPasswordSel.val().trim();
    var reg = /^[a-zA-Z][a-zA-Z0-9_]{5,127}$/;
    if (!reg.test(password)) {
        signInPasswordError.text('请输入6-128位的密码');
        return false;
    }

    signInPasswordError.text('');
    return true;
}
signInPasswordSel.on('blur', checkSignInPWD);

// 校验登录验证码
var signInCaptcha = $('#signIn_captcha_code');
var signInCaptchaErr = $('#signInCaptchaErr');
function checkSignInCaptcha() {
    var captchaCode = signInCaptcha.val().trim();
    var reg = /^[a-zA-Z0-9]{4}$/;
    if (!reg.test(captchaCode)) {
        signInCaptchaErr.text('请输入正确的验证码');
        return false;
    }

    signInCaptchaErr.text('');
    return true;
}
signInCaptcha.on('blur', checkSignInCaptcha);

// 登录提交
var signInSubmit = $('#signInSubmit');
var signInForm = $('#signInForm');
signInSubmit.on('click', function () {
    if(checkSignInPWD() & checkSignInCaptcha()) {
        signInForm.submit();
    }
});