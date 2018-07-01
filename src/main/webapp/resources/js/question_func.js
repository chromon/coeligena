/**
 * question func
 * Created by Ellery on 2018/6/29.
 */

// 显示全部问题内容
$('#unfold-question').on('click', function() {
    $('#unfold-question').addClass('hide');
    $('#tuck-up-question').removeClass('hide');

    $('#question-digest').addClass('hide');
    $('#question-detail').removeClass('hide');
});

// 收起问题详细信息
$('#tuck-up-question').on('click', function() {
    $('#unfold-question').removeClass('hide');
    $('#tuck-up-question').addClass('hide');

    $('#question-digest').removeClass('hide');
    $('#question-detail').addClass('hide');
});

// 问题评论高度自适应
$('#question-comment').on('input',function(){
    if (this.scrollHeight < 150) {
        this.style.height='auto';
        this.style.height = this.scrollHeight + 'px';
    }
});


