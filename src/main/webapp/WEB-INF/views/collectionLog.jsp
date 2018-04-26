<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>机器学习 - 收藏夹日志 - ${siteInfoDO.siteName}</title>
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

            <div class="custom-story-item custom-card">
                <a href="#">
                    <h4 class="custom-media-heading">
                        机器学习
                    </h4>
                </a>
            </div>

            <div class="custom-story-item custom-card">
                <a href="">Ellery</a> 收藏了答案

                <div class="custom-log-detail">
                    <a href="">如何比较PixelCNN与DCGAN两种Image generation方法？</a>
                </div>

                #682053542
                <span> • </span>
                <span>2017-07-03 14:42:38</span>
            </div>
            <div class="custom-card">
                <a href="javascript:void(0);" class="custom-question-more">
                    <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                </a>
            </div>
        </div>

        <!-- sidebar -->
        <div class="col-sm-3 custom-sidebar-padding">
            <div class="list-group custom-feed-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    取消关注
                </a>
            </div>
            <!-- creator info -->
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">关于创建者</div>
                </div>
                <div class="custom-card-section">
                    <div class="custom-answer-author">
                        <div class="custom-answer-author-avatar">
                            <a href="#">
                                <img class="custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                            </a>
                        </div>
                        <div class="custom-answer-author-content">
                            <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                            <div class="custom-answer-author-headline">724473人关注</div>
                        </div>
                    </div>
                </div>
            </div><!-- end creator info -->
            <!-- collection info -->
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">收藏夹状态</div>
                </div>
                <div class="custom-card-section">
                    <div class="custom-color-9f custom-font-size14">
                        最近活动于
                        <a href=""> 10:49 </a> •
                        <a href="${pageContext.request.contextPath}/collection/123/log">查看收藏夹日志</a>
                        <a href=""> 1991 </a> 人关注了该收藏夹
                    </div>
                </div>
            </div><!-- end collection info -->
            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    举报收藏夹
                </a>
            </div>
            <!-- hot collect -->
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">热门收藏</div>
                    <span class="custom-right">
                        <a href="#" class="custom-item-link">
                            换一换 <i class="fa fa-angle-double-right"></i>
                        </a>
                    </span>
                </div>
                <div class="custom-card-section">
                    <div class="custom-answer-author">
                        <div class="custom-answer-author-content">
                            <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                            <div class="custom-answer-author-headline">724473人关注 • 123条内容</div>
                        </div>
                    </div>
                </div>
                <div class="custom-card-section">
                    <div class="custom-answer-author">
                        <div class="custom-answer-author-content">
                            <div class="custom-answer-author-name custom-font-size15">励学自行</div>
                            <div class="custom-answer-author-headline">3473人关注 • 123条内容</div>
                        </div>
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

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
