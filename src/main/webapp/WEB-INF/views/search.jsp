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
            <div class="custom-card">
                <div>
                    <div class="custom-search-actions">
                        <ul class="nav nav-tabs custom-feed-item" style="width: 70%;display: inline-block;">
                            <li class="active"><a href="#content" data-toggle="tab">综合</a></li>
                            <li><a href="#people" data-toggle="tab">用户</a></li>
                            <li><a href="#topic" data-toggle="tab">话题</a></li>
                            <li><a href="#column" data-toggle="tab">专栏</a></li>
                        </ul>

                        <button class="custom-btn-plain Select-plainButton Select-button custom-right" type="button">
                            <span style="display: inline-flex;align-items: center;">
                                <span class="custom-margin-right5">时间不限</span>
                                <i class="fa fa-sort" aria-hidden="true"></i>
                            </span>
                        </button>
                    </div>
                </div>
            </div>

            <div class="custom-card">
                <!-- list item -->
                <div class="custom-list-item">
                    <!-- content item main -->
                    <div class="custom-contentItem-main">
                        <!-- content item image -->
                        <div class="custom-contentItem-image">
                            <!-- avatar image -->
                            <a href="#">
                                <img class="media-object custom-avatar60" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                            </a>
                        </div><!-- end content item image -->
                        <div class="custom-contentItem-head">
                            <h2 class="custom-contentItem-title">
                                <a href="">Java 虚拟机（JVM）</a>
                                <span class="custom-searchItem-type">
                                    话题
                                </span>
                            </h2>
                            <div class="custom-contentItem-meta">
                                <div class="custom-searchItem-meta">
                                    Java 虚拟机（Java Virtual Machine）是一个虚构出来的计算机，通过在实际的计算机上仿真模拟各种计算机功能来实现的。
                                </div>
                                <div class="custom-contentItem-status">
                                    <a href="" class="custom-searchItem-statusLink">20528关注</a> ·
                                    <a href="" class="custom-searchItem-statusLink">1283问题</a> ·
                                    <a href="" class="custom-searchItem-statusLink">999精华内容</a>
                                </div>
                                <div class="custom-search-more">
                                    <a href="">
                                        查看更多「话题」搜索结果
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="custom-contentItem-extra">
                            <button class="btn btn-primary" type="button">关注话题</button>
                        </div>
                    </div><!-- end content item main -->
                </div><!-- end list item -->
                <!-- list item -->
                <div class="custom-list-item">
                    <!-- content item main -->
                    <div class="custom-contentItem-main">
                        <!-- content item image -->
                        <div class="custom-contentItem-image">
                            <!-- avatar image -->
                            <a href="#">
                                <img class="media-object custom-avatar60" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                            </a>
                        </div><!-- end content item image -->
                        <div class="custom-contentItem-head">
                            <h2 class="custom-contentItem-title">
                                <a href="">JVM 进阶之路</a>
                                <span class="custom-searchItem-type">
                                    专栏
                                </span>
                            </h2>
                            <div class="custom-contentItem-meta">
                                <div class="custom-contentItem-status">
                                    创建者：<a href="" class="custom-searchItem-statusLink">Ellery</a> ·
                                    <a href="" class="custom-searchItem-statusLink">1283关注</a> ·
                                    <a href="" class="custom-searchItem-statusLink">999文章</a>
                                </div>
                                <div class="custom-search-more">
                                    <a href="">
                                        查看更多「专栏」搜索结果
                                        <i class="fa fa-angle-right"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="custom-contentItem-extra">
                            <button class="btn btn-primary" type="button">关注专栏</button>
                        </div>
                    </div><!-- end content item main -->
                </div><!-- end list item -->
            </div>

            <div class="custom-card">
                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade active in" id="content">
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
                                <div class="custom-feed-src-info custom-feed-author-info">
                                    <div class="custom-author-info-content" style="margin-left: 0px;">
                                        <div class="custom-author-info-head">
                                            <a href="#">Ellery</a>
                                        </div>
                                        <div class="custom-author-info-detail">
                                            <div class="custom-author-badge">
                                                <div class="custom-author-badge-text">
                                                    Microsoft Cortana Engineer Oracle Kernel Engineer.
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
                                                    <i class="fa fa-caret-up"></i> 651
                                                </button>
                                                <button class="custom-vote-btn" aria-label="反对" type="button">
                                                    <i class="fa fa-caret-down"></i>
                                                </button>
                                            </span>
                                                <button class="custom-contentItem-action custom-btn-plain" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-comment custom-margin-right5"></i>
                                                    8 条评论
                                                </span>
                                                </button>
                                            </div>
                                        </div>
                                    </div><!-- end feed content -->
                                </div><!-- feed detail -->
                            </div><!-- end feed -->
                        </div><!-- end feed item -->
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
                    <div class="tab-pane fade" id="column">
                        <div class="custom-story-item custom-card">
                            topic
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- sidebar -->
        <div class="col-sm-3 custom-sidebar-padding">
            <!-- hot collect -->
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">${siteInfoDO.siteName}热搜</div>
                </div>
                <div class="custom-topSearch-items">
                    <div class="custom-topSearch-item">
                        <a href="" class="custom-topSearch-itemLink">机器学习</a>
                    </div>
                    <div class="custom-topSearch-item">
                        <a href="" class="custom-topSearch-itemLink">机器学习</a>
                    </div>
                    <div class="custom-topSearch-item">
                        <a href="" class="custom-topSearch-itemLink">机器学习</a>
                    </div>
                    <div class="custom-topSearch-item">
                        <a href="" class="custom-topSearch-itemLink">机器学习</a>
                    </div>
                    <div class="custom-topSearch-item">
                        <a href="" class="custom-topSearch-itemLink">机器学习</a>
                    </div>
                </div>
            </div><!-- end hot collect -->
            <!-- sidebar footer -->
            <div class="custom-footer">
                <a href="#" target="_blank">${siteInfoDO.siteName}指南 • </a>
                <a href="#" target="_blank">${siteInfoDO.siteName}协议 • </a>
                <a href="#" target="_blank">隐私政策 • </a>
                <a href="#" target="_blank">移动应用 • </a>
                <a href="#" target="_blank">工作 • </a>
                <a href="#" target="_blank">申请开通${siteInfoDO.siteName}机构账号</a><br/>
                <a href="#" target="_blank">侵权举报 • </a>
                <a href="#" target="_blank">网上有害信息举报专区</a><br/>
                <a href="#" target="_blank">儿童色情信息举报专区</a><br/>
                <a href="#" target="_blank">联系我们</a>
                <a href="#" target="_blank">&copy;${siteInfoDO.copyRight}</a>
            </div><!-- end sidebar footer -->
        </div><!-- end sidebar -->
    </div>
</div>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
