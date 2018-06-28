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

    alert($(window).height()); //浏览器当前窗口可视区域高度
    alert($(document).height()); //浏览器当前窗口文档的高度
    alert($(document.body).height());//浏览器当前窗口文档body的高度
    alert($(document.body).outerHeight(true));//浏览器当前窗口文档body的总高度 包括border padding margin
    alert($(window).width()); //浏览器当前窗口可视区域宽度
    alert($(document).width());//浏览器当前窗口文档对象宽度
    alert($(document.body).width());//浏览器当前窗口文档body的高度
    alert($(document.body).outerWidth(true));//浏览器当前窗口文档body的总宽度 包括border padding margin
    var fold = $(window).height() + $(window).scrollTop();
    console.log(fold);
}

// 展开全部回答
function unfoldAnswer(id) {
    $('#ans-inner-' + id).removeClass('custom-is-collapsed');
    $('#ans-inner-' + id).css('max-height', '');
    $('#ans-unfold-' + id).addClass('hide');
    $('#tuck-up-' + id).removeClass('hide');

}