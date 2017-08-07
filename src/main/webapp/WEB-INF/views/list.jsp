<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/5
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>list</title>
</head>
<body>
<c:forEach var="course" items="${courseList}">
    <c:out value="${course.courseId}"/> :
    <c:out value="${course.courseName}"/>
    <br/>
</c:forEach>
</body>
</html>
