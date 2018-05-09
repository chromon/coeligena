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
    <title>机器学习算法与自然语言处理 - ${siteInfoDO.siteName}</title>
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
            <!-- column header -->
            <div class="custom-card custom-question-headers">
                <div class="custom-question-header-content">
                    <!-- column header main -->
                    <div class="custom-question-header-main">
                        <h1 class="custom-question-header-title">
                            机器学习算法与自然语言处理
                        </h1>
                        <p style="margin-bottom: 0;">机器学习算法与自然语言处理</p>
                        <div>
                            <a href="#" class="custom-meta-item">
                                Ellery
                            </a>
                            <span class="custom-bull">•</span>
                            <a href="#" class="custom-meta-item">
                                关于专栏
                            </a>
                            <span class="custom-bull">•</span>
                            <a href="#" class="custom-meta-item">
                                1247 人关注
                            </a>
                        </div>
                    </div><!-- end column header main -->
                    <!-- column header side -->
                    <div class="custom-question-header-side">
                        <!-- avatar image -->
                        <a href="#" class="custom-right">
                            <img class="custom-avatar94" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                        </a>
                    </div><!-- column header side -->
                </div>
                <!-- column header footer -->
                <div class="custom-question-header-footer">
                    <div class="custom-question-header-footer-inner">
                        <div class="custom-question-header-main custom-question-header-footer-main">
                            <div class="custom-question-btn-group">
                                <a href="#" class="btn btn-primary custom-margin-right10">
                                    关注专栏
                                </a>
                                <a href="javascript: void(0);" class="btn btn-default custom-margin-right10">
                                   投稿
                                </a>
                            </div>
                        </div>
                    </div>
                </div><!-- column header content footer -->
            </div><!-- end column header -->
        </div>
    </div>

    <!-- answer main -->
    <div class="row">
        <div class="col-sm-10 col-sm-offset-1">
            <!-- sticky column -->
            <div class="custom-card">
                <!-- column list header -->
                <div class="custom-list-header">
                    <span class="custom-column-sectionTitle">
                        置顶文章
                    </span>
                </div><!-- end column list header -->
                <!-- feed item -->
                <div class="custom-feed-item">
                    <!-- feed -->
                    <div>
                        <h2 class="custom-contentItem-title2">
                            <a href="${pageContext.request.contextPath}/question/123">
                                JVM符号引用转换直接引用的过程?
                            </a>
                        </h2>
                        <!-- feed author info -->
                        <div class="custom-feed-author-info">
                            <!-- avatar image -->
                            <a href="#">
                                <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                            </a>
                            <div class="custom-author-info-content">
                                <div class="custom-author-info-head">
                                    <a href="#">Ellery</a>
                                </div>
                                <div class="custom-author-info-detail">
                                    <div class="custom-author-badge">
                                        <div class="custom-author-badge-text">
                                           1 个月前
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- end feed author info -->
                        <!-- feed detail -->
                        <div>
                            <!-- feed content -->
                            <div class="custom-rich-content">
                                <div class="custom-rich-content-inner">
                                    符号引用是只包含语义信息，而解析（resolve）过后的直接引用则是与具体实现息息相关的。
                                    所以当谈及某个符号引用被resolve成怎样的直接引用时，必须要结合某个具体实现来讨论才行。
                                    <button class="custom-contentItem-more custom-btn-plain" type="button">
                                        <span class="custom-margin-right5">阅读全文</span>
                                        <i class="fa fa-chevron-down"></i>
                                    </button>
                                </div>
                                <div>
                                    <div class="custom-contentItem-actions">
                                        <span>
                                            <button class="custom-vote-btn" aria-label="赞同" type="button">
                                                <i class="fa fa-thumbs-up"></i> 651
                                            </button>
                                        </span>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                8 条评论
                                            </span>
                                        </button>
                                        <div class="custom-drop-option2">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                <i class="fa fa-paper-plane"></i> 分享
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">复制链接</a></li>
                                                <li><a href="#">新浪微博</a></li>
                                                <li><a href="#">扫一扫</a></li>
                                            </ul>
                                        </div>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-star custom-margin-right5"></i>
                                                收藏
                                            </span>
                                        </button>
                                        <div class="custom-drop-option2">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                •••
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">举报</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- end feed content -->
                        </div><!-- feed detail -->
                    </div><!-- end feed -->
                </div><!-- end feed item -->
            </div><!-- end sticky column-->
            <!-- newest column -->
            <div class="custom-card">
                <!-- column list header -->
                <div class="custom-list-header">
                    <span class="custom-column-sectionTitle">
                        最新文章
                    </span>
                </div><!-- end column list header -->
                <!-- feed item -->
                <div class="custom-feed-item">
                    <!-- feed -->
                    <div>
                        <h2 class="custom-contentItem-title2">
                            <a href="${pageContext.request.contextPath}/question/123">
                                JVM符号引用转换直接引用的过程?
                            </a>
                        </h2>
                        <!-- feed author info -->
                        <div class="custom-feed-author-info">
                            <!-- avatar image -->
                            <a href="#">
                                <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                            </a>
                            <div class="custom-author-info-content">
                                <div class="custom-author-info-head">
                                    <a href="#">Ellery</a>
                                </div>
                                <div class="custom-author-info-detail">
                                    <div class="custom-author-badge">
                                        <div class="custom-author-badge-text">
                                            1 个月前
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- end feed author info -->
                        <!-- feed detail -->
                        <div>
                            <!-- feed content -->
                            <div class="custom-rich-content">
                                <div class="custom-rich-content-inner">
                                    符号引用是只包含语义信息，而解析（resolve）过后的直接引用则是与具体实现息息相关的。
                                    所以当谈及某个符号引用被resolve成怎样的直接引用时，必须要结合某个具体实现来讨论才行。
                                    <button class="custom-contentItem-more custom-btn-plain" type="button">
                                        <span class="custom-margin-right5">阅读全文</span>
                                        <i class="fa fa-chevron-down"></i>
                                    </button>
                                </div>
                                <div>
                                    <div class="custom-contentItem-actions">
                                        <span>
                                            <button class="custom-vote-btn" aria-label="赞同" type="button">
                                                <i class="fa fa-thumbs-up"></i> 651
                                            </button>
                                        </span>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                8 条评论
                                            </span>
                                        </button>
                                        <div class="custom-drop-option2">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                <i class="fa fa-paper-plane"></i> 分享
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">复制链接</a></li>
                                                <li><a href="#">新浪微博</a></li>
                                                <li><a href="#">扫一扫</a></li>
                                            </ul>
                                        </div>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-star custom-margin-right5"></i>
                                                收藏
                                            </span>
                                        </button>
                                        <div class="custom-drop-option2">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                •••
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">举报</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div><!-- end feed content -->
                        </div><!-- feed detail -->
                    </div><!-- end feed -->
                </div><!-- end feed item -->
            </div><!-- end newest column -->
        </div>
    </div>
    <!-- end answer main -->
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
