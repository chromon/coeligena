/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report
function report(answerId, category) {
    $('#reportModal').modal('show');

    // 回答 id ， 举报分类
    $('#report_answer_id').val(answerId);
    $('#report_category').val(category);

    $('#reportModal').on('shown.bs.modal', function () {
        reportAJAX(0);
    });

    $("#reportModal").on("hidden.bs.modal", function() {
        $(this).removeData("bs.modal");
        // $(".modal-content").children().remove();
        //
        $('#reportMenu-index').removeClass('hide');
        $('#reportMenu-textarea').addClass('hide');
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

            let hasReturn = false;
            if (data['reportTypeDO']['id'] != 0) {
                hasReturn = true;
            }
            data['hasReturn'] = hasReturn;

            let tmp = data['reportTypeDOList'];
            for (let c = 0; c < tmp.length; c ++) {

                if (tmp[c]['requireDetails'] == 1) {
                    tmp[c]['requireDetails'] = true;
                } else {
                    tmp[c]['requireDetails'] = false;
                }

                if (tmp[c]['subReportType'] == 1) {
                    tmp[c]['subReportType'] = true;
                } else {
                    tmp[c]['subReportType'] = false;
                }

                if (tmp[c]['requireDetails'] || tmp[c]['subReportType']) {
                    tmp[c]['hasIcon'] = true;
                } else {
                    tmp[c]['hasIcon'] = false;
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

// 举报详情
function reportTextArea(msg, pid, id) {
    let parentElement = $('#reportMenu-index');
    let currentElement = $('#reportMenu-textarea');

    parentElement.addClass('hide');
    currentElement.removeClass('hide');
    currentElement.find('.modal-title').text(msg);
    currentElement.find('.return-btn').attr('onclick', 'reportReturn("'+ pid +'")');

    $('#report_type_id').val(id);
}

// 次级举报
function nextReportType(pid) {
    reportAJAX(pid);
}

// 举报返回
function reportReturn(pid) {
    $('#reportMenu-textarea').addClass('hide');
    $('#reportMenu-index').removeClass('hide');
    reportAJAX(pid);
}

// 举报选择
function reportCheck(obj, id) {
    $(obj).find('i').toggleClass('hide');
    $('#report_type_id').val(id);
}

// 不需要填写理由的举报
function normalReport() {
    let report_answer_id = $('#report_answer_id').val();
    let report_category = $('#report_category').val();
    let report_type_id = $('#report_type_id').val();

    let data = {
        answerId: report_answer_id,
        reportCategory: report_category,
        reportTypeId: report_type_id
    };

    reportFunc(data);
}

// 需要详细信息的举报
function textReport() {
    let report_answer_id = $('#report_answer_id').val();
    let report_category = $('#report_category').val();
    let report_type_id = $('#report_type_id').val();
    let reportText = $('#reportText').val();

    let data = {
        answerId: report_answer_id,
        reportCategory: report_category,
        reportTypeId: report_type_id,
        reportText:reportText
    };

    reportFunc(data);
}

function reportFunc(data) {
    $.ajax({
        type: "POST",
        url: basePath2 + "/report-answer",
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