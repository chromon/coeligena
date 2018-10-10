/**
 * question func
 * Created by Ellery on 2018/6/29.
 */

// 获取 base path
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath2 = localObj.protocol + "//" + localObj.host;

// handlerbars 注册一个比较大小的 Helper, 判断 v1 是否等于 v2
Handlebars.registerHelper('compare', function (v1, v2, options) {
    if (v1 == v2) {
        // 相等
        return options.fn(this);
    } else {
        // 不满足条件执行 {{else}} 部分
        return options.inverse(this);
    }
});

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
        url: basePath2 + "/question-comment",
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

    var questionId = $('#question_id').val();

    $('#questionCommentsModal').modal({
        keyboard: false
    });
    console.log(basePath2 + "/question-comment-list");
    $.ajax({
        type: "GET",
        url: basePath2 + "/question-comment-list",
        dataType: "json",
        data: {
            questionId: questionId
        },
        success: function(data) {
            console.log(data);

            // 判断是否是添加评论模板
            data['isPost'] = false;

            // json 时间数据格式化
            for (var c = 0; c < data['list'].length; c ++) {
                data['list'][c]['questionCommentsDO']['commentTime'] = getLocalTime(data['list'][c]['questionCommentsDO']['commentTime']);
            }

            // 使用 handlebars 获取模板
            var tpl = $('#question_comment_template').html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#question_comment_wrapper').html(html);

            // 分页模板
            var pagingTpl = $('#question-comments-paging-template').html();
            var pagingTemplate = Handlebars.compile(pagingTpl);
            var pagingHtml = pagingTemplate(data['page']);
            $('#question-comments-paging-wrapper').html(pagingHtml);
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
        url: basePath2 + "/question-comment-reply",
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

// 问题评论分页请求
function questionCommentsWithPage(pageNum) {

    var questionId = $('#question_id').val();

    $.ajax({
        type: "GET",
        url: basePath2 + "/question-comments-with-page",
        data: {
            pageNum: pageNum,
            questionId: questionId
        },
        dataType: "json",
        success: function(data) {
            console.log(data);

            // 判断是否是添加评论模板
            data['isPost'] = false;

            // json 时间数据格式化
            for (var c = 0; c < data['list'].length; c ++) {
                data['list'][c]['questionCommentsDO']['commentTime'] = getLocalTime(data['list'][c]['questionCommentsDO']['commentTime']);
            }

            // 使用 handlebars 获取模板
            var tpl = $('#question_comment_template').html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#question_comment_wrapper').html(html);

            // 分页模板
            var pagingTpl = $('#question-comments-paging-template').html();
            var pagingTemplate = Handlebars.compile(pagingTpl);
            var pagingHtml = pagingTemplate(data['page']);
            $('#question-comments-paging-wrapper').html(pagingHtml);
        }
    });
}

// 问题评论点赞
function likeComment(id) {
    var like_btn = $('#commentItem-like-' + id);
    var unlike_btn = $('#commentItem-unlike-' + id);
    var unlike_text = $('#commentItem-unlike-text-' + id);

    var data = {
        commentId: id,
        commentAction: 1 // 赞
    };

    if (!like_btn.hasClass('custom-is-liked') & !unlike_btn.hasClass('custom-unlike'))  {
        // 没攒没踩
        like_btn.addClass('custom-is-liked');
    } else if (! like_btn.hasClass('custom-is-liked') & unlike_btn.hasClass('custom-unlike')) {
        // 没赞有踩
        unlike_btn.removeClass('custom-unlike');
        unlike_text.text('踩');
        like_btn.addClass('custom-is-liked');
    } else if (like_btn.hasClass('custom-is-liked')) {
        // 已赞
        like_btn.removeClass('custom-is-liked');
    }

    likeUnlikeFunc(data);
}

// 问题评论踩
function unlikeComment(id) {
    var like_btn = $('#commentItem-like-' + id);
    var unlike_btn = $('#commentItem-unlike-' + id);
    var unlike_text = $('#commentItem-unlike-text-' + id);

    var data = {
        commentId: id,
        commentAction: 2 // 踩
    };

    if (!like_btn.hasClass('custom-is-liked') & !unlike_btn.hasClass('custom-unlike')) {
        // 没攒没踩
        unlike_btn.addClass('custom-unlike');
        unlike_text.text('取消踩');
    } else if (like_btn.hasClass('custom-is-liked') & !unlike_btn.hasClass('custom-unlike')) {
        // 已赞没踩
        like_btn.removeClass('custom-is-liked');
        unlike_btn.addClass('custom-unlike');
        unlike_text.text('取消踩');
    } else if (unlike_btn.hasClass('custom-unlike')) {
        // 已踩
        unlike_btn.removeClass('custom-unlike');
        unlike_text.text('踩');
    }

    likeUnlikeFunc(data);
}

// 点赞实现
function likeUnlikeFunc(data) {
    $.ajax({
        type: "POST",
        url: basePath2 + "/question-comments-like",
        data: data,
        dataType: "text",
        success: function(data) {
            console.log(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log('responseText: ' + jqXHR.responseText);
            console.log('status: ' + jqXHR.status);
            console.log('readyState: ' + jqXHR.readyState);
            console.log('statusText: ' + jqXHR.statusText);

            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
}

// 关注问题
function followQuestion(obj, id) {
    if ($(obj).hasClass('btn-primary')) {
        $(obj).removeClass('btn-primary');
        $(obj).addClass('btn-default');
        $(obj).addClass('btn--grey');
        $(obj).text('已关注');

        followQuestionAJAX(id, '/follow-question')
    } else {
        $(obj).removeClass('btn-default');
        $(obj).removeClass('btn--grey');
        $(obj).addClass('btn-primary');
        $(obj).text('关注问题');

        followQuestionAJAX(id, '/cancel-follow-question')
    }
}

function followQuestionAJAX(id, url) {
    $.ajax({
        type: "POST",
        url: basePath2 + url,
        data: {
            questionId: id
        },
        dataType: "json",
        success: function (data) {
            console.log(data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            /*
             弹出jqXHR对象的信息, 对象不仅包括XMLHttpRequest对象，
             还包含其他更多的详细属性和信息。
             这里主要有4个属性：
             readyState :当前状态,0-未初始化，1-正在载入，2-已经载入，3-数据进行交互，4-完成。
             status  ：返回的HTTP状态码，比如常见的404,500等错误代码。
             statusText ：对应状态码的错误信息，比如404错误信息是not found,500是Internal Server Error。
             responseText ：服务器响应返回的文本信息
             */
            console.log('responseText: ' + jqXHR.responseText);
            console.log('status: ' + jqXHR.status);
            console.log('readyState: ' + jqXHR.readyState);
            console.log('statusText: ' + jqXHR.statusText);

            /*
             String textStatus：返回的是字符串类型，表示返回的状态，
             根据服务器不同的错误可能返回下面这些信息："timeout"（超时）, "error"（错误）, "abort"(中止), "parsererror"（解析错误），还有可能返回空值。
             第三个参数 String errorThrown：也是字符串类型，表示服务器抛出返回的错误信息，如果产生的是HTTP错误，那么返回的信息就是HTTP状态码对应的错误信息，
             比如404的Not Found,500错误的Internal Server Error。
             */
            console.log('textStatus: ' + textStatus);
            console.log('errorThrown: ' + errorThrown);
        }
    });
}
