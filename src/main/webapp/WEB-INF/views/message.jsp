<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>私信 - 编乎</title>
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
        <div class="col-sm-8">
            <!-- media list title -->
            <div class="custom-list-title custom-story-item custom-card">
                <a href=""><i class="fa fa-arrow-left" aria-hidden="true"></i> 返回</a>
                <div>
                    <span class="custom-grey">发私信给</span>
                    <span class="custom-darker">编乎团队：</span>
                </div>
                <form class="form-horizontal">
                    <textarea class="form-control" rows="3" id="textArea"></textarea>
                </form>
                <div class="custom-msg-btn">
                    <a href="#" class="btn btn-primary btn-sm">
                        发送
                    </a>
                </div>
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
                                <a href="#" class="custom-meta-item">
                                    回复
                                </a>

                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    删除
                                </a>
                            </span>
                        </div>

                    </div>
                </li>

            </ul><!-- end left main feed -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3 col-sm-offset-1">

        </div><!-- end sidebar -->
    </div>
</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
