<%--
  Created by IntelliJ IDEA.
  User: Ellery
  Date: 2018/6/7
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!-- question comment modal -->
<div class="modal fade" id="questionCommentsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <div class="custom-comments-container">
                    <div class="custom-comments" style="padding: 0">
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

                        <!-- question comments template -->
                        <script type="text/x-handlebars-template" id="question_comment_template">
                            {{#each this}}
                            <!-- comment item -->
                            <div class="custom-comment-item">
                                <div id="question_comment_item_{{questionCommentsDO.id}}" onmouseover="showElement('{{questionCommentsDO.id}}');" onmouseout="hideElement('{{questionCommentsDO.id}}');">
                                    <div class="custom-commentItem-meta">
                                        <span>
                                            <a href="#">
                                                <img class="custom-commentItem-avatar custom-avatar24" src="<%=request.getContextPath()%>{{user.avatarPath}}" alt="{{user.fullname}}">
                                            </a>
                                        </span>
                                        <span>
                                            <a class="custom-comment-userLink" href="#">{{user.fullname}}</a>
                                        </span>
                                        <span class="custom-commentItem-time">{{questionCommentsDO.commentTime}}</span>
                                    </div>
                                    <div class="custom-commentItem-content">
                                        {{questionCommentsDO.commentContent}}
                                    </div>
                                    <div class="custom-commentItem-footer">
                                        <button class="custom-btn-plain custom-margin-right20" type="button">
                                            <span style="display: inline-flex;align-items: center;">
                                                <i class="fa fa-thumbs-up custom-margin-right5"></i>
                                                <span>赞</span>
                                            </span>
                                        </button>
                                        <span id="comment_hide_btn_{{questionCommentsDO.id}}" class="hide">
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
                                        </span>
                                    </div>
                                </div>
                            </div><!-- end comment item -->
                            {{/each}}
                        </script><!-- end question comments template -->

                        <!-- comment list -->
                        <div class="custom-comment-list" id="question_comment_wrapper">

                            <%--<!-- comment item divider -->--%>
                            <%--<div class="custom-comment-list-divider">--%>
                            <%--<div class="custom-comment-list-dividerLine"></div>--%>
                            <%--<div class="custom-comment-list-dividerText">--%>
                            <%--以上为精选评论--%>
                            <%--<i class="fa fa-question-circle"></i>--%>
                            <%--</div>--%>
                            <%--</div><!-- end comment item divider -->--%>

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
                                <input type="hidden" id="parent-comment-id" value="0">
                                <input type="hidden" id="reviewer-id" value="0">
                                <textarea id="question-comment" class="form-control custom-question-comment" rows="1"></textarea>
                                <button id="comment-question-btn" class="btn btn-primary btn-sm" style="float:right;" type="button">评论</button>
                            </div>
                        </div><!-- end comment footer -->
                    </div>
                </div><!-- feed comment -->
            </div>
        </div>
    </div>
</div>
<!-- end question comment modal -->
