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

// 转载、评论类型
$('#answer_setting_list').on('click','button',function() {
    // 转载
    // 1 允许规范转载 2 允许付费转载 3 禁止转载
    if (this.value == 1 || this.value == 2 || this.value == 3) {
        $('#reprint_check').remove();
        $(this).append($('<i id="reprint_check" class="fa fa-check custom-right custom-check-margin" aria-hidden="true"></i>'));
        $('#reprint_type').val(this.value);
    }

    // 评论
    // 4 允许任何人评论 5 评论由我筛选后显示 6 允许我关注的人评论 7 关闭评论
    if (this.value == 4 || this.value == 5 || this.value == 6 || this.value == 7) {
        $('#comment_check').remove();
        $(this).append($('<i id="comment_check" class="fa fa-check custom-right custom-check-margin" aria-hidden="true"></i>'));
        $('#comment_type').val(this.value);
    }
});

$('#post_answer_btn').on('click', function () {
    var markupStr = $('#answer_note').summernote('code');
    $('#answer_wrap').fadeOut('2000');

    $.ajax({
        type: "POST",
        url: basePath + "/answer-the-question",
        data: {
            anonymous: $('#is_anonymous').val(),
            answerContent: markupStr,
            reprintType: $('#reprint_type').val(),
            commentType: $('#comment_type').val(),
            questionId: $('#question_id').val()
        },
        dataType: "json",
        success: function(data){
            console.log(data);

            // 使用 handlebars 获取模板
            var tpl = $("#post_answer_template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#post_answer_wrapper').html(html);
        }
    });
});
