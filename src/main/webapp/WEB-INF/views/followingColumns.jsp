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
    <title>关注的专栏 - ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络现编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body>

<!-- navbar -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- navbar title -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand custom-title">${siteInfoDO.siteName}</a>
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
                    <button type="button" class="custom-btn btn-outline-primary">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        写文章
                    </button>
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
            <!-- following columns -->
            <div class="custom-card">
                <!-- column list item -->
                <div class="custom-feed-item">
                    <div class="custom-contentItem-main">
                        <div class="custom-contentItem-image">
                            <a href="">
                                <img class="custom-avatar60" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                            </a>
                        </div>
                        <div class="custom-contentItem-head">
                            <h2 class="custom-contentItem-title">
                                <a href="${pageContext.request.contextPath}/column/123">
                                    机器学习算法与自然语言处理
                                </a>
                            </h2>
                            <div class="custom-contentItem-meta">
                                <div class="custom-columnItem-meta">
                                    拨开知识的层层密林，探寻美妙算法中的趣味.
                                    <div class="custom-contentItem-status">
                                        <span>共 196 篇文章</span>
                                        <span> • </span>
                                        <span>2635 人关注</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- end column list item -->
                <!-- comment pagination -->
                <div class="custom-pagination">
                    <button class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">上一页</button>
                    <button class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">1</button>
                    <button class="custom-pagination-btn custom-btn-plain" type="button">2</button>
                    <button class="custom-pagination-btn custom-btn-plain" type="button">3</button>
                    <button class="custom-pagination-btn custom-btn-plain" type="button">4</button>
                    <span class="custom-pagination-btn">•••</span>
                    <button class="custom-pagination-btn custom-btn-plain" type="button">12</button>
                    <button class="custom-pagination-btn custom-btn-plain" type="button">下一页</button>
                </div><!-- end comment pagination -->
            </div><!-- end following columns -->
        </div>
    </div>
</div>

<!-- modal -->
<%@include file="userModal.jsp"%>

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
