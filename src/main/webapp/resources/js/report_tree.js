/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report
function report(id) {
    $('#reportModal').modal('show');

    $('#reportModal').on('shown.bs.modal', function () {
        $.ajax({
            type: "GET",
            url: basePath2 + "/report-type-list",
            dataType: "json",
            success: function (data) {
                console.log(data);

                // 使用 handlebars 获取模板
                let tpl = $("#report-root-type-template").html();
                // 预编译模板
                let template = Handlebars.compile(tpl);
                // 匹配 json 内容
                let html = template(data);
                // 输入模板
                $('#reportMenu-index').html(html);
            }
        });
    });
}

// 举报
function reportFunc(msg, pid, id) {
    let parentElement = $('#reportMenu-' + pid);
    let currentElement = $('#reportMenu-' + id);

    if (parentElement.length <= 0) {
        parentElement = $('#reportMenu-index')
    }

    parentElement.addClass('hide');
    currentElement.removeClass('hide');
    currentElement.find('.modal-title').text(msg);

    currentElement.find('.return-btn').attr('onclick', 'reportReturn("'+ pid +'", "'+ id +'");');

}

// 举报返回
function reportReturn(pid, id) {
    let parentElement = $('#reportMenu-' + pid);
    let currentElement = $('#reportMenu-' + id);

    parentElement.removeClass('hide');
    currentElement.addClass('hide');
}