
'use strict'

// 显示注册
$('#signup_tab').on('click', function () {
    // 显示 tab 标签样式
    $('#signup_tab').addClass('active');
    $('.slide-bar').addClass('slide-bar-left');
    // 显示注册 tab
    $('#signup').removeClass('hide');
    $('#signin').addClass('hide');

    $('#_btn').text('注册');
});

// 显示登录
$('#signin_tab').on('click', function () {
    // 显示 tab 标签样式
    $('#signin_tab').addClass('active');
    $('.slide-bar').removeClass('slide-bar-left');
    // 显示登录 tab
    $('#signup').addClass('hide');
    $('#signin').removeClass('hide');
    $('#_btn').text('登录');
});

// 修改复选框样式
$('.remember-mecheck').on('click', function () {
    if (!$('#remember-me').is(':checked')) {
        $('.selected').css('display', 'none');
        $('#remember-me').removeAttr("checked");
    } else {
        $('.selected').css('display', 'block');
        $('#remember-me').attr('checked','true');
    }
});