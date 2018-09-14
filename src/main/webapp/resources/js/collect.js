/**
 * Created by Ellery on 2018/5/7.
 * answer/ article collect
 */

function showCollectModal(id) {
    $('#collectModal').modal('show');

    $('#collectModal').on('shown.bs.modal', function () {
        $.ajax({
            type: "GET",
            url: basePath2 + "/collection-folders-list",
            dataType: "json",
            success: function (data) {
                // console.log(data);

                // 添加回答 id
                for (let c = 0; c < data.length; c ++) {
                    data[c]['answerId'] = id;
                }

                // 使用 handlebars 获取模板
                let tpl = $("#collection-folder-items-template").html();
                // 预编译模板
                let template = Handlebars.compile(tpl);
                // 匹配 json 内容
                let html = template(data);
                // 输入模板
                $('#favorite_list').html(html);
            }
        });
    });
}



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

            // 添加回答 id
            for (let c = 0; c < data.length; c ++) {
                data[c]['answerId'] = id;
            }

            // 使用 handlebars 获取模板
            var tpl = $("#collection-folder-item-template").html();
            // 预编译模板
            var template = Handlebars.compile(tpl);
            // 匹配 json 内容
            var html = template(data);
            // 输入模板
            $('#collection-folder-items').append(html);
        }
    });

    // 返回收藏夹列表页
    showCollectionsList();
});

// 添加答案到收藏夹
function toFolder(obj, id, answerId) {

    let data =  {
        folderId: id,
        answerId: answerId,
    };

    if ($(obj).hasClass('btn-outline-primary')) {
        // 收藏
        $(obj).removeClass('btn-outline-primary');
        $(obj).addClass('btn--grey');
        $(obj).text('已收藏');

        collect(data, "/add-to-collection-folders");
    } else {
        // 取消收藏
        $(obj).removeClass('btn--grey');
        $(obj).addClass('btn-outline-primary');
        $(obj).text('收藏');

        collect(data, "/remove-from-collection-folders");
    }
}

function collect(d, path) {
    $.ajax({
        type: "POST",
        url: basePath2 + path,
        data: d,
        dataType: "json",
        success: function (data) {
            console.log(JSON.stringify(data));
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