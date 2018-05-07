/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report tree
var tree = [{
    text: "侵犯我的权益",
    nodes: [{
        text: "骚扰我"
    }, {
        text: "抄袭了我的内容"
    }, {
        text: "侵犯了我企业的权益"
    }, {
        text: "侵犯了我个人的权益"
    }],
    state: {
        expanded: false
    }
}, {
    text: "对编之社区有害的内容",
    nodes: [{
        text: "垃圾广告信息"
    }, {
        text: "色情、暴力、血腥等违反法律法规的内容"
    }, {
        text: "政治敏感"
    }, {
        text: "不规范转载"
    }, {
        text: "诱导投票"
    }],
    state: {
        expanded: false
    }
}, {
    text: "辱骂、歧视、挑衅等（不友善）"
}];
$('#reportTree').treeview({
    data: tree,
    expandIcon: 'fa fa-plus',
    collapseIcon: 'fa fa-minus',
    emptyIcon: ''
});