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
    <title>我的收藏 - ${siteInfoDO.siteName}</title>
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
                <ul class="nav nav-tabs custom-story-item">
                    <li class="active"><a href="#followedCollections" data-toggle="tab">我关注的收藏夹</a></li>
                    <li><a href="#myCollections" data-toggle="tab">我创建的收藏夹</a></li>
                </ul>

                <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade active in" id="followedCollections">
                        <!-- collections list -->
                        <div class="custom-feed-item">
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
                        </div><!-- end collections list -->
                    </div>
                    <div class="tab-pane fade" id="myCollections">
                        <!-- my collections list -->
                        <div class="custom-feed-item">
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
                        </div><!-- end my collections list -->
                    </div>
                </div>
            </div>
            <div class="custom-card">
                <a href="javascript:void(0);" class="custom-question-more">
                    <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                </a>
            </div>
        </div>

        <!-- sidebar -->
        <%@include file="sidebar.jsp"%>
    </div>
</div>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
