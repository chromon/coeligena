<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>我关注的问题 - ${siteInfoDO.siteName}</title>
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

            <div class="custom-card">
                <!-- following header -->
                <div class="custom-list-header">
                    <h6 class="custom-list-headerText">我关注的问题</h6>
                </div><!-- end following header -->
                <!-- question item -->
                <div class="custom-feed-item">
                    <a href="#">
                        <h4 class="custom-media-heading">
                            什么是机器学习？
                        </h4>
                    </a>
                    <div class="custom-meta-panel">
                        <span>2018-05-08</span>
                        <span class="custom-bull">•</span>
                        <span>564个答案</span>
                        <span class="custom-bull">•</span>
                        <a href="#" class="custom-meta-item">
                            5265人关注
                        </a>
                    </div>
                </div><!-- end question item -->
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
