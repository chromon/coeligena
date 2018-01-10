<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>xxx - 搜索结果 - ${siteInfoDO.siteName}</title>
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
                <li class="active"><a href="#content" data-toggle="tab">内容</a></li>
                <li><a href="#people" data-toggle="tab">用户</a></li>
                <li><a href="#topic" data-toggle="tab">话题</a></li>
            </ul>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="content">
                    <div class="custom-story-item custom-card">
                        <a href="#">
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
                <div class="tab-pane fade" id="people">
                    <div class="custom-story-item custom-card">
                        people
                    </div>
                </div>
                <div class="tab-pane fade" id="topic">
                    <div class="custom-story-item custom-card">
                        topic
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

    </div>
</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
