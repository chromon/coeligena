<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bone - ${siteInfoDO.siteName}</title>
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

<!-- main content -->
<div class="container">

    <!-- prefile header -->
    <div class="row custom-content-margin">
        <div class="col-sm-12">
            <div class="custom-card">
                <div class="custom-profileHeader-userCover">
                    <%--<div class="custom-user-cover custom-color-block"></div>--%>
                    <div class="custom-user-cover">
                        <img class="custom-userCover-img" src="<%=request.getContextPath()%>/resources/images/logo/usercover.jpg" alt="用户封面">
                    </div>
                </div>
                <div class="custom-profileHeader-userWrapper">
                    <div class="custom-profileHeader-main">
                        <div class="custom-user-avatar custom-profileHeader-avatar" style="top: -25px;">
                            <img class="custom-avatar160 custom-user-avatar-inner" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                        </div>
                        <div class="custom-profileHeader-content">
                            <div class="custom-profileHeader-contentHead">
                                <h1 class="custom-profileHeader-title">
                                    <span class="custom-profileHeader-name">Bone</span>
                                    <span class="custom-profileHeader-headline">人的观点，是随着现实而改变的...</span>
                                </h1>
                            </div>
                            <div class="custom-profileHeader-contentBody">
                                <div class="custom-profileHeader-info">
                                    <div class="custom-profileHeader-infoItem">
                                        <div class="custom-profileHeader-iconWrapper">
                                            <i class="fa fa-briefcase custom-profile-icon" aria-hidden="true"></i>
                                        </div>
                                        互联网
                                        <div class="custom-profileHeader-divider"></div>
                                        自由职业
                                        <div class="custom-profileHeader-divider"></div>
                                        你猜
                                    </div>
                                    <div class="custom-profileHeader-infoItem">
                                        <div class="custom-profileHeader-iconWrapper">
                                            <i class="fa fa-graduation-cap" aria-hidden="true"></i>
                                        </div>
                                        XX大学
                                        <div class="custom-profileHeader-divider"></div>
                                        软件工程
                                        <div class="custom-profileHeader-divider"></div>
                                        <div class="custom-profileHeader-iconWrapper">
                                            <i class="fa fa-mars" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="custom-profileHeader-footer">
                                <button class="custom-contentItem-more custom-btn-plain" type="button">
                                    <i class="fa fa-chevron-down" style="margin-right: 12px;"></i>
                                    <span>查看详细资料</span>
                                </button>
                                <div class="custom-member-btn-group custom-profileHeader-btns">
                                    <button class="btn btn-primary" type="button">
                                        <span style="display: inline-flex; align-items: center;">
                                            <i class="fa fa-plus" style="margin-right: 8px;"></i>
                                            关注
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
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end profile header -->

    <!-- profile main -->
    <div class="row">
        <div class="col-sm-9">
            <div class="custom-story-item custom-card">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#activities" data-toggle="tab">动态</a></li>
                    <li><a href="#answers" data-toggle="tab">回答 25</a></li>
                    <li><a href="#asks" data-toggle="tab">提问 15</a></li>
                    <li><a href="#posts" data-toggle="tab">文章 8</a></li>
                    <li><a href="#columns" data-toggle="tab">专栏 4</a></li>
                    <li><a href="#pins" data-toggle="tab">想法 158</a></li>
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            更多 <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#collections" data-toggle="tab">收藏</a></li>
                            <li class="divider"></li>
                            <li><a href="#following" data-toggle="tab">关注</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="tab-content">
                    <!-- activities tab -->
                    <div class="tab-pane fade active in" id="activities">
                        <!-- tab list header -->
                        <div class="custom-list-header">
                            <h6 class="custom-list-headerText">他的动态</h6>
                            <div class="custom-list-headerOptions">
                                <button class="custom-btn-plain custom-contentItem-right" type="button" style="display: inline-block">
                                <span style="align-items: center;">
                                    <i class="fa fa-exchange"></i>
                                    <span>切换为时间排序</span>
                                </span>
                                </button>
                            </div>
                        </div><!-- end tab list header -->
                        <!-- feed item -->
                        <div class="custom-feed-item">
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
                                        <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
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
                            </div>
                            <!-- end feed -->
                        </div><!-- feed item -->
                    </div><!-- end activities tab -->

                    <div class="tab-pane fade" id="answers">
                        <p>answers</p>
                    </div>
                    <div class="tab-pane fade" id="asks">
                        <p>asks</p>
                    </div>
                    <div class="tab-pane fade" id="posts">
                        <p>posts</p>
                    </div>
                    <div class="tab-pane fade" id="columns">
                        <p>columns</p>
                    </div>
                    <div class="tab-pane fade" id="pins">
                        <p>pins</p>
                    </div>
                    <div class="tab-pane fade" id="collections">
                        <p>collections</p>
                    </div>
                    <div class="tab-pane fade" id="following">
                        <p>following</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- sidebar -->
        <div class="col-sm-3 custom-sidebar-padding custom-profile-sideColumn">
            <div class="custom-card">
                <div class="custom-card-header">
                    <div class="custom-card-headerText">个人成就</div>
                </div>
                <div class="custom-profile-sideColumnItems">
                    <div class="custom-profile-sideColumnItem">
                        <div class="custom-icon-graf">
                            <div class="custom-icon-graf-wrapper">
                                <i class="fa fa-industry" aria-hidden="true"></i>
                            </div>
                            <span>${siteInfoDO.siteName}收录</span>
                            <a href="" class="custom-sidebar-color">11 个回答</a>
                        </div>
                        <div class="custom-profile-sideColumnItemValue">
                            ${siteInfoDO.siteName}周刊收录
                        </div>
                    </div>
                    <div class="custom-profile-sideColumnItem">
                        <div class="custom-icon-graf">
                            <div class="custom-icon-graf-wrapper">
                                <i class="fa fa-thumbs-up" aria-hidden="true"></i>
                            </div>
                            <span>获得 3,233 次赞同</span>
                        </div>
                        <div class="custom-profile-sideColumnItemValue">
                            <span>获得 1,233 次感谢，1833次收藏</span>
                        </div>
                    </div>
                    <div class="custom-profile-sideColumnItem">
                        <div class="custom-icon-graf">
                            <div class="custom-icon-graf-wrapper">
                                <i class="fa fa-pencil-square" aria-hidden="true"></i>
                            </div>
                            <a href="" class="custom-sidebar-color">参与 82 次公共编辑</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="custom-number-board custom-story-item custom-card">
                <div class="NumberBoard QuestionFollowStatus-counts custom-center">
                    <button class="Button NumberBoard-item Button--plain" type="button" data-reactid="95">
                        <div class="NumberBoard-itemInner">
                            <span class="NumberBoard-name" data-reactid="96">关注了</span>
                            <span class="NumberBoard-value" data-reactid="97">738</span>
                        </div>
                    </button>
                    <div class="NumberBoard-divider" data-reactid="98"></div>
                    <div class="NumberBoard-item" data-reactid="99">
                        <div class="NumberBoard-itemInner">
                            <div class="NumberBoard-name" data-reactid="100">关注者</div>
                            <div class="NumberBoard-value" data-reactid="101">4945</div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <a href="" class="list-group-item custom-group-item">
                    <span class="badge custom-badge">8</span>
                    关注的话题
                </a>
                <a href="" class="list-group-item custom-group-item">
                    <span class="badge custom-badge">33</span>
                    关注的专栏
                </a>
                <a href="" class="list-group-item custom-group-item">
                    <span class="badge custom-badge">143</span>
                    关注的问题
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge custom-badge">13</span>
                    关注的收藏夹
                </a>
            </div>
            <div class="custom-footer custom-story-item custom-card custom-center">
                <a href="#">屏蔽用户</a> •
                <a href="#">举报用户</a>
            </div>
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
            </div>
        </div><!-- end sidebar -->
    </div>
    <!-- end profile main -->
</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
