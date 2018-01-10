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
    <title>${siteInfoDO.siteName} - 出错了~</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body>
    <div class="error-wrapper">
        <h1 class="error-header">
            <a href="" class="error-title">${siteInfoDO.siteName}</a>
            一个依靠想象力的问答社区
        </h1>
        <div class="error-content">
            <p>服务器提了一个问题，我们正在紧张的编写答案……</p>
        </div>
    </div>
</body>
</html>
