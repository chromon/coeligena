<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>我的收藏 - 编乎</title>
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

            <ul class="nav nav-tabs custom-story-item custom-card">
                <li class="active"><a href="#followedCollections" data-toggle="tab">我关注的收藏夹</a></li>
                <li><a href="#myCollections" data-toggle="tab">我创建的收藏夹</a></li>
            </ul>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="followedCollections">
                    <div class="custom-story-item custom-card">
                        <a href="${pageContext.request.contextPath}/collection/123">
                            <h4 class="custom-media-heading">
                                机器学习
                                <span class="badge custom-badge">123 new</span>
                            </h4>
                        </a>
                        <div class="custom-meta-panel">
                                <span>
                                由 <a href="#" class="custom-meta-item">Ellery</a> 创建
                                </span>
                            <span class="custom-bull">•</span>
                            <span>564条内容</span>
                            <span class="custom-bull">•</span>
                            <a href="#" class="custom-meta-item">
                                5265人关注
                            </a>
                            <span class="custom-bull">•</span>
                            <a href="#" class="custom-meta-item">
                                取消关注
                            </a>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="myCollections">
                    <div class="custom-story-item custom-card">
                        <a href="#">
                            <h4 class="custom-media-heading">
                                tech
                            </h4>
                        </a>
                        <div class="custom-meta-panel">
                            <span>564条内容</span>
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

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
