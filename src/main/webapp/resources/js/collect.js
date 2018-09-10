/**
 * Created by Ellery on 2018/5/7.
 * answer/ article collect
 */

// 展示收藏 modal
function showCollectionsList() {
    $('#modalCreateLabel').addClass('hidden');
    $('#modalAddLabel').removeClass('hidden');

    $('#create_favorite').addClass('hidden');
    $('#favorite_list').removeClass('hidden');

    $('#modalCreateFooter').addClass('hidden');
    $('#modalAddFooter').removeClass('hidden');
}

// 展示创建收藏夹 modal
function showCreateCollectionFolder() {
    $('#modalAddLabel').addClass('hidden');
    $('#modalCreateLabel').removeClass('hidden');

    $('#favorite_list').addClass('hidden');
    $('#create_favorite').removeClass('hidden');

    $('#modalAddFooter').addClass('hidden');
    $('#modalCreateFooter').removeClass('hidden');
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
            folderName: collection_folder_name,
            description: collection_description,
            forPublic: folder_privacy
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