<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/22
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>消息 - ${siteInfoDO.siteName}</title>
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
            <div class="custom-top-header custom-card">
                全部消息
            </div>
            <div class="custom-card custom-feed-item">
                <h5>2018-04-22</h5>
                <div class="custom-notifications-items">
                    <div class="custom-notification-item">
                        <span>
                            <a href="">Ellery</a>
                            回答了
                            <a href="">alloric</a>
                        </span>
                    </div>
                    <div class="custom-notification-item">
                        <span>
                            <a href="">Ellery</a>
                            在
                            <a href="">alloric</a>
                            发布了
                            <a href="">alloric</a>
                        </span>
                    </div>
                    <div class="custom-notification-item">
                        <span>
                            <a href="">Ellery</a>
                            回答了
                            <a href="">alloric</a>
                        </span>
                    </div>
                    <div class="custom-notification-item">
                        <span>
                            <a href="">Ellery</a>
                            在
                            <a href="">alloric</a>
                            发布了
                            <a href="">alloric</a>
                        </span>
                    </div>
                    <div class="custom-notification-item">
                        <span>
                            <a href="">Ellery</a>
                            回答了
                            <a href="">alloric</a>
                        </span>
                    </div>
                    <div class="custom-notification-item">
                        <span>
                            <a href="">Ellery</a>
                            在
                            <a href="">alloric</a>
                            发布了
                            <a href="">alloric</a>
                        </span>
                    </div>
                    <div class="custom-notification-more">
                        <a href="">查看全部6个回答…</a>
                    </div>
                </div>
            </div>
            <!-- more -->
            <div class="custom-card">
                <a href="javascript:void(0);" class="custom-question-more">
                    <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                </a>
            </div><!-- end more -->
        </div>

        <!-- sidebar -->
        <%@include file="sidebar.jsp"%>
    </div>
</div>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
