<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>私信 - ${siteInfoDO.siteName}</title>
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
            <!-- media list title -->
            <div class="custom-list-title custom-story-item custom-card custom-color-9f">
                <i class="fa fa-list-ul"></i> 最近联系
                <span class="custom-right">
                    <a href="#" class="btn btn-primary btn-sm">
                        写私信
                    </a>
                </span>
            </div>

            <!-- left main feed -->
            <ul class="media-list">
                <li id="feed-item-1" class="media custom-story-item custom-card">
                    <div class="media-left media-top">

                        <!-- avatar image -->
                        <a href="#" id="user-avatar">
                            <img class="media-object custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                        </a>
                    </div>
                    <div class="media-body">

                        <!-- author info -->
                        <div class="custom-name">
                            <a href="#" class="">Ellery</a>：
                        </div>

                        <!-- answer content -->
                        <div>Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，P. Cousot & R. Cousot 1977
                            Automatic discovery of linear restraints among variables of a program，P. Cousot & N. Halbwachs 1978
                            Systematic design of program analysis frameworks， P. Cousot & R. Cousot 1979
                        </div>
                        <!-- feed meta -->
                        <div class="custom-meta-panel">
                            <a href="#" class="custom-meta-item">
                                6月13日 21:18
                            </a>
                            <span class="custom-right">
                                <a href="/inbox/123" class="custom-meta-item">
                                    查看对话
                                </a>

                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    删除
                                </a>
                            </span>
                        </div>

                    </div>
                </li>

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

            <div class="alert alert-dismissible alert-success">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>担心骚扰？</strong> 可以 <a href="#" class="alert-link">设置</a> 为「开启陌生人私信箱」。
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
