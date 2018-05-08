<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/7
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- answer author -->
<div class="custom-display-none"  id="user_info">
    <div class="custom-card-section">
        <div class="custom-answer-author">
            <div class="custom-answer-author-avatar">
                <a href="#">
                    <img class="custom-avatar60" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                </a>
            </div>
            <div class="custom-answer-author-content">
                <div class="custom-answer-author-name">Ellery</div>
                <div class="custom-answer-author-headline">Just do it.</div>
            </div>
        </div>
    </div>
    <div class="custom-card-section">
        <div class="custom-answer-author-item">
            <div class="custom-answer-author-itemIcon">
                <i class="fa fa-check-square custom-icon-color-verification"></i>
            </div>
            <div class="custom-answer-author-itemValue">
                <span><a href="">XXX公司</a></span>
                <span><a href="">、XXX工程师</a></span>
            </div>
        </div>
        <div class="custom-answer-author-item">
            <div class="custom-answer-author-itemIcon">
                <i class="fa fa-certificate custom-icon-color-certificate"></i>
            </div>
            <div class="custom-answer-author-itemValue">
                <span><a href="">XXX</a></span>
                <span><a href="">、XXX</a></span>
                话题的优秀回答者
            </div>
        </div>
        <div class="custom-answer-author-item">
            <div class="custom-answer-author-itemIcon">
                <i class="fa fa-users"></i>
            </div>
            <div class="custom-answer-author-itemValue">
                <span><a href="">Bone</a></span>
                <span><a href="">、Drizzle</a></span>
                也关注了他
            </div>
        </div>
    </div>
    <div class="custom-card-section">
        <div class="custom-answer-counts">
            <div class="custom-number-board">
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">回答</div>
                    <div class="custom-number-board-value">125</div>
                </a>
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">文章</div>
                    <div class="custom-number-board-value">125</div>
                </a>
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">关注者</div>
                    <div class="custom-number-board-value">125</div>
                </a>
            </div>
        </div>
        <div class="custom-member-btn-group custom-answer-author-btns">
            <button class="btn btn-primary" type="button">
                <span style="display: inline-flex; align-items: center;">
                    <i class="fa fa-plus" style="margin-right: 8px;"></i>
                    关注TA
                </span>
            </button>
            <button class="btn btn-default btn--grey custom-contentItem-right" type="button">
                <span style="display: inline-flex; align-items: center;">
                    <i class="fa fa-comments" style="margin-right: 8px;"></i>
                    发私信
                </span>
            </button>
        </div>
    </div>
</div><!-- end answer author -->



<!-- user info hover card -->
<%--<div class="media custom-display-none" id="user_info">--%>
    <%--<div class="custom-margin-top10">--%>
        <%--<div class="media-left">--%>
            <%--<a href="#">--%>
                <%--<img class="media-object custom-avatar68" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">--%>
            <%--</a>--%>
        <%--</div>--%>
        <%--<div class="media-body">--%>
            <%--<h5 class="media-heading">Media heading</h5>--%>
            <%--<div class="custom-answer-info">--%>
                <%--啊咧，一句话介绍不清楚的喵。--%>
                <%--啊咧，一句话介绍不清楚的喵。--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="custom-hover-card">--%>
        <%--<div class="custom-hover-card-item">--%>
            <%--<i class="fa fa-briefcase"></i>--%>
            <%--<span class="custom-margin-left10">Microsoft</span>--%>
            <%--<div class="custom-hover-card-divider"></div> Developer--%>
        <%--</div>--%>
        <%--<div class="custom-hover-card-item">--%>
            <%--<i class="fa fa-users"></i>--%>
            <%--<span class="custom-margin-left10">AAA、BBB、CCC</span>--%>
            <%--也关注了他--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div class="custom-number-board">--%>
        <%--<a href="#" class="custom-button custom-number-board-item custom-button-plain">--%>
            <%--<div class="custom-number-board-name">回答</div>--%>
            <%--<div class="custom-number-board-value">125</div>--%>
        <%--</a>--%>
        <%--<a href="#" class="custom-button custom-number-board-item custom-button-plain">--%>
            <%--<div class="custom-number-board-name">回答</div>--%>
            <%--<div class="custom-number-board-value">125</div>--%>
        <%--</a>--%>
        <%--<a href="#" class="custom-button custom-number-board-item custom-button-plain">--%>
            <%--<div class="custom-number-board-name">回答</div>--%>
            <%--<div class="custom-number-board-value">125</div>--%>
        <%--</a>--%>
    <%--</div>--%>
    <%--<div class="custom-hovercard-btn">--%>
        <%--<a href="#" class="btn btn-primary custom-margin-right30">--%>
            <%--<i class="fa fa-plus"></i>--%>
            <%--关注TA--%>
        <%--</a>--%>
        <%--<a href="#" class="btn btn-default">--%>
            <%--<i class="fa fa-comments"></i>--%>
            <%--发私信--%>
        <%--</a>--%>
    <%--</div>--%>
<%--</div>--%>
<!-- end user info hover card -->
