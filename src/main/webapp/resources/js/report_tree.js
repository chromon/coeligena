/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report
function report(id) {
    $('#reportModal').modal('show');

    $('#reportModal').on('shown.bs.modal', function () {
        reportAJAX(0);
    });
}

function reportAJAX(id) {
    $.ajax({
        type: "POST",
        url: basePath2 + "/report-type-list",
        data: {
            parentReportTypeId: id
        },
        dataType: "json",
        success: function (data) {
            console.log(data);

            for (let c = 0; c < data.length; c ++) {
                // if (data[c]['parentReportTypeId'] == 1) {
                //     data[c]['parentReportTypeId'] = true;
                // } else {
                //     data[c]['parentReportTypeId'] = false;
                // }

                if (data[c]['requireDetails'] == 1) {
                    data[c]['requireDetails'] = true;
                } else {
                    data[c]['requireDetails'] = false;
                }

                if (data[c]['subReportType'] == 1) {
                    data[c]['subReportType'] = true;
                } else {
                    data[c]['subReportType'] = false;
                }

                if (data[c]['requireDetails'] || data[c]['subReportType']) {
                    data[c]['hasIcon'] = true;
                } else {
                    data[c]['hasIcon'] = false;
                }
            }

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
}

function reportTextArea(msg, id) {
    let parentElement = $('#reportMenu-index');
    let currentElement = $('#reportMenu-textarea');

    parentElement.addClass('hide');
    currentElement.removeClass('hide');
    currentElement.find('.modal-title').text(msg);
    currentElement.find('.return-btn').attr('onclick', 'reportReturn("'+ id +'")');
}

function nextReportType(pid) {
    reportAJAX(pid);
}

function reportReturn(pid) {
    $('#reportMenu-textarea').addClass('hide');
    $('#reportMenu-index').removeClass('hide');
    reportAJAX(pid);
}

// // 举报
// function reportFunc(msg, pid, id) {
//     let parentElement = $('#reportMenu-' + pid);
//     let currentElement = $('#reportMenu-' + id);
//
//     if (parentElement.length <= 0) {
//         parentElement = $('#reportMenu-index')
//     }
//
//     parentElement.addClass('hide');
//     currentElement.removeClass('hide');
//     currentElement.find('.modal-title').text(msg);
//
//     currentElement.find('.return-btn').attr('onclick', 'reportReturn("'+ pid +'", "'+ id +'");');
//
// }
//
// // 举报返回
// function reportReturn(pid, id) {
//     let parentElement = $('#reportMenu-' + pid);
//     let currentElement = $('#reportMenu-' + id);
//
//     parentElement.removeClass('hide');
//     currentElement.addClass('hide');
// }