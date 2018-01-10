<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>发现 - ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body>

<!-- navbar -->
<%@include file="navbar.jsp"%>

<!-- main content -->
<div class="container">
    <div class="row custom-content-margin">
        <div class="col-sm-9">
            <!-- media list title -->
            <div class="custom-list-title custom-story-item custom-card">
                <i class="fa fa-list-ul"></i> 编辑推荐
                <span class="custom-cleaner-setting custom-right">
                        <a href="#">
                            更多推荐 <i class="fa fa-angle-double-right"></i>
                        </a>
                    </span>
            </div>

            <!-- left main feed -->
            <ul class="media-list">
                <li class="media custom-story-item custom-card">
                    <div class="media-left media-top">

                        <!-- avatar image -->
                        <a href="#" id="user-avatar">
                            <img class="media-object custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                        </a>
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

                    </div>
                </li>
                <li class="media custom-story-item custom-card">
                    <!-- question title -->
                    <a href="#">
                            <span class="custom-media-heading">
                                当你迷茫的时候，你应该做些什么？
                            </span>
                    </a>
                    <span class="custom-right">问答</span>
                </li>
                <li class="media custom-story-item custom-card">
                    <!-- question title -->
                    <a href="#">
                            <span class="custom-media-heading">
                                当你迷茫的时候，你应该做些什么？
                            </span>
                    </a>
                    <span class="custom-right">问答</span>
                </li>
                <li class="media custom-story-item custom-card">
                    <!-- question title -->
                    <a href="#">
                            <span class="custom-media-heading">
                                当你迷茫的时候，你应该做些什么？
                            </span>
                    </a>
                    <span class="custom-right">问答</span>
                </li>
                <li class="media custom-story-item custom-card">
                    <!-- question title -->
                    <a href="#">
                            <span class="custom-media-heading">
                                当你迷茫的时候，你应该做些什么？
                            </span>
                    </a>
                    <span class="custom-right">问答</span>
                </li>
                <li class="media custom-story-item custom-card">
                    <!-- question title -->
                    <a href="#">
                            <span class="custom-media-heading">
                                当你迷茫的时候，你应该做些什么？
                            </span>
                    </a>
                    <span class="custom-right">问答</span>
                </li>

            </ul><!-- end left main feed -->

            <ul class="nav nav-tabs">
                <li class="active"><a href="#daily_hot" data-toggle="tab">今日最热</a></li>
                <li><a href="#monthly_hot" data-toggle="tab">本月最热</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">

                <!--  daily hot tab -->
                <div class="tab-pane fade active in" id="daily_hot">
                    <ul class="media-list">
                        <li id="feed-item-1" class="media custom-story-item custom-card">
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
                <!-- daily hot tab -->

                <div class="tab-pane fade" id="monthly_hot">
                    <p>monthly_hot</p>
                </div>
            </div>
        </div>

        <!-- sidebar -->
        <div class="col-sm-3">

            <div class="list-group custom-story-item custom-card">
                <div class="custom-list-group-title custom-color-9f">
                    热门话题
                    <span class="custom-right">
                            <a href="#" class="custom-item-link">
                                更多话题 <i class="fa fa-angle-double-right"></i>
                            </a>
                        </span>
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
                            <div class="custom-item-link">
                                2837 人关注
                            </div>
                        </a>
                    </div>
                </div>
            </div>

            <div class="list-group custom-list-group custom-story-item custom-card">

                <div class="custom-list-group-title custom-color-9f">
                    热门收藏
                    <span class="custom-right">
                            <a href="#" class="custom-item-link">
                                换一换 <i class="fa fa-angle-double-right"></i>
                            </a>
                        </span>
                </div>

                <div class="custom-hot-collect custom-bottom-border">
                    <a href="" class="custom-meta-item custom-meta-link">我的收藏</a>
                    <div class="custom-item-link">
                        <span>32 人关注</span>
                        <span> • </span>
                        <span>37 条内容</span>
                    </div>
                </div>

                <div class="custom-hot-collect">
                    <a href="" class="custom-meta-item custom-meta-link">我的收藏</a>
                    <div class="custom-item-link">
                        <span>32 人关注</span>
                        <span> • </span>
                        <span>37 条内容</span>
                    </div>
                </div>
            </div>

            <div class="custom-footer">
                <a href="#" target="_blank">${siteInfoDO.siteName}指南 • </a>
                <a href="#" target="_blank">建议反馈 • </a>
                <a href="#" target="_blank">移动应用 • </a>
                <a href="#" target="_blank">加入${siteInfoDO.siteName}</a>
                <a href="#" target="_blank">${siteInfoDO.siteName}协议 • </a>
                <a href="#" target="_blank">举报投诉 • </a>
                <a href="#" target="_blank">联系我们</a><br/>
                <a href="#" target="_blank">&copy;${siteInfoDO.copyRight}</a>
            </div>
        </div><!-- end sidebar -->
    </div>
</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
