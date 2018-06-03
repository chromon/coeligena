/**
 * post answer
 * Created by Ellery on 2018/6/3.
 */

$('#post_answer_btn').on('click', function () {
    var markupStr = $('#answer_note').summernote('code');
    alert(markupStr);
});
