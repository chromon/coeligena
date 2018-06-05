/**
 * post answer
 * Created by Ellery on 2018/6/3.
 */
// 获取 base path
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

// 匿名确认
$('#anonymous_confirm').on('click', function () {
    // 添加匿名数据
    var answer_wrap = $('#answer_wrap');
    $('#is_anonymous').val(1);
    // 显示匿名连接
    $('#anonymous_btn').css('display', 'none');
    $('#realname_btn').css('display', 'inline-block');
    // 将用户信息修改为匿名
    var fullname = $('#answer_fullname').text();
    var avatar_path = $('#answer_img').attr('src');
    var autograph = $('autograph').text();
    answer_wrap.prepend($('<input id="fullname" type="hidden" name="fullname" value="' + fullname +'">'));
    answer_wrap.prepend($('<input id="avatar_path" type="hidden" name="avatar_path" value="' + avatar_path + '">'));
    answer_wrap.prepend($('<input id="autograph" type="hidden" name="autograph" value="' + autograph + '">'));
    $('#answer_img').attr('src', basePath + '/resources/images/avatar/default_avatar.png');
    $('#answer_fullname').text('匿名用户');
    $('#answer_autograph').css('display', 'none');
    $('#edit_topic_bios').css('display', 'none');
    // 关闭 modal
    $('#anonymousModal').modal('hide');
});

// 取消匿名
$('#realname_confirm').on('click', function () {
    // 实名用户信息
    var fullname = $('#fullname').val();
    var avatar_path = $('#avatar_path').val();
    var autograph = $('#autograph').val();

    $('#answer_img').attr('src', avatar_path);
    $('#answer_fullname').text(fullname);
    $('#answer_autograph').text(autograph);
    $('#autograph').css('display', 'inline');
    $('#edit_topic_bios').css('display', 'inline');

    $('#is_anonymous').val(0);
    $('#fullname').remove();
    $('#avatar_path').remove();
    $('#autograph').remove();

    // 关闭 modal
    $('#realNameModal').modal('hide');
});

$('#post_answer_btn').on('click', function () {
    var markupStr = $('#answer_note').summernote('code');
    alert(markupStr);
});
