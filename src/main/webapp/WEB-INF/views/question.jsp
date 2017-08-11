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
    <title>当你迷茫的时候，你应该做些什么？- 编乎</title>
    <meta name="description" content="一个真实的网络现编社区，帮助你寻找答案，分享知识。">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/favicon.ico" type="image/x-icon">

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap-paper.min.css" media="screen">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/custom.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugin/webui-popover/jquery.webui-popover.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugin/jquery-labelauty/jquery-labelauty.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/plugin/summernote/summernote.css">
</head>
<body>
<!-- navbar -->
<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- navbar title -->
        <div class="navbar-header">
            <a href="#" class="navbar-brand custom-title">编乎</a>
            <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>

        <!-- navbar component auto collapse -->
        <div class="navbar-collapse collapse" id="navbar-main">
            <!-- navbar left -->
            <ul class="nav navbar-nav custom-navbar">
                <li>
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="#">话题</a>
                </li>
                <li>
                    <a href="#">发现</a>
                </li>
                <li>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control input-sm" size="40" placeholder="搜索你感兴趣的内容...">
                            <span class="input-group-btn">
                                    <button class="btn btn-primary btn-sm" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                        </div>
                    </form>
                </li>
                <li>
                    <form class="navbar-form navbar-left" >
                        <div class="input-group">
                            <button class="btn btn-primary btn-sm custom-ask-btn" data-toggle="modal" data-target="#askModal">提问</button>
                        </div>
                    </form>
                </li>
            </ul>

            <!-- navbar right -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a class="custom-nav-icon" href="#">
                        <i class="fa fa-bell"></i>
                    </a>
                </li>
                <li>
                    <a class="custom-nav-icon" href="#">
                        <i class="fa fa-comments"></i>
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle custom-user-info" data-toggle="dropdown" role="button" aria-expanded="false">
                        <img class="custom-avatar30" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="#"><i class="fa fa-user-o custom-menu-mright "></i> 我的主页</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-envelope-o custom-menu-mright"></i> 私信</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-cog custom-menu-mright"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-power-off custom-menu-mright"></i> 退出</a>
                        </li>
                    </ul>
                </li>
            </ul><!-- end navbar right -->
        </div>
    </div>
</div><!-- navbar -->

<!-- main content -->
<div class="container">

    <div class=" custom-card custom-story-item">
        <!-- question header -->
        <div class="row custom-content-margin">
            <!-- question header main -->
            <div class="col-sm-9">
                <!-- tag -->
                <div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                    <div class="custom-tag custom-question-topic">
                        <a href="">标签</a>
                    </div>
                </div>

                <!-- question title -->
                <div class="custom-question-title">
                    当你迷茫的时候，你应该做些什么？
                </div>

                <!-- question detail -->
                <div class="custom-question-rich-text">
                    当你迷茫的时候，你应该做些什么？
                </div>

            </div>
            <!-- end question header main -->

            <!-- question header right-->
            <div class="custom-number-board col-sm-3">
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">关注者</div>
                    <div class="custom-number-board-value">125</div>
                </a>
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">被浏览</div>
                    <div class="custom-number-board-value">25125</div>
                </a>
            </div>
            <!-- end question header right -->
        </div>
        <!-- end question header -->

        <div class="row custom-question-footer">

            <!-- question feed meta -->
            <div class="custom-meta-panel col-sm-9">
                <a href="#" class="custom-meta-item">
                    <i class="fa fa-comment"></i>
                    9条评论
                </a>
                <a href="#comment" data-toggle="collapse" class="custom-meta-item">
                    <i class="fa fa-paper-plane"></i>
                    分享
                </a>
                <a href="#" class="custom-meta-item">
                    <i class="fa fa-star"></i>
                    邀请回答
                </a>
                <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#reportModal">
                    <i class="fa fa-flag"></i>
                    举报
                </a>

                <div class="btn-group custom-margin-left10">
                    <a href="#" class="custom-meta-item dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        •••
                    </a>
                    <ul class="dropdown-menu" role="menu">
                        <li>
                            <a href="#" class="custom-meta-item">使用匿名身份</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/question/123/log" class="custom-meta-item">查看问题日志</a>
                        </li>
                        <li>
                            <a href="#" class="custom-meta-item">关注问题</a>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="col-sm-3 custom-question-footer-right">
                <a href="#" class="btn btn-primary">
                    关注问题
                </a>
                <a href="#" class="btn btn-default">
                    <i class="fa fa-pencil"></i>
                    写答案
                </a>
            </div>
        </div>
    </div>

    <!-- answer main -->
    <div class="row custom-margin-top20">
        <div class="col-sm-9">

            <div class="custom-card">
                <a href="" class="custom-question-more">查看全部3287个回答</a>
            </div>

            <!-- left main feed -->
            <ul class="media-list">

                <li id="answer" class="media custom-card custom-story-item">
                    <div class="media-left media-top">

                        <!-- avatar image -->
                        <a href="#" id="user-avatar">
                            <img class="media-object custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                        </a>

                        <!-- votebar -->
                        <div class="custom-votebar">
                            <button class="custom-up" title="赞同">
                                <i class="fa fa-caret-up custom-vote-arrow"></i>
                                <span class="custom-count">122</span>
                            </button>
                            <button class="custom-down" title="反对，不会显示你的姓名">
                                <i class="fa fa-caret-down custom-vote-arrow"></i>
                            </button>
                        </div>
                    </div>
                    <div class="media-body">
                        <!-- agree with article -->
                        <!-- <div class="custom-feed-source">
                            <a href="#">Ellery</a>
                            赞了
                            <a href="#">ABC</a>
                            中的文章
                            <span class="custom-bull">•</span>
                            <span>57分钟前</span>
                            <span class="custom-close custom-right"><i class="fa fa-times"></i></span>
                        </div> -->

                        <!-- agree with answer  -->
                        <div class="custom-feed-source">
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

                            <span class="custom-bull">•</span>
                            <span>57分钟前</span>
                            <a href="#" class="custom-close custom-right">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>

                        <!-- question title -->
                        <a href="#">
                            <h4 class="media-heading custom-media-heading">
                                当你迷茫的时候，你应该做些什么？
                            </h4>
                        </a>

                        <!-- author info -->
                        <div class="custom-name">
                            <a href="#" class="">Ellery</a>
                            ，
                            <span class="custom-bio">中央处理器 (CPU)</span>
                        </div>

                        <!-- answer content -->
                        <div>Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，P. Cousot & R. Cousot 1977
                            Automatic discovery of linear restraints among variables of a program，P. Cousot & N. Halbwachs 1978
                            Systematic design of program analysis frameworks， P. Cousot & R. Cousot 1979Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，P. Cousot & R. Cousot 1977
                            Automatic discovery of linear restraints among variables of a program，P. Cousot & N. Halbwachs 1978
                            Systematic design of program analysis frameworks， P. Cousot & R. Cousot 1979Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，P. Cousot & R. Cousot 1977
                        </div>

                        <!-- answer date -->
                        <p class="custom-edit-time">
                            <a href="#">编辑于 12:23</a>
                        </p>

                        <!-- feed meta -->
                        <div class="custom-meta-panel">
                            <a href="#comment" data-toggle="collapse" class="custom-meta-item">
                                <i class="fa fa-comment"></i>
                                添加评论
                            </a>
                            <a href="#" class="custom-meta-item">
                                <i class="fa fa-paper-plane"></i>
                                分享
                            </a>
                            <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#collectModal">
                                <i class="fa fa-star"></i>
                                收藏
                            </a>
                            <a href="#" class="custom-meta-item">
                                <i class="fa fa-heart"></i>
                                感谢
                            </a>
                            <a href="#" id="more_point" class="custom-meta-item">
                                •••
                            </a>
                            <div class="custom-collapse-item">
                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    没有帮助
                                </a>
                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#reportModal">
                                    举报
                                </a>
                                <span class="custom-bull">•</span>
                                <a href="#" class="custom-meta-item">
                                    作者保留权利
                                </a>
                            </div>
                            <a href="#" class="custom-meta-item custom-right">
                                <i class="fa fa-chevron-circle-up"></i>
                                收起
                            </a>
                        </div>

                        <!-- comment -->
                        <div id="comment" class="panel panel-default custom-panel collapse">
                            <div class="panel-body custom-panel-body">
                                <ul class="media-list">
                                    <li class="media custom-bottom-border">
                                        <div class="media-left">
                                            <a href="#">
                                                <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                            <a href="#" class="custom-comment-name">
                                                Ellery
                                            </a>
                                            <span class="custom-time custom-right">4小时前</span>
                                            <div>
                                                Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints，
                                            </div>

                                            <!-- feed meta -->
                                            <div class="custom-meta-panel custom-bottom-border">
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-thumbs-up"></i>
                                                    赞
                                                </a>
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-share"></i>
                                                    回复
                                                </a>
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-thumbs-down"></i>
                                                    踩
                                                </a>
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-flag"></i>
                                                    举报
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="media custom-bottom-border">
                                        <div class="media-left">
                                            <a href="#">
                                                <img class="media-object custom-avatar24" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                            </a>
                                        </div>
                                        <div class="media-body">
                                            <a href="#" class="custom-comment-name">
                                                Ellery
                                            </a>
                                            <span class="custom-time custom-right">4小时前</span>
                                            <div>
                                                Abstract interpretation: a unified lattice model for static analysis of programs by construction or a pp ro ximation of fixpoints，
                                            </div>

                                            <!-- feed meta -->
                                            <div class="custom-meta-panel">
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-thumbs-up"></i>
                                                    赞
                                                </a>
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-share"></i>
                                                    回复
                                                </a>
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-thumbs-down"></i>
                                                    踩
                                                </a>
                                                <a href="#" class="custom-meta-item">
                                                    <i class="fa fa-flag"></i>
                                                    举报
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="media">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="写下你的评论……">
                                            <span class="input-group-btn">
                                                    <button class="btn btn-primary" type="button">回复</button>
                                                </span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div><!-- end comment -->
                    </div>
                </li>

                <li class="media">
                    <!-- <a href="#" class="btn btn-default btn-md btn-block">加载更多</a> -->
                    <a href="#" class="btn btn-default btn-md btn-block">
                        <i class="fa fa-spinner fa-spin" aria-hidden="true"></i>
                    </a>
                </li>

                <!-- author info -->
                <li class="media custom-card custom-story-item">
                    <div class="media-left media-top">
                        <!-- avatar image -->
                        <a href="#">
                            <img class="media-object custom-avatar38" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                        </a>
                    </div>

                    <div class="media-body">
                        <!-- author info -->
                        <div class="custom-name">
                            <a href="#" class="">Ellery</a>
                            <span class="custom-right">
                                    使用匿名身份回答
                                </span><br/>
                            <span class="custom-bio">中央处理器 (CPU)</span>
                        </div>
                    </div>
                </li>

                <li class="media custom-card">
                    <div id="summernote">Hello Summernote</div>
                </li>

            </ul><!-- end left main feed -->
        </div>

        <!-- sidebar -->
        <div class="col-sm-3">

            <div class="media custom-card custom-story-item">

                <div class="custom-card-header custom-answerAuthor-title">
                    <div class="custom-card-headerText">关于作者</div>
                </div>

                <div class="custom-margin-top10 custom-padding-bottom10">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object custom-avatar60" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                        </a>
                    </div>
                    <div class="media-body">
                        <h5 class="media-heading">Ellery</h5>
                        <div class="custom-answer-info">
                            啊咧，不清楚的喵
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
                        <div class="custom-number-board-name">文章</div>
                        <div class="custom-number-board-value">125</div>
                    </a>
                    <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                        <div class="custom-number-board-name">关注者</div>
                        <div class="custom-number-board-value">125</div>
                    </a>
                </div>
                <div class="custom-hovercard-btn2">
                    <a href="#" class="btn btn-primary custom-margin-right5">
                        <i class="fa fa-plus"></i>
                        关注TA
                    </a>
                    <a href="#" class="btn btn-default">
                        <i class="fa fa-comments"></i>
                        发私信
                    </a>
                </div>
            </div>

            <div class="list-group custom-list-group custom-margin-bottom10 custom-story-item custom-card custom-color-9f">
                <div class="custom-list-title custom-color-9f">相关问题</div>
                <div class="custom-similar-question">
                    <a href="#">
                        活了这么久，你懂得了什么使你改变？
                    </a>
                    <span>30个回答</span>
                </div>
                <div class="custom-similar-question">
                    <a href="#">
                        美国私立大学的钱从哪里来？
                    </a>
                    <span>52个回答</span>
                </div>
                <div class="custom-similar-question">
                    <a href="#">
                        美国选举会避亲吗？
                    </a>
                    <span>3个回答</span>
                </div>
            </div>
            <div class="custom-footer custom-padding-top10 custom-padding-left5">
                <a href="#" target="_blank">编乎指南 • </a>
                <a href="#" target="_blank">建议反馈 • </a>
                <a href="#" target="_blank">移动应用 • </a>
                <a href="#" target="_blank">加入编乎</a>
                <a href="#" target="_blank">编乎协议 • </a>
                <a href="#" target="_blank">举报投诉 • </a>
                <a href="#" target="_blank">联系我们</a><br/>
                <a href="#" target="_blank">&copy;2017</a>
            </div>
        </div><!-- end sidebar -->
    </div>
    <!-- end answer main -->
</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>
</body>
</html>
