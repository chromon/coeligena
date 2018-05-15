<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/8
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- sidebar -->
<div id="rightSidebar" class="col-sm-3 custom-sidebar-padding">
    <div class="sidebar_inner">
        <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
            <a href="${pageContext.request.contextPath}/collections" class="list-group-item custom-group-item">
                <span class="badge custom-badge">8</span>
                <i class="fa fa-star"></i> 我的收藏
            </a>
            <a href="${pageContext.request.contextPath}/following/questions" class="list-group-item custom-group-item">
                <i class="fa fa-check-circle-o"></i> 我的关注
            </a>
            <a href="${pageContext.request.contextPath}/question/invited" class="list-group-item custom-group-item">
                <span class="badge custom-badge">113</span>
                <i class="fa fa-user-plus"></i> 我的邀请
            </a>
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-home"></i> 社区服务中心
            </a>
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-copyright"></i> 版权服务中心
            </a>
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-pencil-square"></i> 公共编辑动态
            </a>
        </div>
        <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-flash"></i> Live
            </a>
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-book"></i> 书店
            </a>
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-futbol-o"></i> 圆桌
            </a>
            <a href="${pageContext.request.contextPath}/following/columns" class="list-group-item custom-group-item">
                <i class="fa fa-pencil"></i> 专栏
            </a>
            <a href="#" class="list-group-item custom-group-item">
                <i class="fa fa-btc"></i> 付费编辑
            </a>
        </div>
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
    </div>
</div><!-- end sidebar -->