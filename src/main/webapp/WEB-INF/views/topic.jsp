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
                                <a class="custom-item-vote-count js-expand js-vote-count" href="">100</a>
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

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
