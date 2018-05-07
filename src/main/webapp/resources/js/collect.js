/**
 * Created by Ellery on 2018/5/7.
 * answer/ article collect
 */

// the width of favorite
$('#collect_list').labelauty({
    // minimum_width: 80%;
});

// create favorite button click
$('#create_favorite_btn').click(function () {
    $('#modalAddLabel').hide();
    $('#modalCreateLabel').removeClass('hidden');
    $('#modalCreateLabel').show();

    $('#favorite_list').hide();
    $('#create_favorite').removeClass('hidden');
    $('#create_favorite').show();

    $('#modalAddFooter').hide();
    $('#modalCreateFooter').removeClass('hidden');
    $('#modalCreateFooter').show();
});

// back to add favorite
$('#return_add_favorite').click(function () {
    $('#modalCreateLabel').hide();
    $('#modalCreateLabel').addClass('hidden');
    $('#modalAddLabel').show();

    $('#create_favorite').hide();
    $('#create_favorite').addClass('hidden');
    $('#favorite_list').show()

    $('#modalCreateFooter').hide();
    $('#modalCreateFooter').addClass('hidden');
    $('#modalAddFooter').show();
});
