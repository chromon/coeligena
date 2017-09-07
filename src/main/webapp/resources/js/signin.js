
'use strict';

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

// 修改复选框样式
$('#signIn_RememberMe').on('click', function () {
    if (!$('#signIn_RememberMe').is(':checked')) {
        $('.selected').css('display', 'none');
        $('#signIn_RememberMe').removeAttr("checked");
    } else {
        $('.selected').css('display', 'block');
        $('#signIn_RememberMe').attr('checked','true');
    }
});

$('#signUp_RememberMe').on('click', function () {
    if (!$('#signUpn_RememberMe').is(':checked')) {
        $('.selected').css('display', 'none');
        $('#signUp_RememberMe').removeAttr("checked");
    } else {
        $('.selected').css('display', 'block');
        $('#signUp_RememberMe').attr('checked','true');
    }
});