<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>问题日志 - 如何比较PixelCNN与DCGAN两种Image generation方法？- ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="./favicon.ico" type="image/x-icon">

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

            <!-- tag -->
            <div class="custom-feed-item custom-card">
                <div class="custom-margin-bottom20">
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                </div>
                <!-- question title -->
                <h2 class="custom-contentItem-title2">
                    <a href="/coeligena/question/123">
                        如何判断比较PixelCNN与DCGAN两种Image generation方法？
                    </a>
                </h2>
            </div>
            <!-- log details -->
            <div class="custom-card">
                <!-- log item -->
                <div class="custom-feed-item">
                    <a href="">Ellery</a> 编辑了问题
                    <!--
                    添加问题
                    添加话题
                    编辑了补充说明
                    移除话题 -->
                    <div class="custom-log-detail">
                        如何<del>判断</del><ins>比较</ins>PixelCNN与DCGAN两种Image generation方法？
                    </div>
                    <div>
                        修改理由：改进标点或格式
                    </div>
                    <div>
                        #682053542
                        <span> • </span>
                        <span>2017-07-03 14:42:38</span>
                    </div>
                </div><!-- end log item -->
            </div><!-- end log details -->
            <!-- more -->
            <div class="custom-card">
                <a href="javascript:void(0);" class="custom-question-more">
                    <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                </a>
            </div><!-- end more -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3 custom-sidebar-padding">
            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    关注问题
                </a>
                <span class="custom-padding-left5">2304 人关注该问题</span>
            </div>
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
