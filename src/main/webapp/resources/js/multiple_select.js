/**
 * Created by Ellery on 2018/5/7.
 * multiple select with select2
 */

$(document).ready(function() {
    // multi-select
    $('.js-example-basic-multiple').select2({
        theme: "bootstrap",
        width: '100%',
        multiple: true,
        maximumSelectionLength: 5,
        minimumInputLength: 2,
        language: "zh-CN",
        placeholder: '添加话题',
        ajax: {
            url: basePath + '/topic-search',
            dataType: 'json',
            delay: 250,
            data: function (params) {
                return {
                    topicName: encodeURIComponent(params.term)
                };
            },
            processResults: function (data) {
                console.log(data);
                return {
                    results: data
                };
            },
            cache: true
        },
        escapeMarkup: function (markup) { return markup; },
        templateResult: formatRepo,
        templateSelection: formatRepoSelection
    });

});

function formatRepo(repo) {
    return repo.topicName;
    // return '<option value="' + repo.id + '" selected>' + repo.topicName + '</option>'
}
function formatRepoSelection(repo) {
    return repo.topicName;
}