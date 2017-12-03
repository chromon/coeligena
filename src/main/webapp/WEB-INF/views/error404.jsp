<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/12/1
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>编乎 - 404~</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body>
    <div class="error-wrapper">
        <h1 class="error-header">
            <a href="" class="error-title">编乎</a>
            — 404
        </h1>
        <div class="error-content">
            <p>
                <strong>你似乎来到了没有知识存在的荒原...</strong>
            </p>
            <p>来源链接是否正确？用户、话题或问题是否存在？</p>
            <hr>
            <p>
                <a href="/">返回首页</a>
                <span>或者</span>
                <a href="javascript:void(0)" id="js-history-back">返回上页</a>
            </p>
        </div>
    </div>
</body>
</html>
