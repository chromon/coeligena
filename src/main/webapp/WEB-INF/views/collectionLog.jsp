<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>机器学习 - 收藏夹日志 - 编乎</title>
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

            <div class="custom-story-item custom-card">
                <a href="#">
                    <h4 class="custom-media-heading">
                        机器学习
                    </h4>
                </a>
            </div>

            <div class="custom-story-item custom-card">
                <a href="">Ellery</a> 收藏了答案

                <div class="custom-log-detail">
                    <a href="">如何比较PixelCNN与DCGAN两种Image generation方法？</a>
                </div>

                #682053542
                <span> • </span>
                <span>2017-07-03 14:42:38</span>
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
                    取消关注
                </a>
            </div>

            <div class="list-group custom-story-item custom-card">
                <div class="custom-list-group-title custom-color-9f">
                    关于创建者
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
                                    <i class="fa fa-plus custom-topic-item"></i> 关注TA
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="list-group custom-story-item custom-card">
                <div class="custom-list-group-title custom-color-9f">
                    收藏夹状态
                </div>
                <div class="custom-color-9f">
                    最近活动于
                    <a href=""> 10:49 </a> • 查看收藏夹日志 <a href=""> 1991 </a> 人关注了该收藏夹
                </div>
            </div>

            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    举报收藏夹
                </a>
            </div>

            <div class="list-group custom-list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <div class="custom-list-title custom-color-9f">
                    热门收藏
                    <span class="custom-right">
                            <a href="#" class="custom-item-link">
                                换一换 <i class="fa fa-angle-double-right"></i>
                            </a>
                        </span>
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
