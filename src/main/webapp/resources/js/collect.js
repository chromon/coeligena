/**
 * Created by Ellery on 2018/5/7.
 * answer/ article collect
 */

// 获取 base path
let localObj = window.location;
let contextPath = localObj.pathname.split("/")[1];
let basePath2 = localObj.protocol + "//" + localObj.host;

// 展示收藏 modal
function showCollectionsList() {
    $('#modalCreateLabel').hide();
    $('#modalCreateLabel').addClass('hidden');
    $('#modalAddLabel').show();

    $('#create_favorite').hide();
    $('#create_favorite').addClass('hidden');
    $('#favorite_list').show()

    $('#modalCreateFooter').hide();
    $('#modalCreateFooter').addClass('hidden');
    $('#modalAddFooter').show();
}

// 展示创建收藏夹 modal
function showCreateCollectionFolder() {
    $('#modalAddLabel').hide();
    $('#modalCreateLabel').removeClass('hidden');
    $('#modalCreateLabel').show();

    $('#favorite_list').hide();
    $('#create_favorite').removeClass('hidden');
    $('#create_favorite').show();

    $('#modalAddFooter').hide();
    $('#modalCreateFooter').removeClass('hidden');
    $('#modalCreateFooter').show();
}

// 展示创建收藏夹
$('#create_favorite_btn').click(function () {
   showCreateCollectionFolder();
});

// 取消创建收藏夹
$('#return_add_favorite').click(function () {
    showCollectionsList();
});

// 创建收藏夹
$('#create_collection_folder').click(function () {

    let collection_folder_name = $("#collection_folder_name").val();
    let collection_description = $("#collection_description").val();
    let folder_privacy = $("input[name='folder_privacy']:checked").val();

    $.ajax({
        type: "POST",
        url: basePath2 + "/create-collection-folder",
        data: {
            answerId: answerId,
            reviewerId: $('#reviewer-id-r-' + id).val(),
            parentCommentId: id,
            commentContent: content
        },
        dataType: "json",
        success: function (data) {
            // console.log(data);

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

    // 返回收藏夹列表页
    showCollectionsList();
});