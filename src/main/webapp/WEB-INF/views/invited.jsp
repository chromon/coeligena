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
        <%@include file="sidebar.jsp"%>
    </div>
</div>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
