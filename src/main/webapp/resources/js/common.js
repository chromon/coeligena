/**
 * Created by Ellery on 2017/8/8.
 */

// user info hover card
$('#user-avatar').webuiPopover({
    url: '#user_info',
    placement: 'auto',
    width: '360',
    trigger: 'hover',
    arrow: false,
    animation: 'pop'
});

// notification click card
$('#notification_bell').webuiPopover({
    url: '#notification_card',
    placement: 'bottom',
    width: '360',
    trigger: 'click',
    arrow: true,
    animation: 'pop'
});

// message click card
$('#message_bar').webuiPopover({
    url: '#message_card',
    placement: 'bottom',
    width: '360',
    trigger: 'click',
    arrow: true,
    animation: 'pop'
});

// the width of favorite
$('#collect_list').labelauty({
    minimum_width: '270px'
});

// create favorite button click
$('#create_favorite_btn').click(function () {
    $('#modalAddLabel').hide();
    $('#modalCreateLabel').removeClass('hidden');
    $('#modalCreateLabel').show();

    $('#favorite_list').hide();
    $('#create_favorite').removeClass('hidden');
    $('#create_favorite').show();

    $('#modalAddFooter').hide();
    $('#modalCreateFooter').removeClass('hidden');
    $('#modalCreateFooter').show();
});

// back to add favorite
$('#return_add_favorite').click(function () {
    $('#modalCreateLabel').hide();
    $('#modalCreateLabel').addClass('hidden');
    $('#modalAddLabel').show();

    $('#create_favorite').hide();
    $('#create_favorite').addClass('hidden');
    $('#favorite_list').show()

    $('#modalCreateFooter').hide();
    $('#modalCreateFooter').addClass('hidden');
    $('#modalAddFooter').show();
});

// report tree
var tree = [{
    text: "侵犯我的权益",
    nodes: [{
        text: "骚扰我"
    }, {
        text: "抄袭了我的内容"
    }, {
        text: "侵犯了我企业的权益"
    }, {
        text: "侵犯了我个人的权益"
    }],
    state: {
        expanded: false
    }
}, {
    text: "对编乎社区有害的内容",
    nodes: [{
        text: "垃圾广告信息"
    }, {
        text: "色情、暴力、血腥等违反法律法规的内容"
    }, {
        text: "政治敏感"
    }, {
        text: "不规范转载"
    }, {
        text: "诱导投票"
    }],
    state: {
        expanded: false
    }
}, {
    text: "辱骂、歧视、挑衅等（不友善）"
}];
$('#reportTree').treeview({
    data: tree,
    expandIcon: 'fa fa-plus',
    collapseIcon: 'fa fa-minus',
    emptyIcon: ''
});

// back to top
$(window).scroll(function (e) {
    //若滚动条离顶部大于100元素
    if($(window).scrollTop()>100)
        $("#back_to_top").fadeIn(1000); // 以1秒的间隔渐显id=back_to_top的元素
    else
        $("#back_to_top").fadeOut(1000); // 以1秒的间隔渐隐id=back_to_top的元素
});
//点击回到顶部的元素
$("#back_to_top").click(function(e) {
    //以0.3秒的间隔返回顶部
    $('body,html').animate({scrollTop: 0}, 300);
});

// collapse item
$(".custom-collapse-item").hide();
$("#feed-item-1").hover(function () {
    console.log('show');
    $(".custom-collapse-item").show();
}, function () {
    console.log('hide');
    $(".custom-collapse-item").hide();
});

// editor
$('#summernote').summernote({
    height: 200,                 // set editor height
    lang: 'zh-CN',
    // airMode: true,
    minHeight: null,             // set minimum height of editor
    maxHeight: null,             // set maximum height of editor
    focus: false,
    codemirror: { // codemirror options
        theme: 'monokai'
    },
    toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        // ['fontname', ['fontname']],
        // ['color', ['color']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['table', ['table']],
        ['insert', ['link', 'picture', 'video']],
        ['view', ['fullscreen', 'codeview']]
    ]
});
