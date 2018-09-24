/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report
function report(id) {
    $('#reportModal').modal('show');
}

function reportFunc(msg, pid, id) {
    let parentElement = $('#reportMenu-' + pid);
    let currentElement = $('#reportMenu-' + id);

    parentElement.addClass('hide');
    currentElement.removeClass('hide');
    currentElement.find('.modal-title').text(msg);
}