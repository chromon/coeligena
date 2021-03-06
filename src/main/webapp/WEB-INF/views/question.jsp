<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>${questionsDO.questionContent} - ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络现编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body>

<!-- navbar -->
<%@include file="navbar.jsp"%>

<input id="usersDO" type="hidden" value="${userInfoDTO.usersDO}">
<input id="questionId" type="hidden" value="${questionsDO.id}">

<!-- main content -->
<div class="container">
    <div class="row custom-content-margin">
        <div class="col-sm-12">
            <!-- question header -->
            <div class="custom-card custom-question-headers">
                <div class="custom-question-header-content">
                    <!-- question header main -->
                    <div class="custom-question-header-main">
                        <!-- question header tags -->
                        <div class="custom-question-header-tags">
                            <div class="custom-question-header-topics">
                                <c:forEach var="questionTag" items="${questionTagsList}">
                                <div class="custom-question-topic custom-tag">
                                    <a href="">${questionTag.topicName}</a>
                                </div>
                                </c:forEach>
                            </div>
                        </div><!-- end question header tags -->
                        <h1 class="custom-question-header-title">
                            ${questionsDO.questionContent}
                        </h1>
                        <!-- question header details -->
                        <div class="custom-question-header-detail">
                            <div class="custom-question-rich-text">
                                <span id="question-digest">${questionsDO.questionDigest} ……</span>
                                <span id="question-detail" class="hide">${questionsDO.questionDetail}</span>
                                <input type="hidden" id="question_id" value="${questionsDO.id}">
                                <button id="unfold-question" class="custom-contentItem-more custom-btn-plain" type="button">
                                    <span class="custom-margin-right5">显示全部</span>
                                    <i class="fa fa-chevron-down"></i>
                                </button>
                            </div>
                        </div><!-- end question header details -->
                    </div><!-- end question header main -->
                    <!-- question header side -->
                    <div class="custom-question-header-side">
                        <div class="custom-number-board">
                            <div class="NumberBoard QuestionFollowStatus-counts" data-reactid="94">
                                <button class="Button NumberBoard-item Button--plain" type="button" data-reactid="95">
                                    <div class="NumberBoard-itemInner">
                                        <span class="NumberBoard-name" data-reactid="96">关注者</span>
                                        <span class="NumberBoard-value" data-reactid="97">${questionsDO.followerCount}</span>
                                    </div>
                                </button>
                                <div class="NumberBoard-divider" data-reactid="98"></div>
                                <div class="NumberBoard-item" data-reactid="99">
                                    <div class="NumberBoard-itemInner">
                                        <div class="NumberBoard-name" data-reactid="100">被浏览</div>
                                        <div class="NumberBoard-value" data-reactid="101">${questionsDO.viewCount}</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!-- question header side -->
                </div>
                <!-- question header footer -->
                <div class="custom-question-header-footer">
                    <div class="custom-question-header-footer-inner">
                        <div class="custom-question-header-main custom-question-header-footer-main">
                            <div class="custom-question-btn-group">
                                <c:choose>
                                    <c:when test="${followed}">
                                        <a href="#" onclick="followQuestion(this, '${questionsDO.id}')" class="btn btn-default btn--grey custom-margin-right10">
                                            已关注
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="#" onclick="followQuestion(this, '${questionsDO.id}')" class="btn btn-primary custom-margin-right10">
                                            关注问题
                                        </a>
                                    </c:otherwise>
                                </c:choose>
                                <a id="write_answer_top" href="javascript: void(0);" class="btn btn-default custom-margin-right10">
                                    <i class="fa fa-pencil"></i>
                                    写答案
                                </a>
                            </div>
                            <div class="custom-question-header-actions">
                                <button id="question-comments" class="custom-contentItem-action custom-btn-plain" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-comment custom-margin-right5"></i>
                                        ${questionsDO.commentCount} 条评论
                                    </span>
                                </button>
                                <div class="custom-drop-option2">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                        <i class="fa fa-paper-plane"></i> 分享
                                    </a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">复制链接</a></li>
                                        <li><a href="#">新浪微博</a></li>
                                        <li><a href="#">扫一扫</a></li>
                                    </ul>
                                </div>
                                <button onclick="report('${questionsDO.id}', 1);" class="custom-contentItem-action custom-btn-plain" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-flag custom-margin-right5"></i>
                                        举报
                                    </span>
                                </button>
                                <div class="custom-drop-option2">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                        •••
                                    </a>
                                    <ul class="dropdown-menu" role="menu">
                                        <li><a href="#">使用匿名身份</a></li>
                                        <li><a href="#">查看问题日志</a></li>
                                    </ul>
                                </div>

                                <button id="tuck-up-question" class="custom-contentItem-action custom-btn-plain custom-right hide" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <span class="custom-margin-right5">收起</span>
                                        <i class="fa fa-chevron-up"></i>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div><!-- question header content footer -->
            </div><!-- end question header -->
        </div>
    </div>

    <!-- answer main -->
    <div class="row">
        <div class="col-sm-9">
            <!-- editor -->
            <div id="answer_wrap" class="custom-card custom-editor" style="display: none">
                <input id="is_anonymous" type="hidden" name="anonymous" value="0">

                <!-- end editor header -->
                <div class="custom-editor-header">
                    <div class="custom-author-info">
                        <span class="custom-author-avatar">
                            <a href="#">
                                <img id="answer_img" class="media-object custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="${userInfoDTO.usersDO.fullname}">
                            </a>
                        </span>
                        <div class="custom-author-content">
                            <div class="custom-author-content-head">
                                <span id="answer_fullname" class="custom-author-name">${userInfoDTO.usersDO.fullname}</span>
                            </div>
                            <div id="autograph_wrap" class="custom-author-content-detail">
                                <div class="custom-author-badge">
                                    <span id="answer_autograph" class="custom-author-bio">${userInfoDTO.usersDO.autograph}</span>
                                    <a id="edit_topic_bios" data-toggle="modal" data-target="#topicBioModal" href="" class="custom-topic-bios">
                                        <i class="fa fa-pencil"></i>
                                        编辑话题经验
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a id="anonymous_btn" data-toggle="modal" data-target="#anonymousModal" href="" class="custom-toggle-anonymous">使用匿名身份回答</a>
                    <a id="realname_btn" data-toggle="modal" data-target="#realNameModal" href="" class="custom-toggle-anonymous" style="display: none;">使用实名身份回答</a>
                </div><!-- end editor header -->
                <!-- editor note -->
                <div id="answer_note"></div><!-- end editor note -->
                <!-- editor footer -->
                <div class="custom-answer-footer">
                    <div class="custom-answer-status">
                        <a class="custom-answer-delete" href=""><i class="fa fa-trash-o"></i></a>
                        草稿以保存（11分钟前）
                    </div>
                    <div class="custom-answer-right">
                        <a id="answer_setting_btn" href="#" class="custom-answer-setting">
                            <i class="fa fa-cog"></i> 设置
                        </a>
                        <a id="post_answer_btn" href="javascript: void(0);" class="btn btn-primary">提交答案</a>
                    </div>
                </div><!-- end editor footer -->
            </div><!-- end editor -->

            <c:if test="${fromAnswer}">
            <div class="custom-card">
                <a href="" class="custom-question-more">查看全部3287个回答</a>
            </div>
            </c:if>

            <!-- left main feed -->
            <div>
                <!-- question invitation -->
                <div class="custom-card custom-question-invitation">
                    <div class="custom-top-bar">
                        <div class="custom-top-bar-title">
                            <div class="custom-invitation-title">
                                <span>你可以邀请下面用户，快速获得回答</span>
                            </div>
                        </div>
                        <div class="custom-top-bar-options">
                            <div class="custom-invitation-input">
                                <input type="text" class="form-control input-sm" size="40" placeholder="搜索你感兴趣的内容...">
                            </div>
                        </div>
                    </div>
                    <div class="custom-invitation-content">
                        <div>
                            <!-- invitation list item -->
                            <div class="custom-feed-item">
                                <div class="custom-contentItem-main">
                                    <div class="custom-contentItem-image">
                                        <a href="">
                                            <img class="custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                                        </a>
                                    </div>
                                    <div class="custom-contentItem-head">
                                        <h2 class="custom-contentItem-title">
                                            <a href="${pageContext.request.contextPath}/column/123">
                                                机器学习算法与自然语言处理
                                            </a>
                                        </h2>
                                        <div class="custom-contentItem-meta">
                                            <div class="custom-columnItem-meta">
                                                <div class="custom-contentItem-status">
                                                    <span>在话题 </span>
                                                    <a href="">世界贸易组织（WTO）</a>
                                                    <span>下有</span>
                                                    <a href="">3</a>
                                                    <span>个回答</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="custom-contentItem-extra">
                                        <button class="custom-btn btn-outline-primary" type="button">邀请回答</button>
                                    </div>
                                </div>
                            </div><!-- end invitation list item -->
                            <!-- more invitation -->
                            <div class="custom-feed-item custom-invitation-more">
                                <a href="">更多推荐结果</a>
                            </div><!-- end more invitation -->
                        </div>
                    </div>
                </div><!-- end question invitation -->

                <c:if test="${empty answersDTOList}">
                <!-- no answers -->
                <div class="custom-card custom-feed-item custom-answers-none">
                    <div class="custom-empty-state">
                        <div class="custom-empty-state-inner">
                            <i class="fa fa-pencil-square-o fa-5x" aria-hidden="true"></i>
                            <div>
                                暂时还没有回答，开始
                                <a id="write_answers_none" href="javascript: void(0);">写第一个回答</a>
                            </div>
                        </div>
                    </div>
                </div><!-- end no answers -->
                </c:if>

                <!-- feed list -->
                <div>
                    <!-- post answer template -->
                    <script type="text/template" id="post_answer_template">

                        <!-- feed item -->
                        <div class="custom-card custom-feed-item">
                            <a href="" class="custom-feed-item-right">
                                <i class="fa fa-times"></i>
                            </a>
                            <!-- feed -->
                            <div>
                                <!-- feed author info -->
                                <div class="custom-feed-src-info custom-feed-author-info">
                                    <!-- avatar image -->
                                    <a href="#">
                                        <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>${userInfoDTO.usersDO.avatarPath}" alt="${userInfoDTO.usersDO.fullname} avatar">
                                    </a>

                                    <div class="custom-author-info-content">
                                        <div class="custom-author-info-head">
                                            <a href="#">${userInfoDTO.usersDO.fullname}</a>
                                        </div>
                                        <div class="custom-author-info-detail">
                                            <div class="custom-author-badge">
                                                <div class="custom-author-badge-text">
                                                    ${userInfoDTO.usersDO.autograph}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- end feed author info -->

                                <!-- feed detail -->
                                <div>
                                    <!-- feed content -->
                                    <div class="custom-rich-content">
                                        <div class="custom-answerItem-extraInfo">
                                            <span class="custom-voters">
                                                <a href="">{{approvalCount}} 人赞同了该回答</a>
                                            </span>
                                        </div>
                                        <div class="custom-rich-content-inner">
                                            <span>{{{answerContent}}}</span>
                                        </div>
                                        <div class="custom-contentItem-time">
                                            <a href="#">编辑于 {{answerTime}}</a>
                                        </div>
                                        <div>
                                            <div class="custom-contentItem-actions">
                                                <span>
                                                    <button class="custom-vote-btn" aria-label="赞同" type="button">
                                                        <i class="fa fa-caret-up"></i> {{approvalCount}}
                                                    </button>
                                                    <button class="custom-vote-btn" aria-label="反对" type="button">
                                                        <i class="fa fa-caret-down"></i>
                                                    </button>
                                                </span>
                                                <button class="custom-contentItem-action custom-btn-plain" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <i class="fa fa-comment custom-margin-right5"></i>
                                                        {{commentCount}} 条评论
                                                    </span>
                                                </button>
                                                <div class="custom-drop-option2">
                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                        <i class="fa fa-paper-plane"></i> 分享
                                                    </a>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">复制链接</a></li>
                                                        <li><a href="#">新浪微博</a></li>
                                                        <li><a href="#">扫一扫</a></li>
                                                    </ul>
                                                </div>
                                                <button class="custom-contentItem-action custom-btn-plain" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <i class="fa fa-star custom-margin-right5"></i>
                                                        收藏
                                                    </span>
                                                </button>
                                                <button class="custom-contentItem-action custom-btn-plain" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <i class="fa fa-heart custom-margin-right5"></i>
                                                        感谢
                                                    </span>
                                                </button>
                                                <div class="custom-drop-option2">
                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                        •••
                                                    </a>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">没有帮助</a></li>
                                                        <li><a href="#">举报</a></li>
                                                    </ul>
                                                </div>
                                                <button class="custom-contentItem-action custom-btn-plain custom-contentItem-right" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <span class="custom-margin-right5">收起</span>
                                                        <i class="fa fa-chevron-up"></i>
                                                    </span>
                                                </button>
                                            </div>
                                        </div>
                                    </div><!-- end feed content -->
                                </div><!-- feed detail -->
                            </div><!-- end feed -->
                        </div><!-- feed item -->

                    </script><!-- end post answer template -->

                    <div id="post_answer_wrapper"></div>

                    <!-- feed item -->
                    <div class="custom-card">

                        <div class="custom-list-header">
                            <h6 class="custom-list-headerText">
                                <c:out value="${fn:length(answersDTOList)}"/>
                                个回答
                            </h6>
                            <div class="custom-list-headerOptions">
                                <span class="custom-switcher custom-right">
                                    <a id="default-sort" onclick="sortAnswer(${questionsDO.id}, 0);" href="javascript: void(0)" class="custom-current">默认排序</a> |
                                    <a id="time-sort" onclick="sortAnswer(${questionsDO.id}, 1);" href="javascript: void(0)">时间排序</a>
                                </span>
                            </div>
                        </div>

                        <div id="answers-wrapper">
                            <c:forEach var="answersDTOList" items="${answersDTOList}">
                            <!-- feed -->
                            <div class="custom-feed-item">
                                <!-- feed author info -->
                                <div class="custom-feed-src-info custom-feed-author-info">
                                    <!-- avatar image -->
                                    <a href="#" id="user-avatar-${answersDTOList.usersDO.id}">
                                        <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>${answersDTOList.usersDO.avatarPath}" alt="Ellery">
                                    </a>

                                    <div class="custom-author-info-content">
                                        <div class="custom-author-info-head">
                                            <a href="#">${answersDTOList.usersDO.fullname}</a>
                                        </div>
                                        <div class="custom-author-info-detail">
                                            <div class="custom-author-badge">
                                                <div class="custom-author-badge-text">
                                                    ${answersDTOList.usersDO.autograph}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!-- end feed author info -->

                                <!-- feed detail -->
                                <div>
                                    <!-- feed content -->
                                    <div class="custom-rich-content">
                                        <div class="custom-answerItem-extraInfo">
                                        <span class="custom-voters">
                                            <a href="">1 人赞同了该回答</a>
                                        </span>
                                        </div>
                                        <!-- custom-is-collapsed -->
                                        <div class="custom-rich-content-inner" id="ans-inner-${answersDTOList.answersDO.id}">
                                            <span>${answersDTOList.answersDO.answerContent}</span>
                                        </div>
                                        <button id="ans-unfold-${answersDTOList.answersDO.id}" onclick="unfoldAnswer(${answersDTOList.answersDO.id});" class="custom-contentItem-rightBtn custom-btn-plain hide" type="button">
                                            <span class="custom-margin-right5">展开阅读全文</span>
                                            <i class="fa fa-chevron-down"></i>
                                        </button>
                                        <div class="custom-contentItem-time">
                                            <a href="#">编辑于 ${answersDTOList.answersDO.answerTime}</a>
                                        </div>
                                        <div>
                                            <div class="custom-contentItem-actions custom-sticky custom-is-fixed">
                                                <span>
                                                    <c:choose>
                                                        <c:when test="${answersDTOList.votesDO != null}">
                                                            <c:if test="${answersDTOList.votesDO.voteType == 1}">
                                                                <button class="custom-vote-btn is-active" onclick="voteUp(this, '${answersDTOList.answersDO.id}');" aria-label="赞同" type="button">
                                                                    <i class="fa fa-caret-up"></i> ${answersDTOList.answersDO.approvalCount}
                                                                </button>
                                                                <button class="custom-vote-btn" onclick="voteDown(this, '${answersDTOList.answersDO.id}');" aria-label="反对" type="button">
                                                                    <i class="fa fa-caret-down"></i>
                                                                </button>
                                                            </c:if>
                                                            <c:if test="${answersDTOList.votesDO.voteType == 2}">
                                                                <button class="custom-vote-btn" onclick="voteUp(this, '${answersDTOList.answersDO.id}');" aria-label="赞同" type="button">
                                                                    <i class="fa fa-caret-up"></i> ${answersDTOList.answersDO.approvalCount}
                                                                </button>
                                                                <button class="custom-vote-btn is-active" onclick="voteDown(this, '${answersDTOList.answersDO.id}');" aria-label="反对" type="button">
                                                                    <i class="fa fa-caret-down"></i>
                                                                </button>
                                                            </c:if>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <button class="custom-vote-btn" onclick="voteUp(this, '${answersDTOList.answersDO.id}');" aria-label="赞同" type="button">
                                                                <i class="fa fa-caret-up"></i> ${answersDTOList.answersDO.approvalCount}
                                                            </button>
                                                            <button class="custom-vote-btn" onclick="voteDown(this, '${answersDTOList.answersDO.id}');" aria-label="反对" type="button">
                                                                <i class="fa fa-caret-down"></i>
                                                            </button>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                                <button onclick="commentsList(${answersDTOList.answersDO.id})" data-toggle="collapse" data-target="#answer-comments-wrapper-${answersDTOList.answersDO.id}"
                                                        aria-expanded="false" aria-controls="collapseExample" class="custom-contentItem-action custom-btn-plain" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <i class="fa fa-comment custom-margin-right5"></i>
                                                        ${answersDTOList.answersDO.commentCount} 条评论
                                                    </span>
                                                </button>
                                                <div class="custom-drop-option2">
                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                        <i class="fa fa-paper-plane"></i> 分享
                                                    </a>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">复制链接</a></li>
                                                        <li><a href="#">新浪微博</a></li>
                                                        <li><a href="#">扫一扫</a></li>
                                                    </ul>
                                                </div>
                                                <button onclick="showCollectModal('${answersDTOList.answersDO.id}')" class="custom-contentItem-action custom-btn-plain" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <i class="fa fa-star custom-margin-right5"></i>
                                                        收藏
                                                    </span>
                                                </button>
                                                <c:choose>
                                                    <c:when test="${answersDTOList.thanked}">
                                                    <button onclick="forThanks(this, '${answersDTOList.answersDO.id}');" class="custom-contentItem-action custom-btn-plain already-thanks" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-heart custom-margin-right5"></i>
                                                            <span class="thanks-text">取消感谢</span>
                                                        </span>
                                                    </button>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <button onclick="forThanks(this, '${answersDTOList.answersDO.id}');" class="custom-contentItem-action custom-btn-plain" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-heart custom-margin-right5"></i>
                                                            <span class="thanks-text">感谢</span>
                                                        </span>
                                                        </button>
                                                    </c:otherwise>
                                                </c:choose>
                                                <div class="custom-drop-option2">
                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                        •••
                                                    </a>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <c:choose>
                                                            <c:when test="${answersDTOList.noHelp}">
                                                                <li><a href="javascript:void(0);" onclick="noHelp(this, '${answersDTOList.answersDO.id}');" class="no-help">撤销没有帮助</a></li>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <li><a href="javascript:void(0);" onclick="noHelp(this, '${answersDTOList.answersDO.id}');">没有帮助</a></li>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <li><a onclick="report('${answersDTOList.answersDO.id}', 2);" href="javascript:void(0);">举报</a></li>
                                                        <li><a href="javascript:void(0);">不感兴趣</a></li>
                                                    </ul>
                                                </div>
                                                <c:if test="${fn:length(answersDTOList.answersDO.answerContent) > 150}">
                                                <button id="tuck-up-${answersDTOList.answersDO.id}" onclick="tuckUpAnswer(${answersDTOList.answersDO.id});" class="custom-contentItem-action custom-btn-plain custom-contentItem-right" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <span class="custom-margin-right5">收起</span>
                                                        <i class="fa fa-chevron-up"></i>
                                                    </span>
                                                </button>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div><!-- end feed content -->

                                    <!-- feed comment -->
                                    <div id="answer-comments-wrapper-${answersDTOList.answersDO.id}" class="collapse">
                                        <div class="custom-comments custom-comments-withPagination custom-comments-container">
                                            <!-- comment top bar -->
                                            <div class="custom-comments-topbar">
                                                <div class="custom-comments-topbar-title">
                                                    <h2>${answersDTOList.answersDO.commentCount} 条评论</h2>
                                                </div>
                                                <div class="custom-comments-topbar-option">
                                                    <button class="custom-btn-plain custom-contentItem-right" type="button">
                                                    <span style="display: inline-flex;align-items: center;">
                                                        <i class="fa fa-exchange custom-margin-right5"></i>
                                                        <span>切换为时间排序</span>
                                                    </span>
                                                    </button>
                                                </div>
                                            </div><!-- end comment top bar -->

                                            <div id="comments-container-${answersDTOList.answersDO.id}" class="custom-comment-list">
                                            </div>

                                            <!-- comment pagination -->
                                            <div id="answer-comments-paging-wrapper-${answersDTOList.answersDO.id}">
                                            </div><!-- end comment pagination -->

                                            <!-- collapse comment -->
                                            <div class="custom-comment-list-action">
                                                <div class="custom-comment-list-collapse">
                                                    <span>1 条评论被折叠</span>
                                                    （<a href="">为什么？</a>）
                                                </div>
                                            </div><!-- end collapse comment -->
                                            <!-- comment footer -->
                                            <div class="custom-comments-footer custom-comments-editor">
                                                <div class="form-group" style="margin-bottom: 0px;">
                                                    <input type="hidden" id="parent-comment-id-${answersDTOList.answersDO.id}" value="0">
                                                    <input type="hidden" id="reviewer-id-${answersDTOList.answersDO.id}" value="0">
                                                    <textarea id="answer-comment-${answersDTOList.answersDO.id}" class="form-control custom-border-shadow custom-question-comment" rows="1"></textarea>
                                                    <button id="comment-answer-btn-${answersDTOList.answersDO.id}" onclick="postAnswerComment(${answersDTOList.answersDO.id});" class="btn btn-primary btn-sm" style="float:right;" type="button">评论</button>
                                                </div>
                                            </div><!-- end comment footer -->
                                        </div><!-- end feed comment -->
                                    </div>
                                </div><!-- feed detail -->
                            </div><!-- end feed -->
                            </c:forEach>
                        </div>
                    </div><!-- feed item -->
                </div>
                <!-- end feed list -->

                <script type="text/html" id="answers-template">
                    {{each data}}
                    <%--<div>KEY:{{$value.answersDO.id}}</div>--%>
                    <!-- feed -->
                    <div class="custom-feed-item">
                        <!-- feed author info -->
                        <div class="custom-feed-src-info custom-feed-author-info">
                            <!-- avatar image -->
                            <a href="#" id="user-avatar-{{$value.usersDO.id}}">
                                <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>{{$value.usersDO.avatarPath}}" alt="{{$value.usersDO.fullname}}">
                            </a>

                            <div class="custom-author-info-content">
                                <div class="custom-author-info-head">
                                    <a href="#">{{$value.usersDO.fullname}}</a>
                                </div>
                                <div class="custom-author-info-detail">
                                    <div class="custom-author-badge">
                                        <div class="custom-author-badge-text">
                                            {{$value.usersDO.autograph}}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- end feed author info -->

                        <!-- feed detail -->
                        <div>
                            <!-- feed content -->
                            <div class="custom-rich-content">
                                <div class="custom-answerItem-extraInfo">
                                    <span class="custom-voters">
                                        <a href="">1 人赞同了该回答</a>
                                    </span>
                                </div>
                                <!-- custom-is-collapsed -->
                                <div class="custom-rich-content-inner" id="ans-inner-{{$value.answersDO.id}}">
                                    <span>{{@$value.answersDO.answerContent}}</span>
                                </div>
                                <button id="ans-unfold-{{$value.answersDO.id}}" onclick="unfoldAnswer('{{$value.answersDO.id}}');" class="custom-contentItem-rightBtn custom-btn-plain hide" type="button">
                                    <span class="custom-margin-right5">展开阅读全文</span>
                                    <i class="fa fa-chevron-down"></i>
                                </button>
                                <div class="custom-contentItem-time">
                                    <a href="#">编辑于 {{$value.answersDO.answerTime}}</a>
                                </div>
                                <div>
                                    <div class="custom-contentItem-actions custom-sticky custom-is-fixed">
                                        <span>
                                            {{if $value.votesDO != null}}
                                                {{if $value.votesDO.voteType == 1}}
                                                    <button class="custom-vote-btn is-active" onclick="voteUp(this, '{{$value.answersDO.id}}');" aria-label="赞同" type="button">
                                                        <i class="fa fa-caret-up"></i> {{$value.answersDO.approvalCount}}
                                                    </button>
                                                    <button class="custom-vote-btn" onclick="voteDown(this, '{{$value.answersDO.id}}');" aria-label="反对" type="button">
                                                        <i class="fa fa-caret-down"></i>
                                                    </button>
                                                {{else if $value.votesDO.voteType == 2}}
                                                    <button class="custom-vote-btn" onclick="voteUp(this, '{{$value.answersDO.id}}');" aria-label="赞同" type="button">
                                                        <i class="fa fa-caret-up"></i> {{$value.answersDO.approvalCount}}
                                                    </button>
                                                    <button class="custom-vote-btn is-active" onclick="voteDown(this, '{{$value.answersDO.id}}');" aria-label="反对" type="button">
                                                        <i class="fa fa-caret-down"></i>
                                                    </button>
                                                {{/if}}
                                            {{else}}
                                                <button class="custom-vote-btn" onclick="voteUp(this, '{{$value.answersDO.id}}');" aria-label="赞同" type="button">
                                                    <i class="fa fa-caret-up"></i> {{$value.answersDO.approvalCount}}
                                                </button>
                                                <button class="custom-vote-btn" onclick="voteDown(this, '{{$value.answersDO.id}}');" aria-label="反对" type="button">
                                                    <i class="fa fa-caret-down"></i>
                                                </button>
                                            {{/if}}

                                        </span>
                                        <button onclick="commentsList('{{$value.answersDO.id}}')" data-toggle="collapse" data-target="#answer-comments-wrapper-{{$value.answersDO.id}}"
                                                aria-expanded="false" aria-controls="collapseExample" class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                {{$value.answersDO.commentCount}} 条评论
                                            </span>
                                        </button>
                                        <div class="custom-drop-option2">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                <i class="fa fa-paper-plane"></i> 分享
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">复制链接</a></li>
                                                <li><a href="#">新浪微博</a></li>
                                                <li><a href="#">扫一扫</a></li>
                                            </ul>
                                        </div>
                                        <button onclick="showCollectModal('{{$value.answersDO.id}}')" class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-star custom-margin-right5"></i>
                                                收藏
                                            </span>
                                        </button>
                                        {{if $value.thanked}}
                                            <button onclick="forThanks(this, '{{$value.answersDO.id}}');" class="custom-contentItem-action custom-btn-plain already-thanks" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-heart custom-margin-right5"></i>
                                                    <span class="thanks-text">取消感谢</span>
                                                </span>
                                            </button>
                                        {{else}}
                                            <button onclick="forThanks(this, '{{$value.answersDO.id}}');" class="custom-contentItem-action custom-btn-plain" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-heart custom-margin-right5"></i>
                                                    <span class="thanks-text">感谢</span>
                                                </span>
                                            </button>
                                        {{/if}}

                                        <div class="custom-drop-option2">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                                •••
                                            </a>
                                            <ul class="dropdown-menu" role="menu">
                                                {{if $value.noHelp}}
                                                <li><a href="javascript:void(0);" onclick="noHelp(this, '{{$value.answersDO.id}}');" class="no-help">撤销没有帮助</a></li>
                                                {{else}}
                                                <li><a href="javascript:void(0);" onclick="noHelp(this, '{{$value.answersDO.id}}');">没有帮助</a></li>
                                                {{/if}}

                                                <li><a onclick="report('{{$value.answersDO.id}}', 2);" href="javascript:void(0);">举报</a></li>
                                                <li><a href="javascript:void(0);">不感兴趣</a></li>
                                            </ul>
                                        </div>
                                        <button id="tuck-up-{{$value.answersDO.id}}" onclick="tuckUpAnswer('{{$value.answersDO.id}}');" class="custom-contentItem-action custom-btn-plain custom-contentItem-right" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <span class="custom-margin-right5">收起</span>
                                                <i class="fa fa-chevron-up"></i>
                                            </span>
                                        </button>
                                    </div>
                                </div>
                            </div><!-- end feed content -->

                            <!-- feed comment -->
                            <div id="answer-comments-wrapper-{{$value.answersDO.id}}" class="collapse">
                                <div class="custom-comments custom-comments-withPagination custom-comments-container">
                                    <!-- comment top bar -->
                                    <div class="custom-comments-topbar">
                                        <div class="custom-comments-topbar-title">
                                            <h2>{{$value.answersDO.commentCount}} 条评论</h2>
                                        </div>
                                        <div class="custom-comments-topbar-option">
                                            <button class="custom-btn-plain custom-contentItem-right" type="button">
                                                <span style="display: inline-flex;align-items: center;">
                                                    <i class="fa fa-exchange custom-margin-right5"></i>
                                                    <span>切换为时间排序</span>
                                                </span>
                                            </button>
                                        </div>
                                    </div><!-- end comment top bar -->

                                    <div id="comments-container-{{$value.answersDO.id}}" class="custom-comment-list">
                                    </div>

                                    <!-- comment pagination -->
                                    <div id="answer-comments-paging-wrapper-{{$value.answersDO.id}}">
                                    </div><!-- end comment pagination -->

                                    <!-- collapse comment -->
                                    <div class="custom-comment-list-action">
                                        <div class="custom-comment-list-collapse">
                                            <span>1 条评论被折叠</span>
                                            （<a href="">为什么？</a>）
                                        </div>
                                    </div><!-- end collapse comment -->
                                    <!-- comment footer -->
                                    <div class="custom-comments-footer custom-comments-editor">
                                        <div class="form-group" style="margin-bottom: 0px;">
                                            <input type="hidden" id="parent-comment-id-{{$value.answersDO.id}}" value="0">
                                            <input type="hidden" id="reviewer-id-{{$value.answersDO.id}}" value="0">
                                            <textarea id="answer-comment-{{$value.answersDO.id}}" class="form-control custom-border-shadow custom-question-comment" rows="1"></textarea>
                                            <button id="comment-answer-btn-{{$value.answersDO.id}}" onclick="postAnswerComment('{{$value.answersDO.id}}');" class="btn btn-primary btn-sm" style="float:right;" type="button">评论</button>
                                        </div>
                                    </div><!-- end comment footer -->
                                </div><!-- end feed comment -->
                            </div>
                        </div><!-- feed detail -->
                    </div><!-- end feed -->
                    {{/each}}
                </script>

                <!-- answer comments template -->
                <script type="text/template" id="answer-comments-template">
                    {{#if isPost}}
                    <!-- comment item -->
                    <div class="custom-comment-item">
                        <div>
                            <div class="custom-commentItem-meta">
                                <span>
                                    <a href="#">
                                        <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>{{user.avatarPath}}" alt="{{user.fullname}}">
                                    </a>
                                </span>
                                <span>
                                    <a class="custom-comment-userLink" href="#">{{user.fullname}}</a>
                                </span>
                                {{#if reviewer}}
                                <span>
                                    <span class="custom-commentItem-reply">回复</span>
                                    <a class="custom-comment-userLink" href="#">{{reviewer.fullname}}</a>
                                </span>
                                {{/if}}
                                <span class="custom-commentItem-time">{{questionCommentsDO.commentTime}}</span>
                            </div>
                            <div class="custom-commentItem-content">
                                {{answerCommentsDO.commentContent}}
                            </div>
                            <div class="custom-commentItem-footer">
                                <button class="custom-btn-plain custom-margin-right20" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                        <span>赞</span>
                                    </span>
                                </button>
                                {{#if reviewer}}
                                <button class="custom-btn-plain custom-margin-right20" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-comment custom-margin-right5"></i>
                                        <span>查看对话</span>
                                    </span>
                                </button>
                                {{/if}}
                                <button class="custom-btn-plain custom-margin-right20" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-share custom-margin-right5"></i>
                                        <span>回复</span>
                                    </span>
                                </button>
                                <button class="custom-btn-plain custom-margin-right20" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-thumbs-down custom-margin-right5"></i>
                                        <span>踩</span>
                                    </span>
                                </button>
                                <button class="custom-btn-plain custom-margin-right20" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-flag custom-margin-right5"></i>
                                        <span>举报</span>
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div><!-- end comment item -->
                    <%--<!-- comment item divider -->--%>
                    <%--<div class="custom-comment-list-divider">--%>
                    <%--<div class="custom-comment-list-dividerLine"></div>--%>
                    <%--<div class="custom-comment-list-dividerText">--%>
                    <%--以上为精选评论--%>
                    <%--<i class="fa fa-question-circle"></i>--%>
                    <%--</div>--%>
                    <%--</div><!-- end comment item divider -->--%>
                    {{else}}
                    {{#each this.list}}
                    <!-- comment item -->
                    <div class="custom-comment-item">
                        <div  onmouseover="showElement(this);" onmouseout="hideElement(this);">
                            <div class="custom-commentItem-meta">
                                <span>
                                    <a href="#">
                                        <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>{{user.avatarPath}}" alt="{{user.fullname}}">
                                    </a>
                                </span>
                                <span>
                                    <a class="custom-comment-userLink" href="#">{{user.fullname}}</a>
                                </span>
                                {{#if reviewer}}
                                <span>
                                    <span class="custom-commentItem-reply">回复</span>
                                    <a class="custom-comment-userLink" href="#">{{reviewer.fullname}}</a>
                                </span>
                                {{/if}}
                                <span class="custom-commentItem-time">{{answerCommentsDO.commentTime}}</span>
                            </div>
                            <div class="custom-commentItem-content">
                                {{answerCommentsDO.commentContent}}
                            </div>
                            <!-- reply comment -->
                            <div id="answerComment-reply-{{answerCommentsDO.id}}" class="hide" style="padding-bottom: 30px;">
                                <div class="form-group">
                                    <input type="hidden" id="parent-comment-id-r-{{answerCommentsDO.id}}" value="{{answerCommentsDO.id}}">
                                    <input type="hidden" id="reviewer-id-r-{{answerCommentsDO.id}}" value="{{user.id}}">
                                    <textarea id="answer-comment-r-{{answerCommentsDO.id}}" class="form-control custom-border-shadow" rows="1" placeholder="回复：{{user.fullname}}" style="font-size: 14px;"></textarea>
                                    <div class="custom-right" style="padding-top: 15px;">
                                        <button id="cancel-reply-{{answerCommentsDO.id}}" onclick="hideAnswerComment('{{answerCommentsDO.id}}');" class="btn btn-default btn-sm">取消</button>
                                        <button id="question-comment-btn-{{answerCommentsDO.id}}" onclick="postAnswerCommentReply('{{answerId}}', '{{answerCommentsDO.id}}');" type="button" class="btn btn-primary btn-sm">评论</button>
                                    </div>
                                </div>
                            </div><!-- end reply comment -->
                            <div class="custom-commentItem-footer" id="answerCommentItem-footer-{{answerCommentsDO.id}}">
                                {{#if like}}
                                <button id="answerComment-like-{{answerCommentsDO.id}}" class="custom-btn-plain custom-margin-right20 custom-is-liked" onclick="likeAnswerComment('{{answerCommentsDO.id}}');" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                        <span>赞</span>
                                    </span>
                                </button>
                                {{else}}
                                <button id="answerComment-like-{{answerCommentsDO.id}}" class="custom-btn-plain custom-margin-right20" onclick="likeAnswerComment('{{answerCommentsDO.id}}');" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                        <span>赞</span>
                                    </span>
                                </button>
                                {{/if}}
                                {{#if reviewer}}
                                <button class="custom-btn-plain custom-margin-right20" type="button">
                                    <span style="display: inline-flex;align-items: center;">
                                        <i class="fa fa-comment custom-margin-right5"></i>
                                        <span>查看对话</span>
                                    </span>
                                </button>
                                {{/if}}
                                <span class="hide comment-hide">
                                    <button onclick="replyAnswerComment('{{answerCommentsDO.id}}')" class="custom-btn-plain custom-margin-right20" type="button">
                                        <span style="display: inline-flex;align-items: center;">
                                            <i class="fa fa-share custom-margin-right5"></i>
                                            <span>回复</span>
                                        </span>
                                    </button>
                                    {{#if unlike}}
                                    <button id="answerComment-unlike-{{answerCommentsDO.id}}" class="custom-btn-plain custom-margin-right20 custom-unlike" onclick="unlikeAnswerComment('{{answerCommentsDO.id}}');" type="button">
                                        <span style="display: inline-flex;align-items: center;">
                                            <i class="fa fa-thumbs-down custom-margin-right5"></i>
                                            <span id="answerComment-unlike-text-{{answerCommentsDO.id}}">取消踩</span>
                                        </span>
                                    </button>
                                    {{else}}
                                    <button id="answerComment-unlike-{{answerCommentsDO.id}}" class="custom-btn-plain custom-margin-right20" onclick="unlikeAnswerComment('{{answerCommentsDO.id}}');" type="button">
                                        <span style="display: inline-flex;align-items: center;">
                                            <i class="fa fa-thumbs-down custom-margin-right5"></i>
                                            <span id="answerComment-unlike-text-{{answerCommentsDO.id}}">踩</span>
                                        </span>
                                    </button>
                                    {{/if}}
                                    <button class="custom-btn-plain custom-margin-right20" type="button">
                                        <span style="display: inline-flex;align-items: center;">
                                            <i class="fa fa-flag custom-margin-right5"></i>
                                            <span>举报</span>
                                        </span>
                                    </button>
                                </span>
                            </div>
                        </div>
                    </div><!-- end comment item -->
                    {{/each}}
                    {{/if}}
                </script><!-- end answer comments template -->

                <script type="text/x-handlebars-template" id="answer-comments-paging-template">

                    <!-- comment pagination -->
                    <div class="custom-pagination">
                        <!-- previous page -->
                        {{#if hasPreviousPage}}
                        <button onclick="answerCommentsWithPage('{{prePage}}', '{{answerId}}');" class="custom-pagination-btn custom-btn-plain" type="button">上一页</button>
                        {{else}}
                        <button onclick="answerCommentsWithPage('{{prePage}}', '{{answerId}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">上一页</button>
                        {{/if}}<!-- end previous page -->

                        <!-- first page -->
                        {{#compare pageNum 1}}
                        <button onclick="answerCommentsWithPage(1, '{{answerId}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">1</button>
                        {{else}}
                        <button onclick="answerCommentsWithPage(1, '{{answerId}}');" class="custom-pagination-btn custom-btn-plain" type="button">1</button>
                        {{/compare}}<!-- end first page -->

                        <!-- navigate page -->
                        {{#if showFirstEllipsis}}
                        <span class="custom-pagination-btn">•••</span>
                        {{/if}}
                        {{#each navigatePageNums}}
                        {{#compare ../pageNum this}}
                        <button onclick="answerCommentsWithPage('{{this}}', '{{../answerId}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">{{this}}</button>
                        {{else}}
                        <button onclick="answerCommentsWithPage('{{this}}', '{{../answerId}}');" class="custom-pagination-btn custom-btn-plain" type="button">{{this}}</button>
                        {{/compare}}
                        {{/each}}
                        {{#if showLastEllipsis}}
                        <span class="custom-pagination-btn">•••</span>
                        {{/if}}<!-- end navigate page -->

                        <!-- last page -->
                        {{#compare pageNum totalPages}}
                        <button onclick="answerCommentsWithPage('{{totalPages}}', '{{answerId}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">{{totalPages}}</button>
                        {{else}}
                        <button onclick="answerCommentsWithPage('{{totalPages}}', '{{answerId}}');" class="custom-pagination-btn custom-btn-plain" type="button">{{totalPages}}</button>
                        {{/compare}}
                        <!-- end last page -->

                        <!-- next page -->
                        {{#if hasNextPage}}
                        <button onclick="answerCommentsWithPage('{{nextPage}}', '{{answerId}}');" class="custom-pagination-btn custom-btn-plain" type="button">下一页</button>
                        {{else}}
                        <button onclick="answerCommentsWithPage('{{nextPage}}', '{{answerId}}');" class="custom-pagination-btn custom-btn-plain custom-pagination-btn-current" type="button">下一页</button>
                        {{/if}}<!-- end next page -->
                    </div><!-- end comment pagination -->
                </script>

                <!-- more -->
                <div id="show_more_btn" class="custom-card hide">
                    <a href="javascript:void(0);" class="custom-question-more">
                        <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                    </a>
                </div><!-- end more -->
                <!-- write answer -->
                <div class="custom-card">
                    <a id="write_answer_bottom" href="javascript:void(0);" class="custom-question-more">
                        <i class="fa fa-pencil"></i> 写答案
                    </a>
                </div><!-- end write answer -->
            </div><!-- end left main feed -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3 custom-sidebar-padding">

            <c:if test="${fromAnswer}">
            <!-- answer author -->
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">关于作者</div>
                </div>
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
            </c:if>

            <!-- similar question -->
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">相关问题</div>
                </div>
                <div class="custom-card-section">
                    <div class="custom-similar-question-item">
                        <a href="" class="">JVM符号引用转换直接引用的过程?</a> 13个回答
                    </div>
                    <div class="custom-similar-question-item">
                        <a href="" class="">JVM符号引用转换直接引用的过程?</a> 13个回答
                    </div>
                    <div class="custom-similar-question-item">
                        <a href="" class="">JVM符号引用转换直接引用的过程?</a> 13个回答
                    </div>
                </div>
            </div><!-- end similar question -->
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
        </div><!-- end sidebar -->
    </div>
    <!-- end answer main -->
</div>

<!-- answer setting click card -->
<div class="custom-display-none" id="answer_setting_panel">
    <input type="hidden" id="reprint_type" value="1">
    <input type="hidden" id="comment_type" value="4">
    <div id="answer_setting_list" class="custom-answerItem-menu">
        <button value="1" type="button" class="custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            允许规范转载
            <i id="reprint_check" class="fa fa-check custom-right custom-check-margin" aria-hidden="true"></i>
        </button>
        <button value="2" type="button" class=" custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            允许付费转载
        </button>
        <button value="3" type="button" class=" custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            禁止转载
        </button>
        <li class="custom-menu-divider"></li>
        <button value="4" type="button" class=" custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            允许任何人评论
            <i id="comment_check" class="fa fa-check custom-right custom-check-margin" aria-hidden="true"></i>
        </button>
        <button value="5" type="button" class=" custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            评论由我筛选后显示
            </button>
        <button value="6" type="button" class=" custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            允许我关注的人评论
        </button>
        <button value="7" type="button" class=" custom-btn-plain custom-menu-item custom-answerItem-selectMenuItem">
            关闭评论
        </button>
    </div>
</div>
<!-- end private message click card -->

<!-- modal -->
<%@include file="anonymousModal.jsp"%>
<%@include file="topicBioModal.jsp"%>
<%@include file="questionCommentsModal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>

<input type="hidden" id="answersPageNum" value="${page.pageNum}">
<input type="hidden" id="answersHasNextPage" value="${page.hasNextPage}">

<script type="text/javascript">
    // 防止重复加载
    let lock = true;
    $(window).scroll(function () {

        let answersPageNum = $('#answersPageNum').val();
        let answersHasNextPage = $('#answersHasNextPage').val();
        let questionId = $('#questionId').val();

        // 获取网页的总高度，主要是考虑兼容性所以把Ie支持的documentElement也写了，这个方法至少支持IE8
        let htmlHeight = $(document).height();
        // clientHeight是网页在浏览器中的可视高度，
        let clientHeight = $(window).height();
        // scrollTop滚动条到顶部的垂直高度
        let scrollTop = $(document).scrollTop();
        // 通过判断滚动条的top位置与可视网页之和与整个网页的高度是否相等来决定是否加载内容；
        let he = scrollTop + clientHeight;

        // 加载缓冲区为 50px
        // page 不为空，即 page.hasNextPage 存在，否则 JSON.parse 会报错
        if (answersHasNextPage.length > 0) {
            if (JSON.parse(answersHasNextPage) && he >= htmlHeight - 50) {
                if (lock) {
                    lock = false;
                    if ($('#default-sort').hasClass('custom-current')) {
                        showMore(questionId, parseInt(answersPageNum) + 1, '/default-more-answers');
                    } else {
                        showMore(questionId, parseInt(answersPageNum) + 1, '/time-more-answers');
                    }
                }
            }
        }
    });
    function showMore(questionId, pageNum, url) {

        let data = {
            questionId: questionId,
            pageNum: pageNum
        };

        $.ajax({
            type:"POST",
            url: basePath2 + url,
            data: data,
            dataType: 'json',
            beforeSend: function() {
                $('#show_more_btn').removeClass('hide');
            },
            success: function(dataRec) {
                $('#show_more_btn').addClass('hide');
                lock = true;

                // console.log(dataRec);

                let data = dataRec['list'];
                let page = dataRec['page'];

                let answersPageNum = $('#answersPageNum').val(page.pageNum);
                let answersHasNextPage = $('#answersHasNextPage').val(page.hasNextPage);

                // json 时间数据格式化
                for (let c = 0; c < data.length; c ++) {
                    data[c]['answersDO']['answerTime'] = getLocalTime(data[c]['answersDO']['answerTime']);
                }

                let html = template("answers-template", {data:data});
                $("#answers-wrapper").append(html);
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log('responseText: ' + jqXHR.responseText);
                console.log('status: ' + jqXHR.status);
                console.log('readyState: ' + jqXHR.readyState);
                console.log('statusText: ' + jqXHR.statusText);

                console.log('textStatus: ' + textStatus);
                console.log('errorThrown: ' + errorThrown);
            }
        })
    }
</script>


</body>
</html>
