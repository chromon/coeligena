<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>邀请我回答的问题 - ${siteInfoDO.siteName}</title>
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
                <!-- tab title -->
                <ul class="nav nav-tabs custom-feed-item">
                    <li><a href="#recommend" data-toggle="tab">为你推荐</a></li>
                    <li><a href="#hot" data-toggle="tab">全站热门</a></li>
                    <li class="active"><a href="#invited" data-toggle="tab">邀请回答（25）</a></li>
                </ul><!-- end tab title -->
                <div id="myTabContent" class="tab-content">
                    <!-- recommend tab -->
                    <div class="tab-pane fade" id="recommend">
                        <div class="custom-feed-item">
                            recommend
                        </div>
                    </div><!-- end recommend tab -->
                    <!-- hot tab -->
                    <div class="tab-pane fade" id="hot">
                        <div class="custom-feed-item">
                            hot
                        </div>
                    </div><!-- end hot tab -->
                    <!-- invited tab -->
                    <div class="tab-pane fade active in" id="invited">
                        <!-- tab list header -->
                        <div class="custom-list-header">
                            <h6 class="custom-list-headerText">邀请我回答的问题</h6>
                            <div class="custom-list-headerOptions">
                                <span class="custom-switcher custom-right">
                                    <a href="" class="custom-current">所有人 (39)</a> |
                                    <a href=""> 我关注的人 (0)</a>
                                </span>
                            </div>
                        </div><!-- end tab list header -->
                        <div class="custom-feed-item">
                            <a href="#">
                                <h4 class="custom-media-heading">
                                    什么是机器学习？
                                </h4>
                                <a href="" class="btn btn-default custom-right">忽略</a>
                            </a>
                            <div class="custom-meta-panel">
                                <span>
                                    <a href="#" class="custom-meta-item">Ellery</a> 邀请你回答
                                </span>
                                <span class="custom-bull">•</span>
                                <span>564个答案</span>
                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    5265人关注
                                </a>
                            </div>
                        </div>
                    </div><!-- end invited tab -->
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
        <div id="rightSidebar" class="col-sm-3 custom-sidebar-padding">
            <div class="sidebar_inner">
                <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                    <a href="${pageContext.request.contextPath}/collections" class="list-group-item custom-group-item">
                        <span class="badge custom-badge">8</span>
                        <i class="fa fa-star"></i> 我的收藏
                    </a>
                    <a href="${pageContext.request.contextPath}/people/123/following/questions" class="list-group-item custom-group-item">
                        <i class="fa fa-check-circle-o"></i> 我的关注
                    </a>
                    <a href="${pageContext.request.contextPath}/question/invited" class="list-group-item custom-group-item">
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
            </div>
        </div><!-- end sidebar -->
    </div>
</div>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
