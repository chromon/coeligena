<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>邀请我回答的问题 - 编乎</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-paper.min.css" media="screen">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/custom.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css">
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
                            <button type="button" class="btn btn-primary btn-sm custom-ask-btn" data-toggle="modal" data-target="#askModal">提问</button>
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

            <ul class="nav nav-tabs custom-story-item custom-card">
                <li><a href="#recommend" data-toggle="tab">为你推荐</a></li>
                <li><a href="#hot" data-toggle="tab">全站热门</a></li>
                <li class="active"><a href="#invited" data-toggle="tab">邀请回答（25）</a></li>
            </ul>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade" id="recommend">
                    <div class="custom-story-item custom-card">
                        recommend
                    </div>
                </div>
                <div class="tab-pane fade" id="hot">
                    <div class="custom-story-item custom-card">
                        hot
                    </div>
                </div>
                <div class="tab-pane fade active in" id="invited">
                    <div class="custom-story-item custom-card">
                        <a href="#">
                            <h4 class="custom-media-heading">
                                什么是机器学习？
                            </h4>
                            <a href="" class="btn btn-default custom-right">忽略</a>
                        </a>
                        <div class="custom-meta-panel">
                                <span>
                                    <a href="#" class="custom-meta-item">Ellery</a> 邀请你回答
                                </span>
                            <span class="custom-bull">•</span>
                            <span>564个答案</span>
                            <span class="custom-bull">•</span>
                            <a href="#" class="custom-meta-item">
                                5265人关注
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- left main feed -->
            <ul class="media-list">
                <li class="media">
                    <!-- <a href="#" class="btn btn-default btn-md btn-block">加载更多</a> -->
                    <a href="#" class="btn btn-default btn-lg btn-block">
                        <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                    </a>
                </li>
            </ul><!-- end left main feed -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3">

            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge custom-badge">8</span>
                    <i class="fa fa-star"></i> 我的收藏
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-check-circle-o"></i> 我的关注
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge custom-badge">13</span>
                    <i class="fa fa-user-plus"></i> 我的邀请
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-home"></i> 社区服务中心
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-copyright"></i> 版权服务中心
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-pencil-square"></i> 公共编辑动态
                </a>
            </div>

            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-flash"></i> Live
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-book"></i> 书店
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-futbol-o"></i> 圆桌
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-pencil"></i> 专栏
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-btc"></i> 付费编辑
                </a>
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
                    <input id="collect_list" type="checkbox" data-labelauty="Don't delete my files|Delete my files"/>
                </div>
                <div id="create_favorite" class="hidden">
                    <form>
                        <input type="text" class="form-control custom-margin-bottom10" placeholder="收藏标题">
                        <textarea class="form-control custom-margin-bottom10" rows="3" placeholder="收藏描述（可选）"></textarea>
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
                <h4 class="modal-title">举报</h4>
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

<!-- ask modal -->
<div class="modal fade" id="askModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">提问</h4>
            </div>
            <div class="modal-body">
                <form class="form">
                    <div class="form-group">
                        <input class="form-control input-sm" type="text" id="inputSmall" placeholder="写下你的问题">
                    </div>
                    <div class="form-group">
                        <label for="textArea" class="control-label">问题说明（可选）：</label>
                        <textarea class="form-control input-sm" rows="4" id="textArea" placeholder="问题背景、条件等详细信息"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="textArea" class="control-label">选择话题</label>
                        <input class="form-control input-sm" type="text" placeholder="搜索话题">
                        <span class="help-block custom-right">话题越精准，越容易让相关领域专业人士看到你的问题</span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="checkbox custom-left">
                    <label>
                        <input type="checkbox"> 匿名
                    </label>
                </div>
                <button type="button" class="btn btn-primary">发布</button>
            </div>
        </div>
    </div>
</div>
<!-- end ask modal -->

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

    // the width of favorite
    $('#collect_list').labelauty({
        minimum_width: '270px'
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
