/**
 * answer collapse
 * Created by Ellery on 2018/6/23.
 */

$(document).ready(function () {
    console.log($('.custom-rich-content-inner').height());
});

// 收起回答
function tuckUpAnswer(id) {
    $('#ans-inner-' + id).addClass('custom-is-collapsed');
    $('#ans-inner-' + id).css('max-height', '400px');
    $('#ans-unfold-' + id).removeClass('hide');
    $('#tuck-up-' + id).addClass('hide');
}

// 展开全部回答
function unfoldAnswer(id) {
    $('#ans-inner-' + id).removeClass('custom-is-collapsed');
    $('#ans-inner-' + id).css('max-height', '');
    $('#ans-unfold-' + id).addClass('hide');
    $('#tuck-up-' + id).removeClass('hide');

}