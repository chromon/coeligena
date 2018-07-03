/**
 * question func
 * Created by Ellery on 2018/6/29.
 */

// 获取 base path
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

// 显示全部问题内容
$('#unfold-question').on('click', function() {
    $('#unfold-question').addClass('hide');
    $('#tuck-up-question').removeClass('hide');

    $('#question-digest').addClass('hide');
    $('#question-detail').removeClass('hide');
});

// 收起问题详细信息
$('#tuck-up-question').on('click', function() {
    $('#unfold-question').removeClass('hide');
    $('#tuck-up-question').addClass('hide');

    $('#question-digest').removeClass('hide');
    $('#question-detail').addClass('hide');
});

// 问题评论高度自适应
$('#question-comment').on('input', function() {
    if (this.scrollHeight < 150) {
        this.style.height='auto';
        this.style.height = this.scrollHeight + 'px';
    }
});

// 评论问题
$('#comment-question-btn').on('click', function() {
    var content = $('#question-comment').val();

    $.ajax({
        type: "POST",
        url: basePath + "/question-comment",
        data: {
            questionId: $('#question_id').val(),
            reviewerId: $('#reviewer-id').val(),
            parentCommentId: $('#parent-comment-id').val(),
            commentContent: content
        },
        dataType: "json",
        success: function(data){
            // console.log(data);

            // json 时间数据格式化
            data['questionCommentsDO']['commentTime'] = getLocalTime(data['questionCommentsDO']['commentTime']);

            // 使用 handlebars 获取模板
            var tpl = $("#question_comment_template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#question_comment_wrapper').html(html);

        }
    });
});

