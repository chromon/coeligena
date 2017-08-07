<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>话题动态 - 编乎</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-paper.min.css" media="screen">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/custom.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugin/webui-popover/jquery.webui-popover.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugin/jquery-labelauty/jquery-labelauty.css">
</head>
<body>
<!-- navbar -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- navbar title -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand custom-title">编乎</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- navbar component auto collapse -->
        <div class="navbar-collapse collapse" id="navbar-main">
            <!-- navbar left -->
            <ul class="nav navbar-nav custom-navbar">
                <li>
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#">话题</a>
                </li>
                <li>
                    <a href="#">发现</a>
                </li>
                <li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm" size="40" placeholder="搜索你感兴趣的内容...">
                            <span class="input-group-btn">
                                    <button class="btn btn-primary btn-sm" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                        </div>
                    </form>
                </li>
                <li>
                    <form class="navbar-form navbar-left" >
                        <div class="input-group">
                            <button class="btn btn-primary btn-sm custom-ask-btn" data-toggle="modal" data-target="#askModal">提问</button>
                        </div>
                    </form>
                </li>
            </ul>

            <!-- navbar right -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="custom-nav-icon" href="#">
                        <i class="fa fa-bell"></i>
                    </a>
                </li>
                <li>
                    <a class="custom-nav-icon" href="#">
                        <i class="fa fa-comments"></i>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle custom-user-info" data-toggle="dropdown" role="button" aria-expanded="false">
                        <img class="custom-avatar30" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="#"><i class="fa fa-user-o custom-menu-mright "></i> 我的主页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope-o custom-menu-mright"></i> 私信</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cog custom-menu-mright"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-power-off custom-menu-mright"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul><!-- end navbar right -->
        </div>
    </div>
</div><!-- navbar -->

<!-- main content -->
<div class="container">
    <div class="row custom-content-margin">
        <div class="col-sm-9">

            <!-- tag -->
            <div class="custom-topic-content custom-story-item custom-card">
                <div class="custom-tag custom-question-topic">
                    <a href="">标签</a>
                </div>
                <div class="custom-tag custom-question-topic">
                    <a href="">标签</a>
                </div>
                <div class="custom-tag custom-question-topic">
                    <a href="">标签</a>
                </div>
                <div class="custom-tag custom-question-topic">
                    <a href="">标签</a>
                </div>
            </div>

            <div class="custom-topic-content custom-story-item custom-card">
                <div class="custom-margin-bottom20">
                    <a href="#">
                        <img class="custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="">
                    </a>
                    <a href="#" class="custom-topic-name">知乎</a>

                    <span class="custom-switcher custom-right">
                            <a href="" class="custom-current">默认排序</a> |
                            <a href="">时间排序</a>
                        </span>
                </div>

                <ul class="media-list">
                    <li id="feed-item-1" class="media custom-padding-top10">
                        <div class="media-left media-top">

                            <!-- votebar -->
                            <div class="custom-item-vote custom-margin-top5">
                                <a class="custom-item-vote-count js-expand js-vote-count" href="javascript:;">100</a>
                            </div>
                        </div>
                        <div class="media-body">

                            <!-- question title -->
                            <a href="#">
                                <h4 class="media-heading custom-media-heading">
                                    当你迷茫的时候，你应该做些什么？
                                </h4>
                            </a>

                            <!-- author info -->
                            <div class="custom-name">
                                <a href="#" class="">Ellery</a>
                                ，
                                <span class="custom-bio">中央处理器 (CPU)</span>
                            </div>

                            <!-- answer content -->
                            <div>Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，P. Cousot & R. Cousot 1977
                                Automatic discovery of linear restraints among variables of a program，P. Cousot & N. Halbwachs 1978
                                Systematic design of program analysis frameworks， P. Cousot & R. Cousot 1979
                            </div>

                            <!-- feed meta -->
                            <div class="custom-meta-panel">
                                <a href="#" class="custom-meta-item">
                                    <i class="fa fa-plus"></i>
                                    关注问题
                                </a>
                                <a href="#comment" data-toggle="collapse" class="custom-meta-item">
                                    <i class="fa fa-comment"></i>
                                    添加评论
                                </a>

                                <!-- collapse meta item -->
                                <div class="custom-collapse-item">
                                    <a href="#" class="custom-meta-item">
                                        <i class="fa fa-heart"></i>
                                        感谢
                                    </a>
                                    <a href="#" class="custom-meta-item">
                                        <i class="fa fa-paper-plane"></i>
                                        分享
                                    </a>
                                    <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#collectModal">
                                        <i class="fa fa-star"></i>
                                        收藏
                                    </a>
                                    <span class="custom-bull">•</span>
                                    <a href="#" class="custom-meta-item">
                                        没有帮助
                                    </a>
                                    <span class="custom-bull">•</span>
                                    <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#reportModal">
                                        举报
                                    </a>
                                </div>

                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    作者保留权利
                                </a>
                                <a href="#" class="custom-meta-item custom-right">
                                    <i class="fa fa-chevron-circle-up"></i>
                                    收起
                                </a>
                            </div>

                            <!-- comment -->
                            <div id="comment" class="panel panel-default custom-panel collapse">
                                <div class="panel-body custom-panel-body">
                                    <ul class="media-list">
                                        <li class="media custom-bottom-border">
                                            <div class="media-left">
                                                <a href="#">
                                                    <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                                </a>
                                            </div>
                                            <div class="media-body">
                                                <a href="#" class="custom-comment-name">
                                                    Ellery
                                                </a>
                                                <span class="custom-time custom-right">4小时前</span>
                                                <div>
                                                    Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，
                                                </div>

                                                <!-- feed meta -->
                                                <div class="custom-meta-panel custom-bottom-border">
                                                    <a href="#" class="custom-meta-item">
                                                        <i class="fa fa-thumbs-up"></i>
                                                        赞
                                                    </a>
                                                    <a href="#" class="custom-meta-item">
                                                        <i class="fa fa-share"></i>
                                                        回复
                                                    </a>
                                                    <a href="#" class="custom-meta-item">
                                                        <i class="fa fa-thumbs-down"></i>
                                                        踩
                                                    </a>
                                                    <a href="#" class="custom-meta-item">
                                                        <i class="fa fa-flag"></i>
                                                        举报
                                                    </a>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="media">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="写下你的评论……">
                                                <span class="input-group-btn">
                                                        <button class="btn btn-primary" type="button">回复</button>
                                                    </span>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div><!-- end comment -->
                        </div>
                    </li>
                </ul>
            </div>
        </div>

        <!-- sidebar -->
        <div class="col-sm-3">

            <div class="list-group custom-story-item custom-card">
                <div class="custom-list-group-title custom-color-9f">
                    其他人关注的话题
                    <span class="custom-right">
                            <a href="#" class="custom-item-link">
                                换一换 <i class="fa fa-angle-double-right"></i>
                            </a>
                        </span>
                </div>
                <div class="media-list custom-other-topic">
                    <div class="media">
                        <div class="media-left media-top">
                            <a href="#">
                                <img class="media-object custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <a href="#">
                                <h4 class="media-heading custom-media-heading">
                                    WWDC17
                                </h4>
                            </a>
                            <a href="#">
                                <div class="custom-item-link">
                                    <i class="fa fa-plus custom-topic-item"></i> 关注
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="media">
                        <div class="media-left media-top">
                            <a href="#">
                                <img class="media-object custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <a href="#">
                                <h4 class="media-heading custom-media-heading">
                                    WWDC17
                                </h4>
                            </a>
                            <a href="#">
                                <div class="custom-item-link">
                                    <i class="fa fa-plus custom-topic-item"></i> 关注
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="custom-footer">
                <a href="#" target="_blank">编乎指南 • </a>
                <a href="#" target="_blank">建议反馈 • </a>
                <a href="#" target="_blank">移动应用 • </a>
                <a href="#" target="_blank">加入编乎</a>
                <a href="#" target="_blank">编乎协议 • </a>
                <a href="#" target="_blank">举报投诉 • </a>
                <a href="#" target="_blank">联系我们</a><br/>
                <a href="#" target="_blank">&copy;2017</a>
            </div>
        </div><!-- end sidebar -->
    </div>
</div>

<!-- user info hover card -->
<div class="media custom-display-none" id="user_info">
    <div class="media-left">
        <a href="#">
            <img class="media-object custom-avatar68" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
        </a>
    </div>
    <div class="media-body">
        <h4 class="media-heading">Media heading</h4>
        <div>
            啊咧，一句话介绍不清楚的喵。
            啊咧，一句话介绍不清楚的喵。
        </div>
    </div>
    <div class="custom-hover-card">
        <div class="custom-hover-card-item">
            <i class="fa fa-briefcase"></i>
            <span class="custom-margin-left10">Microsoft</span>
            <div class="custom-hover-card-divider"></div> Developer
        </div>
        <div class="custom-hover-card-item">
            <i class="fa fa-users"></i>
            <span class="custom-margin-left10">AAA、BBB、CCC</span>
            也关注了他
        </div>
    </div>
    <div class="custom-number-board">
        <a href="#" class="custom-button custom-number-board-item custom-button-plain">
            <div class="custom-number-board-name">回答</div>
            <div class="custom-number-board-value">125</div>
        </a>
        <a href="#" class="custom-button custom-number-board-item custom-button-plain">
            <div class="custom-number-board-name">回答</div>
            <div class="custom-number-board-value">125</div>
        </a>
        <a href="#" class="custom-button custom-number-board-item custom-button-plain">
            <div class="custom-number-board-name">回答</div>
            <div class="custom-number-board-value">125</div>
        </a>
    </div>
    <div class="custom-hovercard-btn">
        <a href="#" class="btn btn-primary custom-margin-right30">
            <i class="fa fa-plus"></i>
            关注TA
        </a>
        <a href="#" class="btn btn-default">
            <i class="fa fa-comments"></i>
            发私信
        </a>
    </div>
</div>
<!-- end user info hover card -->

<!-- collection modal -->
<div class="modal fade" id="collectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div id="add_favorite" class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 id="modalAddLabel" class="modal-title">添加到收藏夹</h4>
                <h4 id="modalCreateLabel" class="modal-title hidden">创建新收藏夹</h4>
            </div>
            <div class="modal-body">
                <div id="favorite_list" class="custom-margin-left45">
                    <input type="checkbox" data-labelauty="Don't delete my files|Delete my files"/>
                    <input type="checkbox" data-labelauty="Don't delete my files|Delete my files"/>
                    <input type="checkbox" data-labelauty="Don't delete my files|Delete my files"/>
                </div>
                <div id="create_favorite" class="hidden">
                    <form>
                        <input type="text" class="form-control custom-margin-bottom10" placeholder="收藏标题">
                        <textarea class="form-control custom-margin-bottom10" rows="3" id="textArea" placeholder="收藏描述（可选）"></textarea>
                        <div class="custom-margin-bottom10">
                            <input class="" type="radio" value="option1" checked="">
                            公开 有其他人关注此收藏夹时不可设置为私密
                        </div>
                        <div class="custom-margin-bottom10">
                            <input type="radio" value="option2" checked="">
                            私密 只有你自己可以查看这个收藏夹
                        </div>
                    </form>
                </div>
            </div>
            <div id="modalAddFooter" class="modal-footer">
                <button type="button" class="btn btn-default custom-left" id="create_favorite_btn">
                    <i class="fa fa-plus-circle" aria-hidden="true"></i> 创建收藏夹
                </button>
                <button type="button" class="btn btn-primary">完成</button>
            </div>
            <div id="modalCreateFooter" class="modal-footer hidden">
                <button type="button" class="btn btn-default" id="return_add_favorite">返回</button>
                <button type="button" class="btn btn-primary">确认创建</button>
            </div>
        </div>
    </div>
</div>
<!-- end collection modal -->

<!-- report modal -->
<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">举报</h4>
            </div>
            <div class="modal-body">
                <div id="reportTree"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">举报</button>
            </div>
        </div>
    </div>
</div>
<!-- end report modal -->

<!-- back to top -->
<div class="custom-backtotop" id="back_to_top">
    <a class="custom-btn-action" href="javascript:;">
        <div class="custom-arrow"></div>
        <div class="custom-stick"></div>
    </a>
</div>
<!-- end back to top -->

<script type="text/javascript" src='<%=request.getContextPath()%>/resources/js/jquery-3.2.1.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/js/bootstrap.min.js'></script>
<script type="text/javascript" src='<%=request.getContextPath()%>/resources/plugin/webui-popover/jquery.webui-popover.min.js'></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugin/jquery-labelauty/jquery-labelauty.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/plugin/bootstrap-treeview/bootstrap-treeview.min.js"></script>

<script type="text/javascript">

    // back to top
    $(window).scroll(function (e) {
        //若滚动条离顶部大于100元素
        if($(window).scrollTop()>100)
            $("#back_to_top").fadeIn(1000); // 以1秒的间隔渐显id=back_to_top的元素
        else
            $("#back_to_top").fadeOut(1000); // 以1秒的间隔渐隐id=back_to_top的元素
    });
    //点击回到顶部的元素
    $("#back_to_top").click(function(e) {
        //以0.3秒的间隔返回顶部
        $('body,html').animate({scrollTop: 0}, 300);
    });

    // collapse item
    $(".custom-collapse-item").hide();
    $("#feed-item-1").hover(function () {
        console.log('show');
        $(".custom-collapse-item").show();
    }, function () {
        console.log('hide');
        $(".custom-collapse-item").hide();
    });
</script>
</body>
</html>
