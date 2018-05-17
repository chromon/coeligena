/**
 * Created by Ellery on 2018/5/7.
 * hover card with webuiPopover
 */


// user info hover card
$('#user-avatar').webuiPopover({
    url: '#user_info',
    placement: 'auto',
    width: '360',
    trigger: 'hover',
    arrow: false,
    animation: 'pop'
});

// notification click card
$('#notification_bell').webuiPopover({
    url: '#notification_card',
    placement: 'bottom',
    width: '360',
    trigger: 'click',
    arrow: true,
    animation: 'pop'
});

// message click card
$('#message_bar').webuiPopover({
    url: '#message_card',
    placement: 'bottom',
    width: '360',
    trigger: 'click',
    arrow: true,
    animation: 'pop'
});

// publish-panel click card
$('#publish-btn').webuiPopover({
    url: '#publish-panel',
    placement: 'bottom',
    width: '320',
    trigger: 'click',
    arrow: true,
    animation: 'pop'
});