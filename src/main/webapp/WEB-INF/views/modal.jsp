<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2017/8/8
  Time: 15:02
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

<!-- collection modal -->
<div class="modal fade" id="collectModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div id="add_favorite" class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 id="modalAddLabel" class="modal-title">添加到收藏夹</h4>
                <h4 id="modalCreateLabel" class="modal-title hidden">创建新收藏夹</h4>
            </div>
            <div class="modal-body">
                <div id="favorite_list" class="custom-margin-left45">
                    <input id="collect_list" type="checkbox" data-labelauty="Don't delete my files|Delete my files"/>
                </div>
                <div id="create_favorite" class="hidden">
                    <form>
                        <input type="text" class="form-control custom-margin-bottom10" placeholder="收藏标题">
                        <textarea class="form-control custom-margin-bottom10" rows="3" placeholder="收藏描述（可选）"></textarea>
                        <div class="custom-margin-bottom10">
                            <input class="" type="radio" value="option1" checked="">
                            公开 有其他人关注此收藏夹时不可设置为私密
                        </div>
                        <div class="custom-margin-bottom10">
                            <input type="radio" value="option2" checked="">
                            私密 只有你自己可以查看这个收藏夹
                        </div>
                    </form>
                </div>
            </div>
            <div id="modalAddFooter" class="modal-footer">
                <button type="button" class="btn btn-default custom-left" id="create_favorite_btn">
                    <i class="fa fa-plus-circle" aria-hidden="true"></i> 创建收藏夹
                </button>
                <button type="button" class="btn btn-primary">完成</button>
            </div>
            <div id="modalCreateFooter" class="modal-footer hidden">
                <button type="button" class="btn btn-default" id="return_add_favorite">返回</button>
                <button type="button" class="btn btn-primary">确认创建</button>
            </div>
        </div>
    </div>
</div>
<!-- end collection modal -->

<!-- report modal -->
<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">举报</h4>
            </div>
            <div class="modal-body">
                <div id="reportTree"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">举报</button>
            </div>
        </div>
    </div>
</div>
<!-- end report modal -->

<!-- ask modal -->
<div class="modal fade" id="askModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">提问</h4>
            </div>
            <div class="modal-body">
                <form class="form">
                    <div class="form-group">
                        <input class="form-control input-sm" type="text" placeholder="写下你的问题">
                    </div>
                    <div class="form-group">
                        <label class="control-label">问题说明（可选）：</label>
                        <div id="ask_note"></div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">选择话题</label>
                        <select class="form-control js-example-basic-multiple" name="states[]" multiple="multiple">
                            <option value="AL">basssssssssssssssma</option>
                            <option value="WY">Wing2</option>
                            <option value="WY">Wing3</option>
                            <option value="WY">Wing4</option>
                            <option value="WY">Wing5</option>
                            <option value="WY">Wing6</option>
                            <option value="WY">Wing7</option>
                        </select>
                        <span class="help-block custom-right">话题越精准，越容易让相关领域专业人士看到你的问题</span>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <div class="checkbox custom-left">
                    <label>
                        <input type="checkbox"> 匿名提问
                    </label>
                </div>
                <button type="button" class="btn btn-primary">提交问题</button>
            </div>
        </div>
    </div>
</div>
<!-- end ask modal -->

<!-- back to top -->
<div class="custom-backtotop" id="back_to_top">
    <a class="custom-btn-action" href="">
        <div class="custom-arrow"></div>
        <div class="custom-stick"></div>
    </a>
</div>
<!-- end back to top -->

<!-- set email modal -->
<div class="modal fade" id="setEmailModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog custom-modal-size" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel2">验证身份</h4>
            </div>
            <div class="modal-body">
                <form class="form">
                    <div class="form-group">
                        <label class="control-label">为了保证帐号安全，请验证身份。验证成功后进行下一步操作</label>
                    </div>
                    <div class="form-group custom-input-size">
                        <select class="form-control input-sm" id="select">
                            <option>使用邮箱a***y@msn.com验证</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select>
                    </div>
                    <div class="form-group custom-input-size">
                        <input class="form-control input-sm" type="text" placeholder="输入6位数验证码">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default">发送验证码</button>
                <button type="button" class="btn btn-primary">发布</button>
            </div>
        </div>
    </div>
</div>
<!-- end set email modal -->
