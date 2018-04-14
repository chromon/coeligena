/**
 * 通用 js
 *
 * Created by Ellery on 2017/8/8.
 */

// 获取 base path
var localObj = window.location;
var contextPath = localObj.pathname.split("/")[1];
var basePath = localObj.protocol + "//" + localObj.host + "/" + contextPath;

$(document).ready(function() {
    NProgress.start();
    NProgress.inc(0.1);
    NProgress.done();

    $('.js-example-basic-multiple').select2({
        theme: "bootstrap",
        width: '100%',
        multiple: true,
        maximumSelectionLength: 5,
        minimumInputLength: 2,
        language: "zh-CN",
        placeholder: '添加话题',
        ajax: {
            url: basePath + '/topic-search',
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    topicName: encodeURIComponent(params.term)
                };
            },
            processResults: function (data) {
                return {
                    results: data
                };
            },
            cache: true
        },
        escapeMarkup: function (markup) { return markup; },
        templateResult: formatRepo,
        templateSelection: formatRepoSelection
    });

});

function formatRepo(repo) {return repo.topicName}
function formatRepoSelection(repo) {return repo.topicName}

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
    }
    ,
    toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['insert', ['link', 'picture', 'video']],
        ['view', ['fullscreen', 'codeview']]
    ]
});

// tags input
// $('#inputtags').selectize({
//     plugins: ['remove_button'],
//     maxItems: 5,
//     valueField: 'topic_name',
//     labelField: 'topic_name',
//     searchField: 'topic_name',
//     options: [],
// create: false,
//     render: {
//         option: function(item, escape) {
//             console.log(item);
//             console.log(escape(item.id));
//             return 'hehehehehehe';
//             // return '<div>' + escape(item) + '</div>' +
//             //     '<div>' + escape(item.topicName) + '</div>' +
//             //     '<div>' + item + '</div>' +
//             //     '<div>' + item.id + '</div>';
//             // return '<div>' +
//             //     '<span class="title">' +
//             //     '<span class="name"><i class="icon ' + (item.fork ? 'fork' : 'source') + '"></i>' + escape(item.name) + '</span>' +
//             //     '<span class="by">' + escape(item.username) + '</span>' +
//             //     '</span>' +
//             //     '<span class="description">' + escape(item.description) + '</span>' +
//             //     '<ul class="meta">' +
//             //     (item.language ? '<li class="language">' + escape(item.language) + '</li>' : '') +
//             //     '<li class="watchers"><span>' + escape(item.watchers) + '</span> watchers</li>' +
//             //     '<li class="forks"><span>' + escape(item.forks) + '</span> forks</li>' +
//             //     '</ul>' +
//             //     '</div>';
//         }
//     },
//     // score: function(search) {
//     //     var score = this.getScoreFunction(search);
//     //     return function(item) {
//     //         return score(item) * (1 + Math.min(item.watchers / 100, 1));
//     //     };
//     // },
//     load: function(query, callback) {
//         if (!query.length) return callback();
//         $.ajax({
//             url: basePath + '/topic-search/' + encodeURIComponent(query),
//             type: 'GET',
//             error: function() {
//                 callback();
//             },
//             success: function(res) {
//                 console.log(res);
//                 callback(res);
//             }
//         });
//     }
// });

// $('#inputtags').selectize({
//     plugins: ['remove_button'],
//     maxItems: 3,
//     valueField: 'url',
//     labelField: 'name',
//     searchField: 'name',
//     options: [],
//     create: false,
//     render: {
//         option: function(item, escape) {
//             console.log('--x--'+item);
//             // console.log(escape(item.id));
//             return '<div>-----------ddd</div>';
//             // return '<div>' +
//             //     '<span class="title">' +
//             //     '<span class="name"><i class="icon ' + (item.fork ? 'fork' : 'source') + '"></i>' + escape(item.name) + '</span>' +
//             //     '<span class="by">' + escape(item.username) + '</span>' +
//             //     '</span>' +
//             //     '<span class="description">' + escape(item.description) + '</span>' +
//             //     '<ul class="meta">' +
//             //     (item.language ? '<li class="language">' + escape(item.language) + '</li>' : '') +
//             //     '<li class="watchers"><span>' + escape(item.watchers) + '</span> watchers</li>' +
//             //     '<li class="forks"><span>' + escape(item.forks) + '</span> forks</li>' +
//             //     '</ul>' +
//             //     '</div>';
//         }
//     },
//     score: function(search) {
//         var score = this.getScoreFunction(search);
//         return function(item) {
//             return score(item) * (1 + Math.min(item.watchers / 100, 1));
//         };
//     },
//     load: function(query, callback) {
//         if (!query.length) return callback();
//         $.ajax({
//             url: basePath + '/topic-search/' + encodeURIComponent(query),
//             type: 'GET',
//             error: function() {
//                 callback();
//             },
//             success: function(res) {
//                 console.log(res);
//                 console.log(res.slice(0, 10));
//                 callback(res.slice(0, 10));
//             }
//         });
//     }
// });
