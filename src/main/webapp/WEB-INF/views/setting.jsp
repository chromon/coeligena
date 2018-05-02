<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/7
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>账号设置 - ${siteInfoDO.siteName}</title>
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

    <div class="row custom-content-margin custom-font-size14">
        <div class="col-sm-12">
            <div class="custom-card">
                <!-- setting tab -->
                <ul class="nav nav-tabs custom-feed-item">
                    <li class="active"><a href="#profile" data-toggle="tab">基本资料</a></li>
                    <li><a href="#account" data-toggle="tab">账号和密码</a></li>
                    <li><a href="#notification" data-toggle="tab">消息和邮件</a></li>
                    <li><a href="#filter" data-toggle="tab">屏蔽</a></li>
                    <li><a href="#lab" data-toggle="tab">实验室</a></li>
                </ul><!-- end setting tab -->
                <!-- setting content -->
                <div id="myTabContent" class="tab-content">
                    <!-- profile tab content -->
                    <div class="tab-pane fade active in" id="profile">
                        <div class="custom-setting-section">
                            <div class="custom-setting-item">
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">姓名</label>
                                        <div class="col-sm-10 custom-align-bottom">
                                            <%--<input type="text" class="form-control custom-input-width" id="inputName" disabled="" placeholder="Bone">--%>
                                            <%--<span class="help-block">180 天只能修改一次</span>--%>
                                            <span>Bone</span>
                                            <button class="custom-btn-plain custom-edit-btn" type="button">
                                                <span style="display: inline-flex; align-items: center;">
                                                    <i class="fa fa-pencil custom-margin-right2"></i>
                                                    <span>修改</span>
                                                </span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">个性域名</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control custom-input-width" placeholder="ellery">
                                            <span class="custom-edit-btn">只能修改一次</span>
                                            <span class="help-block"> 例：xxx.com/people/ellery</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">隐私保护</label>
                                        <div class="col-lg-10">
                                            <div class="checkbox custom-font-size14">
                                                <label>
                                                    <input type="checkbox">
                                                    在站外搜到我在${siteInfoDO.siteName}创作的内容时，我的姓名将不会被显示
                                                </label>
                                                <span class="help-block">
                                                    <a href="">什么情况下应该使用这个选项？</a>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-2">
                                            <button type="submit" class="btn btn-primary">保存</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div><!-- end profile tab content -->
                    <!-- account tab content -->
                    <div class="tab-pane fade" id="account">
                        <div class="custom-setting-section">
                            <div class="custom-setting-item">
                                <form class="form-horizontal">
                                    <p class="custom-margin-left20 custom-settings-section-desc">绑定手机和邮箱，并设置密码，帐号更安全。</p>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">邮箱</label>
                                        <div class="col-sm-10 custom-form-padding">
                                            <span>all***@msn.com</span>
                                            <a href="#" data-toggle="modal" data-target="#setEmailModal">修改</a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">手机</label>
                                        <div class="col-sm-10 custom-form-padding">
                                            <a href="">绑定手机</a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-2 control-label">账号密码</label>
                                        <div class="col-lg-10 custom-form-padding">
                                            <a href="">修改密码</a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">社交账号</label>
                                        <div class="col-sm-10 custom-form-padding">
                                            <a href="" class="custom-margin-right10">
                                                <i class="fa fa-weixin" aria-hidden="true"></i> 绑定微信
                                            </a>
                                            <a href="" class="custom-margin-right10">
                                                <i class="fa fa-weibo" aria-hidden="true"></i> 绑定微博
                                            </a>
                                            <a href="">
                                                <i class="fa fa-qq" aria-hidden="true"></i> 绑定QQ
                                            </a>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-2">
                                            <button type="submit" class="btn btn-primary">保存</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div><!-- end account tab content -->
                    <!-- notification tab content -->
                    <div class="tab-pane fade" id="notification">
                        <div class="custom-setting-section">
                            <div class="custom-setting-item">
                                <form class="form-horizontal">
                                    <h5 class="custom-margin-left20">私信设置</h5>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">有人给我发了私信</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios1" value="option1" checked="">
                                                    允许所有人给我发私信
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios1" value="option2">
                                                    只允许我关注的人给我发私信
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">
                                                    开启陌生人私信箱
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox" checked="">
                                                    有私信时邮件提醒我
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                    <h5 class="custom-margin-left20">消息设置</h5>
                                    <p class="custom-margin-left20">你可以在这里设置接收的消息类型。「邀请我回答问题」和「关注的问题有了新回答」不支持关闭消息。</p>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">邀请我回答问题</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios2" value="option3" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios2" value="option4">
                                                    只接收关注人的消息
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">
                                                    有消息时邮件提醒我
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">关注的问题有了新回答</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios3" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios3" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                            </div>
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"  checked="">
                                                    获取你接收消息范围内的全部新回答通知，即便这些回答质量可能不够高。
                                                    <a href="">选中这个会发生什么？</a>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">关注的专栏有了新文章</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios4" value="option5" checked="">
                                                    接收消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios4" value="option6">
                                                    不接收消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">关注的人出版了电子书</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios5" value="option5" checked="">
                                                    接收消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios5" value="option6">
                                                    不接收消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">@ / 评论我</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios6" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios6" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios6" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">赞同 / 感谢我的回答</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios7" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios7" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios7" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">赞了我的评论</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios8" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios8" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios8" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">赞了我的文章</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios9" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios9" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios9" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">赞了我的电子书</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios10" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios10" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios10" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">赞赏了我的文章</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios11" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios11" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios11" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">有人关注了我</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios12" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios12" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios12" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>

                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox"  checked="">
                                                    有消息时邮件提醒我
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">有人关注了我的专栏</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios13" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios13" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios13" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">有人关注了我的收藏夹</label>
                                        <div class="col-sm-10">
                                            <div class="radio">
                                                <label class="custom-margin-right10">
                                                    <input type="radio" name="optionsRadios14" value="option5" checked="">
                                                    接收所有人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios14" value="option6">
                                                    只接收关注人的消息
                                                </label>
                                                <label>
                                                    <input type="radio" name="optionsRadios14" value="option6">
                                                    不接收任何人的消息
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                    <h5 class="custom-margin-left20">邮件设置</h5>
                                    <p class="custom-margin-left20">你可以在这里设置是否接收来自${siteInfoDO.siteName}的邮件。</p>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">${siteInfoDO.siteName}每周精选</label>
                                        <div class="col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">
                                                    接收每周精选邮件
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">新品发布和活动通知</label>
                                        <div class="col-sm-10">
                                            <div class="checkbox">
                                                <label>
                                                    <input type="checkbox">
                                                    有新品发布或活动举行时发邮件给我
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-2">
                                            <button type="submit" class="btn btn-primary">保存</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div><!-- end notification tab content -->
                    <!-- filter tab content -->
                    <div class="tab-pane fade" id="filter">
                        <div class="custom-setting-section">
                            <div class="custom-setting-item custom-margin-left10">
                                <form class="form-horizontal">
                                    <!-- topic filter -->
                                    <div class="custom-margin-bottom30">
                                        <h5>屏蔽话题设置</h5>
                                        <p class="custom-settings-section-desc">在个人首页动态中屏蔽来自特定话题的内容</p>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">个人咨询</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">个人咨询</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">个人咨询</a>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control custom-input-width" placeholder="搜索话题">
                                            </div>
                                        </div>
                                    </div><!-- topic filter -->
                                    <!-- limited topic -->
                                    <div class="custom-margin-bottom30">
                                        <h5>受限话题</h5>
                                        <p class="custom-settings-section-desc">除非主动关注，来自以下话题和它们的部分子话题的内容不会出现在你的首页动态中。</p>
                                        <p class="custom-settings-section-desc">详情参见 <a href="">${siteInfoDO.siteName}上的哪些内容需要主动关注才会出现在首页动态中？</a></p>

                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">${siteInfoDO.siteName}社区</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">成人内容</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">个人咨询</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">感情</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">调查类问题</a>
                                        </div>
                                        <div class="custom-tag custom-setting-tag">
                                            <a href="">钓鱼（广义的）</a>
                                        </div>
                                    </div><!-- limited topic -->
                                    <!-- filter setting -->
                                    <div class="custom-margin-bottom30">
                                        <h5>屏蔽专栏设置</h5>
                                        <p class="custom-settings-section-desc">在个人首页动态中屏蔽来自特定专栏的内容</p>
                                        <!-- filter item -->
                                        <div class="custom-filter-item">
                                            <div class="custom-filter-section">
                                                <div class="custom-answer-author">
                                                    <div class="custom-answer-author-avatar">
                                                        <a href="#">
                                                            <img class="custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                                        </a>
                                                    </div>
                                                    <div class="custom-answer-author-content">
                                                        <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                                                        <div class="custom-answer-author-headline">
                                                            <a href="#">
                                                                <div class="custom-item-link">
                                                                    <i class="fa fa-minus custom-topic-item"></i> 取消屏蔽
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- end filter item -->
                                        <!-- filter item -->
                                        <div class="custom-filter-item">
                                            <div class="custom-filter-section">
                                                <div class="custom-answer-author">
                                                    <div class="custom-answer-author-avatar">
                                                        <a href="#">
                                                            <img class="custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                                        </a>
                                                    </div>
                                                    <div class="custom-answer-author-content">
                                                        <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                                                        <div class="custom-answer-author-headline">
                                                            <a href="#">
                                                                <div class="custom-item-link">
                                                                    <i class="fa fa-minus custom-topic-item"></i> 取消屏蔽
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- end filter item -->
                                        <!-- filter item -->
                                        <div class="custom-filter-item">
                                            <div class="custom-filter-section">
                                                <div class="custom-answer-author">
                                                    <div class="custom-answer-author-avatar">
                                                        <a href="#">
                                                            <img class="custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                                        </a>
                                                    </div>
                                                    <div class="custom-answer-author-content">
                                                        <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                                                        <div class="custom-answer-author-headline">
                                                            <a href="#">
                                                                <div class="custom-item-link">
                                                                    <i class="fa fa-minus custom-topic-item"></i> 取消屏蔽
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- end filter item -->
                                        <!-- filter item -->
                                        <div class="custom-filter-item">
                                            <div class="custom-filter-section">
                                                <div class="custom-answer-author">
                                                    <div class="custom-answer-author-avatar">
                                                        <a href="#">
                                                            <img class="custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                                        </a>
                                                    </div>
                                                    <div class="custom-answer-author-content">
                                                        <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                                                        <div class="custom-answer-author-headline">
                                                            <a href="#">
                                                                <div class="custom-item-link">
                                                                    <i class="fa fa-minus custom-topic-item"></i> 取消屏蔽
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div><!-- end filter setting -->
                                    <!-- block user -->
                                    <div>
                                        <h5>屏蔽用户设置</h5>
                                        <p class="custom-settings-section-desc">在个人首页动态中屏蔽来自特定用户的内容</p>
                                        <!-- block user item -->
                                        <div class="custom-filter-item">
                                            <div class="custom-filter-section">
                                                <div class="custom-answer-author">
                                                    <div class="custom-answer-author-avatar">
                                                        <a href="#">
                                                            <img class="custom-avatar48" src="<%=request.getContextPath()%>/resources/images/avatar/a.jpg" alt="...">
                                                        </a>
                                                    </div>
                                                    <div class="custom-answer-author-content">
                                                        <div class="custom-answer-author-name custom-font-size15">机器学习</div>
                                                        <div class="custom-answer-author-headline">
                                                            <a href="#">
                                                                <div class="custom-item-link">
                                                                    <i class="fa fa-minus custom-topic-item"></i> 取消屏蔽
                                                                </div>
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div><!-- end block user item -->
                                    </div><!-- end block user -->
                                </form>
                            </div>
                        </div>
                    </div><!-- end filter tab content -->
                    <!-- lab tab content -->
                    <div class="tab-pane fade" id="lab">
                        <div class="custom-setting-section">
                            <div class="custom-setting-item  custom-margin-left10">
                                <form class="form-horizontal">
                                    <h5>首页动态</h5>
                                    <div class="form-group" style="margin-left: 5px;">
                                        <div class="checkbox">
                                            <label>
                                                <input type="checkbox">
                                                开启新版首页动态体验
                                                <p class="custom-settings-section-desc" style="display: inline-block">
                                                    （可随时在设置页开启或者关闭。）
                                                </p>
                                            </label>
                                        </div>
                                        <a href="">新首页动态包含哪些改进？</a>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10">
                                            <button type="submit" class="btn btn-primary">保存</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div><!-- end lab tab content -->
                </div><!-- end setting content -->
            </div>
        </div>
    </div>



                <%--<!-- lab tab -->--%>
                <%--<div class="col-sm-9 tab-pane fade custom-story-item custom-card" id="lab2">--%>
                    <%--<form class="form-horizontal">--%>
                        <%--<h5>首页动态</h5>--%>
                        <%--<div class="form-group">--%>
                            <%--<div class="col-lg-9">--%>
                                <%--<div class="checkbox">--%>
                                    <%--<label>--%>
                                        <%--<input type="checkbox">--%>
                                        <%--开启新版首页动态体验 （可随时在设置页开启或者关闭。）--%>
                                    <%--</label>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<a href="">新首页动态包含哪些改进？</a>--%>

                        <%--<div class="form-group">--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<button type="submit" class="btn btn-primary">保存</button>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    <%--</form>--%>
                <%--</div>--%>
                <%--<!-- end lab tab -->--%>
            <%--</div>--%>

        <%--</div>--%>
    <%--</div>--%>
    <!-- end home header -->

</div>

<!-- modal -->
<%@include file="modal.jsp"%>

<!-- js -->
<%@include file="includeJs.jsp"%>

</body>
</html>
