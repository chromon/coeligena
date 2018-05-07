<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/5/7
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- user info hover card -->
<div class="media custom-display-none" id="user_info">
    <div class="custom-margin-top10">
        <div class="media-left">
            <a href="#">
                <img class="media-object custom-avatar68" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
            </a>
        </div>
        <div class="media-body">
            <h5 class="media-heading">Media heading</h5>
            <div class="custom-answer-info">
                啊咧，一句话介绍不清楚的喵。
                啊咧，一句话介绍不清楚的喵。
            </div>
        </div>
    </div>
    <div class="custom-hover-card">
        <div class="custom-hover-card-item">
            <i class="fa fa-briefcase"></i>
            <span class="custom-margin-left10">Microsoft</span>
            <div class="custom-hover-card-divider"></div> Developer
        </div>
        <div class="custom-hover-card-item">
            <i class="fa fa-users"></i>
            <span class="custom-margin-left10">AAA、BBB、CCC</span>
            也关注了他
        </div>
    </div>
    <div class="custom-number-board">
        <a href="#" class="custom-button custom-number-board-item custom-button-plain">
            <div class="custom-number-board-name">回答</div>
            <div class="custom-number-board-value">125</div>
        </a>
        <a href="#" class="custom-button custom-number-board-item custom-button-plain">
            <div class="custom-number-board-name">回答</div>
            <div class="custom-number-board-value">125</div>
        </a>
        <a href="#" class="custom-button custom-number-board-item custom-button-plain">
            <div class="custom-number-board-name">回答</div>
            <div class="custom-number-board-value">125</div>
        </a>
    </div>
    <div class="custom-hovercard-btn">
        <a href="#" class="btn btn-primary custom-margin-right30">
            <i class="fa fa-plus"></i>
            关注TA
        </a>
        <a href="#" class="btn btn-default">
            <i class="fa fa-comments"></i>
            发私信
        </a>
    </div>
</div>
<!-- end user info hover card -->
