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
    $('#question-comment').val('');

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

            // 判断是否是添加评论模板
            data['isPost'] = true;

            // json 时间数据格式化
            data['questionCommentsDO']['commentTime'] = getLocalTime(data['questionCommentsDO']['commentTime']);

            // 使用 handlebars 获取模板
            var tpl = $("#question_comment_template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#question_comment_wrapper').append(html);

        }
    });
});

// 问题评论列表
$('#question-comments').on('click', function() {
    $('#questionCommentsModal').modal({
        keyboard: false
    });
    $.ajax({
        type: "GET",
        url: basePath + "/question-comment-list",
        dataType: "json",
        success: function(data){
            // console.log(data);

            // 判断是否是添加评论模板
            data['isPost'] = false;

            // // json 时间数据格式化
            for (var c = 0; c < data.length; c ++) {
                data[c]['questionCommentsDO']['commentTime'] = getLocalTime(data[c]['questionCommentsDO']['commentTime']);
            }

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

// 显示评论相关功能
function showElement(obj) {
    $(obj).find('.comment-hide').removeClass('hide');
}

// 隐藏评论相关功能
function hideElement(obj) {
    $(obj).find('.comment-hide').addClass('hide');
}

// 显示回复组件
function replyContent(id) {
    $('#commentItem-footer-' + id).addClass('hide');
    $('#reply-content-' + id).removeClass('hide');
}

// 隐藏回复组件
function hideReplyContent(id) {
    $('#commentItem-footer-' + id).removeClass('hide');
    $('#reply-content-' + id).addClass('hide');
}

// 问题回复评论
function postReply(id) {
    var content = $('#question-comment-r-' + id).val();

    $.ajax({
        type: "POST",
        url: basePath + "/question-comment-reply",
        data: {
            questionId: $('#question_id').val(),
            reviewerId: $('#reviewer-id-r-' + id).val(),
            parentCommentId: id,
            commentContent: content
        },
        dataType: "json",
        success: function (data) {
            // console.log(data);

            $('#commentItem-footer-' + id).removeClass('hide');
            $('#reply-content-' + id).addClass('hide');

            // 判断是否是添加评论模板
            data['isPost'] = true;

            // json 时间数据格式化
            data['questionCommentsDO']['commentTime'] = getLocalTime(data['questionCommentsDO']['commentTime']);

            // 使用 handlebars 获取模板
            var tpl = $("#question_comment_template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#question_comment_wrapper').append(html);

        }
    });
}