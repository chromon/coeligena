<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/8
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
            <!-- navbar left -->
            <ul class="nav navbar-nav custom-navbar">
                <li>
                    <a href="${pageContext.request.contextPath}/index">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/topic">话题</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/explore">发现</a>
                </li>
                <li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm" size="40" placeholder="搜索你感兴趣的内容...">
                            <span class="input-group-btn">
                                <button onclick="window.location.href='${pageContext.request.contextPath}/search?type=content&q=dddd'" class="btn btn-primary btn-sm" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                        </div>
                    </form>
                </li>
                <li>
                    <form class="navbar-form navbar-left" >
                        <div class="input-group">
                            <button type="button" class="btn btn-primary btn-sm custom-ask-btn" data-toggle="modal" data-target="#askModal">提问</button>
                        </div>
                    </form>
                </li>
            </ul><!-- end navbar left -->

            <!-- navbar right -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="custom-nav-icon" id="notification_bell" href="#">
                        <i class="fa fa-bell"></i>
                    </a>
                </li>
                <li>
                    <a class="custom-nav-icon" id="message_bar" href="#">
                        <i class="fa fa-comments"></i>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle custom-user-info" data-toggle="dropdown" role="button" aria-expanded="false">
                        <img class="custom-avatar30" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="${pageContext.request.contextPath}/people/123">
                                <i class="fa fa-user-o custom-menu-mright"></i> 我的主页
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/inbox">
                                <i class="fa fa-envelope-o custom-menu-mright"></i> 私信
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/setting">
                                <i class="fa fa-cog custom-menu-mright"></i> 设置
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="${pageContext.request.contextPath}/logout">
                                <i class="fa fa-power-off custom-menu-mright"></i> 退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- end navbar right -->
        </div>
    </div>
</div><!-- navbar -->

<!-- notification click card -->
<div class="media custom-display-none" id="notification_card">
    <ul class="nav nav-tabs">
        <li class="active custom-tab-width">
            <a href="#notification_default" data-toggle="tab">
                <i class="fa fa-list fa-lg" aria-hidden="true"></i>
            </a>
        </li>
        <li class="custom-tab-width">
            <a href="#follow" data-toggle="tab">
                <i class="fa fa-user fa-lg" aria-hidden="true"></i>
            </a>
        </li>
        <li class="custom-tab-width">
            <a href="#vote_thank" data-toggle="tab">
                <i class="fa fa-heart fa-lg" aria-hidden="true"></i>
            </a>
        </li>
    </ul>

    <div id="myTabContent" class="tab-content">
        <div class="tab-pane fade active in" id="notification_default">
            <div class="custom-notifications-list">
                <div class="custom-nushNotifications-item custom-nushNotifications-newItem">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item custom-nushNotifications-newItem">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
            </div>
            <div class="custom-notifications-footer">
                <a href="" class="custom-footer-item">
                    <i class="fa fa-cog"></i> 设置
                </a>
                <a href="${pageContext.request.contextPath}/notifications" class="custom-right custom-footer-item">
                    查看全部提醒
                </a>
            </div>
        </div>
        <div class="tab-pane fade" id="follow">
            hot
        </div>
        <div class="tab-pane fade" id="vote_thank">
            askdlf
        </div>
    </div>
</div>
<!-- end notification click card -->

<!-- private message click card -->
<div class="media custom-display-none" id="message_card">
    <ul class="nav nav-tabs">
        <li class="active custom-tab-width2">
            <a href="#private_message" data-toggle="tab" class="custom-tab-center">
                我的私信
            </a>
        </li>
    </ul>

    <div id="privateMessageTabContent" class="tab-content">
        <div class="tab-pane fade active in" id="private_message">
            <div class="custom-notifications-list">
                <div class="custom-nushNotifications-item custom-nushNotifications-newItem">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item custom-nushNotifications-newItem">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
                <div class="custom-nushNotifications-item">
                    <span>
                        <span><a href="">Ellery</a></span>
                        <span>回答了</span>
                        <span><a href="">alloric</a></span>
                    </span>
                </div>
            </div>
            <div class="custom-notifications-footer">
                <a href="" class="custom-footer-item">
                    <i class="fa fa-pencil"></i> 写新私信
                </a>
                <a href="${pageContext.request.contextPath}/inbox" class="custom-right custom-footer-item">
                    查看全部私信
                </a>
            </div>
        </div>
    </div>
</div>
<!-- end private message click card -->

<!-- modal -->
<%@include file="userModal.jsp"%>
<%@include file="collectionModal.jsp"%>
<%@include file="reportModal.jsp"%>
<%@include file="askModal.jsp"%>
<%@include file="emailModal.jsp"%>

<!-- back to top -->
<div class="custom-backtotop" id="back_to_top">
    <a class="custom-btn-action" href="">
        <div class="custom-arrow"></div>
        <div class="custom-stick"></div>
    </a>
</div><!-- end back to top -->
