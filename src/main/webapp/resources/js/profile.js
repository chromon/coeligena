/**
 * profile js
 * Created by Ellery on 2018/11/16.
 */

// 关注
function followFunc(obj, id) {

    let profile_follow_text = $('#profile-follow-text');
    let follow_icon = $('#follow-icon');
    let data;

    if ($(obj).hasClass('btn-primary')) {
        $(obj).removeClass('btn-primary');
        $(obj).addClass('btn-default');
        $(obj).addClass('btn--grey');
        follow_icon.addClass('hide');
        profile_follow_text.text('已关注');

        data = {
            followId: id,
            followAction: 1 // 关注
        };
    } else {
        $(obj).removeClass('btn-default');
        $(obj).removeClass('btn--grey');
        $(obj).addClass('btn-primary');
        follow_icon.removeClass('hide');
        profile_follow_text.text('关注');

        data = {
            followId: id,
            followAction: 0 // 取关
        };
    }

    followAJAXfunc(data);
}

// 关注实现
function followAJAXfunc(data) {
    $.ajax({
        type: "POST",
        url: basePath2 + "/follow-user",
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