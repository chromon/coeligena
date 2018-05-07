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
