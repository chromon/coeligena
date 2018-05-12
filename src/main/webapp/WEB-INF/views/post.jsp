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
    <title>概率公开课 - ${siteInfoDO.siteName}</title>
    <meta name="description" content="一个真实的网络现编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <!-- css -->
    <%@include file="includeCss.jsp"%>
</head>
<body class="custom-article-bg">

<!-- navbar -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- navbar title -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand custom-title">${siteInfoDO.siteName}</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div><!-- end navbar title -->
        <!-- navbar component auto collapse -->
        <div class="navbar-collapse collapse" id="navbar-main">
            <!-- navbar right -->
            <ul class="nav navbar-nav navbar-right custom-margin-right5">
                <li class="custom-user-info">
                    <button type="button" class="custom-btn btn-outline-primary">
                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        写文章
                    </button>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle custom-column-info" data-toggle="dropdown" role="button" aria-expanded="false">
                        •••
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="">
                                草稿
                            </a>
                        </li>
                        <li>
                            <a href="">
                                我的文章
                            </a>
                        </li>
                        <li>
                            <a href="">
                                专栏 • 发现
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- end navbar right -->
        </div>
    </div>
</div><!-- end navbar -->

<!-- main content -->
<div class="container">
    <div class="row custom-content-margin">
        <div class="col-sm-10 col-sm-offset-1">
            <!-- post -->
            <div class="custom-post-main">
                <!-- post header -->
                <div class="custom-post-header">
                    <h1 class="custom-post-title">概率公开课笔记</h1>
                    <div class="custom-post-author">
                        <div class="custom-post-authorInfo">
                            <span>
                                <a href="#">
                                    <img class="custom-avatar38 custom-authorInfo-avatar" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                                </a>
                            </span>
                            <div class="custom-post-authorInfo-content">
                                <div class="custom-post-authorInfo-head">
                                    <span class="custom-post-authorInfo-name">深度碎片</span>
                                </div>
                                <div class="custom-post-authorInfo-detail">
                                    <div class="custom-authorInfo-badge">
                                        <div class="custom-authorInfo-badgeText">
                                            探索深度学习的Intuition
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="#" class="btn btn-primary">
                            关注专栏
                        </a>
                    </div>
                    <div>
                        <span>
                            <a href="#" class="custom-post-voters">8 人赞了该文章</a>
                        </span>
                    </div>
                </div><!-- end post header -->
                <!-- post content -->
                <div class="custom-post-richText">
                    <p>人工智能，应用广泛功能强大，但被很多人误认为是黑匣子，只因为还没人提出系统理论（很多学者正在努力的理论创作中）；目前虽然没有系统理论，但如果能直观感受到人工智能的“智慧”根基长什么样子，也是件有趣且务实的工作；</p>
                    <p>一种观点：人工智能 = 众多聪明高效算法+强大计算的合体效果；</p>
                </div><!-- end post content -->
                <!-- post time -->
                <div class="custom-postItem-time">
                    <a href="">
                        <span>编辑于 2018-03-22</span>
                    </a>
                </div><!-- end post time -->
                <!-- reward -->
                <div class="custom-reward">
                    <div>
                        <div class="custom-reward-tagline">「真诚赞赏，手留余香」</div>
                        <button class="btn custom-reward-btn" type="button">赞赏</button>
                    </div>
                    <div class="custom-reward-countZero">还没有人赞赏，快来当第一个赞赏的人吧！</div>
                </div><!-- end reward -->
                <!-- post topic -->
                <div class="custom-post-topicsAndReviewer">
                    <div class="custom-topicList custom-post-topics">
                        <div class="custom-tag custom-topic">
                            <a href="">AI芯片</a>
                        </div>
                        <div class="custom-tag custom-topic">
                            <a href="">AI芯片</a>
                        </div>
                        <div class="custom-tag custom-topic">
                            <a href="">AI芯片</a>
                        </div>
                    </div>
                </div><!-- end post topic -->
                <!-- post action -->
                <div class="custom-margin-top20">
                    <div class="custom-contentItem-actions">
                        <span>
                            <button class="custom-vote-btn" aria-label="赞同" type="button">
                                <i class="fa fa-thumbs-up"></i> 651
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
                        <div class="custom-drop-option2">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                                •••
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li><a href="#">举报</a></li>
                            </ul>
                        </div>
                    </div>
                </div><!-- end post action -->
                <!-- post index -->
                <div class="custom-post-index">
                    <div class="custom-block-title">文章被以下专栏收录</div>
                    <!-- post header -->
                    <div class="custom-post-header custom-margin-top20">
                        <div class="custom-post-author">
                            <div class="custom-post-authorInfo">
                                <span>
                                    <a href="#">
                                        <img class="custom-avatar38 custom-authorInfo-avatar" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="Ellery">
                                    </a>
                                </span>
                                <div class="custom-post-authorInfo-content">
                                    <div class="custom-post-authorInfo-head">
                                        <span class="custom-post-authorInfo-name">深度碎片</span>
                                    </div>
                                    <div class="custom-post-authorInfo-detail">
                                        <div class="custom-authorInfo-badge">
                                            <div class="custom-authorInfo-badgeText">
                                                探索深度学习的Intuition
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <a href="#" class="btn btn-primary">
                                关注专栏
                            </a>
                        </div>
                    </div><!-- end post header -->
                </div><!-- end post index -->
                <!-- post comments -->
                <div class="custom-comments-container2">
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
                            <!-- comment item divider -->
                            <div class="custom-comment-list-divider">
                                <div class="custom-comment-list-dividerLine"></div>
                                <div class="custom-comment-list-dividerText">
                                    以上为精选评论
                                    <i class="fa fa-question-circle"></i>
                                </div>
                            </div><!-- end comment item divider -->
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
                                    <input type="text" class="form-control" placeholder="评论由作者筛选后显示">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">评论</button>
                                    </span>
                                </div>
                            </div>
                        </div><!-- end comment footer -->
                    </div>
                </div><!-- end post comments -->
            </div><!-- end post -->
        </div>
    </div>
</div>

<!-- modal -->
<%@include file="userModal.jsp"%>

<!-- back to top -->
<div class="custom-backtotop" id="back_to_top">
    <a class="custom-btn-action" href="">
        <div class="custom-arrow"></div>
        <div class="custom-stick"></div>
    </a>
</div><!-- end back to top -->

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
