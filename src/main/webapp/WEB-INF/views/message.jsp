<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>私信 - 编乎</title>
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
        <div class="col-sm-8">
            <!-- media list title -->
            <div class="custom-list-title custom-story-item custom-card">
                <a href=""><i class="fa fa-arrow-left" aria-hidden="true"></i> 返回</a>
                <div>
                    <span class="custom-grey">发私信给</span>
                    <span class="custom-darker">编乎团队：</span>
                </div>
                <form class="form-horizontal">
                    <textarea class="form-control" rows="3" id="textArea"></textarea>
                </form>
                <div class="custom-msg-btn">
                    <a href="#" class="btn btn-primary btn-sm">
                        发送
                    </a>
                </div>
            </div>

            <!-- left main feed -->
            <ul class="media-list">
                <li id="feed-item-1" class="media custom-story-item custom-card">
                    <div class="media-left media-top">

                        <!-- avatar image -->
                        <a href="#" id="user-avatar">
                            <img class="media-object custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                        </a>
                    </div>
                    <div class="media-body">

                        <!-- author info -->
                        <div class="custom-name">
                            <a href="#" class="">Ellery</a>：
                        </div>

                        <!-- answer content -->
                        <div>Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，P. Cousot & R. Cousot 1977
                            Automatic discovery of linear restraints among variables of a program，P. Cousot & N. Halbwachs 1978
                            Systematic design of program analysis frameworks， P. Cousot & R. Cousot 1979
                        </div>
                        <!-- feed meta -->
                        <div class="custom-meta-panel">
                            <a href="#" class="custom-meta-item">
                                6月13日 21:18
                            </a>
                            <span class="custom-right">
                                <a href="#" class="custom-meta-item">
                                    回复
                                </a>

                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    删除
                                </a>
                            </span>
                        </div>

                    </div>
                </li>

            </ul><!-- end left main feed -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3 col-sm-offset-1">

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

<script type="text/javascript">
    // user info hover card
    $('#user-avatar').webuiPopover({
        url: '#user_info',
        placement:'auto',
        width: '360',
        trigger:'hover',
        animation:'pop'
    });

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
</script>
</body>
</html>
