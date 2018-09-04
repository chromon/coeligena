/**
 * answer function
 * Created by Ellery on 2018/6/23.
 */
// 获取 base path
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath2 = localObj.protocol + "//" + localObj.host;

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
    $('#answer_img').attr('src', basePath2 + '/resources/images/avatar/default_avatar.png');
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
        url: basePath2 + "/answer-the-question",
        data: {
            anonymous: $('#is_anonymous').val(),
            answerContent: markupStr,
            reprintType: $('#reprint_type').val(),
            commentType: $('#comment_type').val(),
            questionId: $('#question_id').val()
        },
        dataType: "json",
        success: function(data){
            // console.log(data);

            // json 时间数据格式化
            data['answerTime'] = getLocalTime(data['answerTime']);

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

// 收起回答
function tuckUpAnswer(id) {
    $('#ans-inner-' + id).addClass('custom-is-collapsed');
    $('#ans-inner-' + id).css('max-height', '400px');
    $('#ans-unfold-' + id).removeClass('hide');
    $('#tuck-up-' + id).addClass('hide');
}

// 展开全部回答
function unfoldAnswer(id) {
    $('#ans-inner-' + id).removeClass('custom-is-collapsed');
    $('#ans-inner-' + id).css('max-height', '');
    $('#ans-unfold-' + id).addClass('hide');
    $('#tuck-up-' + id).removeClass('hide');
}

// 回答赞同
function voteUp(obj, id) {

    var data = {
        answerId: id,
        voteAction: 1 // 赞
    };

    if (!$(obj).hasClass('is-active') && !$(obj).next().hasClass('is-active')) {
        // 没攒没踩
        $(obj).addClass('is-active');
    } else if ($(obj).hasClass('is-active') && !$(obj).next().hasClass('is-active')) {
        // 有赞没踩
        $(obj).removeClass('is-active');
    } else if ($(obj).next().hasClass('is-active')) {
        // 已踩
        $(obj).next().removeClass('is-active');
        $(obj).addClass('is-active');
    }

    voteFunc(data);
}

// 回答反对
function voteDown(obj, id) {

    var data = {
        answerId: id,
        voteAction: 2 // 踩
    };

    if (!$(obj).prev().hasClass('is-active') && !$(obj).hasClass('is-active')) {
        // 没攒没踩
        $(obj).addClass('is-active');
    } else if ($(obj).prev().hasClass('is-active') && !$(obj).hasClass('is-active')) {
        // 有赞没踩
        $(obj).prev().removeClass('is-active');
        $(obj).addClass('is-active');
    } else if ($(obj).hasClass('is-active')) {
        // 已踩
        $(obj).removeClass('is-active');
    }

    voteFunc(data);
}

// 回答投票
function voteFunc(data) {
    $.ajax({
        type: "POST",
        url: basePath2 + "/answer-vote",
        data: data,
        dataType: "text",
        success: function(data) {
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

// 回答评论列表
function commentsList(answerId) {

    console.log(basePath2);

    $.ajax({
        type: "GET",
        url: basePath2 + "/answer-comment-list",
        data: {
            answerId: answerId
        },
        dataType: "json",
        success: function(data) {
            console.log(data);

            // 判断是否是添加评论模板
            data['isPost'] = false;

            // json 时间数据格式化
            for (var c = 0; c < data['list'].length; c ++) {
                data['list'][c]['answerCommentsDO']['commentTime'] = getLocalTime(data['list'][c]['answerCommentsDO']['commentTime']);
            }

            // 使用 handlebars 获取模板
            var tpl = $('#answer-comments-template').html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#comments-container-' + answerId).html(html);

            // 分页模板
            var pagingTpl = $('#answer-comments-paging-template').html();
            var pagingTemplate = Handlebars.compile(pagingTpl);
            data['page']['answerId'] = answerId;
            var pagingHtml = pagingTemplate(data['page']);
            $('#answer-comments-paging-wrapper-' + answerId).html(pagingHtml);
        }
    });
}

// 回答题评论分页请求
function answerCommentsWithPage(pageNum, answerId) {
    $.ajax({
        type: "GET",
        url: basePath2 + "/answer-comments-with-page",
        data: {
            pageNum: pageNum,
            answerId: answerId
        },
        dataType: "json",
        success: function(data) {
            // console.log(data);

            // 判断是否是添加评论模板
            data['isPost'] = false;

            // json 时间数据格式化
            for (var c = 0; c < data['list'].length; c ++) {
                data['list'][c]['answerCommentsDO']['commentTime'] = getLocalTime(data['list'][c]['answerCommentsDO']['commentTime']);
            }

            // 使用 handlebars 获取模板
            var tpl = $('#answer-comments-template').html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#comments-container-' + answerId).html(html);

            // 分页模板
            var pagingTpl = $('#answer-comments-paging-template').html();
            var pagingTemplate = Handlebars.compile(pagingTpl);
            data['page']['answerId'] = answerId;
            var pagingHtml = pagingTemplate(data['page']);
            $('#answer-comments-paging-wrapper-' + answerId).html(pagingHtml);
        }
    });
}

// 评论回答
function postAnswerComment(id) {

    var content = $('#answer-comment-' + id).val();
    $('#answer-comment-' + id).val('');

    $.ajax({
        type: "POST",
        url: basePath2 + "/answer-comment",
        data: {
            answerId: id,
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
            data['answerCommentsDO']['commentTime'] = getLocalTime(data['answerCommentsDO']['commentTime']);

            // 使用 handlebars 获取模板
            var tpl = $("#answer-comments-template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#comments-container-' + id).append(html);

        }
    });
}

// 回答评论回复
function replyAnswerComment(id) {
    $('#answerCommentItem-footer-' + id).addClass('hide');
    $('#answerComment-reply-' + id).removeClass('hide');
}

// 隐藏回复组件
function hideAnswerComment(id) {
    $('#answerCommentItem-footer-' + id).removeClass('hide');
    $('#answerComment-reply-' + id).addClass('hide');
}

// 回答评论回复
function postAnswerCommentReply(answerId, id) {
    var content = $('#answer-comment-r-' + id).val();
    console.log(answerId);
    $.ajax({
        type: "POST",
        url: basePath2 + "/answer-comment-reply",
        data: {
            answerId: answerId,
            reviewerId: $('#reviewer-id-r-' + id).val(),
            parentCommentId: id,
            commentContent: content
        },
        dataType: "json",
        success: function (data) {
            console.log(data);

            $('#answerCommentItem-footer-' + id).removeClass('hide');
            $('#answerComment-reply-' + id).addClass('hide');

            // 判断是否是添加评论模板
            data['isPost'] = true;

            // json 时间数据格式化
            data['answerCommentsDO']['commentTime'] = getLocalTime(data['answerCommentsDO']['commentTime']);

            // 使用 handlebars 获取模板
            var tpl = $("#answer-comments-template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#comments-container-' + answerId).append(html);

        }
    });
}