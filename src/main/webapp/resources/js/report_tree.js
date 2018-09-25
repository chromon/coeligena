/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report
function report(id) {
    $('#reportModal').modal('show');
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