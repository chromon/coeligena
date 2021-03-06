<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>首页 - ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络瞎编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="icon" href="./favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="./favicon.ico" type="image/x-icon" />
    <link rel="bookmark" href="./favicon.ico" type="image/x-icon" />

    <!-- css -->
    <%@include file="WEB-INF/views/includeCss.jsp"%>
</head>
<body>

<!-- navbar -->
<%@include file="WEB-INF/views/navbar.jsp"%>

<!-- skeleton screen -->
<div class="container" id="skeleton_screen" style="display: none;">
    <div class="pageContent row custom-content-margin">
        <div class="col-sm-9">
            <div class="custom-card custom-feed-item">
                <div class="skeleton">
                    <div class="skeleton-head"></div>
                    <div class="skeleton-body">
                        <div class="skeleton-title"></div>
                        <div class="skeleton-content"></div>
                    </div>
                    <div class="skeleton-detail"></div>
                    <div class="skeleton-detail2"></div>
                </div>
            </div>
            <div class="custom-card custom-feed-item">
                <div class="skeleton">
                    <div class="skeleton-head"></div>
                    <div class="skeleton-body">
                        <div class="skeleton-title"></div>
                        <div class="skeleton-content"></div>
                    </div>
                    <div class="skeleton-detail"></div>
                    <div class="skeleton-detail2"></div>
                </div>
            </div>
            <div class="custom-card custom-feed-item">
                <div class="skeleton">
                    <div class="skeleton-head"></div>
                    <div class="skeleton-body">
                        <div class="skeleton-title"></div>
                        <div class="skeleton-content"></div>
                    </div>
                    <div class="skeleton-detail"></div>
                    <div class="skeleton-detail2"></div>
                </div>
            </div>
        </div>

        <!-- skeleton scree sidebar -->
        <div class="col-sm-3 custom-sidebar-padding">
            <div class="sidebar_inner">
                <div class="custom-margin-bottom10 custom-feed-item custom-card custom-color-9f">
                    <div class="skeleton">
                        <div class="skeleton-detail" style="margin-top: 10px;"></div>
                        <div class="skeleton-detail" style="width: 55%"></div>
                        <div class="skeleton-detail"></div>
                        <div class="skeleton-detail" style="width: 55%"></div>
                        <div class="skeleton-detail"></div>
                        <div class="skeleton-detail" style="width: 55%"></div>
                    </div>
                </div>
                <div class="custom-margin-bottom10 custom-feed-item custom-card custom-color-9f">
                    <div class="skeleton">
                        <div class="skeleton-detail" style="margin-top: 10px;"></div>
                        <div class="skeleton-detail" style="width: 55%"></div>
                        <div class="skeleton-detail"></div>
                        <div class="skeleton-detail" style="width: 55%"></div>
                        <div class="skeleton-detail"></div>
                        <div class="skeleton-detail" style="width: 55%"></div>
                    </div>
                </div>
            </div>
        </div><!-- end skeleton scree sidebar -->
    </div>
</div><!-- end skeleton screen -->


<!-- main content -->
<div class="container" id="original_page">
    <div class="pageContent row custom-content-margin">
        <div id="centerContent" class="col-sm-9">

            <div class="custom-top-header custom-card">
                <div class="custom-top-header-nav">
                    <a href="" class="custom-top-header-navItem" data-toggle="modal" data-target="#askModal">
                        <i class="fa fa-question-circle-o custom-color-9f custom-margin-right5" aria-hidden="true"></i>
                        提问
                    </a>
                    <a href="" class="custom-top-header-navItem">
                        <i class="fa fa-file-text-o custom-color-9f custom-margin-right5" aria-hidden="true"></i>
                        回答
                    </a>
                    <a href="${pageContext.request.contextPath}/write" class="custom-top-header-navItem">
                        <i class="fa fa-pencil-square-o custom-color-9f custom-margin-right5" aria-hidden="true"></i>
                        写文章
                    </a>
                    <a href="" class="custom-top-header-navItem">
                        <i class="fa fa-lightbulb-o custom-color-9f custom-margin-right5" aria-hidden="true"></i>
                        写想法
                    </a>
                </div>
                <a href="${pageContext.request.contextPath}/draft" class="custom-top-header-navItem-right">草稿（13）</a>
            </div>

            <!-- left main feed -->
            <div>
                <c:if test="${empty feedsDTOList}">
                    <!-- no answers -->
                    <div class="custom-card custom-feed-item custom-answers-none">
                        <div class="custom-empty-state">
                            <div class="custom-empty-state-inner">
                                <i class="fa fa-pencil-square-o fa-5x" aria-hidden="true"></i>
                                <div>
                                    暂时还没有动态
                                </div>
                            </div>
                        </div>
                    </div><!-- end no answers -->
                </c:if>
                <c:forEach var="feedsDTO" items="${feedsDTOList}">
                <div class="custom-card custom-feed-item">
                    <a href="" class="custom-feed-item-right hide">
                        <i class="fa fa-times"></i>
                    </a>
                    <!-- feed -->
                    <div>
                        <!-- feed status -->
                        <div class="custom-feed-src-status">
                            <span>
                                <a href="#">${feedsDTO.usersDO.fullname}</a>
                                <c:if test="${feedsDTO.feedsDO.feedsType == 4}">
                                    添加了问题
                                </c:if>
                                <c:if test="${feedsDTO.feedsDO.feedsType == 1}">
                                    关注了问题
                                </c:if>
                                <c:if test="${feedsDTO.feedsDO.feedsType == 3}">
                                    回答了问题
                                </c:if>
                                <c:if test="${feedsDTO.feedsDO.feedsType == 2}">
                                    赞同了回答
                                </c:if>
                                <!-- collect article -->
                                <!-- 赞同了回答 -->
                                <!-- collect article -->
                                <!-- 回答了问题 -->
                                <!-- collect answer -->
                                <!-- 收藏了回答 -->
                                <!-- collect article -->
                                <!-- 收藏了文章 -->
                            </span>
                            <span> · </span>
                            ${feedsDTO.questionsDO.questionTime}
                        </div><!-- end feed status -->

                        <!-- feed detail -->
                        <div>
                            <h2 class="custom-contentItem-title">
                                <a href="${pageContext.request.contextPath}/question/${feedsDTO.questionsDO.id}">
                                    ${feedsDTO.questionsDO.questionContent}
                                </a>
                            </h2>

                            <!-- feed content -->
                            <div class="custom-rich-content">
                                <c:if test="${feedsDTO.feedsDO.feedsType == 2 || feedsDTO.feedsDO.feedsType == 3}">
                                <div class="custom-rich-content-inner">
                                    ${feedsDTO.answersDO.answerDigest}
                                    <button class="custom-contentItem-more custom-btn-plain" type="button">
                                        <span class="custom-margin-right5">阅读全文</span>
                                        <i class="fa fa-chevron-down"></i>
                                    </button>
                                </div>
                                <div class="custom-contentItem-time">
                                    <a href="#">编辑于 ${feedsDTO.answersDO.answerTime}</a>
                                </div>
                                </c:if>
                                <div>
                                    <div class="custom-contentItem-actions">
                                        <c:if test="${feedsDTO.feedsDO.feedsType == 1 || feedsDTO.feedsDO.feedsType == 4}">
                                        <span>
                                            <button type="button" class="custom-btn btn-outline-primary">关注问题</button>
                                        </span>
                                        </c:if>
                                        <c:if test="${feedsDTO.feedsDO.feedsType == 2 || feedsDTO.feedsDO.feedsType == 3}">
                                            <c:choose>
                                                <c:when test="${feedsDTO.votesDO != null}">
                                                    <c:if test="${feedsDTO.votesDO.voteType == 1}">
                                                        <span>
                                                        <button class="custom-vote-btn is-active" onclick="voteUp(this, '${feedsDTO.answersDO.id}');" aria-label="赞同" type="button">
                                                            <i class="fa fa-caret-up"></i> ${feedsDTO.answersDO.approvalCount}
                                                        </button>
                                                        <button class="custom-vote-btn" onclick="voteDown(this, '${feedsDTO.answersDO.id}');" aria-label="反对" type="button">
                                                            <i class="fa fa-caret-down"></i>
                                                        </button>
                                                        </span>
                                                    </c:if>
                                                    <c:if test="${feedsDTO.votesDO.voteType == 2}">
                                                        <span>
                                                        <button class="custom-vote-btn" onclick="voteUp(this, '${feedsDTO.answersDO.id}');" aria-label="赞同" type="button">
                                                            <i class="fa fa-caret-up"></i> ${feedsDTO.answersDO.approvalCount}
                                                        </button>
                                                        <button class="custom-vote-btn is-active" onclick="voteDown(this, '${feedsDTO.answersDO.id}');" aria-label="反对" type="button">
                                                            <i class="fa fa-caret-down"></i>
                                                        </button>
                                                        </span>
                                                    </c:if>
                                                </c:when>
                                                <c:otherwise>
                                                    <span>
                                                    <button class="custom-vote-btn" onclick="voteUp(this, '${feedsDTO.answersDO.id}');" aria-label="赞同" type="button">
                                                        <i class="fa fa-caret-up"></i> ${feedsDTO.answersDO.approvalCount}
                                                    </button>
                                                    <button class="custom-vote-btn" onclick="voteDown(this, '${feedsDTO.answersDO.id}');" aria-label="反对" type="button">
                                                        <i class="fa fa-caret-down"></i>
                                                    </button>
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                <c:if test="${feedsDTO.feedsDO.feedsType == 1 || feedsDTO.feedsDO.feedsType == 4}">
                                                    ${feedsDTO.questionsDO.commentCount} 条评论
                                                </c:if>
                                                <c:if test="${feedsDTO.feedsDO.feedsType == 2 || feedsDTO.feedsDO.feedsType == 3}">
                                                    ${feedsDTO.answersDO.commentCount} 条评论
                                                </c:if>
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
                                        <c:if test="${feedsDTO.feedsDO.feedsType == 1 || feedsDTO.feedsDO.feedsType == 4}">
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-align-left custom-margin-right5"></i>
                                                ${feedsDTO.questionsDO.answerCount} 个回答
                                            </span>
                                        </button>
                                        </c:if>
                                        <c:if test="${feedsDTO.feedsDO.feedsType == 2 || feedsDTO.feedsDO.feedsType == 3}">
                                            <button class="custom-contentItem-action custom-btn-plain" type="button" data-toggle="modal" data-target="#collectModal">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-star custom-margin-right5"></i>
                                                收藏
                                            </span>
                                            </button>
                                            <c:choose>
                                                <c:when test="${feedsDTO.thanksDO != null}">
                                                    <button onclick="forThanks(this, '${feedsDTO.answersDO.id}');" class="custom-contentItem-action custom-btn-plain already-thanks" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-heart custom-margin-right5"></i>
                                                            <span class="thanks-text">取消感谢</span>
                                                        </span>
                                                    </button>
                                                </c:when>
                                                <c:otherwise>
                                                    <button onclick="forThanks(this, '${feedsDTO.answersDO.id}');" class="custom-contentItem-action custom-btn-plain" type="button">
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
                                                        <c:when test="${feedsDTO.noHelpsDO != null}">
                                                            <li><a href="javascript:void(0);" onclick="noHelp(this, '${feedsDTO.answersDO.id}');" class="no-help">撤销没有帮助</a></li>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <li><a href="javascript:void(0);" onclick="noHelp(this, '${feedsDTO.answersDO.id}');">没有帮助</a></li>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <li><a href="#" data-toggle="modal" data-target="#reportModal">举报</a></li>
                                                    <li><a href="#">不感兴趣</a></li>
                                                </ul>
                                            </div>
                                        </c:if>
                                        <c:if test="${feedsDTO.feedsDO.feedsType == 2 || feedsDTO.feedsDO.feedsType == 3}">
                                        <button class="custom-contentItem-action custom-btn-plain custom-contentItem-right" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <span class="custom-margin-right5">收起</span>
                                                <i class="fa fa-chevron-up"></i>
                                            </span>
                                        </button>
                                        </c:if>
                                    </div>
                                </div>
                            </div><!-- end feed content -->

                        </div><!-- feed detail -->
                    </div>
                    <!-- end feed -->
                </div>
                </c:forEach>
                <!-- feed item -->
                <div class="custom-card custom-feed-item">
                    <a href="" class="custom-feed-item-right">
                        <i class="fa fa-times"></i>
                    </a>
                    <!-- feed -->
                    <div>
                        <!-- feed status -->
                        <div class="custom-feed-src-status">
                            <span>
                                <a href="#">Ellery</a>
                                赞同了回答
                                <!-- collect article -->
                                <!-- 关注了问题 -->
                                <!-- collect article -->
                                <!-- 关注了问题 -->
                                <!-- collect answer -->
                                <!-- 收藏了回答 -->
                                <!-- collect article -->
                                <!-- 收藏了文章 -->
                            </span>
                            <span> · </span>
                            1 小时前
                        </div><!-- end feed status -->

                        <!-- feed author info -->
                        <div class="custom-feed-src-info custom-feed-author-info">
                            <!-- avatar image -->
                            <a href="#" id="user-avatar">
                                <img class="custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                            </a>

                            <div class="custom-author-info-content">
                                <div class="custom-author-info-head">
                                    <a href="#">Ellery</a>
                                </div>
                                <div class="custom-author-info-detail">
                                    <div class="custom-author-badge">
                                        <div class="custom-author-badge-text">
                                            Microsoft Cortana Engineer Oracle Kernel Engineer.
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- end feed author info -->

                        <!-- feed detail -->
                        <div>
                            <h2 class="custom-contentItem-title">
                                <a href="${pageContext.request.contextPath}/question/123">
                                    JVM符号引用转换直接引用的过程?
                                </a>
                            </h2>

                            <!-- feed content -->
                            <div class="custom-rich-content">
                                <div class="custom-answerItem-extraInfo">
                                    <span class="custom-voters">
                                        <a href="">1 人赞同了该回答</a>
                                    </span>
                                </div>
                                <div class="custom-rich-content-inner">
                                    符号引用是只包含语义信息，不涉及具体实现的；而解析（resolve）过后的直接引用则是与具体实现息息相关的。
                                    所以当谈及某个符号引用被resolve成怎样的直接引用时，必须要结合某个具体实现来讨论才行。
                                    <button class="custom-contentItem-more custom-btn-plain" type="button">
                                        <span class="custom-margin-right5">阅读全文</span>
                                        <i class="fa fa-chevron-down"></i>
                                    </button>
                                </div>
                                <div class="custom-contentItem-time">
                                    <a href="#">编辑于 12:23</a>
                                </div>
                                <div>
                                    <div class="custom-contentItem-actions">
                                        <span>
                                            <button class="custom-vote-btn" aria-label="赞同" type="button">
                                                <i class="fa fa-caret-up"></i> 651
                                            </button>
                                            <button class="custom-vote-btn" aria-label="反对" type="button">
                                                <i class="fa fa-caret-down"></i>
                                            </button>
                                        </span>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                8 条评论
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
                                        <button class="custom-contentItem-action custom-btn-plain" type="button" data-toggle="modal" data-target="#collectModal">
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
                                                <li><a href="#" data-toggle="modal" data-target="#reportModal">举报</a></li>
                                                <li><a href="#">不感兴趣</a></li>
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

                            <!-- feed comment -->
                            <div class="custom-comments-container">
                                <div class="custom-comments custom-comments-withPagination">
                                    <!-- comment top bar -->
                                    <div class="custom-comments-topbar">
                                        <div class="custom-comments-topbar-title">
                                            <h2>1 条评论</h2>
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

                                    <!-- comment list -->
                                    <div class="custom-comment-list">
                                        <!-- comment item -->
                                        <div class="custom-comment-item">
                                            <div>
                                                <div class="custom-commentItem-meta">
                                                    <span>
                                                        <a href="#">
                                                            <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                                                        </a>
                                                    </span>
                                                    <span>
                                                        <a class="custom-comment-userLink" href="#">Ellery</a>
                                                    </span>
                                                    <span class="custom-commentItem-time">13 分钟前</span>
                                                </div>
                                                <div class="custom-commentItem-content">
                                                    这不是前端日常么。
                                                </div>
                                                <div class="custom-commentItem-footer">
                                                    <button class="custom-btn-plain custom-margin-right20" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                                            <span>赞</span>
                                                        </span>
                                                    </button>
                                                    <button class="custom-btn-plain custom-margin-right20" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-comment custom-margin-right5"></i>
                                                            <span>查看对话</span>
                                                        </span>
                                                    </button>
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
                                        <div class="custom-comment-item">
                                            <div>
                                                <div class="custom-commentItem-meta">
                                                    <span>
                                                        <a href="#">
                                                            <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                                                        </a>
                                                    </span>
                                                    <span>
                                                        <a class="custom-comment-userLink" href="#">Ellery</a>
                                                    </span>
                                                    <span>
                                                        <span class="custom-commentItem-reply">回复</span>
                                                        <a class="custom-comment-userLink" href="#">Ellery</a>
                                                    </span>
                                                    <span class="custom-commentItem-time">13 分钟前</span>
                                                </div>
                                                <div class="custom-commentItem-content">
                                                    这不是前端日常么。
                                                </div>
                                                <div class="custom-commentItem-footer">
                                                    <button class="custom-btn-plain custom-margin-right20" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                                            <span>赞</span>
                                                        </span>
                                                    </button>
                                                    <button class="custom-btn-plain custom-margin-right20" type="button">
                                                        <span style="display: inline-flex;align-items: center;">
                                                            <i class="fa fa-comment custom-margin-right5"></i>
                                                            <span>查看对话</span>
                                                        </span>
                                                    </button>
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
                                        </div>
                                    </div><!-- end comment list -->
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
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="写下你的评论…">
                                                <span class="input-group-btn">
                                                    <button class="btn btn-primary" type="button">评论</button>
                                                </span>
                                            </div>
                                        </div>
                                    </div><!-- end comment footer -->
                                    <!-- disable comments -->
                                    <div class="question-comments-disableText">
                                        <div>因作者设置，评论已关闭</div>
                                    </div><!-- end disable comments -->
                                </div>
                            </div><!-- feed comment -->
                        </div><!-- feed detail -->
                    </div>
                    <!-- end feed -->
                </div><!-- feed item -->
                <div class="custom-card custom-feed-item">
                    <a href="" class="custom-feed-item-right">
                        <i class="fa fa-times"></i>
                    </a>
                    <!-- feed -->
                    <div>
                        <!-- feed status -->
                        <div class="custom-feed-src-status">
                            <span>
                                <a href="#">Ellery</a>
                                关注了问题
                                <!-- collect article -->
                                <!-- 关注了问题 -->
                                <!-- collect article -->
                                <!-- 关注了问题 -->
                                <!-- collect answer -->
                                <!-- 收藏了回答 -->
                                <!-- collect article -->
                                <!-- 收藏了文章 -->
                            </span>
                            <span> · </span>
                            1 小时前
                        </div><!-- end feed status -->

                        <!-- feed detail -->
                        <div>
                            <h2 class="custom-contentItem-title">
                                <a href="">JVM符号引用转换直接引用的过程?</a>
                            </h2>

                            <!-- feed content -->
                            <div class="custom-rich-content">
                                <div>
                                    <div class="custom-contentItem-actions">
                                        <span>
                                            <button type="button" class="custom-btn btn-outline-primary">关注问题</button>
                                        </span>
                                        <button class="custom-contentItem-action custom-btn-plain" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-comment custom-margin-right5"></i>
                                                8 条评论
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
                                                <i class="fa fa-align-left custom-margin-right5"></i>
                                                20 个回答
                                            </span>
                                        </button>
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
                    </div>
                    <!-- end feed -->
                </div>
            </div><!-- end left main feed -->
            <!-- more -->
            <div class="custom-card">
                <a href="javascript:void(0);" class="custom-question-more">
                    <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                </a>
            </div><!-- end more -->
        </div>

        <!-- sidebar -->
        <%@include file="WEB-INF/views/sidebar.jsp"%>
    </div>
</div>

<!-- js -->
<%@include file="WEB-INF/views/includeJs.jsp"%>
</body>
</html>
