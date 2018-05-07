/**
 * Created by Ellery on 2018/5/7.
 * back to top
 */

// back to top
$(window).scroll(function (e) {
    //若滚动条离顶部大于100元素
    if ($(window).scrollTop()>100) {
        // 以1秒的间隔渐显id=back_to_top的元素
        $("#back_to_top").fadeIn(1000);
    } else {
        // 以1秒的间隔渐隐id=back_to_top的元素
        $("#back_to_top").fadeOut(1000);
    }
});
//点击回到顶部的元素
$("#back_to_top").click(function(e) {
    //以0.3秒的间隔返回顶部
    $('body,html').animate({scrollTop: 0}, 300);
});