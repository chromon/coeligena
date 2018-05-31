/**
 * Created by Ellery on 2018/5/7.
 * editor
 */

// write answer editor
function write_answer() {
    $('#answer_note').summernote({
        placeholder: '写回答…',
        height: 110,
        lang: 'zh-CN',
        minHeight: null,
        maxHeight: null,
        focus: true,
        codemirror: { // codemirror options
            theme: 'monokai'
        },
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'underline', 'clear']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['insert', ['link', 'picture', 'video']],
            ['view', ['fullscreen', 'codeview']]
        ]
    });
    $('#answer_wrap').fadeIn('3000');
}
$('#write_answer_top').click(write_answer);
$('#write_answer_bottom').click(write_answer);
$('#write_answers_none').click(write_answer);

// ask editor
$('#ask_note').summernote({
    placeholder: '问题背景、条件等详细信息',
    height: 110,
    lang: 'zh-CN',
    minHeight: null,
    maxHeight: null,
    focus: true,
    codemirror: { // codemirror options
        theme: 'monokai'
    },
    toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['insert', ['link', 'picture', 'video']],
        ['view', ['fullscreen', 'codeview']]
    ]
});

// write column editor
$('#write_column').summernote({
    placeholder: '请输入正文',
    height: 300,
    lang: 'zh-CN',
    minHeight: null,
    maxHeight: null,
    focus: true,
    codemirror: { // codemirror options
        theme: 'monokai'
    },
    toolbar: [
        ['style', ['style']],
        ['font', ['bold', 'underline', 'clear']],
        ['para', ['ul', 'ol', 'paragraph']],
        ['insert', ['link', 'picture', 'video']],
        ['view', ['fullscreen', 'codeview']]
    ]
});
