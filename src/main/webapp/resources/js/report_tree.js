/**
 * Created by Ellery on 2018/5/7.
 * report tree
 */

// report tree
var tree = [{
    text: "垃圾广告信息"
}, {
    text: "不友善行为",
    nodes: [{
        text: "辱骂、歧视、挑衅等"
    }, {
        text: "其他不友善行为"
    }],
    state: {
        expanded: false
    }
}, {
    text: "有害信息",
    nodes: [{
        text: "政治敏感垃圾广告信息"
    }, {
        text: "色情、暴力、血腥等违反法律法规的内容"
    }, {
        text: "不实信息"
    }, {
        text: "有人意图自杀或自残"
    }, {
        text: "违法违规"
    }],
    state: {
        expanded: false
    }
}, {
    text: "涉嫌侵权",
    nodes: [{
        text: "不规范转载"
    }, {
        text: "个人侵权"
    }, {
        text: "企业侵权"
    }],
    state: {
        expanded: false
    }
}, {
    text: "诱导投票"
}, {
    text: "其他"
}];
$('#reportTree').treeview({
    data: tree,
    expandIcon: 'fa fa-plus',
    collapseIcon: 'fa fa-minus',
    emptyIcon: ''
});