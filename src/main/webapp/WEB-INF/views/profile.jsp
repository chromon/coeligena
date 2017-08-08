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
    <title>Bone - 编乎</title>
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

    <!-- home header -->
    <div class="row custom-content-margin">
        <div class="col-sm-12">
            <div class="media custom-story-item custom-card">
                <div class="media-left media-top">
                    <a href="#">
                        <img class="media-object custom-avatar168" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                    </a>
                </div>
                <div class="media-body">
                    <div class="custom-profile-card">
                        <span class="media-heading custom-profile-title">Middlex</span>
                        <span class="custom-profile-text">QWERTYASDFGH</span>
                        <div class="custom-profile-info">
                            <div class="custom-profile-item">
                                <i class="fa fa-briefcase custom-profile-icon" aria-hidden="true"></i>
                                business
                                <div class="custom-profile-driver"></div>
                                company
                                <div class="custom-profile-driver"></div>
                                position
                            </div>
                            <div class="custom-profile-item">
                                <i class="fa fa-graduation-cap custom-profile-icon" aria-hidden="true"></i>
                                school
                                <div class="custom-profile-driver"></div>
                                major
                                <div class="custom-profile-driver"></div>
                                <i class="fa fa-mars" aria-hidden="true"></i>
                            </div>
                            <div class="custom-profile-item">
                                <i class="fa fa-quote-left fa-2x custom-profile-icon" aria-hidden="true"></i>
                                Personal profile
                                <a href="#" class="btn btn-primary custom-right">编辑个人资料</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- end home header -->

    <!-- answer main -->
    <div class="row custom-margin-top20">
        <div class="col-sm-9">
            <ul class="nav nav-tabs custom-story-item custom-card">
                <li class="active"><a href="#activities" data-toggle="tab">动态</a></li>
                <li><a href="#answers" data-toggle="tab">回答</a></li>
                <li><a href="#asks" data-toggle="tab">提问</a></li>
                <li><a href="#columns" data-toggle="tab">专栏</a></li>
                <li><a href="#collections" data-toggle="tab">收藏</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        更多 <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#shares" data-toggle="tab">分享</a></li>
                        <li class="divider"></li>
                        <li><a href="#following" data-toggle="tab">关注</a></li>
                    </ul>
                </li>
            </ul>
            <div id="myTabContent" class="tab-content">

                <!-- activities tab -->
                <div class="tab-pane fade active in" id="activities">
                    <ul class="media-list">
                        <li id="feed-item-1" class="media custom-story-item custom-card">
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
                                    <span class="custom-close custom-right"><i class="fa fa-times"></i></span>
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
                                    Systematic design of program analysis frameworks， P. Cousot & R. Cousot 1979
                                </div>

                                <!-- answer date -->
                                <p class="custom-edit-time">
                                    <a href="#">编辑于 12:23</a>
                                </p>

                                <!-- feed meta -->
                                <div class="custom-meta-panel">
                                    <a href="#" class="custom-meta-item">
                                        <i class="fa fa-plus"></i>
                                        关注问题
                                    </a>
                                    <a href="#comment" data-toggle="collapse" class="custom-meta-item">
                                        <i class="fa fa-comment"></i>
                                        添加评论
                                    </a>

                                    <!-- collapse meta item -->
                                    <div class="custom-collapse-item">
                                        <a href="#" class="custom-meta-item">
                                            <i class="fa fa-heart"></i>
                                            感谢
                                        </a>
                                        <a href="#" class="custom-meta-item">
                                            <i class="fa fa-paper-plane"></i>
                                            分享
                                        </a>
                                        <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#collectModal">
                                            <i class="fa fa-star"></i>
                                            收藏
                                        </a>
                                        <span class="custom-bull">•</span>
                                        <a href="#" class="custom-meta-item">
                                            没有帮助
                                        </a>
                                        <span class="custom-bull">•</span>
                                        <a href="#" class="custom-meta-item" data-toggle="modal" data-target="#reportModal">
                                            举报
                                        </a>
                                    </div>

                                    <span class="custom-bull">•</span>
                                    <a href="#" class="custom-meta-item">
                                        作者保留权利
                                    </a>
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
                    </ul>
                </div>
                <!-- activities tab -->


                <div class="tab-pane fade" id="answers">
                    <p>answers</p>
                </div>
                <div class="tab-pane fade" id="asks">
                    <p>asks</p>
                </div>
                <div class="tab-pane fade" id="columns">
                    <p>columns</p>
                </div>
                <div class="tab-pane fade" id="collections">
                    <p>collections</p>
                </div>
                <div class="tab-pane fade" id="shares">
                    <p>shares</p>
                </div>
                <div class="tab-pane fade" id="following">
                    <p>following</p>
                </div>
            </div>
        </div>

        <!-- sidebar -->
        <div class="col-sm-3">

            <div class="list-group custom-list-group custom-story-item custom-card">
                <div class="custom-list-title custom-color-9f">个人成就</div>
                <a href="#" class="list-group-item custom-group-item">
                    <i class="fa fa-pencil-square-o" aria-hidden="true"></i> 参与 11 次公共编辑
                </a>
            </div>


            <div class="custom-number-board custom-story-item custom-card">
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">关注了</div>
                    <div class="custom-number-board-value">125</div>
                </a>
                <a href="#" class="custom-button custom-number-board-item custom-button-plain">
                    <div class="custom-number-board-name">关注者</div>
                    <div class="custom-number-board-value">2525</div>
                </a>
            </div>

            <div class="list-group custom-list-group custom-story-item custom-card">
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge">8</span>关注的话题
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge">0</span>关注的专栏
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge">13</span>关注的问题
                </a>
                <a href="#" class="list-group-item custom-group-item">
                    <span class="badge">0</span>关注的收藏夹
                </a>
            </div>
            <div class="custom-footer custom-story-item custom-card">
                <a href="#">个人主页被浏览 2254 次</a>
            </div>
            <div class="custom-footer custom-padding-top10 custom-padding-left5">
                <a href="#">编乎指南 • </a>
                <a href="#">建议反馈 • </a>
                <a href="#">移动应用 • </a>
                <a href="#">加入编乎</a>
                <a href="#">编乎协议 • </a>
                <a href="#">举报投诉 • </a>
                <a href="#">联系我们</a><br/>
                <a href="#">&copy;2017</a>
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
