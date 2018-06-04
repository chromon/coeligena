/**
 * post answer
 * Created by Ellery on 2018/6/3.
 */
// 获取 base path
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

// 匿名确认
$('#anonymous_confirm').on('click', function() {
    $('#answer_wrap').prepend($('<input type="hidden" name="anonymous" value="1">'));
    $('#anonymous_btn').attr('data-target', 'realNameModal');
    $('#anonymous_btn').text('使用实名身份回答');
    $('#answer_img').attr('src', basePath + '/resources/images/avatar/default_avatar.png');
    $('#answer_fullname').text('匿名用户');
    $('#autograph_wrap').css('display', 'none');
    $('#anonymousModal').modal('hide');
});

$('#post_answer_btn').on('click', function () {
    var markupStr = $('#answer_note').summernote('code');
    alert(markupStr);
});
