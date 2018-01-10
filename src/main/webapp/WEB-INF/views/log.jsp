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
            <div class="custom-story-item custom-card">
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

                <!-- question title -->
                <div class="custom-question-title">
                    如何判断比较PixelCNN与DCGAN两种Image generation方法？
                </div>
            </div>

            <div class="custom-story-item custom-card">
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
            </div>

            <!-- left main feed -->
            <ul class="media-list">
                <li class="media">
                    <!-- <a href="#" class="btn btn-default btn-md btn-block">加载更多</a> -->
                    <a href="#" class="btn btn-default btn-lg btn-block">
                        <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                    </a>
                </li>
            </ul><!-- end left main feed -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3">

            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="#" class="list-group-item custom-group-item">
                    关注问题
                </a>
                <span class="custom-padding-left5">2304人关注该问题</span>
            </div>

            <div class="list-group custom-story-item custom-card">
                <div class="custom-list-group-title custom-color-9f">
                    收藏夹状态
                </div>
                <div class="custom-color-9f">
                    最近活动于 10:49 • <a href=""> 查看问题日志 </a>，被浏览 167107 次，相关话题关注者 319071 人
                </div>
            </div>

            <div class="custom-footer">
                <a href="#" target="_blank">${siteInfoDO.siteName}指南 • </a>
                <a href="#" target="_blank">建议反馈 • </a>
                <a href="#" target="_blank">移动应用 • </a>
                <a href="#" target="_blank">加入${siteInfoDO.siteName}</a>
                <a href="#" target="_blank">${siteInfoDO.siteName}协议 • </a>
                <a href="#" target="_blank">举报投诉 • </a>
                <a href="#" target="_blank">联系我们</a><br/>
                <a href="#" target="_blank">&copy;${siteInfoDO.copyRight}</a>
            </div>
        </div><!-- end sidebar -->
    </div>
</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
