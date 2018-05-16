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
    <title>我的草稿 - ${siteInfoDO.siteName}</title>
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
                <!-- draft header -->
                <div class="custom-list-header">
                    <h6 class="custom-list-headerText">我的草稿</h6>
                    <div class="custom-list-headerOptions">
                        <button class="custom-btn-plain custom-contentItem-right" type="button" style="display: inline-block">
                            <span style="align-items: center;">
                                <span>全部草稿</span>
                                <i class="fa fa-sort"></i>
                            </span>
                        </button>
                    </div>
                </div><!-- end draft header -->
                <!-- question item -->
                <div class="custom-feed-item">
                    <a href="#">
                        <h4 class="custom-media-heading">
                            怎么证明三笔不能经过九个点？
                        </h4>
                    </a>
                    <div class="custom-rich-content-inner custom-text-overflow">
                        符号引用是只包含语义信息，不涉及具体实现的；而解析（resolve）过后的直接引用则是与具体实现息息相关的。
                        所以当谈及某个符号引用被resolve成怎样的直接引用时，必须要结合某个具体实现来讨论才行。
                    </div>
                    <div class="custom-meta-panel">
                        <a href="" class="custom-meta-item">删除</a>
                        <span class="custom-bull">•</span>
                        <a href="" class="custom-meta-item">编辑</a>
                        <span class="custom-bull">•</span>
                        <span>2018-05-08</span>
                        <span class="custom-bull">•</span>
                        <span>共523个字</span>
                        <span class="custom-bull">•</span>
                        <span>回答</span>
                        <%--<span>文章</span>--%>
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
