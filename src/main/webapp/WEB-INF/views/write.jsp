<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>写文章 - ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络现编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body class="custom-article-bg">

<!-- navbar -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- navbar title -->
        <div class="navbar-header">
            <a href="${pageContext.request.contextPath}/index" class="navbar-brand custom-title">${siteInfoDO.siteName}</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div><!-- end navbar title -->
        <!-- navbar component auto collapse -->
        <div class="navbar-collapse collapse" id="navbar-main">
            <!-- navbar right -->
            <ul class="nav navbar-nav navbar-right custom-margin-right5">
                <li class="custom-user-info">
                    <button type="button" id="publish-btn" class="custom-btn btn-outline-primary">
                        发布
                        <i class="fa fa-angle-down" aria-hidden="true"></i>
                    </button>
                    <div id="publish-panel" class="custom-display-none">
                        publish column
                    </div>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle custom-column-info" data-toggle="dropdown" role="button" aria-expanded="false">
                        •••
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="">
                                草稿
                            </a>
                        </li>
                        <li>
                            <a href="">
                                我的文章
                            </a>
                        </li>
                        <li>
                            <a href="">
                                专栏 • 发现
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- end navbar right -->
        </div>
    </div>
</div><!-- end navbar -->

<!-- main content -->
<div class="container">
    <div class="row custom-content-margin">
        <div class="col-sm-10 col-sm-offset-1">
            <!-- write cover -->
            <div class="custom-margin-top30">
                <div class="custom-writeCover-wrapper">
                    <div class="custom-writeCover-previewWrapper">
                        <i class="fa fa-camera fa-2x" aria-hidden="true"></i>
                        <input type="file" class="custom-writeCover-uploadInput" name="upload_file" accept=".jpeg, .jpg, .png">
                    </div>
                </div>
                <div class="form-group custom-margin-top20">
                    <input class="form-control input-lg" type="text" placeholder="请输入标题">
                </div>
                <div class="form-group">
                    <textarea id="write_column" name="questionDetail"></textarea>
                </div>
            </div><!-- end write cover -->
        </div>
    </div>
</div>

<!-- modal -->
<%@include file="userModal.jsp"%>
<%@include file="collectionModal.jsp"%>
<%@include file="reportModal.jsp"%>

<!-- back to top -->
<div class="custom-backtotop" id="back_to_top">
    <a class="custom-btn-action" href="">
        <div class="custom-arrow"></div>
        <div class="custom-stick"></div>
    </a>
</div><!-- end back to top -->

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
